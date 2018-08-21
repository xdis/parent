package com.zyxy.service.micro.core.api.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zyxy.common.dto.WithdrawRecordInsertDTO;
import com.zyxy.common.vo.ApiResultVO;

/**
 * 撤案Service
 */
@FeignClient("coreService")
public interface WithdrawService {

	@RequestMapping(value="/case/withdraw",method=RequestMethod.POST)
	ApiResultVO<String> add(@RequestBody WithdrawRecordInsertDTO formData);
}
