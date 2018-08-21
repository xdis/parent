package com.zyxy.service.micro.core.api.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zyxy.common.domain.CompromiseRecord;
import com.zyxy.common.dto.CompromiseRecordInsertDTO;
import com.zyxy.common.dto.CompromiseRecordListDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.CompromiseRecordVO;

@FeignClient("coreService")
public interface CompromiseRecordService {
	
	@RequestMapping(value="/compromise/record/list",method=RequestMethod.POST)
	ApiResultVO<List<CompromiseRecordVO>> list(@RequestBody CompromiseRecordListDTO formData);
	
	@RequestMapping(value="/compromise/record/add",method=RequestMethod.POST)
	ApiResultVO<List<CompromiseRecordVO>> add(@RequestBody CompromiseRecordInsertDTO formData);
	
}
