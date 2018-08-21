package com.zyxy.service.micro.core.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.LitigantAnswerQuestionDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.QuestionAnswerListVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.api.service.LitigantAnswerService;
@Api(description="当事人问答")
@RestController
@RequestMapping("/api/litigant/question")
public class ApiLitigantAnswerController extends BaseController{
	
	@Autowired
	private LitigantAnswerService litigantAnswerService;

	@WebLog("当事人问答列表")
	@ApiOperation("当事人问答列表")
	@GetMapping("/{caseId}/list")
	public ApiResultVO<QuestionAnswerListVO> list(@PathVariable("caseId")String caseId){
		return litigantAnswerService.list(caseId,getSessionUser().getUserInfoId());
	}

	@WebLog("当事人回答问题")
	@ApiOperation("当事人回答")
	@PutMapping("/answer")
	public ApiResultVO<String> answer(@RequestBody LitigantAnswerQuestionDTO formData){
		formData.setUserId(getSessionUser().getUserInfoId());
		return litigantAnswerService.answer(formData);
	}
}
