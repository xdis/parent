package com.zyxy.service.micro.message.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.common.domain.SmsRecordWithBLOBs;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.util.JsonUtil;
import com.zyxy.common.util.StringUtil;
import com.zyxy.common.vo.BuzzResultVO;
import com.zyxy.service.micro.message.config.SmsTplConfig;
import com.zyxy.service.micro.message.constant.SmsConstant;
import com.zyxy.service.micro.message.service.client.ALISmsClient;
import com.zyxy.service.micro.message.service.client.MDSmsClient;

/**
 * 
 * @author tanquan
 *
 */
@Service
public class SmsService {
    
    @Autowired
    private SmsTplConfig config;
    @Autowired
    private SequenceService sequenceService;
    @Autowired
    private SmsRecordService smsRecordService;
    @Autowired
    private ALISmsClient aliClient;
    @Autowired
    private MDSmsClient mdClient;
    
    /**
     * 短信发送
     * @param phoneNo 手机号
     * @param tplId 模板ID 请见 sms-template.properties
     * @param tplParams 模板对应的参数 json字符串
     * @param userId 用户ID
     * @param buzzId 业务ID（冗余）
     * @return null为发送失败
     */
    public BuzzResultVO<String> send(String phoneNo, String tplId, String tplParams, String userId, String buzzId) {
        BuzzResultVO<String> ret = new BuzzResultVO<String>();
        // 校验 tplId是否存在
        if (!config.getTpls().containsKey(tplId + ".id")) {
            return ret.setOk(false).setMessage("模板[" + tplId + "]不存在");
        }
        
        String msgProviderCode = config.getProvider();
        if (StringUtil.isEmpty(msgProviderCode)) {
            msgProviderCode = SmsConstant.ALI_SMS_CODE;
        }
        // 获取模板
        String tplCnt = config.getTpls().get(tplId + ".cnt");
        
        SmsRecordWithBLOBs record = new SmsRecordWithBLOBs();
        record.setId(sequenceService.getCommonID());
        record.setBuzzId(buzzId);
        record.setChannelCode(msgProviderCode);
        record.setCreateTime(new Date());
        record.setPhoneNo(phoneNo);
        record.setStatus(0); // 发送中
        record.setTplId(tplId);
        record.setTplCnt(tplCnt);
        record.setTplParams(tplParams);
        smsRecordService.insert(record);
        SmsRecordWithBLOBs up = new SmsRecordWithBLOBs();
        up.setId(record.getId());
        if (config.getDebug()) { // 调试模式下直接返回
            up.setStatus(1);
            smsRecordService.updateByPrimaryKeySelective(up);
            return ret.setOk(true).setAttach(record.getId());
        }
        
        // 根据路由选择渠道发送
        BuzzResultVO<String> sendRet = null;
        if (SmsConstant.ALI_SMS_CODE.equals(msgProviderCode)) {
            String providerTplId = config.getTpls().get(tplId + ".providerTpl." + msgProviderCode);
            sendRet = aliClient.sendAliDayuVerifyCodeSms(phoneNo, providerTplId, tplParams);
        } else if (SmsConstant.MD_SMS_CODE.equals(msgProviderCode)) {
            BuzzResultVO<String> tranRet = this.translateTpl(tplCnt, tplParams);
            if (!tranRet.getOk()) {
                return ret.setOk(false).setMessage(tranRet.getMessage());
            }
            try {
                sendRet = mdClient.mdsmssend(phoneNo, URLEncoder.encode(config.getSign() + tranRet.getAttach(), "UTF-8"), "1", "", "", "");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            return ret.setOk(false).setMessage("短信渠道配置错误");
        }
        
        if (sendRet != null && sendRet.getOk()) {
            up.setStatus(1);
            ret.setOk(true).setAttach(record.getId());
        } else {
            up.setStatus(2);
            ret.setOk(true).setMessage(sendRet.getMessage());
        }
        smsRecordService.updateByPrimaryKeySelective(up);
        return ret;
    }
    
    /**
     * 翻译模板
     * @param tmplStr
     * @param tplParamsJsonStr
     * @return
     */
    private BuzzResultVO<String> translateTpl(String tmplStr, String tplParamsJsonStr) {
        BuzzResultVO<String> ret = new BuzzResultVO<String>();
        List<String> toReplacedKey = this.getTplKeys(tmplStr);
        if (toReplacedKey == null || toReplacedKey.isEmpty()) {
            return ret.setOk(true).setAttach(tmplStr);
        }
        Map<String, Object> params = null;
        try {
            params = JsonUtil.jsonToMap(tplParamsJsonStr);
        } catch (Exception e) {
            e.printStackTrace();
            return ret.setOk(false).setMessage("短信模板参数json格式不正确");
        }
        String keyValue = null;
        for (String key : toReplacedKey) {
            keyValue = (String)params.get(key);
            if (keyValue == null) {
                return ret.setOk(false).setMessage("模板参数[" + key + "]缺失");
            }
            tmplStr = tmplStr.replace("{" + key + "}", keyValue);
        }
        return ret.setOk(true).setAttach(tmplStr);
    }
    
    /**
     * 获取模板keys
     * @param tmplStr
     * @return
     */
    private List<String> getTplKeys(String tmplStr) {
        Pattern p = Pattern.compile("\\{([a-zA-Z0-9]+)\\}"); 
        Matcher m = p.matcher(tmplStr); 
        List<String> keys = new ArrayList<String>();
        while(m.find()) { 
            keys.add(m.group(1)); 
        }
        return keys;
    }
    
}
