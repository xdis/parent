package com.zyxy.service.micro.api.service.micro;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zyxy.common.dto.CaseRejoinUpdateDTO;
import com.zyxy.common.dto.CaseReplyDTO;
import com.zyxy.common.dto.GetCaseDraftDTO;
import com.zyxy.common.dto.RegisterCaseDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.CaseApplyDraftVO;

/**
 * 公共案件模块
 */
@FeignClient("coreService")
public interface PublicCaseService {

    @RequestMapping(value = "/public/case/caseApply", method = RequestMethod.POST)
    ApiResultVO<String> caseApply(@RequestBody RegisterCaseDTO formData);

    @RequestMapping(value = "/public/case/caseApplyDraft", method = RequestMethod.POST)
    ApiResultVO<String> caseApplyDraft(@RequestBody RegisterCaseDTO formData);

    @RequestMapping(value = "/public/case/getCaseApplyDraft", method = RequestMethod.POST)
    ApiResultVO<CaseApplyDraftVO> getCaseApplyDraft(@RequestBody GetCaseDraftDTO formData);

    @RequestMapping(value = "/public/case/{requestId}/caseReply", method = RequestMethod.POST)
    ApiResultVO<String> caseReply(@PathVariable("requestId") String requestId, @RequestBody CaseReplyDTO formData);
    
    @RequestMapping(value = "/public/case/{id}/rejoin", method = RequestMethod.POST)
    ApiResultVO<String> rejoinAmend(@PathVariable("id") String id,@RequestBody CaseRejoinUpdateDTO formData);
    
}
