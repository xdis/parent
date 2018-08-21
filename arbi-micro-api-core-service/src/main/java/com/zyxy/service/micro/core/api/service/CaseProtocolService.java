package com.zyxy.service.micro.core.api.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zyxy.common.dto.ProtocolRecordInsertDTO;
import com.zyxy.common.dto.ProtocolResponseDTO;
import com.zyxy.common.vo.ApiResultVO;

@FeignClient("coreService")
public interface CaseProtocolService {
	
	@RequestMapping(value = "/case/protocol/add",method=RequestMethod.POST)
	ApiResultVO<String> add(@RequestBody ProtocolRecordInsertDTO formData);
	
	@RequestMapping(value = "/case/protocol/add",method=RequestMethod.POST)
	ApiResultVO<String> response(@RequestBody ProtocolResponseDTO formData);
}
