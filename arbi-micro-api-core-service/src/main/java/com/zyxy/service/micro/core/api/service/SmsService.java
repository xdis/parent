package com.zyxy.service.micro.core.api.service;

import com.zyxy.common.dto.LostSmsSendDTO;
import com.zyxy.common.dto.SmsSendDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;

/**
 * 公共案件模块
 */
public interface SmsService {

    /**
     * 发送短信业务验证
     * @param formData 业务对象
     * @return 验证结果
     */
    BusiValidResult sendSmsBusiValid(SmsSendDTO formData);

    /**
     * 发送短信业务处理
     * @param formData 业务对象
     * @return 处理结果
     */
    BusiExecuteResult sendSmsBusiExecute(SmsSendDTO formData);

    BusiValidResult sendSmsLoginValid(SmsSendDTO formData);

    BusiExecuteResult sendSmsLoginExecute(SmsSendDTO formData);

    /**
     * 发送找回密码验证码业务验证
     *
     * @param formData 业务对象
     * @return 验证结果
     */
    BusiValidResult sendSmsLostValid(LostSmsSendDTO formData);

    /**
     * 发送找回密码验证码业务处理
     * @param formData 业务对象
     * @return 执行结果
     */
    BusiExecuteResult sendSmsLostExecute(LostSmsSendDTO formData);
}
