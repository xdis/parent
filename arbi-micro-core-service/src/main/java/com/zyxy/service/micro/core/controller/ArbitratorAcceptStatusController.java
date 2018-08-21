package com.zyxy.service.micro.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyxy.common.dto.ArbitratorAcceptStatusDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.service.ArbitratorAcceptStatusService;

/**
 * 仲裁员接案状态控制层
 */
@Api(description="仲裁员接案状态")
@RequestMapping("/arbitrator/acceptstatus")
@RestController
public class ArbitratorAcceptStatusController extends BaseController{

	@Autowired
	private ArbitratorAcceptStatusService acceptStatusService;
	
	@ApiOperation(value="更新仲裁员接案状态")
	@RequestMapping(value="/updateStatus")
	public ApiResultVO<String> updateStatus(@RequestBody @Valid ArbitratorAcceptStatusDTO formData,
			BindingResult bindingResult, HttpServletRequest request){
        //参数验证
        if (bindingResult.hasErrors()) {
            return super.validError();
        }
        BusiExecuteResult<String> busiExecuteResult=acceptStatusService.updateAcceptStatusBusiExecute(formData);
        // 该日志必不可少
		return super.busiExecuteSuccess(busiExecuteResult.getBody());
	}
}
