package com.zyxy.service.micro.core.controller;

import com.zyxy.common.vo.CaseEvaluationVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyxy.common.dto.CaseEvaluationDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.service.CaseEvaluationService;

@Api(description="案件评论模块")
@Controller
@RequestMapping("/arbitrator/caseEvaluation")
public class CaseEvaluationController extends BaseController{

	@Autowired
	private CaseEvaluationService evaluationService;
	
	@RequestMapping(value="")
	@ApiOperation(value="案件评论列表")
	@ResponseBody
	public ApiResultVO<CaseEvaluationVO> query(@RequestBody @Valid CaseEvaluationDTO formData, BindingResult bindingResult, HttpServletRequest request){

		//参数验证
		if(bindingResult.hasErrors()){
			super.validError();
		}
		
		//获取裁决员id并设置到CaseEvaluationDTO对象
		formData.setArbitratorId(formData.getUserId());
		
		BusiExecuteResult<CaseEvaluationVO> paged=evaluationService.queryCaseEvaluationBusiExecute(formData);

        return super.busiExecuteSuccess(paged.getBody());
	}
}
