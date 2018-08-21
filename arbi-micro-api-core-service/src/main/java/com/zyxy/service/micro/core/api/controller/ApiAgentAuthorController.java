package com.zyxy.service.micro.core.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.AgencyAuthorDTO;
import com.zyxy.common.dto.ChangeAuthorDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.AuthorDocVO;
import com.zyxy.common.vo.CaseLitigantValidDTO;
import com.zyxy.common.vo.MessageVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.api.service.AgentAuthorService;

@Api(description="代理授权")
@RequestMapping("/api/agent/author")
@RestController
public class ApiAgentAuthorController extends BaseController {

	@Autowired
	private AgentAuthorService agentAuthorService;
	
	@WebLog("验证是否四要素认证")
	@ApiOperation("验证是否四要素认证")
	@PostMapping("/{cardId}/elementVerify")
	public ApiResultVO<String> elementVerify(@PathVariable("cardId") String cardId){
		return agentAuthorService.elementVerify(cardId);
	};
	
	@WebLog("获取授权验证码")
	@ApiOperation("获取授权验证码")
	@PostMapping("/litigantValid")
	public ApiResultVO<String> litigantValid(@RequestBody CaseLitigantValidDTO formData){
		formData.setUserId(getSessionUser().getUserInfoId());
		return agentAuthorService.litigantValid(formData);
	}
	
	@WebLog("授权书预览")
	@ApiOperation("授权书预览")
	@PostMapping("/preview")
	public ApiResultVO<AuthorDocVO> preview(@RequestBody AgencyAuthorDTO formData){
		formData.setUserId(getSessionUser().getUserInfoId());
		return agentAuthorService.preview(formData);
	}
	
	@WebLog("获取授权验证码")
	@ApiOperation("获取授权验证码")
	@PostMapping("/authorMsg")
	public ApiResultVO<MessageVO> authorMsg(@RequestBody AgencyAuthorDTO formData){
		formData.setUserId(getSessionUser().getUserInfoId());
		return agentAuthorService.authorMsg(formData);
	}
	
	@WebLog("授权")
	@ApiOperation("授权")
	@PostMapping("/author")
	public ApiResultVO<String> author(@RequestBody AgencyAuthorDTO formData){
		formData.setUserId(getSessionUser().getUserInfoId());
		return agentAuthorService.author(formData);
	}
	
	@WebLog("更改授权权限")
	@ApiOperation("更改授权权限")
	@PostMapping("/changeAuthor")
	public ApiResultVO<String> changeAuthor(@RequestBody ChangeAuthorDTO formData){
		formData.setUserId(getSessionUser().getUserInfoId());
		return agentAuthorService.changeAuthor(formData);
	}
	
	@WebLog("取消授权")
	@ApiOperation("取消授权")
	@PostMapping("/{caseId}/cancelAuthor")
	public ApiResultVO<String> cancelAuthor(@PathVariable("caseId") String caseId){
		return agentAuthorService.cancelAuthor(caseId,getSessionUser().getUserInfoId());
	}
} 
