package com.zyxy.service.micro.core.api.controller;

import java.util.List;

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
import com.zyxy.common.domain.ArgueRecord;
import com.zyxy.common.dto.ArgueRecordInsertDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.api.service.ArgueRecordService;

@Api(description="辩论")
@RequestMapping("/api/case/argue")
@RestController
public class ApiArgueRecordController extends BaseController{
	
	@Autowired
	private ArgueRecordService argueRecordService;
	
	@ApiOperation("辩论记录列表")
	@WebLog("辩论记录列表")
	@GetMapping("/{caseId}")
	public ApiResultVO<List<ArgueRecord>> list(@PathVariable("caseId") String caseId){
		return argueRecordService.list(caseId);
	}
	
	@ApiOperation("辩论记录增加")
	@WebLog("辩论记录增加")
	@PostMapping("")
	public ApiResultVO<List<ArgueRecord>> add(@RequestBody ArgueRecordInsertDTO formData) {
		formData.setUserId(getSessionUser().getUserInfoId());
//		formData.setUserId("5");
		return argueRecordService.add(formData);
	}

}
