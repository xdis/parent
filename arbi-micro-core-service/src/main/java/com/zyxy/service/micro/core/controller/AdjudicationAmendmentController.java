package com.zyxy.service.micro.core.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.zyxy.common.dto.AdjudiAmendRecordAuditDTO;
import com.zyxy.common.dto.AdjudiAmendRecordInsertDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.service.AmendmentService;

/**
 * 补正Controller
 */
@Api(description="补正")
@RequestMapping("/adjudication/amendment")
@RestController
public class AdjudicationAmendmentController extends BaseController{
	
	@Autowired
	private AmendmentService adjudicationAmendmentService;
	
	@ApiOperation("补正-申请")
	@RequestMapping("/apply")
	public ApiResultVO<String> add(@RequestBody @Valid AdjudiAmendRecordInsertDTO formData,
			BindingResult bindingResult){
		//参数验证
		if (bindingResult.hasErrors()) {
			return super.validError();
		}
		//业务验证
		BusiValidResult busiValidResult = adjudicationAmendmentService.adjudicationAmendmentInsertValid(formData);
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
		}
		//业务处理
		BusiExecuteResult<String> busiExecuteResult = adjudicationAmendmentService.adjudicationAmendmentInsertExecute(formData);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),busiExecuteResult.getMsg());
		}
		return super.busiExecuteSuccess();
	}
	
	@ApiOperation("仲裁员-审核")
	@RequestMapping("/audit")
	public ApiResultVO<String> audit(@RequestBody @Valid AdjudiAmendRecordAuditDTO formData,
			BindingResult bindingResult){
		//参数验证
		if (bindingResult.hasErrors()) {
			return super.validError();
		}
		//业务验证
		BusiValidResult busiValidResult = adjudicationAmendmentService.adjudicationAmendmentAuditValid(formData);
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
		}
		//业务执行
		BusiExecuteResult<String> busiExecuteResult = adjudicationAmendmentService.
				adjudicationAmendmentAuditExecute(formData);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
		}
		return super.busiExecuteSuccess();
	}
	
}
