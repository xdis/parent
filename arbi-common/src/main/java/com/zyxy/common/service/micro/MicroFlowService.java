package com.zyxy.common.service.micro;

import com.zyxy.common.dto.flow.*;
import com.zyxy.common.service.micro.fallback.MicroFlowServiceImpl;
import com.zyxy.common.vo.ApiResultVO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 流程服务, fallback=MicroFlowServiceImpl.class
 */
@FeignClient(value = "coreService")
public interface MicroFlowService {

    /**
     * 立案审核流程控制
     */
    @RequestMapping(value = "/caseFlow/{caseId}/audit", method = RequestMethod.POST)
    ApiResultVO<String> audit(@PathVariable("caseId") String caseId, @RequestBody CaseAuditDTO formData);

    /**
     * 缴费流程控制
     */
    @RequestMapping(value = "/caseFlow/{caseId}/pay", method = RequestMethod.POST)
    ApiResultVO<String> pay(@PathVariable("caseId") String caseId, @RequestBody CasePayDTO formData);

    /**
     * 中途退出和解流程控制
     */
    @RequestMapping(value = "/caseFlow/{caseId}/compromiseExit", method = RequestMethod.POST)
    ApiResultVO<String> compromiseExit(@PathVariable("caseId") String caseId);

    /**
     * 结案流程控制
     */
    @RequestMapping(value = "/caseFlow/{caseId}/caseOver", method = RequestMethod.POST)
    ApiResultVO<String> caseOver(@PathVariable("caseId") String caseId, @RequestBody CaseOverDTO formData);

    /**
     * 和解结束接口
     *
     * @param caseId   案件Id
     * @param formData DTO
     * @return
     */
    @RequestMapping(value = "/caseFlow/{caseId}/compromiseOver", method = RequestMethod.POST)
    ApiResultVO<String> compromiseOver(@PathVariable("caseId") String caseId, @RequestBody CaseCompromiseOverDTO formData);

    /**
     * 放弃答辩期接口
     *
     * @param caseId   案件Id
     * @param formData DTO
     * @return
     */
    @RequestMapping(value = "/caseFlow/{caseId}/giveReply", method = RequestMethod.POST)
    ApiResultVO<String> giveReply(@PathVariable("caseId") String caseId, @RequestBody CaseGiveReplyDTO formData);

    /**
     * 取消任务
     *
     * @param caseId   案件Id
     * @param formData DTO
     * @return
     */
    @RequestMapping(value = "/caseFlow/{caseId}/cancelCase", method = RequestMethod.POST)
    ApiResultVO<String> cancelCase(@PathVariable("caseId") String caseId, @RequestBody CaseCancelDTO formData);

}
