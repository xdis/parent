package com.zyxy.service.micro.core.api.controller;

import java.util.List;

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
import com.zyxy.common.dto.CompromiseApplyInsertDTO;
import com.zyxy.common.dto.CompromiseResponseDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.CompromiseApplyInfoVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.api.service.CompromiseApplyService;

@Api(description="和解申请")
@RequestMapping("/api/compromise/apply")
@RestController
public class ApiCompromiseApplyController extends BaseController {
	
	@Autowired
	private CompromiseApplyService compromiseApplyService;
	
	@WebLog("和解申请记录")
	@ApiOperation("和解申请记录")
	@GetMapping("/{caseId}")
	public ApiResultVO<List<CompromiseApplyInfoVO>> get(@PathVariable String caseId){
		return compromiseApplyService.get(caseId,getSessionUser().getUserInfoId());
	}
	
	@WebLog("和解申请")
	@ApiOperation("和解申请")
	@PostMapping("")
	public ApiResultVO<String> add(@RequestBody CompromiseApplyInsertDTO formData){
		formData.setUserId(getSessionUser().getUserInfoId());
		return compromiseApplyService.add(formData);
	}
	
	@WebLog("和解申请回应")
	@ApiOperation("和解申请回应")
	@PutMapping("/{id}")
	public ApiResultVO<String> response(@RequestBody CompromiseResponseDTO formData){
		formData.setUserId(getSessionUser().getUserInfoId());
//		formData.setUserId("3");
		return compromiseApplyService.response(formData);
	}

	

}
