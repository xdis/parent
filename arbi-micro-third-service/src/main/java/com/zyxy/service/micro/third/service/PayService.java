package com.zyxy.service.micro.third.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.zyxy.common.domain.PayOrder;
import com.zyxy.common.domain.PayRLItems;
import com.zyxy.common.domain.PayRLItemsExample;
import com.zyxy.common.domain.SysDataDicKey;
import com.zyxy.common.dto.PayInfoDTO;
import com.zyxy.common.dto.PayInfoDTO.PayItem;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.service.SysDataDicService;
import com.zyxy.common.util.CRCUtil;
import com.zyxy.common.util.DateUtil;
import com.zyxy.common.util.ImageUtil;
import com.zyxy.common.util.JsonUtil;
import com.zyxy.common.util.QRCodeUtil;
import com.zyxy.common.util.StringUtil;
import com.zyxy.common.vo.BuzzResultVO;
import com.zyxy.common.vo.ChannelResultVO;
import com.zyxy.service.micro.third.client.ruilian.RuiLianPayClient;

/**
 * 
 * @author tanquan
 *
 */
@Service
public class PayService {
    
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private PayOrderService payOrderService;
    
    @Autowired
    private SequenceService sequenceService;
    @Autowired
    private PayRLItemsService payRLItemsService;
    @Autowired
    private SysDataDicService sysDataDicService;
    
    @Autowired
    private RuiLianPayClient ruiLianPayClient;
    
    @Value("${pay.rl.noteType:0}")
    private String noteType;
    @Value("${pay.rl.userName}")
    private String userName;
    @Value("${pay.isDebug:false}")
    private Boolean isPayDebug;
    @Value("${pay.debugStatus:4}")
    private Integer debugStatus;
    
    /**
     * 发起支付（生成缴费通知书）
     * @param info
     * @return 返回支付记录ID
     */
    public BuzzResultVO<String> pay(PayInfoDTO info) {
        BuzzResultVO<String> ret = new BuzzResultVO<String>();
        // 入库
        PayOrder order = new PayOrder();
        // 单位编码
        String unitNo = userName;
        // 区域码2位+通知书类型1位+年份码2位+序列号8位
        String regionCode = sysDataDicService.selectValueByPrimaryKey(SysDataDicKey.PAY_REGION_CODE_KEY);
        String year = DateUtil.getDate("yy");
        String seq = sequenceService.getRLPaySeq();
        // 缴款通知书号码
        String pnNo = regionCode + noteType + year + seq;
        // 号码校验码
        String checkDigitNo = StringUtil.leftZero(String.valueOf(CRCUtil.getCRC16(unitNo + pnNo)), 5);
        // 全书校验码
        String amtStr = info.getReceivableAmt().setScale(2).toString().replace(".", "");
        String checkDigitAll = StringUtil.leftZero(String.valueOf(CRCUtil.getCRC16(unitNo + pnNo + amtStr)), 5);
        order.setId(sequenceService.getCommonID());
        order.setBuzzId(info.getBuzzId());
        order.setChargeItemCount(info.getItems().size());
        order.setCheckDigitAll(checkDigitAll);
        order.setCheckDigitNo(checkDigitNo);
        order.setRegionCode(regionCode);
        order.setRegionZipCode("");
        order.setCreateTime(new Date());
        // 区域邮政编码
        String regionZipCode = sysDataDicService.selectValueByPrimaryKey(SysDataDicKey.PAY_REGION_ZIP_CODE_KEY);
        order.setRegionZipCode(regionZipCode);
        PayRLItemsExample ex = new PayRLItemsExample();
        for (PayItem item : info.getItems()) {
            ex.clear();
            ex.createCriteria().andItemNoEqualTo(item.getItemNo());
            List<PayRLItems> list = payRLItemsService.selectByExample(ex);
            if (list == null || list.isEmpty()) {
                return ret.setOk(false).setMessage("项目编号不存在：" + item.getItemNo());
            }
            item.setItemName(list.get(0).getItemName());
        }
        order.setItems(JsonUtil.toJson(info.getItems()));
        order.setPayerName(info.getPayerName());
        order.setPnNo(pnNo);
        order.setReceivableAmt(info.getReceivableAmt());
        order.setRemark(info.getRemark());
        order.setStatus(0); // 处理中
        order.setUnitNo(unitNo);
        order.setUserId(info.getUserId());
        if (isPayDebug) {
            order.setStatus(debugStatus);
            order.setChannelMsg("此订单为测试订单，状态直接设置为：" + debugStatus);
        }
        payOrderService.insertSelective(order);
        if (isPayDebug) {
            return ret.setOk(true).setAttach(order.getId());
        }
        
        // 调用渠道接口
        ChannelResultVO<String>  cRet = ruiLianPayClient.generatePayNote(order);
        
        // 更新库
        PayOrder up = new PayOrder();
        up.setId(order.getId());
        if (cRet.getOk()) {
            up.setStatus(1);
            up.setChannelVoucherNo(cRet.getAttach());
        } else {
            up.setStatus(2);
            up.setChannelMsg(cRet.getMessage());
        }
        payOrderService.updateByPrimaryKeySelective(up);
        if (!cRet.getOk()) {
            return ret.setOk(false).setMessage("调用非税系统生成缴费单接口失败").setAttach(order.getId());
        }
        return ret.setOk(true).setAttach(order.getId());
    }
    
    /**
     * 支付服务-获取缴费通知书二维码
     * @param id
     * @return
     */
    public BuzzResultVO<String> getPayNoteQrCode(String id) {
        BuzzResultVO<String> ret = new BuzzResultVO<String>();
        PayOrder db = payOrderService.selectByPrimaryKey(id);
        if (db == null) {
            return ret.setOk(false).setMessage("支付订单不存在");
        }
        if (db.getStatus() != 1) {
            return ret.setOk(false).setMessage("该支付订单非待缴费状态");
        }
        String cnt = db.getRegionZipCode() + "|" + db.getUnitNo() + "|" + db.getPnNo() + "|" + db.getReceivableAmt().setScale(2).toString() + "|" + db.getCheckDigitNo() + "|" + db.getCheckDigitAll() + "|" + "|";
        String qrBase64Str = ImageUtil.convertImg2Base64(QRCodeUtil.encode(cnt));
        return ret.setOk(true).setAttach(qrBase64Str);
    }
    
    /**
     * 支付服务-查询支付详情及缴费状态
     * @param id
     * @param forceFlush 是否强制刷新
     * @return
     */
    public BuzzResultVO<PayOrder> queryOrder(String id, boolean forceFlush) {
        BuzzResultVO<PayOrder> ret = new BuzzResultVO<PayOrder>();
        PayOrder db = payOrderService.selectByPrimaryKey(id);
        if (db == null) {
            return ret.setOk(false).setMessage("支付订单不存在");
        }
        // 如果非缴费状态则直接返回交易数据
        if (db.getStatus() != 1 && !forceFlush) { 
            return ret.setOk(true).setAttach(db);
        }
        if (isPayDebug) {
            return ret.setOk(true).setAttach(db);
        }
        // 查询渠道当前交易支付状态
        ChannelResultVO<PayOrder> cRet = ruiLianPayClient.queryPayNote(db);
        if (!cRet.getOk()) {
            return ret.setOk(false).setMessage("查询非税系统接口失败");
        }
        // 更新库
        payOrderService.updateByPrimaryKeySelective(cRet.getAttach());
        db = payOrderService.selectByPrimaryKey(id);
        return ret.setOk(true).setAttach(db);
    }
    
    /**
     * 支付服务-取消支付（取消缴款通知书）
     * @param id
     * @return
     */
    public BuzzResultVO<String> cancleQuery(String id) {
        BuzzResultVO<String> ret = new BuzzResultVO<String>();
        PayOrder db = payOrderService.selectByPrimaryKey(id);
        if (db == null) {
            return ret.setOk(false).setMessage("支付订单不存在");
        }
        // 如果非缴费状态则直接返回交易数据
        if (db.getStatus() != 1) { 
            return ret.setOk(false).setMessage("非待缴费的缴款通知书不能取消");
        }
        // 调用去掉取消接口
        ChannelResultVO<String> cRet = ruiLianPayClient.cancelPayNote(db);
        if (!cRet.getOk()) {
            return ret.setOk(false).setMessage("查询非税系统接口失败");
        }
        // 更新数据库
        PayOrder up = new PayOrder();
        up.setId(db.getId());
        up.setUpdateTime(new Date());
        up.setCancelTime(new Date());
        up.setStatus(3);
        return ret.setOk(true);
    }
}
