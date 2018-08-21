package com.zyxy.service.micro.core.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.ArbitratorQuestionDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.api.service.ArbitratorQuestionService;

/**
 * 仲裁员-提问
 */
@Api(description="仲裁员-提问")
@RequestMapping("api/arbitrator/qusetion")
@RestController
public class ApiArbitratorQuestionController extends BaseController{
	
	@Autowired
	private ArbitratorQuestionService arbitratorQuestionService;
	
	@WebLog("仲裁员提问")
	@ApiOperation("仲裁员提问")
	@PostMapping("")
	public ApiResultVO<String> add(@RequestBody ArbitratorQuestionDTO formData){
		formData.setUserId(getSessionUser().getUserInfoId());
		return arbitratorQuestionService.arbitratorQuestion(formData);
	};

}
