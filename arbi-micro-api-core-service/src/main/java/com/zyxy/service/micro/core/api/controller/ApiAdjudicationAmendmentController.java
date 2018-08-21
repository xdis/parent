package com.zyxy.service.micro.core.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.AdjudiAmendRecordAuditDTO;
import com.zyxy.common.dto.AdjudiAmendRecordInsertDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.api.service.AdjudicationAmendmentService;
@Api(description="补正")
@RestController
@RequestMapping("/api/adjudication/amendment")
public class ApiAdjudicationAmendmentController extends BaseController{
	
	@Autowired
	private AdjudicationAmendmentService adjudicationAmendmentService;
	
	@PostMapping("")
	@WebLog("当事人-申请补正")
	@ApiOperation("当事人-申请补正")
	public ApiResultVO<String> add(@RequestBody AdjudiAmendRecordInsertDTO formData){
		formData.setUserId(getSessionUser().getUserInfoId());
//		formData.setUserId("5");
		return adjudicationAmendmentService.add(formData);
	}
	
	@PutMapping("/{id}")
	@WebLog("仲裁员-补正审核")
	@ApiOperation("仲裁员-补正审核")
	public ApiResultVO<String> add(@RequestBody AdjudiAmendRecordAuditDTO formData){
		formData.setUserId(getSessionUser().getUserInfoId());
//		formData.setUserId("3");
		return adjudicationAmendmentService.audit(formData);
	}
}
