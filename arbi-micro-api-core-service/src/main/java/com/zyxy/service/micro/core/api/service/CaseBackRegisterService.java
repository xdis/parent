package com.zyxy.service.micro.core.api.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zyxy.common.dto.BackRegisterCaseDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.DocHeadVO;

@FeignClient("coreService")
public interface CaseBackRegisterService {
	
	@RequestMapping(value = "/case/back/regesiter",method = RequestMethod.POST)
	ApiResultVO<String> backRegister(@RequestBody BackRegisterCaseDTO formData);
	
	@RequestMapping(value = "/case/back/{caseId}/headInfo",method = RequestMethod.POST)
	ApiResultVO<DocHeadVO> headInfo(@PathVariable("caseId") String caseId ,@RequestBody String userId);
	
}
