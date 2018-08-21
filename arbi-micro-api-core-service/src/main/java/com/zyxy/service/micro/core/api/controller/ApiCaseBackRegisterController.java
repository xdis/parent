package com.zyxy.service.micro.core.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.BackRegisterCaseDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.DocHeadVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.api.service.CaseBackRegisterService;

/**
 * 案件-反请求申请
 */
@Api(description = "案件-反请求申请")
@RequestMapping("/api/back/register")
@RestController
public class ApiCaseBackRegisterController extends BaseController{
	
	@Autowired
	private CaseBackRegisterService caseBackRegisterService;
	
	@WebLog(value="案件-反请求申请")
	@ApiOperation(value="案件-反请求申请")
	@PostMapping("/{caseId}")
	public ApiResultVO<String> add(@RequestBody BackRegisterCaseDTO formData){
		formData.setCreaterId(getSessionUser().getUserInfoId());
		return caseBackRegisterService.backRegister(formData);
	}
	

	@WebLog(value="案件-反请求申请")
	@ApiOperation(value="案件-反请求申请")
	@GetMapping("/{caseId}/headInfo")
	public ApiResultVO<DocHeadVO> headInfo(@PathVariable("caseId") String caseId){
		return caseBackRegisterService.headInfo(caseId, getSessionUser().getUserInfoId());
	}
}
