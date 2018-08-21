package com.zyxy.service.micro.core.api.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zyxy.common.dto.CompromiseApplyInsertDTO;
import com.zyxy.common.dto.CompromiseResponseDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.CompromiseApplyInfoVO;
/**
 * 和解申请Service
 */
@FeignClient("coreService")
public interface CompromiseApplyService {
	
	@RequestMapping(value="/compromise/apply/{caseId}/info",method=RequestMethod.POST)
	ApiResultVO<List<CompromiseApplyInfoVO>> get(@PathVariable("caseId") String caseId,@RequestBody String userId);

	@RequestMapping(value="/compromise/apply/add",method=RequestMethod.POST)
	ApiResultVO<String> add(@RequestBody CompromiseApplyInsertDTO formData);
	
	@RequestMapping(value="/compromise/apply/response",method=RequestMethod.POST)
	ApiResultVO<String> response(@RequestBody CompromiseResponseDTO formData);
}
