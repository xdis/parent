package com.zyxy.service.micro.core.api.controller;

import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.*;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.EnterpriseAuthStatusVO;
import com.zyxy.common.vo.LivenessTokenVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.common.web.util.RequestUtil;
import com.zyxy.service.micro.core.api.service.FacePlusService;
import com.zyxy.service.micro.core.api.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigDecimal;

/**
 * 用户控制层
 */
@Api(description = "用户模块")
@RequestMapping("/api/sys/user")
@RestController
public class ApiSysUserController extends BaseController {

    Logger logger = LoggerFactory.getLogger(ApiSysUserController.class);

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private FacePlusService facePlusService;

    @WebLog("用户-修改密码")
    @ApiOperation(value = "修改密码")
    @PostMapping(value = "password")
    public ApiResultVO<String> accept(@RequestBody SysUserPwdDTO formData) {
        formData.setUserId(getSessionUser().getUserInfoId());
        return sysUserService.updatePassword(formData);
    }

    @WebLog("用户-四要素认证")
    @ApiOperation(value = "四要素认证")
    @PostMapping(value = "elementVerify")
    public ApiResultVO<String> elementVerify(@RequestBody ElementVerifyDTO formData) {
        formData.setUserId(getSessionUser().getUserInfoId());
        return sysUserService.elementVerify(formData);
    }

    @WebLog("用户-人工实名认证")
    @ApiOperation(value = "人工实名认证")
    @PostMapping(value = "labourRealName")
    public ApiResultVO<String> labourRealName(@RequestBody LabourRealNameDTO formData) {
        formData.setUserId(getSessionUser().getUserInfoId());
        return sysUserService.labourRealName(formData);
    }

    @WebLog("用户-企业审核认证状态")
    @ApiOperation(value = "企业审核认证状态")
    @RequestMapping(value = "enterpriseAuthStatus")
    public ApiResultVO<EnterpriseAuthStatusVO> enterpriseAuthStatus() {
        BaseDTO formData = new BaseDTO();
        formData.setUserId(getSessionUser().getUserInfoId());
        return sysUserService.enterpriseAuthStatus(formData);
    }

    @WebLog("用户-企业审核认证")
    @ApiOperation(value = "企业审核认证")
    @RequestMapping(value = "enterpriseAuth")
    public ApiResultVO<BigDecimal> enterpriseAuth(@RequestBody EnterpriseAuthDTO formData) {
        formData.setUserId(getSessionUser().getUserInfoId());
        return sysUserService.enterpriseAuth(formData);
    }

    @WebLog(value = "申请活体验证token")
    @ApiOperation(value = "申请活体验证token")
    @GetMapping(value = "livenessToken")
    public ApiResultVO<LivenessTokenVO> livenessToken(String returnUrl) {
        return sysUserService.livenessToken(getSessionUser().getUserInfoId(), returnUrl);
    }

    @WebLog(value = "申请活体验证Notify")
    @ApiOperation(value = "申请活体验证Notify")
    @RequestMapping(value = "livenessNotify", method = {RequestMethod.GET, RequestMethod.POST})
    public ApiResultVO livenessNotify(FaceIdNotifyDTO formData) {
        return sysUserService.livenessNotify(formData);
    }

    @ApiOperation(value = "申请活体验证Return")
    @RequestMapping(value = "livenessReturn")
    public ModelAndView livenessReturn(FaceIdNotifyDTO formData, @RequestParam String returnUrl) {
        BusiExecuteResult busiExecuteResult = facePlusService.livenessReturnBusiExecuteResult(formData);
        if (busiExecuteResult.hasError()) {
            return new ModelAndView("redirect:" + returnUrl + "?success=false");
        }
        return new ModelAndView("redirect:" + returnUrl + "?success=true");
    }

    @WebLog("用户-注册")
    @ApiOperation(value = "用户注册")
    @PostMapping(value = "")
    public ApiResultVO<String> register(@RequestBody UserRegisterDTO formData, HttpServletRequest request) {
        formData.setIp(RequestUtil.getIp(request));
        return sysUserService.register(formData);
    }

    @WebLog("用户-得到找回密码token")
    @ApiOperation(value = "得到找回密码token")
    @PostMapping(value = "lostPwdToken")
    public ApiResultVO<String> lostPwdToken(@RequestBody LostPwdTokenDTO formData) {
        return sysUserService.lostPwdToken(formData);
    }

    @WebLog("用户-找回密码")
    @ApiOperation(value = "用户-找回密码")
    @PostMapping(value = "lostPwd")
    public ApiResultVO lostPwd(@Valid @RequestBody LostPwdDTO formData) {
        return sysUserService.lostPwd(formData);
    }

    @WebLog("用户-修改当前角色")
    @ApiOperation(value = "用户-修改当前角色")
    @PostMapping(value = "changeRole")
    public ApiResultVO changeRole(@Valid @RequestBody ChangeRoleDTO formData) {
        formData.setUserId(getSessionUserId());
        return sysUserService.changeRole(formData);
    }
}
