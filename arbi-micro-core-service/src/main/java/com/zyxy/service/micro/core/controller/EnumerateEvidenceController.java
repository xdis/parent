package com.zyxy.service.micro.core.controller;

import javax.validation.Valid;

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

import com.zyxy.common.dto.EnumerateEvidenceDTO;
import com.zyxy.common.dto.OppugnEvidenceDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.EvidenceListVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.service.EnumerateEvidenceService;

@Api(description="举证质证")
@RequestMapping("/case/evidence")
@RestController
public class EnumerateEvidenceController extends BaseController {
	
	@Autowired
	private EnumerateEvidenceService enumerateEvidenceService;
	
	@ApiOperation(value="举证")
	@PostMapping(value="/{caseId}/enumerate")
	public ApiResultVO<String> enumerate(@RequestBody @Valid EnumerateEvidenceDTO formData,
			BindingResult bindingResult){
		//参数验证
		if (bindingResult.hasErrors()) {
			return super.validError();
		}
		if (formData.getCaseEvidences().size()==0) {
			return super.validError();
		}
		//业务验证
		BusiValidResult busiValidResult = enumerateEvidenceService.enumerateEvidenceValid(formData);
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
		}
		//业务执行
		BusiExecuteResult<String> busiExecuteResult = enumerateEvidenceService.enumerateEvidenceExecute(formData);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),busiExecuteResult.getMsg());
		}
		return super.ok();
	}
	
	@ApiOperation(value="质证")
	@PostMapping("/{id}/oppugn")
	public ApiResultVO<String> oppugn(@RequestBody @Valid OppugnEvidenceDTO formData,
			BindingResult bindingResult){
		//参数验证
		if (bindingResult.hasErrors()) {
			return super.validError();
		}
		//业务验证
		BusiValidResult busiValidResult = enumerateEvidenceService.oppugnEvidenceValid(formData);
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
		}
		//业务执行
		BusiExecuteResult<String> busiExecuteResult = enumerateEvidenceService.oppugnEvidenceExecute(formData);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
		}
		return super.ok();
	}
	
	@PostMapping("/{caseId}/list")
	public ApiResultVO<EvidenceListVO> list(@PathVariable("caseId") String caseId,@RequestBody String userId){
		//参数验证
		if (StringUtils.isBlank(caseId)) {
			return super.validError();
		}
		if (StringUtils.isBlank(userId)) {
			return super.validError();
		}
		//业务验证
		BusiValidResult busiValidResult = enumerateEvidenceService.evidenceListValid(caseId, userId);
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
		}
		//业务处理
		BusiExecuteResult<EvidenceListVO> busiExecuteResult= enumerateEvidenceService.evidenceListExecute(caseId);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
		}
		return super.ok(busiExecuteResult.getBody());
	}

}