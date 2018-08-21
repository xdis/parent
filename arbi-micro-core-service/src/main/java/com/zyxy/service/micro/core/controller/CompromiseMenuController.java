package com.zyxy.service.micro.core.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.CompromiseMenuVO;
import com.zyxy.common.vo.MenuVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.service.CompromiseMenuService;

/*
 *和解按钮
 */
@Api(description="和解按钮")
@RestController
@RequestMapping(value="/compromise/menu")
public class CompromiseMenuController extends BaseController {
	
	@Autowired
	private CompromiseMenuService compromiseMenuService;
	
	@ApiOperation(value="和解按钮")
	@PostMapping(value="/{caseId}")
	public ApiResultVO<CompromiseMenuVO> getMenus(@PathVariable("caseId") String caseId,@RequestBody String userId) {
		if (StringUtils.isBlank(userId)||StringUtils.isBlank(caseId)) {
			return super.validError();
		}
		BusiValidResult busiValidResult = compromiseMenuService.compromiseMenuBusiValid(caseId, userId);
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
		}
		BusiExecuteResult<CompromiseMenuVO> busiExecuteResult = compromiseMenuService.compromiseMenuBusiExecute(caseId, userId);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(),busiExecuteResult.getMsg());
		}
		return super.ok(busiExecuteResult.getBody());
	}
	
}
