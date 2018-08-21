package com.zyxy.service.micro.core.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.CaseChangeRecordInsertDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.api.service.CaseChangeRecordService;

/**
 * 仲裁请求更改
 */
@Api(description="当事人-仲裁请求更改")
@RestController
@RequestMapping("api/case/change")
public class ApiCaseChangeController extends BaseController{
	
	@Autowired
	private CaseChangeRecordService caseChangeRecordService;
	
	@ApiOperation("仲裁请求更改申请")
	@WebLog("公共-变更仲裁申请")
	@PostMapping("")
	public ApiResultVO<String> add(@RequestBody CaseChangeRecordInsertDTO formData){
		formData.setCreaterId(getSessionUser().getUserInfoId());
//		formData.setCreaterId("5");
		return caseChangeRecordService.add(formData);
	}

}
