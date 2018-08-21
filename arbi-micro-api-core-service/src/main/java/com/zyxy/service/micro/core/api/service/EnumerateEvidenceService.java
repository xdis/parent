package com.zyxy.service.micro.core.api.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zyxy.common.dto.EnumerateEvidenceDTO;
import com.zyxy.common.dto.OppugnEvidenceDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.EvidenceListVO;
/**
 * 举证质证Service
 */
@FeignClient("coreService")
public interface EnumerateEvidenceService {
	
	@RequestMapping(value="/case/evidence/{caseId}/enumerate",method=RequestMethod.POST)
	ApiResultVO<String> enumerate(@PathVariable("caseId") String caseId,@RequestBody EnumerateEvidenceDTO formData);
	
	@RequestMapping(value="/case/evidence/{id}/oppugn",method=RequestMethod.POST)
	ApiResultVO<String> oppugn(@PathVariable("id") String id,@RequestBody OppugnEvidenceDTO formData);
	
	@RequestMapping(value="/case/evidence/{caseId}/list",method=RequestMethod.POST)
	ApiResultVO<EvidenceListVO> list(@PathVariable("caseId") String caseId, @RequestBody String userId);
}
