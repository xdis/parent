package com.zyxy.service.micro.core.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyxy.common.dto.CompromiseRecordInsertDTO;
import com.zyxy.common.dto.CompromiseRecordListDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.CompromiseRecordVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.service.CompromiseRecordService;

/**
 * 案件和解调节controller
 */
@Api(description="案件和解调节")
@RestController
@RequestMapping("/compromise/record")
public class CompromiseRecordController extends BaseController{
	
	@Autowired
	private CompromiseRecordService compromiseRecordService;

	
	@ApiOperation("和解记录列表")
	@RequestMapping("/list")
	public ApiResultVO<List<CompromiseRecordVO>> list(@RequestBody CompromiseRecordListDTO formData,BindingResult bindingResult){
		//参数验证
		if (bindingResult.hasErrors()) {
			return super.validError();
		}
		List<CompromiseRecordVO> list = compromiseRecordService.list(formData);
		
		return super.ok(list);
	}
	
	@ApiOperation("发送和解消息")
	@RequestMapping("/add")
	public ApiResultVO<List<CompromiseRecordVO>> add(@RequestBody CompromiseRecordInsertDTO formData,BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			return super.validError();
		}
		BusiValidResult busiValidResult = compromiseRecordService.compromiseSendValid(formData);
		if (busiValidResult.hasError()) {
			return super.busiExecuteError(busiValidResult.getCode(), busiValidResult.getMsg());
		}
		BusiExecuteResult<List<CompromiseRecordVO>> busiExecuteResult = compromiseRecordService.compromiseSendExecute(formData);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),busiExecuteResult.getMsg());
		}
		return super.busiExecuteSuccess(busiExecuteResult.getBody());
	}
}
