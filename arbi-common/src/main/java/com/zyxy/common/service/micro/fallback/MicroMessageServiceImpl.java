package com.zyxy.common.service.micro.fallback;

import org.springframework.stereotype.Component;

import com.zyxy.common.dto.MailInfoDTO;
import com.zyxy.common.service.micro.MicroMessageService;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ApiResultVO.Coder;

@Component
public class MicroMessageServiceImpl implements MicroMessageService{

    @Override
    public ApiResultVO<String> sendSms(String phoneNo, String tplId,
            String tplParams, String userId, String buzzId) {
        return new ApiResultVO<String>().setCoder(Coder.CALL_SERV_ERROR).setMessage("短信服务调用失败，请检查服务是否启动");
    }

    @Override
    public ApiResultVO<String> sendMail(MailInfoDTO info) {
        return new ApiResultVO<String>().setCoder(Coder.CALL_SERV_ERROR).setMessage("邮件服务调用失败，请检查服务是否启动");
    }
    
}
