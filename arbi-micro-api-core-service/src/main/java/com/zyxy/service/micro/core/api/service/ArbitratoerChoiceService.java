package com.zyxy.service.micro.core.api.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zyxy.common.dto.CaseArbitratorOprInsertDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ArbitratorAvoidRecordVO;

/**
 * 当事人选择仲裁员service
 */
@FeignClient("coreService")
public interface ArbitratoerChoiceService {
	
	/**
	 * 当事人选择仲裁员
	 * @param formData
	 * @return
	 */
	@RequestMapping(value = "/arbitrator/choice/add",method = RequestMethod.POST)
	ApiResultVO<String> arbitratorChoice(@RequestBody CaseArbitratorOprInsertDTO formData);
	
	/**
	 * 仲裁员回避记录
	 * @param caseId
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/arbitrator/choice/{caseId}/list",method = RequestMethod.POST)
	ApiResultVO<List<ArbitratorAvoidRecordVO>> list(@PathVariable("caseId") String caseId,@RequestParam("userId") String userId);
}
