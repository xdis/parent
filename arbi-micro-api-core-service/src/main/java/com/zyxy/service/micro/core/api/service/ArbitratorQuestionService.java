package com.zyxy.service.micro.core.api.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zyxy.common.dto.ArbitratorQuestionDTO;
import com.zyxy.common.vo.ApiResultVO;

@FeignClient("coreService")
public interface ArbitratorQuestionService {
	
	@RequestMapping(value = "/arbitrator/question/add",method=RequestMethod.POST)
	ApiResultVO<String> arbitratorQuestion(@RequestBody ArbitratorQuestionDTO formData);
}
