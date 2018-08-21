package com.zyxy.service.micro.core.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.CaseAvoidRecordInsertDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.api.service.CaseAviodService;

@Api(description="当事人秘书 、仲裁员回避")
@RestController
@RequestMapping("/api/case/avoid")
public class ApiCaseAvoidController extends BaseController{
	@Autowired
	private CaseAviodService caseAviodService;
	
	@WebLog("秘书 、仲裁员回避申请")
	@ApiOperation("秘书 、仲裁员回避申请")
	@PostMapping("")
	public ApiResultVO<String> add(@RequestBody CaseAvoidRecordInsertDTO formData){
		formData.setCreaterId(getSessionUser().getUserInfoId());
//		formData.setCreaterId("5");
		return caseAviodService.add(formData);
	}
	
}
