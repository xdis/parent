package com.zyxy.service.micro.core.api.controller;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.*;
import com.zyxy.common.vo.*;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.api.service.ArbitratorCaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 仲裁员案件信息控制层
 */
@Api(description = "仲裁员案件信息模块")
@RequestMapping("/api/arbitrator/case")
@RestController
public class ApiArbitratorCaseController extends BaseController {

    @Autowired
    private ArbitratorCaseService arbitratorCaseService;

    @WebLog("仲裁员-获取案件列表")
    @ApiOperation(value = "案件列表")
    @GetMapping(value = "")
    public ApiResultVO<PageInfo<ArbitratorCaseListVO>> list(ArbitratorCaseListDTO formData) {
        formData.setUserId(getSessionUser().getUserInfoId());
        ApiResultVO<PageInfo<ArbitratorCaseListVO>> list = arbitratorCaseService.list(formData);
        return list;
    }

    @WebLog("仲裁员-受理案件")
    @ApiOperation(value = "受理案件")
    @PostMapping(value = "/{caseId}/accept")
    public ApiResultVO<String> accept(@RequestBody ArbitratorCaseAcceptDTO formData) {
        formData.setUserId(getSessionUser().getUserInfoId());
        return arbitratorCaseService.accept(formData.getCaseId(), formData);
    }

    @WebLog("仲裁员-案件基本信息")
    @ApiOperation(value = "案件基本信息")
    @GetMapping(value = "/{caseId}")
    public ApiResultVO<ArbitratorCaseBaseInfoVO> caseBaseInfo(@PathVariable("caseId") String caseId) {
        return arbitratorCaseService.caseBaseInfo(caseId, getSessionUser().getUserInfoId());
    }

    @WebLog("仲裁员-案件公共信息")
    @ApiOperation(value = "案件公共信息")
    @GetMapping(value = "/{caseId}/commInfo")
    public ApiResultVO<CaseCommInfoVO> caseCommInfo(@PathVariable("caseId") String caseId) {
        return arbitratorCaseService.caseCommInfo(caseId, getSessionUser().getUserInfoId());
    }

    @WebLog("仲裁员-案件请求信息")
    @ApiOperation(value = "案件请求信息")
    @GetMapping(value = "/{caseId}/requestInfo")
    public ApiResultVO<ArbitratorCaseRequestInfoVO> caseRequestInfo(@PathVariable("caseId") String caseId) {
        return arbitratorCaseService.caseRequestInfo(caseId, getSessionUser().getUserInfoId());
    }

    @WebLog("仲裁员-案件请求答辩信息")
    @ApiOperation(value = "案件请求答辩信息")
    @GetMapping(value = "/{caseId}/requestReplyInfo")
    public ApiResultVO<ArbitratorCaseReplyInfoVO> caseReplyInfo(@PathVariable("caseId") String caseId) {
        return arbitratorCaseService.caseReplyInfo(caseId, getSessionUser().getUserInfoId());
    }

    @WebLog("仲裁员-案件反请求信息")
    @ApiOperation(value = "案件反请求信息")
    @GetMapping(value = "/{caseId}/deRequestInfo")
    public ApiResultVO<ArbitratorCaseRequestInfoVO> caseDeRequestInfo(@PathVariable("caseId") String caseId) {
        return arbitratorCaseService.caseDeRequestInfo(caseId, getSessionUser().getUserInfoId());
    }

    @WebLog("仲裁员-案件反请求答辩信息")
    @ApiOperation(value = "案件反请求答辩信息")
    @GetMapping(value = "/{caseId}/deRequestReplyInfo")
    public ApiResultVO<ArbitratorCaseReplyInfoVO> caseDeReplyInfo(@PathVariable("caseId") String caseId) {
        return arbitratorCaseService.caseDeReplyInfo(caseId, getSessionUser().getUserInfoId());
    }

    @WebLog("仲裁员-案件流程信息")
    @ApiOperation(value = "案件流程信息")
    @GetMapping(value = "/{caseId}/flowInfo")
    public ApiResultVO<CaseFlowVO> caseFlowInfo(@PathVariable("caseId") String caseId) {
        return arbitratorCaseService.caseFlowInfo(caseId, getSessionUser().getUserInfoId());
    }

    @WebLog("仲裁员-案件和解信息")
    @ApiOperation(value = "案件和解信息")
    @GetMapping(value = "/{caseId}/compromiseInfo")
    public ApiResultVO<CaseCompromiseVO> caseCompromiseInfo(@PathVariable("caseId") String caseId) {
        return arbitratorCaseService.caseCompromiseInfo(caseId, getSessionUser().getUserInfoId());
    }

    @WebLog("仲裁员-案件和解审核")
    @ApiOperation(value = "案件和解审核")
    @PostMapping(value = "/{caseId}/compromiseAudit")
    public ApiResultVO compromiseAudit(@RequestBody ArbitratorCaseCompromiseAuditDTO formData) {
        formData.setUserId(getSessionUserId());
        return arbitratorCaseService.caseCompromiseAudit(formData.getCaseId(), formData);
    }

    @WebLog("仲裁员-案件和解回复")
    @ApiOperation(value = "案件和解回复")
    @PostMapping(value = "/{caseId}/compromiseReply")
    public ApiResultVO compromiseReply(@RequestBody ArbitratorCaseCompromiseReplyDTO formData) {
        formData.setUserId(getSessionUserId());
        return arbitratorCaseService.caseCompromiseReply(formData.getCaseId(), formData);
    }

    @WebLog("仲裁员-案件裁判信息")
    @ApiOperation(value = "案件裁判信息")
    @GetMapping(value = "/{caseId}/arbitrationInfo")
    public ApiResultVO<CaseArbitrationInfoVO> caseArbitrationInfo(@PathVariable("caseId") String caseId) {
        return arbitratorCaseService.caseArbitrationInfo(caseId, getSessionUser().getUserInfoId());
    }

    @WebLog("仲裁员-案件补正记录")
    @ApiOperation(value = "案件补正记录")
    @GetMapping(value = "/{caseId}/amendmentInfo")
    public ApiResultVO<PageInfo<AdjudicationAmendmentVO>> caseAmendmentInfo(@PathVariable("caseId") String caseId) {
        return arbitratorCaseService.caseAmendmentInfo(caseId, getSessionUser().getUserInfoId());
    }

    @WebLog("仲裁员-案件辩论回复")
    @ApiOperation(value = "案件辩论回复")
    @PostMapping(value = "/{caseId}/argueReply")
    public ApiResultVO caseArgueReply(@RequestBody ArbitratorCaseArgueReplyDTO formData) {
        formData.setUserId(getSessionUserId());
        return arbitratorCaseService.caseArgueReply(formData.getCaseId(), formData);
    }

    @WebLog("仲裁员-案件辩论列表")
    @ApiOperation(value = "案件辩论列表")
    @GetMapping(value = "/{caseId}/argue")
    public ApiResultVO argue(@PathVariable("caseId") String caseId) {
        return arbitratorCaseService.caseArgue(caseId, getSessionUserId());
    }


    @ApiOperation(value = "案件出具裁决书")
    @RequestMapping(value = "/{caseId}/arbitralAwards", method = RequestMethod.POST)
    public ApiResultVO arbitralAwards(@RequestBody @Valid ArbitratorCaseArbitralAwardsDTO formData) {
        formData.setUserId(getSessionUser().getUserInfoId());
        return arbitratorCaseService.arbitralAwards(formData.getCaseId(), formData);
    }

    @ApiOperation(value = "案件重新出具裁决书")
    @RequestMapping(value = "/{caseId}/arbitralAwardsChange", method = RequestMethod.POST)
    public ApiResultVO arbitralAwardsChange(@RequestBody @Valid ArbitratorCaseArbitralAwardsDTO formData) {
        formData.setUserId(getSessionUser().getUserInfoId());
        return arbitratorCaseService.arbitralAwardsChange(formData.getCaseId(), formData);
    }

    @ApiOperation(value = "案件出具裁决书存草稿")
    @RequestMapping(value = "/{caseId}/arbitralAwardsDraft", method = RequestMethod.POST)
    public ApiResultVO arbitralAwardsDraft(@RequestBody @Valid ArbitratorCaseArbitralAwardsDTO formData) {
        formData.setUserId(getSessionUser().getUserInfoId());
        return arbitratorCaseService.arbitralAwardsDraft(formData.getCaseId(), formData);
    }

    @ApiOperation(value = "案件出具裁决书状态")
    @RequestMapping(value = "/{caseId}/arbitralAwardsStatus", method = RequestMethod.GET)
    public ApiResultVO<ArbitratorCaseArbitralAwardStatusVO> arbitralAwardsStatus(@PathVariable("caseId") String caseId) {
        return arbitratorCaseService.arbitralAwardsStatus(caseId, getSessionUserId());
    }

    @ApiOperation(value = "案件出具调解书")
    @RequestMapping(value = "/{caseId}/mediateAwards", method = RequestMethod.POST)
    public ApiResultVO mediateAwards(@PathVariable("caseId") String caseId) {
        return arbitratorCaseService.mediateAwards(caseId, getSessionUserId());
    }

    @ApiOperation(value = "案件出具调解书状态")
    @RequestMapping(value = "/{caseId}/mediateAwardsStatus", method = RequestMethod.GET)
    public ApiResultVO<ArbitratorCaseMediateAwardStatusVO> mediateAwardsStatus(@PathVariable("caseId") String caseId) {
        return arbitratorCaseService.mediateAwardsStatus(caseId, getSessionUserId());
    }

    @ApiOperation(value = "案件重新出具调解书")
    @RequestMapping(value = "/{caseId}/mediateAwardsChange", method = RequestMethod.POST)
    public ApiResultVO mediateAwardsChange(@PathVariable("caseId") String caseId) {
        return arbitratorCaseService.mediateAwardsChange(caseId, getSessionUserId());
    }

    @ApiOperation(value = "案件出具管辖权异议决定书")
    @RequestMapping(value = "/{caseId}/jurisAwards", method = RequestMethod.POST)
    public ApiResultVO jurisAwards(@RequestBody @Valid ArbitratorCaseJurisAwardsDTO formData) {
        formData.setUserId(getSessionUser().getUserInfoId());
        return arbitratorCaseService.jurisAwards(formData.getCaseId(), formData);
    }

    @ApiOperation(value = "案件重新出具管辖权异议决定书")
    @RequestMapping(value = "/{caseId}/jurisAwardsChange", method = RequestMethod.POST)
    public ApiResultVO jurisAwardsChange(@RequestBody @Valid ArbitratorCaseJurisAwardsDTO formData) {
        formData.setUserId(getSessionUser().getUserInfoId());
        return arbitratorCaseService.jurisAwardsChange(formData.getCaseId(), formData);
    }

    @ApiOperation(value = "案件出具管辖权异议决定书状态")
    @RequestMapping(value = "/{caseId}/jurisAwardsStatus", method = RequestMethod.POST)
    public ApiResultVO<ArbitratorCaseJurisAwardStatusVO> jurisAwardsStatus(@RequestBody @Valid ArbitratorCaseJurisAwardsStatusDTO formData) {
        formData.setUserId(getSessionUserId());
        return arbitratorCaseService.jurisAwardsStatus(formData.getCaseId(), formData);
    }

}
