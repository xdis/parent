package com.zyxy.service.micro.core.api.service;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.domain.ArgueRecord;
import com.zyxy.common.dto.*;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.*;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 仲裁员案件信息控制层
 */
@FeignClient(value = "coreService")
public interface ArbitratorCaseService {

    /**
     * 案件列表
     * @param formData
     * @return
     */
    @RequestMapping(value = "/arbitrator/case", method = RequestMethod.POST)
    ApiResultVO<PageInfo<ArbitratorCaseListVO>> list(@RequestBody ArbitratorCaseListDTO formData);

    /**
     * 受理案件
     * @param formData
     * @return
     */
    @RequestMapping(value = "/arbitrator/case/{caseId}/accept", method = RequestMethod.POST)
    ApiResultVO<String> accept(@PathVariable("caseId") String caseId, @RequestBody ArbitratorCaseAcceptDTO formData);

    /**
     * 案件基本信息
     * @param caseId
     * @return
     */
    @RequestMapping(value = "/arbitrator/case/{caseId}", method = RequestMethod.POST)
    ApiResultVO<ArbitratorCaseBaseInfoVO> caseBaseInfo(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId);

    /**
     * 案件请求信息
     * @param caseId
     * @return
     */
    @RequestMapping(value = "/arbitrator/case/{caseId}/commInfo", method = RequestMethod.POST)
    ApiResultVO<CaseCommInfoVO> caseCommInfo(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId);

    /**
     * 案件请求信息
     * @param caseId
     * @return
     */
    @RequestMapping(value = "/arbitrator/case/{caseId}/requestInfo", method = RequestMethod.POST)
    ApiResultVO<ArbitratorCaseRequestInfoVO> caseRequestInfo(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId);

    /**
     * 案件请求答辩信息
     * @param caseId
     * @return
     */
    @RequestMapping(value = "/arbitrator/case/{caseId}/requestReplyInfo", method = RequestMethod.POST)
    ApiResultVO<ArbitratorCaseReplyInfoVO> caseReplyInfo(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId);

    /**
     * 案件反请求信息
     * @param caseId
     * @return
     */
    @RequestMapping(value = "/arbitrator/case/{caseId}/deRequestInfo", method = RequestMethod.POST)
    ApiResultVO<ArbitratorCaseRequestInfoVO> caseDeRequestInfo(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId);

    /**
     * 案件反请求答辩信息
     * @param caseId
     * @return
     */
    @RequestMapping(value = "/arbitrator/case/{caseId}/deRequestReplyInfo", method = RequestMethod.POST)
    ApiResultVO<ArbitratorCaseReplyInfoVO> caseDeReplyInfo(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId);

    /**
     * 案件流程信息
     * @param caseId
     * @return
     */
    @RequestMapping(value = "/arbitrator/case/{caseId}/flowInfo", method = RequestMethod.POST)
    ApiResultVO<CaseFlowVO> caseFlowInfo(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId);

    /**
     * 案件和解信息
     *
     * @param caseId
     * @return
     */
    @RequestMapping(value = "/arbitrator/case/{caseId}/compromiseInfo", method = RequestMethod.POST)
    ApiResultVO<CaseCompromiseVO> caseCompromiseInfo(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId);

    /**
     * 案件和解审核
     *
     * @param formData
     * @return
     */
    @RequestMapping(value = "/arbitrator/case/{caseId}/compromiseAudit", method = RequestMethod.POST)
    ApiResultVO caseCompromiseAudit(@PathVariable("caseId") String caseId, @RequestBody ArbitratorCaseCompromiseAuditDTO formData);

    /**
     * 案件和解回复
     *
     * @param formData
     * @return
     */
    @RequestMapping(value = "/arbitrator/case/{caseId}/compromiseReply", method = RequestMethod.POST)
    ApiResultVO caseCompromiseReply(@PathVariable("caseId") String caseId, @RequestBody ArbitratorCaseCompromiseReplyDTO formData);

    /**
     * 案件裁判信息
     * @param caseId
     * @return
     */
    @RequestMapping(value = "/arbitrator/case/{caseId}/arbitrationInfo", method = RequestMethod.POST)
    ApiResultVO<CaseArbitrationInfoVO> caseArbitrationInfo(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId);

    /**
     * 案件补正信息
     * @param caseId
     * @return
     */
    @RequestMapping(value = "/arbitrator/case/{caseId}/amendmentInfo", method = RequestMethod.POST)
    ApiResultVO<PageInfo<AdjudicationAmendmentVO>> caseAmendmentInfo(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId);

    /**
     * 案件辩论信息
     *
     * @param caseId
     * @return
     */
    @RequestMapping(value = "/arbitrator/case/{caseId}/argue", method = RequestMethod.POST)
    ApiResultVO<List<ArgueRecord>> caseArgue(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId);

    /**
     * 案件辩论回复
     *
     * @param formData
     * @return
     */
    @RequestMapping(value = "/arbitrator/case/{caseId}/argueReply", method = RequestMethod.POST)
    ApiResultVO caseArgueReply(@PathVariable("caseId") String caseId, @RequestBody ArbitratorCaseArgueReplyDTO formData);

    @ApiOperation(value = "案件出具裁决书")
    @RequestMapping(value = "/arbitrator/case/{caseId}/arbitralAwards", method = RequestMethod.POST)
    ApiResultVO arbitralAwards(@PathVariable("caseId") String caseId, @RequestBody ArbitratorCaseArbitralAwardsDTO formData);

    @ApiOperation(value = "案件重新出具裁决书")
    @RequestMapping(value = "/arbitrator/case/{caseId}/arbitralAwardsChange", method = RequestMethod.POST)
    ApiResultVO arbitralAwardsChange(@PathVariable("caseId") String caseId, @RequestBody ArbitratorCaseArbitralAwardsDTO formData);

    @ApiOperation(value = "案件出具裁决书存草稿")
    @RequestMapping(value = "/arbitrator/case/{caseId}/arbitralAwardsDraft", method = RequestMethod.POST)
    ApiResultVO arbitralAwardsDraft(@PathVariable("caseId") String caseId, @RequestBody ArbitratorCaseArbitralAwardsDTO formData);

    @ApiOperation(value = "案件出具裁决书状态")
    @RequestMapping(value = "/arbitrator/case/{caseId}/arbitralAwardsStatus", method = RequestMethod.POST)
    ApiResultVO<ArbitratorCaseArbitralAwardStatusVO> arbitralAwardsStatus(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId);

    @ApiOperation(value = "案件出具调解书")
    @RequestMapping(value = "/arbitrator/case/{caseId}/mediateAwards", method = RequestMethod.POST)
    ApiResultVO mediateAwards(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId);

    @ApiOperation(value = "案件出具调解书状态")
    @RequestMapping(value = "/arbitrator/case/{caseId}/mediateAwardsStatus", method = RequestMethod.POST)
    ApiResultVO<ArbitratorCaseMediateAwardStatusVO> mediateAwardsStatus(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId);

    @ApiOperation(value = "案件重新出具调解书")
    @RequestMapping(value = "/arbitrator/case/{caseId}/mediateAwardsChange", method = RequestMethod.POST)
    ApiResultVO mediateAwardsChange(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId);

    @ApiOperation(value = "案件出具管辖权异议决定书")
    @RequestMapping(value = "/arbitrator/case/{caseId}/jurisAwards", method = RequestMethod.POST)
    ApiResultVO jurisAwards(@PathVariable("caseId") String caseId, @RequestBody ArbitratorCaseJurisAwardsDTO formData);

    @ApiOperation(value = "案件重新出具管辖权异议决定书")
    @RequestMapping(value = "/arbitrator/case/{caseId}/jurisAwardsChange", method = RequestMethod.POST)
    ApiResultVO jurisAwardsChange(@PathVariable("caseId") String caseId, @RequestBody ArbitratorCaseJurisAwardsDTO formData);

    @ApiOperation(value = "案件出具管辖权异议决定书状态")
    @RequestMapping(value = "/arbitrator/case/{caseId}/jurisAwardsStatus", method = RequestMethod.POST)
    ApiResultVO<ArbitratorCaseJurisAwardStatusVO> jurisAwardsStatus(@PathVariable("caseId") String caseId, @RequestBody ArbitratorCaseJurisAwardsStatusDTO formData);

}
