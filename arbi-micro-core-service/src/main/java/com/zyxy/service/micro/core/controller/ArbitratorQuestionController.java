package com.zyxy.service.micro.core.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

import com.zyxy.common.dto.ArbitratorQuestionDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.service.ArbitratorQuestionService;
/**
 * 仲裁员提问 controller
 */
@Api("仲裁员-提问")
@RestController
@RequestMapping("/arbitrator/question")
public class ArbitratorQuestionController extends BaseController{
	
	@Autowired
	private  ArbitratorQuestionService arbitratorQuestionService;
	
	@RequestMapping("/add")
	public ApiResultVO<String> add(@RequestBody @Valid ArbitratorQuestionDTO formData,BindingResult bindingResult){
		//参数认证
		if(bindingResult.hasErrors()){
			return super.validError();
		}
		//业务验证
		BusiValidResult busiValidResult = arbitratorQuestionService.arbitratorQuestionValid(formData);
		if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
		}
		//业务执行
		BusiExecuteResult<String> busiExecuteResult = arbitratorQuestionService.arbitratorExecute(formData);
		if (busiExecuteResult.hasError()) {
			return super.busiValidError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
		}
		
		return super.busiExecuteSuccess();
	}
}
