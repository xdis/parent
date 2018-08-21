package com.zyxy.service.micro.message.service.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.zyxy.common.util.StringUtil;
import com.zyxy.common.vo.BuzzResultVO;
import com.zyxy.service.micro.message.config.SmsTplConfig;

@Component
public class ALISmsClient {
    
    private static final Logger logger = LoggerFactory.getLogger(ALISmsClient.class);
    
    @Autowired
    private SmsTplConfig config;
    
    @Value("${provider.101.appId:}")
    private String aliAppId;
    @Value("${provider.101.secret:}")
    private String aliAppSecret;
    @Value("${provider.101.sign:}")
    private String aliAppSign;
    
    /**
     * 阿里大鱼短信
     * @param tel
     * @param tplJsonStr
     * @param tplId
     * @return
     */
    public BuzzResultVO<String> sendAliDayuVerifyCodeSms(String tel, String tplId, String tplJsonStr) {
        BuzzResultVO<String> ret = new BuzzResultVO<String>();
        if (StringUtil.isEmpty(aliAppId) || StringUtil.isEmpty(aliAppSecret)) {
            return ret.setOk(false).setMessage("请配置阿里大鱼短信通道参数");
        }
        
        //设置超时时间-可自行调整
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        //初始化ascClient需要的几个参数
        final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
        final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）

        //替换成你的AK
        //初始化ascClient,暂时不支持多region
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", aliAppId,
                aliAppSecret);
        try {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        } catch (ClientException e) {
            logger.error("短信发送失败", e);
        }
        IAcsClient acsClient = new DefaultAcsClient(profile);
        //组装请求对象
        SendSmsRequest request = new SendSmsRequest();
        //使用post提交
        request.setMethod(MethodType.POST);
        //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
        request.setPhoneNumbers(tel);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(config.getSign());
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(tplId);
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
        request.setTemplateParam(tplJsonStr);
        //可选-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");
        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        //request.setOutId("yourOutId");
        //请求失败这里会抛ClientException异常
        SendSmsResponse sendSmsResponse = null;
        try {
            sendSmsResponse = acsClient.getAcsResponse(request);
        } catch (ServerException e) {
            logger.error("发送短信失败", e);
            return ret.setOk(false).setMessage("调用渠道接口发送短信失败");
        } catch (ClientException e) {
            logger.error("发送短信失败", e);
            return ret.setOk(false).setMessage("调用渠道接口发送短信失败");
        }
        if(sendSmsResponse == null || !"OK".equalsIgnoreCase(sendSmsResponse.getCode())) {
            logger.error("发送短信失败-{}-{}", sendSmsResponse.getCode(), sendSmsResponse.getMessage());
            return ret.setOk(false).setMessage("调用渠道接口发送短信失败");
        }
        return ret.setOk(true);
    }
}
