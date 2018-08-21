package com.zyxy.service.micro.core.controller;

import com.zyxy.common.dto.*;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.EnterpriseAuthStatusVO;
import com.zyxy.common.vo.LivenessTokenVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.service.SysUserPwdService;
import com.zyxy.service.micro.core.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigDecimal;

/**
 * 用户控制层
 */
@Api(description = "用户模块")
@RequestMapping("/sys/user")
@RestController
public class SysUserController extends BaseController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysUserPwdService sysUserPwdService;

    @ApiOperation(value = "用户模块-修改密码")
    @RequestMapping(value = "updatePassword")
    public ApiResultVO<String> password(@RequestBody @Valid SysUserPwdDTO formData, BindingResult bindingResult, HttpServletRequest request) {
        /*
         * 参数验证
         */
        if (bindingResult.hasErrors()) {
            return super.validError();
        }  
	    /*
         * 业务验证，密码正确性验证
         */
        BusiValidResult busiValidResult = sysUserPwdService.sysUserPwdBusiValid(formData);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
	    /*
         * 核心业务处理，修改密码
         */
        BusiExecuteResult busiExecuteResult = sysUserPwdService.sysUserPwdBusiExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
        }
        return super.busiExecuteSuccess();
    }

    @ApiOperation(value = "用户模块-当事人注册")
    @RequestMapping(value = "register")
    public ApiResultVO<String> register(@RequestBody @Valid UserRegisterDTO formData, BindingResult bindingResult) {
	    /*
         * 参数验证
         */
        if (bindingResult.hasErrors()) {
            return super.validError();
        }
	    /*
         * 业务验证，密码正确性验证
         */
        BusiValidResult busiValidResult = sysUserService.userRegisterBusiValid(formData);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
	    /*
         * 核心业务处理，修改密码
         */
        BusiExecuteResult busiExecuteResult = sysUserService.userRegisterBusiExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
        }
        return super.busiExecuteSuccess((String) busiExecuteResult.getBody());
    }

    @ApiOperation(value = "用户模块-四要素验证")
    @RequestMapping(value = "elementVerify")
    public ApiResultVO<String> elementVerify(@RequestBody @Valid ElementVerifyDTO formData, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return super.validError();
        }
        BusiValidResult busiValidResult = sysUserService.elementVerifyBusiValid(formData);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult busiExecuteResult = sysUserService.elementVerifyBusiExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
        }
        return super.busiExecuteSuccess();
    }

    @ApiOperation(value = "人工实名认证")
    @RequestMapping(value = "labourRealName")
    public ApiResultVO<LivenessTokenVO> labourRealName(@RequestBody @Valid LabourRealNameDTO formData, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return super.validError();
        }
        BusiValidResult busiValidResult = sysUserService.labourRealNameBusiValid(formData);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult busiExecuteResult = sysUserService.labourRealNameBusiExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
        }
        return super.busiExecuteSuccess();
    }

    @ApiOperation(value = "企业审核认证状态")
    @RequestMapping(value = "enterpriseAuthStatus")
    public ApiResultVO<EnterpriseAuthStatusVO> enterpriseAuth(@RequestBody @Valid BaseDTO formData, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return super.validError();
        }
        BusiValidResult busiValidResult = sysUserService.enterpriseAuthStatusBusiValid(formData);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult<EnterpriseAuthStatusVO> busiExecuteResult = sysUserService.enterpriseAuthStatusBusiExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
        }
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

    @ApiOperation(value = "企业审核认证")
    @RequestMapping(value = "enterpriseAuth")
    public ApiResultVO<BigDecimal> enterpriseAuth(@RequestBody @Valid EnterpriseAuthDTO formData, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return super.validError();
        }
        BusiValidResult busiValidResult = sysUserService.enterpriseAuthBusiValid(formData);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult<BigDecimal> busiExecuteResult = sysUserService.enterpriseAuthBusiExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
        }
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

    @ApiOperation(value = "申请活体验证token")
    @RequestMapping(value = "livenessToken")
    public ApiResultVO<LivenessTokenVO> livenessToken(@RequestParam String userId, @RequestParam String returnUrl) {
        BusiValidResult busiValidResult = sysUserService.getFaceTokenBusiValid(userId);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult<LivenessTokenVO> busiExecuteResult = sysUserService.getFaceTokenBusiExecute(userId, returnUrl);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
        }
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

    @ApiOperation(value = "申请活体验证Notify")
    @RequestMapping(value = "livenessNotify")
    public ApiResultVO livenessNotify(@RequestBody FaceIdNotifyDTO formData) {
        BusiExecuteResult busiExecuteResult = sysUserService.livenessNotifyBusiExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
        }
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

    @ApiOperation(value = "得到找回密码token")
    @PostMapping(value = "lostPwdToken")
    public ApiResultVO<String> lostPwdToken(@Valid @RequestBody LostPwdTokenDTO formData, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return super.validError();
        }
        BusiValidResult busiValidResult = sysUserService.lostPwdTokenBusiValid(formData);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult<String> busiExecuteResult = sysUserService.lostPwdTokenBusiExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
        }
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

    @ApiOperation(value = "用户-找回密码修改密码")
    @PostMapping(value = "lostPwd")
    public ApiResultVO<String> lostPwd(@Valid @RequestBody LostPwdDTO formData, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return super.validError();
        }
        BusiValidResult busiValidResult = sysUserService.lostPwdBusiValid(formData);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult busiExecuteResult = sysUserService.lostPwdBusiExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
        }
        return super.busiExecuteSuccess();
    }

    @ApiOperation(value = "用户-修改当前角色")
    @PostMapping(value = "changeRole")
    public ApiResultVO<String> changeRole(@Valid @RequestBody ChangeRoleDTO formData, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return super.validError();
        }
        BusiExecuteResult busiExecuteResult = sysUserService.changeRoleBusiExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
        }
        return super.busiExecuteSuccess();
    }
}
