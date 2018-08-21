package com.zyxy.service.micro.core.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyxy.common.domain.CompromiseRecord;
import com.zyxy.common.dto.CompromiseRecordInsertDTO;
import com.zyxy.common.dto.CompromiseRecordListDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.CompromiseRecordVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.api.service.CompromiseRecordService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 和解调节Controller
 */
@Api(description="和解调节")
@RestController
@RequestMapping("api/compromise/record")
public class ApiComproniseRecordController extends BaseController{
	
	@Autowired
	private CompromiseRecordService compromiseRecordService;
	
	@GetMapping("/{caseId}")
	@ApiOperation("和解调节消息列表")
	public ApiResultVO<List<CompromiseRecordVO>> list(CompromiseRecordListDTO formData){
		formData.setUserId(getSessionUser().getUserInfoId());
		return compromiseRecordService.list(formData);
	}
	
	@ApiOperation("和解调节")
	@PostMapping("/{caseId}")
	public ApiResultVO<List<CompromiseRecordVO>> add(@PathVariable("caseId") String caseId,@RequestBody CompromiseRecordInsertDTO formData){
		formData.setUserId(getSessionUser().getUserInfoId());
		formData.setCaseId(caseId);
		return compromiseRecordService.add(formData);
	}
	
}
