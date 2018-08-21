package com.zyxy.service.micro.core.api.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.CaseArbitratorOprInsertDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ArbitratorAvoidRecordVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.api.service.ArbitratoerChoiceService;
/**
 * 当事人仲裁选择controller
 */
@Api(description = "当事人选择仲裁员")
@RestController
@RequestMapping("/api/arbitrator/choice")
public class ApiArbitratorChoiceController extends BaseController{
	
	@Autowired
	private ArbitratoerChoiceService arbitratoerChoiceService; 
	
	@WebLog(value = "当事人 - 选择仲裁员")
	@ApiOperation(value = "当事人选择仲裁员")
	@PostMapping("/{caseId}")
	public ApiResultVO<String> add(@PathVariable("caseId") String caseId, @RequestBody CaseArbitratorOprInsertDTO formData){
		formData.setUserId(getSessionUser().getUserInfoId());
		formData.setCaseId(caseId);
		return arbitratoerChoiceService.arbitratorChoice(formData);
	}
	
	@WebLog(value = "仲裁员回避记录列表")
	@ApiOperation(value = "当事人选择仲裁员")
	@GetMapping("/{caseId}/list")
	public ApiResultVO<List<ArbitratorAvoidRecordVO>> list(@PathVariable("caseId") String caseId) {
		return arbitratoerChoiceService.list(caseId, getSessionUser().getUserInfoId());
	}
}
