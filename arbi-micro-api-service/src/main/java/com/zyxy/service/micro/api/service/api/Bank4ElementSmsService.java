package com.zyxy.service.micro.api.service.api;

import java.util.concurrent.TimeUnit;

import com.zyxy.common.constants.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.zyxy.common.enums.SysUserEnum;
import com.zyxy.common.mapper.SysUserMapper;
import com.zyxy.common.service.CacheService;
import com.zyxy.common.service.micro.MicroMessageService;
import com.zyxy.common.vo.BuzzResultVO;
import com.zyxy.service.micro.api.dto.ReqSmsCodeDTO;
import com.zyxy.service.micro.api.dto.ResSmsCodeDTO;

/**
 * 四要素验证码获取
 * @author tanquan
 */
@Service
public class Bank4ElementSmsService extends BaseService<ReqSmsCodeDTO, ResSmsCodeDTO>{
    
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private CacheService cacheService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private MicroMessageService microMessageService;
    
    @Override
    protected  BuzzResultVO<ResSmsCodeDTO> doBuzz(ReqSmsCodeDTO dto, String currentIp) {
        String tplId = "1001";
        // String code = String.format("%06d", new Random().nextInt(999999));
        String code = "888888";
        Integer validMin = 3;
        String tplParam = "{\"validMin\":\"" + validMin + "\",\"code\":\""
                + code + "\"}";
        String userId = SysUserEnum.SYSTEM.getValue();
        ValueOperations<String, String> operations = stringRedisTemplate
                .opsForValue();
        operations.set(Constant.REG_PWD_SMS_CODE + dto.getPhoneNo(), code);
        stringRedisTemplate.expire(Constant.REG_PWD_SMS_CODE + dto.getPhoneNo(), 3600,
                TimeUnit.MINUTES);
        /*ApiResultVO<String> stringApiResultVO = microMessageService.sendSms(
                dto.getPhoneNo(), tplId, tplParam, userId, null);
        if (!super.isApiExcuteSuccess(stringApiResultVO)) {
            return super.error(super.getApiExcuteMessage(stringApiResultVO));
        }*/
        ResSmsCodeDTO resDTO = new ResSmsCodeDTO();
        resDTO.setExpire(3L * 60);
        return super.success(resDTO);
    }
    
}

