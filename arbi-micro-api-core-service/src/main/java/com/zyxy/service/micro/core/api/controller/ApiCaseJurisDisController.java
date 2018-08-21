package com.zyxy.service.micro.core.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.CaseJurisDisInsertDTO;
import com.zyxy.common.dto.JurisDisFeedBackDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.api.service.CaseJurisDisService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="管辖权异议")
@RequestMapping("api/case/juris/dis")
@RestController
public class ApiCaseJurisDisController extends BaseController{

	@Autowired
	private CaseJurisDisService caseJurisDisService;
	
	@ApiOperation("管辖权异议申请")
	@WebLog("公共-申请管辖权异议")
	@PostMapping("")
	public ApiResultVO<String> add(@RequestBody CaseJurisDisInsertDTO formData){
		formData.setCreaterId(getSessionUser().getUserInfoId());
		return caseJurisDisService.add(formData);
	}
	
	@ApiOperation("管辖权异议反馈")
	@WebLog("管辖权异议反馈")
	@PutMapping("/{caseId}")
	public ApiResultVO<String> feedback(@RequestBody JurisDisFeedBackDTO formData){
		formData.setUserId(getSessionUser().getUserInfoId());
		return caseJurisDisService.feedback(formData);
	}
}
