package com.zyxy.service.micro.core.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.zyxy.common.domain.ArgueRecord;
import com.zyxy.common.dto.ArgueRecordInsertDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.service.ArgueRecordService;

/**
 * 辩论Controller
 */
@Api(description="辩论")
@RequestMapping("/case/argue")
@RestController
public class ArgueRecordController extends BaseController{
	
	@Autowired
	private ArgueRecordService argueRecordService;
	
	@ApiOperation("辩论记录列表")
	@PostMapping("/lists/{caseId}")
	public ApiResultVO<List<ArgueRecord>> list(@PathVariable("caseId") String caseId){
		if (StringUtils.isBlank(caseId)) {
			return super.validError();
		}
		BusiExecuteResult<List<ArgueRecord>> busiExecuteResult = argueRecordService.argueRecordList(caseId);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
		}
		return super.ok(busiExecuteResult.getBody());
	}
	
	@ApiOperation("辩论记录增加")
	@RequestMapping("/add")
	public ApiResultVO<List<ArgueRecord>> add(@RequestBody @Valid ArgueRecordInsertDTO formData,
			BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			return super.validError();
		}
		BusiValidResult busiValidResult = argueRecordService.argueInsertValid(formData);
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
		}
		BusiExecuteResult<List<ArgueRecord>> busiExecuteResult = argueRecordService.argueInsertExecute(formData);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
		}
		return super.ok(busiExecuteResult.getBody());
	}
}
