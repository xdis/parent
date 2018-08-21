package com.zyxy.service.micro.core.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.BackRegisterCaseDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.DocHeadVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.service.CaseBackRegisterService;

@Api(description="反请求申请")
@RestController
@RequestMapping("/case/back")
public class CaseBackRegisterController extends BaseController{

	
	@Autowired
	private CaseBackRegisterService caseBackRegisterService;
	
	@ApiOperation("反请求申请")
	@RequestMapping("/regesiter")
	public ApiResultVO<String> backRegister(@RequestBody @Valid BackRegisterCaseDTO formData,BindingResult bindingResult,HttpServletRequest request){
		 //参数验证
		 if (bindingResult.hasErrors()) {
			 return super.validError();
		 }
		 //业务验证
		 BusiValidResult busiValidResult = caseBackRegisterService.caseBackRegisterBusiValid(formData);
		 if (busiValidResult.hasError()) {
			 return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
		 }
		 //业务处理
		 BusiExecuteResult<String> busiExecuteResult = caseBackRegisterService.caseBackRegisterBusiExecute(formData);
		 if (busiExecuteResult.hasError()) {
			 return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
		 }
	     return super.busiExecuteSuccess();
	}
	
	@ApiOperation("获取申请人被申请人信息")
	@RequestMapping("/{caseId}/headInfo")
	public ApiResultVO<DocHeadVO> getDocHeadVO(@PathVariable("caseId") String caseId,@RequestBody String userId){
		if (StringUtils.isBlank(userId)||StringUtils.isBlank(caseId)) {
			return super.validError();
		}
		BusiValidResult busiValidResult = caseBackRegisterService.docHeadValid(caseId, userId);
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
		}
		BusiExecuteResult<DocHeadVO> busiExecuteResult = caseBackRegisterService.docHeadExecute(caseId, userId);
		if (busiExecuteResult.hasError()) {
			return super.busiValidError(busiExecuteResult.getCode(),busiExecuteResult.getMsg());
		}
		return super.busiExecuteSuccess(busiExecuteResult.getBody());
	}
}
