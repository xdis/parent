package com.zyxy.service.micro.core.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyxy.common.domain.CompromiseApply;
import com.zyxy.common.dto.CompromiseApplyInsertDTO;
import com.zyxy.common.dto.CompromiseResponseDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ApiResultVO.Coder;
import com.zyxy.common.vo.CompromiseApplyInfoVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.service.CompromiseApplyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 和解申请
 */
@Api(description="和解申请")
@RestController
@RequestMapping("/compromise/apply")
public class CompromiseApplyController extends BaseController{
	
	@Autowired
	private CompromiseApplyService compromiseApplyService;

	@ApiOperation("当事人和解申请")
	@RequestMapping("/add")
	public ApiResultVO<String> add(@RequestBody @Valid CompromiseApplyInsertDTO formData,
			BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			return super.validError();
		}
		BusiValidResult busiValidResult = compromiseApplyService.compromiseApplyValid(formData);
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
		}
		BusiExecuteResult<String> busiExecuteResult = compromiseApplyService.compromiseApplyExecute(formData);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
		}
		return super.ok();
	}
	
	@ApiOperation("和解回应")
	@RequestMapping("/response")
	public ApiResultVO<String> response(@RequestBody @Valid CompromiseResponseDTO formData,
			BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			return super.validError();
		}
		BusiValidResult busiValidResult = compromiseApplyService.compromiseResponseValid(formData);
		if (busiValidResult.hasError()) {
			return super.busiExecuteError(busiValidResult.getCode(), busiValidResult.getMsg());
		}
		BusiExecuteResult<String> busiExecuteResult = compromiseApplyService.compromiseResponseExecute(formData);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
		}
		return super.ok();
	}
	
	@ApiOperation("和解申请信息")
	@RequestMapping("/{caseId}/info")
	public ApiResultVO<List<CompromiseApplyInfoVO>> get(@PathVariable("caseId") String caseId,@RequestBody String userId){
		if (StringUtils.isBlank(caseId)) {
			return super.validError();
		}
		BusiValidResult busiValidResult = compromiseApplyService.compromiseApplyInfoValid(caseId,userId);
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
		}
		BusiExecuteResult<List<CompromiseApplyInfoVO>> busiExecuteResult = compromiseApplyService.compromiseApplyInfoExecute(caseId,userId);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
		}
		return super.ok(busiExecuteResult.getBody());
	}
}
