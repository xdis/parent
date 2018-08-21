package com.zyxy.service.micro.core.controller;

import javax.validation.Valid;

import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ApiResultVO.Coder;
import com.zyxy.common.web.BaseController;
import com.zyxy.common.dto.CaseJurisDisInsertDTO;
import com.zyxy.common.dto.JurisDisFeedBackDTO;
import com.zyxy.service.micro.core.service.CaseJurisDisService;

/**
 * 管辖权异议控制层
 *
 */
@Api(description="申请管辖权异议")
@RequestMapping("/public/case/jurisdis")
@RestController
public class CaseJurisDisController extends BaseController{
	
	@Autowired
	private CaseJurisDisService caseJurisDisService;

	@ApiOperation("公共-申请管辖权异议")
	@RequestMapping("")
	public ApiResultVO<String> add(@Valid @RequestBody CaseJurisDisInsertDTO formData, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
			return super.validError();
		}
		BusiExecuteResult<String> busiExecuteResult = caseJurisDisService.insertCaseJurisDis(formData);
        if (busiExecuteResult.hasError()) {
        	return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
		}
		return super.ok();
	}
	
	@ApiOperation("管辖权异议反馈")
	@RequestMapping("/feedback")
	public ApiResultVO<String> feedback(@RequestBody JurisDisFeedBackDTO formData,BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			return super.validError();
		}
		BusiValidResult busiValidResult = caseJurisDisService.jurisDisFeedBackValid(formData);
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
		}
		BusiExecuteResult<String> busiExecuteResult = caseJurisDisService.jurisDisFeedBackExecute(formData);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),busiExecuteResult.getMsg());
		}
		return super.ok();
	}
	
}
