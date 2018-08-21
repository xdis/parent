package com.zyxy.service.micro.core.api.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zyxy.common.dto.CaseJurisDisInsertDTO;
import com.zyxy.common.dto.JurisDisFeedBackDTO;
import com.zyxy.common.vo.ApiResultVO;

/**
 * 管辖权异议Service
 */
@FeignClient("coreService")
public interface CaseJurisDisService {
	
	@RequestMapping(value="/public/case/jurisdis",method=RequestMethod.POST)
	ApiResultVO<String> add(@RequestBody CaseJurisDisInsertDTO formData);
	
	@RequestMapping(value="/public/case/jurisdis/feedback",method=RequestMethod.POST)
	ApiResultVO<String> feedback(@RequestBody JurisDisFeedBackDTO formData);
}
