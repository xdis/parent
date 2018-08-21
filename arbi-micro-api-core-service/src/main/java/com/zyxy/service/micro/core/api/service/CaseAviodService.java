package com.zyxy.service.micro.core.api.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zyxy.common.dto.CaseAvoidRecordInsertDTO;
import com.zyxy.common.vo.ApiResultVO;

/**
 * 案件当事人秘书仲裁员回避Service
 */
@FeignClient("coreService")
public interface CaseAviodService {
	
	@RequestMapping(value="/public/case/avoid",method=RequestMethod.POST)
	ApiResultVO<String> add(@RequestBody CaseAvoidRecordInsertDTO formData);

}
