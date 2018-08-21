package com.zyxy.service.micro.core.controller;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.domain.ArgueRecord;
import com.zyxy.common.dto.*;
import com.zyxy.common.enums.RequestTypeEnum;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.*;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.service.AmendmentService;
import com.zyxy.service.micro.core.service.ArbitratorCaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * 仲裁员案件信息控制层
 */
@Api(description = "仲裁员案件信息模块")
@RequestMapping("/arbitrator/case")
@RestController
public class ArbitratorCaseController extends BaseController {

    @Autowired
    private ArbitratorCaseService arbitratorCaseService;

    @Autowired
    private AmendmentService amendmentService;

    @ApiOperation(value = "案件列表")
    @RequestMapping(value = "")
    public ApiResultVO<PageInfo<ArbitratorCaseListVO>> list(@RequestBody @Valid ArbitratorCaseListDTO formData, BindingResult bindingResult) {
        //参数验证
        if (bindingResult.hasErrors()) {
            return super.validError();
        }
        BusiExecuteResult<PageInfo<ArbitratorCaseListVO>> busiExecuteResult = arbitratorCaseService.queryCaseListBusiExecute(formData, formData.getUserId());
        // 该日志必不可少
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

    @ApiOperation(value = "受理案件")
    @RequestMapping(value = "/{caseId}/accept")
    public ApiResultVO<String> accept(@RequestBody @Valid ArbitratorCaseAcceptDTO formData, BindingResult bindingResult) {
        /*
         * 参数验证
         */
        if (bindingResult.hasErrors()) {
            return super.validError();
        }
        BusiValidResult busiValidResult = arbitratorCaseService.acceptCaseBusiValid(formData);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        /*
         * 核心业务处理，业务处理统一返回boolean，有错误时，在DTO中调用processRetMsg设置具体枚举
         * 业务处理命名规范：业务名称+BusiExecute
         * 例：acceptCaseBusiExecute
         */
        BusiExecuteResult busiExecuteResult = arbitratorCaseService.acceptCaseBusiExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
        }
        // 该日志必不可少
        return super.busiExecuteSuccess();
    }

    @ApiOperation(value = "案件基本信息")
    @RequestMapping(value = "/{caseId}")
    public ApiResultVO<ArbitratorCaseBaseInfoVO> caseBaseInfo(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId) {

        /*
         * 参数验证
         */
        if (StringUtils.isBlank(caseId)) {
            return super.validError();
        }
        BusiValidResult busiValidResult = arbitratorCaseService.caseBaseInfoBusiValid(caseId, userId);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult<ArbitratorCaseBaseInfoVO> busiExecuteResult = arbitratorCaseService.caseBaseInfoBusiExecute(caseId, userId, RequestTypeEnum.REQUEST.getValue());
        // 该日志必不可少
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

    @ApiOperation(value = "案件公共部分信息")
    @RequestMapping(value = "/{caseId}/commInfo")
    public ApiResultVO<CaseCommInfoVO> caseCommInfo(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId) {

        /*
         * 参数验证
         */
        if (StringUtils.isBlank(caseId)) {
            return super.validError();
        }
        BusiValidResult busiValidResult = arbitratorCaseService.caseCommInfoBusiValid(caseId, userId);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult<CaseCommInfoVO> busiExecuteResult = arbitratorCaseService.caseCommInfoBusiExecute(caseId, userId);
        // 该日志必不可少
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

    @ApiOperation(value = "案件请求信息")
    @RequestMapping(value = "/{caseId}/requestInfo")
    public ApiResultVO<ArbitratorCaseRequestInfoVO> caseRequestInfo(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId) {
        /*
         * 参数验证
         */
        if (StringUtils.isBlank(caseId)) {
            return super.validError();
        }
        BusiValidResult busiValidResult = arbitratorCaseService.caseRequestInfoBusiValid(caseId, userId);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult<ArbitratorCaseRequestInfoVO> busiExecuteResult = arbitratorCaseService.caseRequestInfoBusiExecute(caseId, RequestTypeEnum.REQUEST.getValue());
        // 该日志必不可少
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

    @ApiOperation(value = "案件请求答辩信息")
    @RequestMapping(value = "/{caseId}/requestReplyInfo")
    public ApiResultVO<ArbitratorCaseReplyInfoVO> caseReplyInfo(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId) {
        /*
         * 参数验证
         */
        if (StringUtils.isBlank(caseId)) {
            return super.validError();
        }
        BusiValidResult busiValidResult = arbitratorCaseService.caseReplyInfoBusiValid(caseId, userId);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult<ArbitratorCaseReplyInfoVO> busiExecuteResult = arbitratorCaseService.caseReplyInfoBusiExecute(caseId, RequestTypeEnum.REQUEST.getValue());
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

    @ApiOperation(value = "案件反请求信息")
    @RequestMapping(value = "/{caseId}/deRequestInfo")
    public ApiResultVO<ArbitratorCaseRequestInfoVO> caseDeRequestInfo(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId) {
        /*
         * 参数验证
         */
        if (StringUtils.isBlank(caseId)) {
            return super.validError();
        }
        BusiValidResult busiValidResult = arbitratorCaseService.caseRequestInfoBusiValid(caseId, userId);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult<ArbitratorCaseRequestInfoVO> busiExecuteResult = arbitratorCaseService.caseRequestInfoBusiExecute(caseId, RequestTypeEnum.BACK_REQUEST.getValue());
        // 该日志必不可少
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

    @ApiOperation(value = "案件反请求答辩信息")
    @RequestMapping(value = "/{caseId}/deRequestReplyInfo")
    public ApiResultVO<ArbitratorCaseReplyInfoVO> caseDeReplyInfo(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId) {
        /*
         * 参数验证
         */
        if (StringUtils.isBlank(caseId)) {
            return super.validError();
        }
        BusiValidResult busiValidResult = arbitratorCaseService.caseReplyInfoBusiValid(caseId, userId);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult<ArbitratorCaseReplyInfoVO> busiExecuteResult = arbitratorCaseService.caseReplyInfoBusiExecute(caseId, RequestTypeEnum.BACK_REQUEST.getValue());
        // 该日志必不可少
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

    @ApiOperation(value = "案件流程信息")
    @RequestMapping(value = "/{caseId}/flowInfo")
    public ApiResultVO<CaseFlowVO> caseFlowInfo(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId) {

        /*
         * 参数验证
         */
        if (StringUtils.isBlank(caseId)) {
            return super.validError();
        }
        BusiValidResult busiValidResult = arbitratorCaseService.caseFlowInfoBusiValid(caseId, userId);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult<CaseFlowVO> busiExecuteResult = arbitratorCaseService.caseFlowInfoBusiExecute(caseId);
        // 该日志必不可少
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

    @ApiOperation(value = "案件和解审核")
    @RequestMapping(value = "/{caseId}/compromiseAudit", method = RequestMethod.POST)
    public ApiResultVO caseCompromiseAudit(@RequestBody @Valid ArbitratorCaseCompromiseAuditDTO formData, BindingResult bindingResult) {
        /*
         * 参数验证
         */
        if (bindingResult.hasErrors()) {
            return super.validError();
        }
        BusiValidResult busiValidResult = arbitratorCaseService.caseCompromiseAuditBusiValid(formData);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult busiExecuteResult = arbitratorCaseService.caseCompromiseAuditBusiExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(ApiResultVO.Coder.ILLEGAL);
        }
        // 该日志必不可少
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

    @ApiOperation(value = "案件和解回复")
    @RequestMapping(value = "/{caseId}/compromiseReply", method = RequestMethod.POST)
    public ApiResultVO compromiseReply(@RequestBody @Valid ArbitratorCaseCompromiseReplyDTO formData, BindingResult bindingResult) {
        /*
         * 参数验证
         */
        if (bindingResult.hasErrors()) {
            return super.validError();
        }
        BusiValidResult busiValidResult = arbitratorCaseService.caseCompromiseReplyBusiValid(formData);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult busiExecuteResult = arbitratorCaseService.caseCompromiseReplyBusiExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(ApiResultVO.Coder.ILLEGAL);
        }
        // 该日志必不可少
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

    @ApiOperation(value = "案件和解信息")
    @RequestMapping(value = "/{caseId}/compromiseInfo", method = RequestMethod.POST)
    public ApiResultVO<CaseCompromiseVO> caseCompromiseInfo(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId) {
        /*
         * 参数验证
         */
        if (StringUtils.isBlank(caseId)) {
            return super.validError();
        }
        BusiValidResult busiValidResult = arbitratorCaseService.caseCompromiseInfoBusiValid(caseId, userId);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult<CaseCompromiseVO> busiExecuteResult = arbitratorCaseService.caseCompromiseInfoBusiExecute(caseId);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(ApiResultVO.Coder.ILLEGAL);
        }
        // 该日志必不可少
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

    @ApiOperation(value = "案件裁判信息")
    @RequestMapping(value = "/{caseId}/arbitrationInfo")
    public ApiResultVO<CaseArbitrationInfoVO> caseArbitrationInfo(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId) {
        /*
         * 参数验证
         */
        if (StringUtils.isBlank(caseId)) {
            return super.validError();
        }
        BusiValidResult busiValidResult = arbitratorCaseService.caseArbitrationInfoBusiValid(caseId, userId);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult<CaseArbitrationInfoVO> busiExecuteResult = arbitratorCaseService.caseArbitrationInfoBusiExecute(caseId);
        // 该日志必不可少
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

    @ApiOperation(value = "案件补正信息")
    @RequestMapping(value = "/{caseId}/amendmentInfo")
    public ApiResultVO<PageInfo<AdjudicationAmendmentVO>> amendmentInfo(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId) {
        /*
         * 参数验证
         */
        if (StringUtils.isBlank(caseId)) {
            return super.validError();
        }
        BusiValidResult busiValidResult = amendmentService.amendmentInfoBusiValid(caseId, userId);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }

        BusiExecuteResult amendmentInfoBusiExecute = amendmentService.amendmentInfoBusiExecute(caseId);
        BusiExecuteResult<PageInfo<AdjudicationAmendmentVO>> busiExecuteResult = amendmentInfoBusiExecute;
        // 该日志必不可少
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

    @ApiOperation(value = "案件答辩列表")
    @RequestMapping(value = "/{caseId}/argue", method = RequestMethod.POST)
    public ApiResultVO<List<ArgueRecordVO>> argue(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId) {
        /*
         * 参数验证
         */
        if (StringUtils.isBlank(userId)) {
            return super.validError();
        }
        BusiValidResult busiValidResult = arbitratorCaseService.caseArgueBusiValid(caseId, userId);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult<List<ArgueRecordVO>> busiExecuteResult = arbitratorCaseService.caseArgueBusiExecute(caseId, userId);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(ApiResultVO.Coder.ILLEGAL);
        }
        // 该日志必不可少
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

    @ApiOperation(value = "案件答辩回复")
    @RequestMapping(value = "/{caseId}/argueReply", method = RequestMethod.POST)
    public ApiResultVO argueReply(@RequestBody @Valid ArbitratorCaseArgueReplyDTO formData, BindingResult bindingResult) {
        /*
         * 参数验证
         */
        if (bindingResult.hasErrors()) {
            return super.validError();
        }
        BusiValidResult busiValidResult = arbitratorCaseService.caseArgueReplyBusiValid(formData);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult busiExecuteResult = arbitratorCaseService.caseArgueReplyBusiExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(ApiResultVO.Coder.ILLEGAL);
        }
        // 该日志必不可少
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

    @ApiOperation(value = "案件出具裁决书")
    @RequestMapping(value = "/{caseId}/arbitralAwards", method = RequestMethod.POST)
    public ApiResultVO arbitralAwards(@RequestBody @Valid ArbitratorCaseArbitralAwardsDTO formData, BindingResult bindingResult) {
        /*
         * 参数验证
         */
        if (bindingResult.hasErrors()) {
            return super.validError();
        }
        BusiValidResult busiValidResult = arbitratorCaseService.caseArbitralAwardsBusiValid(formData);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult busiExecuteResult = arbitratorCaseService.caseArbitralAwardsBusiExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(ApiResultVO.Coder.ILLEGAL);
        }
        // 该日志必不可少
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

    @ApiOperation(value = "案件出具裁决书")
    @RequestMapping(value = "/{caseId}/arbitralAwardsChange", method = RequestMethod.POST)
    public ApiResultVO arbitralAwardsChange(@RequestBody @Valid ArbitratorCaseArbitralAwardsDTO formData, BindingResult bindingResult) {
        /*
         * 参数验证
         */
        if (bindingResult.hasErrors()) {
            return super.validError();
        }
        BusiValidResult busiValidResult = arbitratorCaseService.caseArbitralAwardsChangeBusiValid(formData);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult busiExecuteResult = arbitratorCaseService.caseArbitralAwardsChangeBusiExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(ApiResultVO.Coder.ILLEGAL);
        }
        // 该日志必不可少
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

    @ApiOperation(value = "案件出具裁决书存草稿")
    @RequestMapping(value = "/{caseId}/arbitralAwardsDraft", method = RequestMethod.POST)
    public ApiResultVO arbitralAwardsDraft(@RequestBody @Valid ArbitratorCaseArbitralAwardsDTO formData, BindingResult bindingResult) {
        /*
         * 参数验证
         */
        if (bindingResult.hasErrors()) {
            return super.validError();
        }
        BusiValidResult busiValidResult = arbitratorCaseService.caseArbitralAwardsDraftBusiValid(formData);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult busiExecuteResult = arbitratorCaseService.caseArbitralAwardsDraftBusiExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(ApiResultVO.Coder.ILLEGAL);
        }
        // 该日志必不可少
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

    @ApiOperation(value = "案件出具裁决书状态")
    @RequestMapping(value = "/{caseId}/arbitralAwardsStatus", method = RequestMethod.POST)
    public ApiResultVO<ArbitratorCaseArbitralAwardStatusVO> arbitralAwardsStatus(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId) {
        /*
         * 参数验证
         */
        if (StringUtils.isBlank(userId)) {
            return super.validError();
        }
        BusiValidResult busiValidResult = arbitratorCaseService.caseArbitralAwardsStatusBusiValid(caseId, userId);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult<ArbitratorCaseArbitralAwardStatusVO> busiExecuteResult = arbitratorCaseService.caseArbitralAwardsStatusBusiExecute(caseId, userId);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(ApiResultVO.Coder.ILLEGAL);
        }
        // 该日志必不可少
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

    @ApiOperation(value = "案件出具调解书")
    @RequestMapping(value = "/{caseId}/mediateAwards", method = RequestMethod.POST)
    public ApiResultVO mediateAwards(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId) {
        /*
         * 参数验证
         */
        if (StringUtils.isBlank(userId)) {
            return super.validError();
        }
        BusiValidResult busiValidResult = arbitratorCaseService.caseMediateAwardsBusiValid(caseId, userId);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult busiExecuteResult = arbitratorCaseService.caseMediateAwardsBusiExecute(caseId, userId);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(ApiResultVO.Coder.ILLEGAL);
        }
        // 该日志必不可少
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

    @ApiOperation(value = "案件出具调解书状态")
    @RequestMapping(value = "/{caseId}/mediateAwardsStatus", method = RequestMethod.POST)
    public ApiResultVO<ArbitratorCaseMediateAwardStatusVO> mediateAwardsStatus(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId) {
        /*
         * 参数验证
         */
        if (StringUtils.isBlank(userId)) {
            return super.validError();
        }
        BusiValidResult busiValidResult = arbitratorCaseService.caseMediateAwardsStatusBusiValid(caseId, userId);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult<ArbitratorCaseMediateAwardStatusVO> busiExecuteResult = arbitratorCaseService.caseMediateAwardsStatusBusiExecute(caseId, userId);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(ApiResultVO.Coder.ILLEGAL);
        }
        // 该日志必不可少
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

    @ApiOperation(value = "案件重新出具调解书")
    @RequestMapping(value = "/{caseId}/mediateAwardsChange", method = RequestMethod.POST)
    public ApiResultVO mediateAwardsChange(@PathVariable("caseId") String caseId, @RequestParam("userId") String userId) {
        /*
         * 参数验证
         */
        if (StringUtils.isBlank(userId)) {
            return super.validError();
        }
        BusiValidResult busiValidResult = arbitratorCaseService.caseMediateAwardsChangeBusiValid(caseId, userId);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult busiExecuteResult = arbitratorCaseService.caseMediateAwardsChangeBusiExecute(caseId, userId);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(ApiResultVO.Coder.ILLEGAL);
        }
        // 该日志必不可少
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

    @ApiOperation(value = "案件出具管辖权异议决定书")
    @RequestMapping(value = "/{caseId}/jurisAwards", method = RequestMethod.POST)
    public ApiResultVO jurisAwards(@RequestBody @Valid ArbitratorCaseJurisAwardsDTO formData, BindingResult bindingResult) {
        /*
         * 参数验证
         */
        if (bindingResult.hasErrors()) {
            return super.validError();
        }
        BusiValidResult busiValidResult = arbitratorCaseService.caseJurisAwardsBusiValid(formData);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult busiExecuteResult = arbitratorCaseService.caseJurisAwardsBusiExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(ApiResultVO.Coder.ILLEGAL);
        }
        // 该日志必不可少
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

    @ApiOperation(value = "案件出具管辖权异议决定书")
    @RequestMapping(value = "/{caseId}/jurisAwardsChange", method = RequestMethod.POST)
    public ApiResultVO jurisAwardsChange(@RequestBody @Valid ArbitratorCaseJurisAwardsDTO formData, BindingResult bindingResult) {
        /*
         * 参数验证
         */
        if (bindingResult.hasErrors()) {
            return super.validError();
        }
        BusiValidResult busiValidResult = arbitratorCaseService.caseJurisAwardsChangeBusiValid(formData);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult busiExecuteResult = arbitratorCaseService.caseJurisAwardsChangeBusiExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(ApiResultVO.Coder.ILLEGAL);
        }
        // 该日志必不可少
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

    @ApiOperation(value = "案件出具管辖权异议决定书状态")
    @RequestMapping(value = "/{caseId}/jurisAwardsStatus", method = RequestMethod.POST)
    public ApiResultVO<ArbitratorCaseJurisAwardStatusVO> jurisAwardsStatus(@RequestBody @Valid ArbitratorCaseJurisAwardsStatusDTO formData, BindingResult bindingResult) {
        /*
         * 参数验证
         */
        if (bindingResult.hasErrors()) {
            return super.validError();
        }
        BusiValidResult busiValidResult = arbitratorCaseService.caseJurisAwardsStatusBusiValid(formData);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult<ArbitratorCaseJurisAwardStatusVO> busiExecuteResult = arbitratorCaseService.caseJurisAwardsStatusBusiExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(ApiResultVO.Coder.ILLEGAL);
        }
        // 该日志必不可少
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }


    @ApiOperation(value = "案件出具撤案决定书")
    @RequestMapping(value = "/{caseId}/withdrawAwards", method = RequestMethod.POST)
    public ApiResultVO withdrawAwards(@RequestBody @Valid ArbitratorCaseWithdrawAwardsDTO formData, BindingResult bindingResult) {
        /*
         * 参数验证
         */
        if (bindingResult.hasErrors()) {
            return super.validError();
        }
        BusiValidResult busiValidResult = arbitratorCaseService.caseWithdrawAwardsBusiValid(formData);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult busiExecuteResult = arbitratorCaseService.caseWithdrawAwardsBusiExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(ApiResultVO.Coder.ILLEGAL);
        }
        // 该日志必不可少
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

}
