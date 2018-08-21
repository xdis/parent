package com.zyxy.service.micro.core.controller;

import javax.validation.Valid;

import com.zyxy.common.service.BusiExecuteResult;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.common.dto.CaseAvoidRecordInsertDTO;
import com.zyxy.service.micro.core.service.CaseAvoidService;
/**
 * 回避请求controller
 */
@Api(description="回避操作")
@RequestMapping("/public/case/avoid")
@RestController
public class CaseAvoidController extends BaseController{
	
	@Autowired
	private CaseAvoidService caseAvoidService;

	@ApiOperation("公共-申请回避")
	@RequestMapping("")
	public ApiResultVO<String> add(@Valid @RequestBody CaseAvoidRecordInsertDTO formData, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
			return super.validError();
		}
        BusiExecuteResult<String> busiExecuteResult = caseAvoidService.insertCaseAvoidBusiExecute(formData);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
		}
		return super.ok();
	}
	
}
