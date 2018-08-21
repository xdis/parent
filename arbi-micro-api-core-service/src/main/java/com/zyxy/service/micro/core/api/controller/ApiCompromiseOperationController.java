package com.zyxy.service.micro.core.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.CompromiseOperationDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.CompromiseInfoVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.api.service.CompromiseOperationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 和解操作
 */
@Api(description="和解操作")
@RequestMapping("/api/compromise/operation")
@RestController
public class ApiCompromiseOperationController extends BaseController {
	
	@Autowired
	private CompromiseOperationService compromiseOperationService;
	
	@WebLog("和解操作")
	@ApiOperation("和解操作")
	@PostMapping("/{caseId}")
	public ApiResultVO<String> operation(@PathVariable("caseId") String caseId,@RequestBody CompromiseOperationDTO formData){
		formData.setUserId(getSessionUser().getUserInfoId());
		formData.setCaseId(caseId);
		return compromiseOperationService.operation(formData.getCaseId(), formData);
	}
	
	@WebLog("和解信息查询")
	@ApiOperation("和解信息查询")
	@GetMapping("/{caseId}/info")
	public ApiResultVO<CompromiseInfoVO> info(@PathVariable("caseId") String caseId){
		return compromiseOperationService.info(caseId, getSessionUser().getUserInfoId());
	}
}
