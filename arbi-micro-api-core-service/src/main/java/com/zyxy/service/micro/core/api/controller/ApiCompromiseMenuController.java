package com.zyxy.service.micro.core.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.CompromiseMenuVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.api.service.CompromiseMenuService;
/**
 * 和解按钮
 */
@Api(description="当事人和解按钮")
@RequestMapping("/api/compromise/menu")
@RestController
public class ApiCompromiseMenuController extends BaseController {
	
	@Autowired
	private CompromiseMenuService compromiseMenuService;
	
	@ApiOperation("当事人和解按钮")
	@WebLog("当事人和解按钮")
	@GetMapping("/{caseId}")
	public ApiResultVO<CompromiseMenuVO> list(@PathVariable("caseId") String caseId) {
		return compromiseMenuService.list(caseId, getSessionUser().getUserInfoId());
	}
}
