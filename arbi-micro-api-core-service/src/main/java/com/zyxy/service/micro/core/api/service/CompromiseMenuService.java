package com.zyxy.service.micro.core.api.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.CompromiseMenuVO;

@FeignClient("coreService")
public interface CompromiseMenuService {

	@RequestMapping(value="/compromise/menu/{caseId}",method=RequestMethod.POST)
	ApiResultVO<CompromiseMenuVO> list(@PathVariable("caseId") String caseId, @RequestBody String userId);
}
