package com.zyxy.service.micro.third.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.common.domain.RealNameAuthRecord;
import com.zyxy.common.dto.BankFourElementDTO;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.vo.BuzzResultVO;
import com.zyxy.common.vo.ChannelResultVO;
import com.zyxy.service.micro.third.client.zhengyuan.ZhengyuanClient;

/**
 * 
 * @author tanquan
 *
 */
@Service
public class AuthService {
    
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private ZhengyuanClient zhengyuanClient;
    
    @Autowired
    private RealNameAuthRecordService realNameAuthRecordService;
    
    @Autowired
    private SequenceService sequenceService;
    
    /**
     * 银行卡四要素认证
     * @param info
     * @return 返回认证结果
     */
    public BuzzResultVO<String> verifyBankFourElement(BankFourElementDTO elemInfo) {
        BuzzResultVO<String> ret = new BuzzResultVO<String>();
        // 入库
        RealNameAuthRecord record = new RealNameAuthRecord();
        record.setId(sequenceService.getCommonID());
        record.setBuzzId(elemInfo.getBuzzId());
        record.setCardNo(elemInfo.getCardNo());
        record.setCertName(elemInfo.getCertName());
        record.setCertNo(elemInfo.getCertNo());
        record.setCertType(elemInfo.getCertType());
        record.setCreateTime(new Date());
        record.setPhoneNo(elemInfo.getPhoneNo());
        record.setStatus(0); // 0-处理中，1-认证成功，2-认证失败
        record.setUserId(elemInfo.getUserId());
        realNameAuthRecordService.insertSelective(record);
        
        // 调用渠道接口
        ChannelResultVO<Boolean> channelRet = zhengyuanClient.verifyBankInfo("0040", elemInfo.getCardNo(), 
                elemInfo.getCertName(), elemInfo.getCertType(), 
                elemInfo.getCertNo(), elemInfo.getPhoneNo(), record.getId());
        
        // 更新库
        RealNameAuthRecord up = new RealNameAuthRecord();
        up.setId(record.getId());
        up.setChannelCode(channelRet.getChannelCode());
        up.setChannelMsg(channelRet.getChannelMsg());
        up.setVoucherNo(channelRet.getVoucherNo());
        if (channelRet.getOk()) {
            up.setStatus(1); // 成功
        } else {
            up.setStatus(2); // 失败
        }
        if (channelRet.getIsFree()) {
            up.setBeFree(1);
        } else {
            up.setBeFree(0);
        }
        up.setUpdateTime(new Date());
        realNameAuthRecordService.updateByPrimaryKeySelective(up);
        if (!channelRet.getAttach()) {
            return ret.setOk(false).setMessage(channelRet.getMessage()).setAttach(record.getId());
        }
        return ret.setOk(true);
    }
}
