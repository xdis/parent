package com.zyxy.service.micro.core.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.EnumerateEvidenceDTO;
import com.zyxy.common.dto.OppugnEvidenceDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.EvidenceListVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.api.service.EnumerateEvidenceService;

@Api(description="举证质证")
@RequestMapping("/api/case/evidence")
@RestController
public class ApiEunmerateEvidenceController extends BaseController{
	
	@Autowired
	private EnumerateEvidenceService enumerateEvidenceService;
	
	@ApiOperation(value="举证")
	@WebLog("举证")
	@PostMapping("/{caseId}")
	public ApiResultVO<String> enumerate(@RequestBody EnumerateEvidenceDTO formData){
		formData.setUserId(getSessionUser().getUserInfoId());
//		formData.setUserId("5");
		return enumerateEvidenceService.enumerate(formData.getCaseId(), formData);
	}

	@ApiOperation(value="质证")
	@WebLog("质证")
	@PutMapping("/{caseId}")
	public ApiResultVO<String> oppugn(@RequestBody OppugnEvidenceDTO formData){
		formData.setUserId(getSessionUser().getUserInfoId());
//		formData.setUserId("3");
		return enumerateEvidenceService.oppugn(formData.getId(), formData);
	}
	
	@ApiOperation(value="证据列表")
	@WebLog("证据列表")
	@GetMapping("/{caseId}")
	public ApiResultVO<EvidenceListVO> list(@PathVariable("caseId") String caseId){
		return enumerateEvidenceService.list(caseId, getSessionUser().getUserInfoId());
//		return enumerateEvidenceService.list(caseId, "3");
	}

}
