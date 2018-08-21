package com.zyxy.service.micro.core.api.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zyxy.common.dto.CompromiseOperationDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.CompromiseInfoVO;

@FeignClient("coreService")
public interface CompromiseOperationService {
	
	@RequestMapping(value="/compromise/operation/{caseId}",method=RequestMethod.POST)
	ApiResultVO<String> operation(@PathVariable("caseId") String caseId, @RequestBody CompromiseOperationDTO formData);
	
	@RequestMapping(value="/compromise/operation/{caseId}/info",method=RequestMethod.POST)
	ApiResultVO<CompromiseInfoVO> info(@PathVariable("caseId") String caseId, @RequestBody String userId);
}
