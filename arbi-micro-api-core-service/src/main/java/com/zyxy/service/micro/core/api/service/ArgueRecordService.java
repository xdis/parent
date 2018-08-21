package com.zyxy.service.micro.core.api.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zyxy.common.domain.ArgueRecord;
import com.zyxy.common.dto.ArgueRecordInsertDTO;
import com.zyxy.common.vo.ApiResultVO;
/**
 * 辩论Service
 */
@FeignClient("coreService")
public interface ArgueRecordService {
	
	@RequestMapping(value="/case/argue/lists/{caseId}",method=RequestMethod.POST)
	ApiResultVO<List<ArgueRecord>> list(@PathVariable("caseId") String caseId);
	
	@RequestMapping(value="/case/argue/add",method=RequestMethod.POST)
	ApiResultVO<List<ArgueRecord>> add(@RequestBody ArgueRecordInsertDTO formData);

}
