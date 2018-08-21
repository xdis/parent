package com.zyxy.service.micro.core.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.zyxy.common.dto.AgencyAuthorDTO;
import com.zyxy.common.dto.ChangeAuthorDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.AuthorDocVO;
import com.zyxy.common.vo.CaseLitigantValidDTO;
import com.zyxy.common.vo.MessageVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.service.AgencyAuthorizationService;

@Api(description="代理授权")
@RequestMapping("/agent/author")
@RestController
public class AgentAuthorController extends BaseController {
	
	@Autowired
	private AgencyAuthorizationService agencyAuthorizationService;
	
	@ApiOperation("验证用户是否四要素认证")
	@PostMapping("/{cardId}/elementVerify")
	public ApiResultVO<String> elementVerifyValid(@PathVariable("cardId") String cardId){
		if (StringUtils.isBlank(cardId)) {
			return super.validError();
		}
		BusiValidResult busiValidResult = agencyAuthorizationService.agentElementVerifyValid(cardId);
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
		}
		return super.ok();
	}
	
	@ApiOperation("当事人信息验证")
	@RequestMapping("/litigantValid")
	public ApiResultVO<String> litigantValid(@RequestBody CaseLitigantValidDTO formData,BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			return super.validError();
		}
		BusiValidResult busiValidResult = agencyAuthorizationService.caseLitigantValid(formData);
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
		}
		return super.ok();
	}
	
	@ApiOperation("代理授权")
	@RequestMapping("/author")
	public ApiResultVO<String> author(@RequestBody AgencyAuthorDTO formData ,BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			return super.validError();
		}
		BusiValidResult busiValidResult = agencyAuthorizationService.previewAuthorDocValid(formData);
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
		}
		BusiExecuteResult<?> busiExecuteResult = agencyAuthorizationService.agencyAuthorExecute(formData);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),busiExecuteResult.getMsg());
		}
		return super.ok();
	}
	
	@ApiOperation("授权委托书预览")
	@RequestMapping("/preview")
	public ApiResultVO<AuthorDocVO> preview(@RequestBody AgencyAuthorDTO formData ,BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			return super.validError();
		}
		BusiValidResult busiValidResult = agencyAuthorizationService.previewAuthorDocValid(formData);
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
		}
		BusiExecuteResult<AuthorDocVO> busiExecuteResult = agencyAuthorizationService.previewAuthoeDocExecute(formData);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),busiExecuteResult.getMsg());
		}
		return super.ok(busiExecuteResult.getBody());
	}
	
	@ApiOperation("授权短信验证码")
	@RequestMapping("/authorMsg")
	public ApiResultVO<MessageVO> authorMsg(@RequestBody AgencyAuthorDTO formData ,BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			return super.validError();
		}
		BusiValidResult busiValidResult = agencyAuthorizationService.previewAuthorDocValid(formData);
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
		}
		BusiExecuteResult<MessageVO> busiExecuteResult = agencyAuthorizationService.authorMsgExecute(formData);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),busiExecuteResult.getMsg());
		}
		return super.ok(busiExecuteResult.getBody());
	}
	
	@ApiOperation("变更代理权限")
	@RequestMapping("/changeAuthor")
	public ApiResultVO<String> changeAuthor(@RequestBody ChangeAuthorDTO formData,BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			return super.validError();
		}
		BusiValidResult busiValidResult = agencyAuthorizationService.changePrivilegeValid(formData);
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
		}
		BusiExecuteResult<?> busiExecuteResult = agencyAuthorizationService.changePrivilegeExecute(formData);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),busiExecuteResult.getMsg());
		}
		return super.ok();
	}
	
	@ApiOperation("取消授权")
	@PostMapping("/{caseId}/cancelAuthor")
	public ApiResultVO<String> cancelAuthor(@PathVariable("caseId")String caseId,@RequestParam("userId")String userId){
		if (StringUtils.isBlank(userId)||StringUtils.isBlank(caseId)) {
			return super.validError();
		}
		BusiValidResult busiValidResult = agencyAuthorizationService.cancelAgentValid(caseId, userId);
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
		}
		BusiExecuteResult<?> busiExecuteResult = agencyAuthorizationService.cancelAgentExecute(caseId, userId);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),busiExecuteResult.getMsg());
		}
		return super.ok();
	}
	
}
