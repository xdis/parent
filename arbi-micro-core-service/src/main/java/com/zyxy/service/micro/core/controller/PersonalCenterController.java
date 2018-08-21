package com.zyxy.service.micro.core.controller;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.zyxy.common.dto.LitigantEmailUpdateDTO;
import com.zyxy.common.dto.LitigantInfoUpdateDTO;
import com.zyxy.common.dto.PassWordModifyDTO;
import com.zyxy.common.dto.PasswordValidDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.UserBaseInfoVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.service.PersonalCenterService;
/**
 * 当事人-个人中心
 */
@Api(description="当事人-个人中心")
@RequestMapping("/personal/center")
@RestController
public class PersonalCenterController extends BaseController {
	
	@Autowired
	private PersonalCenterService centerService;
	
	@ApiOperation(value="当事人-个人中心-验证密码")
	@RequestMapping("/passwordValid")
	public ApiResultVO<String> passwordValid(@RequestBody @Valid PasswordValidDTO formData,
			BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			return super.validError();
		}
		BusiValidResult busiValidResult = centerService.passwordValid(formData.getUserId(), formData.getPassword());
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
		}
		return super.ok();
	}
	
	@ApiOperation(value="当事人-个人中心-修改邮箱")
	@RequestMapping("/modifyEmail")
	public ApiResultVO<String> modifyEmail(@RequestBody @Valid LitigantEmailUpdateDTO formData,
			BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			return super.validError();
		}
		BusiValidResult busiValidResult = centerService.passwordValid(formData.getUserId(), formData.getPassword());
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
		}
		BusiExecuteResult<String> busiExecuteResult = centerService.updateEmail(formData);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),busiExecuteResult.getMsg());
		}
		return super.ok(); 
	}
	
	@ApiOperation(value="当事人-个人中心-修改密码")
	@RequestMapping("/modifyPassword")
	public ApiResultVO<String> modifyPassword(@RequestBody @Valid PassWordModifyDTO formData,BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			return super.validError();
		}
		BusiValidResult busiValidResult = centerService.passwordValid(formData.getUserId(), formData.getOldPassword());
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
		}
		BusiExecuteResult<String> busiExecuteResult = centerService.updatePasswordExcute(formData);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),busiExecuteResult.getMsg());
		}
		return super.ok(); 
	} 
	
	@ApiOperation(value="当事人-个人中心-修改基本信息")
	@RequestMapping("/modifyInfo")
	public ApiResultVO<String> modifyInfo(@RequestBody @Valid LitigantInfoUpdateDTO formData,BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			return super.validError();
		}
		BusiExecuteResult<String> busiExecuteResult = centerService.updateBaseInfoExcute(formData);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),busiExecuteResult.getMsg());
		}
		return super.ok();
	}
	
	@ApiOperation(value="当事人-个人中心-基本信息")
	@RequestMapping("/getBaseInfo")
	public ApiResultVO<UserBaseInfoVO> getBaseInfo(@RequestParam("userId")String userId){
		if (StringUtils.isBlank(userId)) {
			return super.validError();
		}
		BusiExecuteResult<UserBaseInfoVO> busiExecuteResult = centerService.userBaseInfoExcute(userId);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),busiExecuteResult.getMsg());
		}
		return super.ok(busiExecuteResult.getBody());
	}
	
}
