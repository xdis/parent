package com.zyxy.service.micro.core.api.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zyxy.common.dto.CaseChangeRecordInsertDTO;
import com.zyxy.common.vo.ApiResultVO;

/**
 * 仲裁请求变更
 */
@FeignClient("coreService")
public interface CaseChangeRecordService {
	
	@RequestMapping(value="/public/case/change",method=RequestMethod.POST)
	ApiResultVO<String> add(@RequestBody CaseChangeRecordInsertDTO formData);
}
