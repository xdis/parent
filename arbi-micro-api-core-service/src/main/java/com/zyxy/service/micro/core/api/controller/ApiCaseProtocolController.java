package com.zyxy.service.micro.core.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.ProtocolRecordInsertDTO;
import com.zyxy.common.dto.ProtocolResponseDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.api.service.CaseProtocolService;

@Api(description="当事人和解协议书")
@RequestMapping(value="/api/case/protocol")
@RestController
public class ApiCaseProtocolController extends BaseController{
	
	@Autowired
	private CaseProtocolService caseProtocolService;
	
	@WebLog(value = "调解协议书申请")
	@ApiOperation(value="调解协议书申请")
	@PostMapping("/{caseId}")
	public ApiResultVO<String> add(@PathVariable("caseId") String caseId, @RequestBody ProtocolRecordInsertDTO formData){
		formData.setUserId(getSessionUser().getUserInfoId());
		formData.setCaseId(caseId);
		return caseProtocolService.add(formData);
	}
	
	@WebLog(value = "调解协议书申请回应")
	@ApiOperation(value="调解协议书申请回应")
	@PutMapping("/{caseId}")
	public ApiResultVO<String> response(@PathVariable("caseId") String caseId, @RequestBody ProtocolResponseDTO formData){
		formData.setUserId(getSessionUser().getUserInfoId());
		return caseProtocolService.response(formData);
	}
	
	
}
