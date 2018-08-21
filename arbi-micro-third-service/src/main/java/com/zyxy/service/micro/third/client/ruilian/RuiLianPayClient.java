package com.zyxy.service.micro.third.client.ruilian;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.zyxy.common.domain.PayOrder;
import com.zyxy.common.dto.PayInfoDTO.PayItem;
import com.zyxy.common.enums.CacheTypeEnum;
import com.zyxy.common.exception.BuzzException;
import com.zyxy.common.service.CacheService;
import com.zyxy.common.util.DateUtil;
import com.zyxy.common.util.JsonUtil;
import com.zyxy.common.vo.ChannelResultVO;
import com.zyxy.service.micro.third.client.ruilian.enums.PayStatusEnum;
import com.zyxy.service.micro.third.client.ruilian.enums.RetCodeEnum;
import com.zyxy.service.micro.third.client.ruilian.webservice.CancelPayNoteRetVO;
import com.zyxy.service.micro.third.client.ruilian.webservice.CancelPayNoteVO;
import com.zyxy.service.micro.third.client.ruilian.webservice.ExternalInterfaceWSServiceLocator;
import com.zyxy.service.micro.third.client.ruilian.webservice.ExternalInterfaceWSSoapBindingStub;
import com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteRetVO;
import com.zyxy.service.micro.third.client.ruilian.webservice.GeneratePayNoteVO;
import com.zyxy.service.micro.third.client.ruilian.webservice.LoginRetVO;
import com.zyxy.service.micro.third.client.ruilian.webservice.LoginVO;
import com.zyxy.service.micro.third.client.ruilian.webservice.SearchPayNoteRetVO;
import com.zyxy.service.micro.third.client.ruilian.webservice.SearchPayNoteVO;


/**
 * 瑞联支付客户端工具
 * @author tanquan
 */
@Component
public class RuiLianPayClient {
    
    private static final Logger logger = LoggerFactory.getLogger(RuiLianPayClient.class);
    
    @Autowired
    private CacheService cacheService;
    
    @Value("${pay.rl.address}")
    private String address;
    @Value("${pay.rl.userName}")
    private String userName;
    @Value("${pay.rl.password}")
    private String password;
    
    private ExternalInterfaceWSSoapBindingStub service;
    
    /**
     * 发出缴款通知书
     * @param info
     * @return
     */
	public ChannelResultVO<String> generatePayNote(PayOrder order) {
	    ChannelResultVO<String> ret = new ChannelResultVO<String>();
        List<PayItem> items = JsonUtil.jsonToList(order.getItems(), PayItem.class);
	    GeneratePayNoteVO vo = new GeneratePayNoteVO();
	    vo.setChargeItemCount(items.size());
	    vo.setCheckDigitAll(order.getCheckDigitAll());
	    vo.setCheckDigitNO(order.getCheckDigitNo());
	    try {
            vo.setLoginKey(this.getLoginKey(false));
        } catch(BuzzException e) {
            return ret.setOk(false).setMessage(e.getMessage());
        }
	    vo.setPayerName(order.getPayerName());
	    vo.setPnNO(order.getPnNo());
	    vo.setReceivableAmt(order.getReceivableAmt().toString());
	    vo.setRemark(order.getId());
	    vo.setUnitNO(order.getUnitNo());
	    vo.setChargeItemNO1(items.get(0).getItemNo());
        vo.setPrice1(items.get(0).getPrice().toString());
        vo.setOverdueAmt1("0");
        vo.setCreateTM(DateUtil.formatDate(order.getCreateTime(), "yyyyMMddHHmmss"));
        vo.setQuantity1(String.valueOf(items.get(0).getQuantity()));
        if (items.size() > 1) {
            vo.setChargeItemNO2(items.get(1).getItemNo());
            vo.setPrice2(items.get(1).getPrice().toString());
            vo.setOverdueAmt2("0");
            vo.setQuantity2(String.valueOf(items.get(1).getQuantity()));
        }
        if (items.size() > 2) {
            vo.setChargeItemNO3(items.get(2).getItemNo());
            vo.setPrice3(items.get(2).getPrice().toString());
            vo.setOverdueAmt3("0");
            vo.setQuantity3(String.valueOf(items.get(2).getQuantity()));
        }
        logger.debug("向渠道发送参数：{}", JsonUtil.toJson(vo));
        GeneratePayNoteRetVO cRet = new GeneratePayNoteRetVO();
        try {
            cRet = this.getService().generatePayNote(vo);
            if (RetCodeEnum.NO_LOGIN.getCode().equals(cRet.getReturnCode())) {
                logger.warn("重新登录缴费系统");
                vo.setLoginKey(this.getLoginKey(true));
                cRet = this.getService().generatePayNote(vo);
            }
        } catch (RemoteException e) {
            logger.error("查询非税系统接口失败-orderId:{}", order.getId(), e);
            return ret.setOk(false).setMessage("查询非税系统接口失败");
        }
        logger.info("渠道返回-{}", JsonUtil.toJson(cRet));
        if (!RetCodeEnum.SUCCESS.getCode().equals(cRet.getReturnCode())) {
            return ret.setOk(false).setMessage("查询非税系统接口返回非成功状态");
        }
        
	    return new ChannelResultVO<String>().setOk(true).setAttach(cRet.getPnNO());
	}
	
	/**
	 * 查询缴款通知书缴款情况
	 * @param order
	 * @return
	 */
	public ChannelResultVO<PayOrder> queryPayNote(PayOrder order) {
	    ChannelResultVO<PayOrder> ret = new ChannelResultVO<PayOrder>();
	    SearchPayNoteVO vo = new SearchPayNoteVO();
	    try {
	        vo.setLoginKey(this.getLoginKey(false));
	    } catch(BuzzException e) {
	        return ret.setOk(false).setMessage(e.getMessage());
	    }
	    vo.setPnNO(order.getPnNo());
	    vo.setUnitNO(order.getUnitNo());
	    SearchPayNoteRetVO cRet = null;
	    try {
            cRet = this.getService().searchPayNote(vo);
            if (RetCodeEnum.NO_LOGIN.getCode().equals(cRet.getReturnCode())) {
                logger.warn("重新登录缴费系统");
                vo.setLoginKey(this.getLoginKey(true));
                cRet = this.getService().searchPayNote(vo);
            }
        } catch (RemoteException e) {
            logger.error("查询非税系统接口失败-orderId:{}", order.getId(), e);
            return ret.setOk(false).setMessage("查询非税系统接口失败");
        }
	    logger.info("渠道返回-{}", JsonUtil.toJson(cRet));
	    if (!RetCodeEnum.SUCCESS.getCode().equals(cRet.getReturnCode())) {
	        return ret.setOk(false).setMessage("查询非税系统接口返回非成功状态");
	    }
	    PayOrder up = new PayOrder();
	    up.setId(order.getId());
	    up.setUpdateTime(new Date());
	    if (cRet.getStatus() == PayStatusEnum.PAYED.getCode()) {
	        up.setBankName(cRet.getBankName());
	        up.setStatus(4); //缴费成功
	        up.setPayedTime(DateUtil.formatDate(cRet.getPaidTM()));
	        up.setReceiptNo(cRet.getReceiptNO());
	        up.setReceivedAmt(new BigDecimal(cRet.getReceivedAmt()));
	        up.setRtNo(cRet.getRtNO());
	    } else if (cRet.getStatus() == PayStatusEnum.CANCLE.getCode()) {
	        up.setStatus(3); //被取消
	    }
	    return ret.setOk(true).setAttach(up);
	}
	
	/**
	 * 取消缴费通知书
	 * @param order
	 * @return
	 */
	public ChannelResultVO<String> cancelPayNote(PayOrder order) {
	    ChannelResultVO<String> ret = new ChannelResultVO<String>();
	    CancelPayNoteVO vo = new CancelPayNoteVO();
	    try {
            vo.setLoginKey(this.getLoginKey(false));
        } catch(BuzzException e) {
            return ret.setOk(false).setMessage(e.getMessage());
        }
	    vo.setPnNO(order.getPnNo());
	    vo.setUnitNO(order.getUnitNo());
	    vo.setCheckDigitNO(order.getCheckDigitNo());
	    CancelPayNoteRetVO cRet = null;
	    try {
	        cRet = this.getService().cancelPayNote(vo);
	        if (RetCodeEnum.NO_LOGIN.getCode().equals(cRet.getReturnCode())) {
	            logger.warn("重新登录缴费系统");
	            vo.setLoginKey(this.getLoginKey(true));
	            cRet = this.getService().cancelPayNote(vo);
	        }
	    } catch (RemoteException e) {
	        logger.error("查询非税系统接口失败-orderId:{}", order.getId(), e);
	        return ret.setOk(false).setMessage("查询非税系统接口失败:" + e.getMessage());
	    }
	    logger.info("渠道返回-{}", JsonUtil.toJson(cRet));
	    if (!RetCodeEnum.SUCCESS.getCode().equals(cRet.getReturnCode())) {
	        return ret.setOk(false).setMessage("查询非税系统接口返回非成功状态");
	    }
	    return ret.setOk(true);
	}
	
	/**
	 * 登录非税系统
	 * @param wscWsUsername
	 * @param wsPassword
	 * @param address
	 */
	private String login() throws BuzzException{
        LoginVO loginVO1 = new LoginVO();
        loginVO1.setUnitNO(userName);
        loginVO1.setPassword(password);
        LoginRetVO loginRetVO = null;
        try {
            loginRetVO = getService().login(loginVO1);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new BuzzException("非税系统-登录接口连接出错:" + e.getMessage());
        }
        if (loginRetVO == null) {
            throw new BuzzException("非税系统-登录接口返回出错");
        }
        if (!"100".equals(loginRetVO.getReturnCode())) {
            throw new BuzzException("非税系统认证失败-" + loginRetVO.getReason());
        }
        return loginRetVO.getLoginKey();
    }
	
	/**
	 * 获取登录token
	 * @return
	 */
	private String getLoginKey(boolean forceFlush) throws BuzzException{
	    String cacheKey = (String)cacheService.getCache(CacheTypeEnum.RL_PAY_LOGIN_KEY.getCode(), CacheTypeEnum.RL_PAY_LOGIN_KEY.getCode());
	    if (cacheKey == null || forceFlush) {
	        cacheKey = this.login();
	    }
	    cacheService.addCache(CacheTypeEnum.RL_PAY_LOGIN_KEY.getCode(), CacheTypeEnum.RL_PAY_LOGIN_KEY.getCode(), cacheKey);
	    return cacheKey;
	}
	
	public ExternalInterfaceWSSoapBindingStub getService() {
	    logger.debug("非税系统当前地址-{},用户名—{}", this.address, this.userName);
        if (service == null) {
            ExternalInterfaceWSServiceLocator locator = new ExternalInterfaceWSServiceLocator();
            locator.setExternalInterfaceWSEndpointAddress(address);
            locator.setMaintainSession(true);
            try {
                service = (ExternalInterfaceWSSoapBindingStub) locator.getExternalInterfaceWS();
            } catch (ServiceException e) {
                e.printStackTrace();
                throw new BuzzException("非税webservice接口连接出错");
            }
        }
        return service;
    }
	
}
