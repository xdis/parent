package com.zyxy.common.service.micro;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zyxy.common.dto.MailInfoDTO;
import com.zyxy.common.service.micro.fallback.MicroMessageServiceImpl;
import com.zyxy.common.vo.ApiResultVO;

/**
 * 短信、邮箱等服务
 * @author sonta
 *
 */
@FeignClient(value = "messageService", fallback=MicroMessageServiceImpl.class)
public interface MicroMessageService {
    
    /**
     * 短信发送
     * @param phoneNo 手机号
     * @param tplId 模板ID 请参考 message-service sms-template.properties
     * @param tplParams 模板参数 Json key value 字符串
     * @param userId 用户ID
     * @param buzzId 业务ID（冗余）
     * @return 成功则会在 body中返回短信记录ID
     */
    @RequestMapping(value = "/sms/tpl/send", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE })
    ApiResultVO<String> sendSms(
            @RequestParam("phoneNo") String phoneNo
            ,@RequestParam("tplId") String tplId
            ,@RequestParam("tplParams") String tplParams
            ,@RequestParam("userId") String userId
            ,@RequestParam("buzzId") String buzzId
        );
    
    /**
     * 邮件发送
     * @param info
     * @return
     */
    @RequestMapping(value = "/mail/send", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes =MediaType.MULTIPART_FORM_DATA_VALUE)
    ApiResultVO<String> sendMail(@RequestBody MailInfoDTO info);
    
    
}
