package com.zyxy.service.micro.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.web.util.RequestUtil;
import com.zyxy.service.micro.api.dto.ReqCompanyRegisterDTO;
import com.zyxy.service.micro.api.dto.ReqLivenessTokenDTO;
import com.zyxy.service.micro.api.dto.ReqPersonRegisterDTO;
import com.zyxy.service.micro.api.dto.ReqSmsCodeDTO;
import com.zyxy.service.micro.api.dto.ReqSSOTokenDTO;
import com.zyxy.service.micro.api.dto.ReqUserAuthStatusDTO;
import com.zyxy.service.micro.api.dto.ReqUserLabourAuthDTO;
import com.zyxy.service.micro.api.dto.ResResultDTO;
import com.zyxy.service.micro.api.service.api.Bank4ElementSmsService;
import com.zyxy.service.micro.api.service.api.CompanyRegisterService;
import com.zyxy.service.micro.api.service.api.PersonRegisterService;
import com.zyxy.service.micro.api.service.api.UserAuthStatusService;
import com.zyxy.service.micro.api.service.api.UserLabourAuthService;
import com.zyxy.service.micro.api.service.api.UserLivenessTokenService;
import com.zyxy.service.micro.api.service.api.UserSSOTokenService;

@Api(description="用户模块")
@RequestMapping("/api")
@RestController
public class UserApiController extends BaseController{
    
	@Autowired
	private PersonRegisterService personRegisterService;
	@Autowired
	private CompanyRegisterService companyRegisterService;
	@Autowired
	private UserSSOTokenService userSSOTokenService;
	@Autowired
	private Bank4ElementSmsService bank4ElementSmsService;
	@Autowired
	private UserLivenessTokenService userLivenessTokenService;
	@Autowired
	private UserAuthStatusService userAuthStatusService;
	@Autowired
	private UserLabourAuthService userLabourAuthService;
	
    @WebLog("获取短信验证码（四要素）")
    @ApiOperation("获取短信验证码（四要素）")
    @RequestMapping(value = "/user/auth/getSmsCode", method = {RequestMethod.POST})
    public ResResultDTO getSmsCode(HttpServletRequest request
            , ReqSmsCodeDTO dto
            ) {
        ResResultDTO ret = bank4ElementSmsService.call(dto, RequestUtil.getIp(request));
        return ret;
    }
	
	@WebLog("自然人注册")
	@ApiOperation(value="自然人注册")
	@RequestMapping(value = "/user/person/register", method = {RequestMethod.POST})
	public ResResultDTO personRegister(HttpServletRequest request
	        , ReqPersonRegisterDTO dto
	        ) {
        ResResultDTO ret = personRegisterService.call(dto, RequestUtil.getIp(request));
	    return ret;
	}
	
	@WebLog("企业注册")
	@ApiOperation(value="企业注册")
	@RequestMapping(value = "/user/company/register", method = {RequestMethod.POST})
	public ResResultDTO companyRegister(HttpServletRequest request
	        , ReqCompanyRegisterDTO dto
	        ) {
	    ResResultDTO ret = companyRegisterService.call(dto, RequestUtil.getIp(request));
	    return ret;
	}
	
	@WebLog("获取用户单点登录token")
	@ApiOperation(value="获取用户单点登录token")
	@RequestMapping(value = "/user/sso/token", method = {RequestMethod.POST})
	public ResResultDTO getSSOToken(HttpServletRequest request
	        , ReqSSOTokenDTO dto
	        ) {
	    ResResultDTO ret = userSSOTokenService.call(dto, RequestUtil.getIp(request));
	    return ret;
	}
	
	@WebLog("活体认证")
    @ApiOperation("活体认证")
    @RequestMapping(value = "/user/auth/person/livenessToken", method = {RequestMethod.POST})
    public ResResultDTO getLivenessToken(HttpServletRequest request
            , ReqLivenessTokenDTO dto
            ) {
        ResResultDTO ret = userLivenessTokenService.call(dto, RequestUtil.getIp(request));
        return ret;
    }
	
	@WebLog("企业认证-对公转账认证")
	@ApiOperation("企业认证-对公转账认证")
	@RequestMapping(value = "/user/auth/company/accInfo", method = {RequestMethod.POST})
	public ResResultDTO getPlatformAccInfo(HttpServletRequest request
	        , ReqLivenessTokenDTO dto
	        ) {
	    ResResultDTO ret = userLivenessTokenService.call(dto, RequestUtil.getIp(request));
	    return ret;
	}
	
	@WebLog("用户认证状态查询")
	@ApiOperation("用户认证状态查询")
	@RequestMapping(value = "/user/auth/status", method = {RequestMethod.POST})
	public ResResultDTO getUserAuthStatus(HttpServletRequest request
	        , ReqUserAuthStatusDTO dto
	        ) {
	    ResResultDTO ret = userAuthStatusService.call(dto, RequestUtil.getIp(request));
	    return ret;
	}
	
	@WebLog("用户人工审核认证-手持身份证上传")
	@ApiOperation("用户人工审核认证-手持身份证上传")
	@RequestMapping(value = "/user/auth/labour", method = {RequestMethod.POST})
	public ResResultDTO userLabourAuth(HttpServletRequest request
	        , ReqUserLabourAuthDTO dto
	        ) {
	    ResResultDTO ret = userLabourAuthService.call(dto, RequestUtil.getIp(request));
	    return ret;
	}
}
