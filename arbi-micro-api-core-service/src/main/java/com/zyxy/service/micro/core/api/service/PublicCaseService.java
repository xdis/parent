package com.zyxy.service.micro.core.api.service;

import com.zyxy.common.dto.*;
import com.zyxy.common.vo.ApiResultVO;

import com.zyxy.common.vo.CaseApplyDraftVO;
import com.zyxy.common.vo.CaseDefaultInfoVO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 公共案件模块
 */
@FeignClient("coreService")
public interface PublicCaseService {

    @RequestMapping(value = "/public/case/selfCaseApplyInfo", method = RequestMethod.POST)
    ApiResultVO<CaseDefaultInfoVO> selfCaseApplyInfo(@RequestBody BaseDTO formData);

    @RequestMapping(value = "/public/case/caseApply", method = RequestMethod.POST)
    ApiResultVO<String> caseApply(@RequestBody RegisterCaseDTO formData);

    @RequestMapping(value = "/public/case/caseApplyDraft", method = RequestMethod.POST)
    ApiResultVO<String> caseApplyDraft(@RequestBody RegisterCaseDTO formData);

    @RequestMapping(value = "/public/case/getCaseApplyDraft", method = RequestMethod.POST)
    ApiResultVO<CaseApplyDraftVO> getCaseApplyDraft(@RequestBody GetCaseDraftDTO formData);

    @RequestMapping(value = "/public/case/{caseId}/caseReply", method = RequestMethod.POST)
    ApiResultVO<String> caseReply(@PathVariable("caseId") String caseId, @RequestBody CaseReplyDTO formData);
    
    @RequestMapping(value = "/public/case/{caseId}/rejoin", method = RequestMethod.POST)
    ApiResultVO<String> rejoinAmend(@PathVariable("caseId") String caseId,@RequestBody CaseRejoinUpdateDTO formData);
    
}
