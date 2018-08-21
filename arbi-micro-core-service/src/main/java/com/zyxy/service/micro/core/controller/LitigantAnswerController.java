package com.zyxy.service.micro.core.controller;

import javax.validation.Valid;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zyxy.common.dto.LitigantAnswerQuestionDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.QuestionAnswerListVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.service.LitigantAnswerService;

@Api(description="当事人-问答")
@RestController
@RequestMapping("/litigant/question")
public class LitigantAnswerController extends BaseController{
	
	@Autowired
	private LitigantAnswerService litigantAnswerService;
	
	@ApiOperation("当事人-问答")
	@RequestMapping("/answer")
	public ApiResultVO<String> answer(@RequestBody @Valid LitigantAnswerQuestionDTO formData,
			BindingResult bindingResult){
		//参数验证
		if (bindingResult.hasErrors()) {
			return super.validError();
		}
		//业务认证
		BusiValidResult busiValidResult=litigantAnswerService.litigantAnswerValid(formData);
		if (busiValidResult.hasError()) {
			return super.busiExecuteError(busiValidResult.getCode(), busiValidResult.getMsg());
		}
		//业务执行
		BusiExecuteResult<String> busiExecuteResult = litigantAnswerService.litigantAnswerExecute(formData);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
		}
		return super.busiExecuteSuccess();
	}

	@ApiOperation("当事人-问答列表")
	@RequestMapping("/{caseId}/list")
	public ApiResultVO<QuestionAnswerListVO> list(@PathVariable("caseId")String caseId,@RequestParam("userId") String userId){
		//业务验证
		if (StringUtils.isBlank(userId)||StringUtils.isBlank(caseId)) {
			return super.validError();
		}
		//业务验证
		BusiValidResult busiValidResult = litigantAnswerService.litigantQuesAnsListValid(caseId,userId);
		if (busiValidResult.hasError()) {
			super.busiExecuteError(busiValidResult.getCode(), busiValidResult.getMsg());
		}
		BusiExecuteResult<QuestionAnswerListVO> busiExecuteResult = litigantAnswerService.litigantQuesAnsListExecute(caseId,userId);
		if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
		}
		return super.ok(busiExecuteResult.getBody());
	}
	
	
}
