package com.zyxy.service.micro.core.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.WithdrawRecordInsertDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.api.service.WithdrawService;
/**
 *	撤案
 */
@Api(description="当事人撤案")
@RequestMapping("/api/case/withdraw")
@RestController
public class ApiCaseWithDrawController extends BaseController{
	
	@Autowired
	private WithdrawService withdrawService;
	
	@WebLog("申请撤案")
	@ApiOperation(value="撤案申请")
	@PostMapping("")
	public ApiResultVO<String> add(@RequestBody WithdrawRecordInsertDTO formData){
		formData.setUserId(getSessionUser().getUserInfoId());
//		formData.setUserId("201712061126640004072958");
		return withdrawService.add(formData);
	}
}
