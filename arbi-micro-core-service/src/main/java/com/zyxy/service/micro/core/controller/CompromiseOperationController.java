package com.zyxy.service.micro.core.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.zyxy.common.dto.CompromiseOperationDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.CompromiseInfoVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.service.CompromiseOperationService;

/**
 * 和解操作
 */
@Api(description="和解操作")
@RestController
@RequestMapping("/compromise/operation")
public class CompromiseOperationController extends BaseController {

	@Autowired
	private CompromiseOperationService compromiseOperationService;
	
	@ApiOperation("和解操作")
	@PostMapping("/{caseId}")
	public ApiResultVO<String> operate(@PathVariable("caseId") String caseId, @RequestBody CompromiseOperationDTO formData,BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			return super.validError();
		}
		BusiValidResult busiValidResult = compromiseOperationService.compromiseOperationValid(formData);
		if (busiValidResult.hasError()) {
			return super.busiExecuteError(busiValidResult.getCode(),busiValidResult.getMsg());
		}
		BusiExecuteResult<?> busiExecuteResult = compromiseOperationService.compromiseOperationExcute(formData);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),busiExecuteResult.getMsg());
		}
		return super.ok();
	}
	
	@ApiOperation("和解信息查询")
	@PostMapping("/{caseId}/info")
	public ApiResultVO<CompromiseInfoVO> info(@PathVariable("caseId") String caseId,@RequestBody String userId){
		if (StringUtils.isBlank(userId)||StringUtils.isBlank(caseId)) {
			return super.validError();
		}
		BusiExecuteResult<CompromiseInfoVO> busiExecuteResult = compromiseOperationService.compromiseInfo(caseId, userId);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),busiExecuteResult.getMsg());
		}
		return super.ok(busiExecuteResult.getBody()) ;
	}
}
