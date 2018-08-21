package com.zyxy.service.micro.core.api.service;

import com.zyxy.common.dto.*;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.EnterpriseAuthStatusVO;
import com.zyxy.common.vo.LivenessTokenVO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * 修改密码控制层
 */
@FeignClient("coreService")
public interface SysUserService {

    @RequestMapping(value = "/sys/user/updatePassword", method = RequestMethod.POST)
    ApiResultVO<String> updatePassword(@RequestBody SysUserPwdDTO formData);

    @RequestMapping(value = "/sys/user/elementVerify", method = RequestMethod.POST)
    ApiResultVO<String> elementVerify(@RequestBody ElementVerifyDTO formData);

    @RequestMapping(value = "/sys/user/labourRealName", method = RequestMethod.POST)
    ApiResultVO<String> labourRealName(@RequestBody LabourRealNameDTO formData);

    @RequestMapping(value = "/sys/user/enterpriseAuth", method = RequestMethod.POST)
    ApiResultVO<BigDecimal> enterpriseAuth(@RequestBody EnterpriseAuthDTO formData);

    @RequestMapping(value = "/sys/user/enterpriseAuthStatus", method = RequestMethod.POST)
    ApiResultVO<EnterpriseAuthStatusVO> enterpriseAuthStatus(@RequestBody BaseDTO formData);

    @RequestMapping(value = "/sys/user/register", method = RequestMethod.POST)
    ApiResultVO<String> register(@RequestBody UserRegisterDTO formData);

    @RequestMapping(value = "/sys/user/livenessToken", method = RequestMethod.POST)
    ApiResultVO<LivenessTokenVO> livenessToken(@RequestParam("userId") String userId, @RequestParam("returnUrl") String returnUrl);

    @RequestMapping(value = "/sys/user/livenessNotify", method = RequestMethod.POST)
    ApiResultVO livenessNotify(@RequestBody FaceIdNotifyDTO formData);

    @RequestMapping(value = "/sys/user/lostPwdToken", method = RequestMethod.POST)
    ApiResultVO<String> lostPwdToken(@RequestBody LostPwdTokenDTO formData);

    @RequestMapping(value = "/sys/user/lostPwd", method = RequestMethod.POST)
    ApiResultVO lostPwd(@RequestBody LostPwdDTO formData);

    @RequestMapping(value = "/sys/user/changeRole", method = RequestMethod.POST)
    ApiResultVO changeRole(@RequestBody ChangeRoleDTO formData);
}
