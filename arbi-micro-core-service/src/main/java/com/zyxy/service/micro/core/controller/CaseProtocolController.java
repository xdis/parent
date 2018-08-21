package com.zyxy.service.micro.core.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.zyxy.common.dto.ProtocolRecordInsertDTO;
import com.zyxy.common.dto.ProtocolResponseDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.service.CaseProtocolService;

/**
 * 调节申请
 */
@Api(description="调节申请")
@RequestMapping("/case/protocol")
@RestController
public class CaseProtocolController extends BaseController{
	
	@Autowired
	private CaseProtocolService caseProtocolService;
	
	@ApiOperation(value="")
	@RequestMapping("/add")
	public ApiResultVO<String> add(@RequestBody @Valid ProtocolRecordInsertDTO formData,
				BindingResult bindingResult){
		//参数验证
		if (bindingResult.hasErrors()) {
			return super.validError();
		}
		//业务验证
		BusiValidResult busiValidResult = caseProtocolService.protocolApplyValid(formData);
		if (busiValidResult.hasError()) {
			super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
		}
		//业务处理
		BusiExecuteResult<String> busiExecuteResult = caseProtocolService.protocolApplyExecute(formData);
		if (busiExecuteResult.hasError()) {
			super.busiExecuteError(busiExecuteResult.getCode(),busiExecuteResult.getMsg());
		}
		return super.ok();
	}
	
	@ApiOperation("协议书回应")
	@RequestMapping("/response")
	public ApiResultVO<String> response(@RequestBody ProtocolResponseDTO formData,
			BindingResult bindingResult){
		//参数验证
		if (bindingResult.hasErrors()) {
			return super.validError();
		}
		//业务验证
		BusiValidResult busiValidResult = caseProtocolService.protocolResponseValid(formData);
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
		}
		//业务处理
		BusiExecuteResult<String> busiExecuteResult = caseProtocolService.protoclResponseExecute(formData);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),busiExecuteResult.getMsg());
		}
		return super.ok();
	}

}
