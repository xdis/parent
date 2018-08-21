package com.zyxy.service.micro.core.api.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zyxy.common.dto.AdjudiAmendRecordAuditDTO;
import com.zyxy.common.dto.AdjudiAmendRecordInsertDTO;
import com.zyxy.common.vo.ApiResultVO;
/**
 *	补正Service
 */
@FeignClient("coreService")
public interface AdjudicationAmendmentService {
	
	@RequestMapping(value="/adjudication/amendment/apply",method=RequestMethod.POST)
	ApiResultVO<String> add(@RequestBody AdjudiAmendRecordInsertDTO formData);
	
	@RequestMapping(value="/adjudication/amendment/audit",method=RequestMethod.POST)
	ApiResultVO<String> audit(@RequestBody AdjudiAmendRecordAuditDTO formData);
}
