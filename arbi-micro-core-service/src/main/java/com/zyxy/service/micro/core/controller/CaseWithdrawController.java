package com.zyxy.service.micro.core.controller;

import javax.validation.Valid;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.WithdrawRecordInsertDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.service.CaseWithdrawService;
/**
 * 撤案Controller
 */
@Api(description="当事人-撤案")
@RequestMapping("/case/withdraw")
@RestController
public class CaseWithdrawController extends BaseController{
	
	@Autowired
	private CaseWithdrawService caseWithdrawService;
	
	@ApiOperation("撤案申请")
	@RequestMapping("")
	public ApiResultVO<String> add(@RequestBody @Valid WithdrawRecordInsertDTO formData,
			BindingResult bindingResult){
		//参数验证
		if (bindingResult.hasErrors()) {
			return super.validError();
		}
		//业务验证
		BusiValidResult busiValidResult = caseWithdrawService.caseWithDrawValid(formData);
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
		}
		//业务处理
		BusiExecuteResult<String> busiExecuteResult = caseWithdrawService.caseWithDrawExecute(formData);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
		}
		return super.ok();
	}

}
