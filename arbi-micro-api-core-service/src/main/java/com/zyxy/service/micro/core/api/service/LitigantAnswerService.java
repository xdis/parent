package com.zyxy.service.micro.core.api.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zyxy.common.dto.LitigantAnswerQuestionDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.QuestionAnswerListVO;

@FeignClient("coreService")
public interface LitigantAnswerService {

	@RequestMapping(value="/litigant/question/{caseId}/list",method=RequestMethod.POST)
	ApiResultVO<QuestionAnswerListVO> list(@PathVariable("caseId")String caseId,@RequestParam("userId") String userId);
	
	@RequestMapping(value="/litigant/question/answer",method=RequestMethod.POST)
	ApiResultVO<String> answer(@RequestBody LitigantAnswerQuestionDTO formData);
}