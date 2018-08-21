package com.zyxy.service.micro.core.api.service;

import com.zyxy.common.dto.CaseEvaluationDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.CaseEvaluationVO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("coreService")
public interface CaseEvaluationService {

	@RequestMapping(value="/arbitrator/caseEvaluation", method = RequestMethod.POST)
	ApiResultVO<CaseEvaluationVO> query(@RequestBody CaseEvaluationDTO formData);
}
