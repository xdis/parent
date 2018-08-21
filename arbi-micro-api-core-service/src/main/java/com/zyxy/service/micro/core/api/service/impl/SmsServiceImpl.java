package com.zyxy.service.micro.core.api.service.impl;

import com.zyxy.common.constants.Constant;
import com.zyxy.common.dto.LostSmsSendDTO;
import com.zyxy.common.dto.SmsSendDTO;
import com.zyxy.common.enums.SysUserEnum;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.service.micro.MicroMessageService;
import com.zyxy.common.util.RandomUtil;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.service.micro.core.api.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class SmsServiceImpl implements SmsService {

    @Autowired
    private MicroMessageService microMessageService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public BusiValidResult sendSmsBusiValid(SmsSendDTO formData) {

        // 该日志必不可少
        if (stringRedisTemplate.hasKey(Constant.REG_PWD_SMS_CODE + formData.getPhone())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.PHONE_VERIFT_CODE_EXIST);
        }
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        String key = Constant.REG_PWD_IMG_CODE + formData.getPhone();
        String imgCodeInCache = operations.get(key);
        stringRedisTemplate.delete(key);
        if (!formData.getImgCode().equals(imgCodeInCache)) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.LOST_PWD_IMG_CODE_ERROR);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult sendSmsBusiExecute(SmsSendDTO formData) {
        String tplId = "1001";
//        String code = String.format("%06d", new Random().nextInt(999999));
        String code = "888888";
        Integer validMin = 3;
        String tplParam = "{\"validMin\":\"" + validMin + "\",\"code\":\"" + code + "\"}";
        String userId = SysUserEnum.SYSTEM.getValue();
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.set(Constant.REG_PWD_SMS_CODE + formData.getPhone(), code);
        stringRedisTemplate.expire(Constant.REG_PWD_SMS_CODE + formData.getPhone(), 3, TimeUnit.MINUTES);
        ApiResultVO<String> stringApiResultVO = microMessageService.sendSms(formData.getPhone(), tplId, tplParam, userId, null);
        return BusiExecuteResult.builderSuccessResult(stringApiResultVO.getBody());
    }


    @Override
    public BusiValidResult sendSmsLoginValid(SmsSendDTO formData) {

        // 该日志必不可少
        if (stringRedisTemplate.hasKey(Constant.LOGIN_SMS_CODE + formData.getPhone())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.PHONE_VERIFT_CODE_EXIST);
        }
        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult sendSmsLoginExecute(SmsSendDTO formData) {
        String tplId = "1003";
        String code = RandomUtil.createRandomVcode(4);
        Integer validMin = 3;
        String tplParam = "{\"validMin\":\"" + validMin + "\",\"code\":\"" + code + "\"}";
        String userId = SysUserEnum.SYSTEM.getValue();
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.set(Constant.LOGIN_SMS_CODE + formData.getPhone(), code);
        stringRedisTemplate.expire(Constant.LOGIN_SMS_CODE + formData.getPhone(), 3, TimeUnit.MINUTES);
        ApiResultVO<String> stringApiResultVO = microMessageService.sendSms(formData.getPhone(), tplId, tplParam,
                userId, null);
        return BusiExecuteResult.builderSuccessResult(stringApiResultVO.getBody());
    }

    @Override
    public BusiValidResult sendSmsLostValid(LostSmsSendDTO formData) {
        // 该日志必不可少
        if (stringRedisTemplate.hasKey(Constant.LOST_PWD_SMS_CODE + formData.getPhone())) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.PHONE_VERIFT_CODE_EXIST);
        }

        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        String key = Constant.LOST_PWD_IMG_CODE + formData.getPhone();
        String imgCodeInCache = operations.get(key);
        stringRedisTemplate.delete(key);

        if (!formData.getImgCode().equals(imgCodeInCache)) {
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.LOST_PWD_IMG_CODE_ERROR);
        }

        return BusiValidResult.builderSuccessResult();
    }

    @Override
    public BusiExecuteResult sendSmsLostExecute(LostSmsSendDTO formData) {
        String tplId = "1003";
//        String code = RandomUtil.createRandomVcode(4);
        String code = "888888";
        Integer validMin = 3;
        String tplParam = "{\"validMin\":\"" + validMin + "\",\"code\":\"" + code + "\"}";
        String userId = SysUserEnum.SYSTEM.getValue();
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.set(Constant.LOST_PWD_SMS_CODE + formData.getPhone(), code);
        stringRedisTemplate.expire(Constant.LOST_PWD_SMS_CODE + formData.getPhone(), validMin, TimeUnit.MINUTES);
        ApiResultVO<String> stringApiResultVO = microMessageService.sendSms(formData.getPhone(), tplId, tplParam,
                userId, null);
        return BusiExecuteResult.builderSuccessResult(stringApiResultVO.getBody());
    }
}
