package com.zyxy.service.micro.core.api.controller;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.ChangeDocDTO;
import com.zyxy.common.dto.DelayedReplyDTO;
import com.zyxy.common.dto.LitigantCaseListDTO;
import com.zyxy.common.dto.ReplyDocDTO;
import com.zyxy.common.vo.*;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.api.service.LitigantCaseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(description = "当事人案件")
@RestController
@RequestMapping("/api/litigant/case")
public class ApiLitigantCaseController extends BaseController {

    @Autowired
    private LitigantCaseService litigantCaseSercvice;

    @WebLog("当事人-案件列表")
    @ApiOperation(value = "当事人案件列表")
    @GetMapping("")
    public ApiResultVO<PageInfo<LitigantCaseListVO>> list(LitigantCaseListDTO formData) {
        formData.setUserId(getSessionUser().getUserInfoId());
        return litigantCaseSercvice.list(formData);
    }

    @WebLog("当事人-案件仲裁员")
    @ApiOperation(value = "当事人案件仲裁员")
    @GetMapping(value = "/{caseId}/arbitratorInfo")
    public ApiResultVO<ArbitratorInfoVO> get(@PathVariable String caseId) {
        return litigantCaseSercvice.get(caseId, getSessionUser().getUserInfoId());
    }

    @WebLog("当事人-案件缴费信息")
    @ApiOperation(value = "当事人案件缴费信息")
    @GetMapping(value = "/{caseId}/payInfo")
    public ApiResultVO<PayOrderVO> payInfo(@PathVariable String caseId) {
        return litigantCaseSercvice.payInfo(caseId, getSessionUser().getUserInfoId());
    }

    @WebLog("当事人-案件信息")
    @ApiOperation(value = "当事人案件信息")
    @GetMapping(value = "/{caseId}/caseInfo")
    public ApiResultVO<PayAndCaseInfoVO> getCaseInfo(@PathVariable("caseId") String caseId){
    	return litigantCaseSercvice.getCaseInfo(caseId,getSessionUser().getUserInfoId());
    }
    
    @WebLog("当事人-案件反请求")
    @ApiOperation(value = "当事人案件反请求")
    @GetMapping(value = "/{caseId}/backRequest")
    public ApiResultVO<PayAndCaseInfoVO> getBackRequest(@PathVariable("caseId") String caseId){
    	return litigantCaseSercvice.getBackRequest(caseId,getSessionUser().getUserInfoId());
    }
    
    @WebLog("案件公共模块")
    @ApiOperation(value = "案件公共模块")
    @GetMapping(value = "/{caseId}/commInfo")
    public ApiResultVO<CaseCommInfoVO> getCommInfo(@PathVariable String caseId){
    	return litigantCaseSercvice.getCommonInfo(caseId, getSessionUser().getUserInfoId());
    }
    
    @WebLog("本请求列表（包括变更请求）")
    @ApiOperation(value = "本请求列表（包括变更请求）")
    @GetMapping(value="/{caseId}/request")
    public ApiResultVO<RequestVO> requestList(@PathVariable("caseId") String caseId){
    	return litigantCaseSercvice.getRequestList(caseId, getSessionUser().getUserInfoId());
    }
    
    @WebLog(value="反请求列表（包括变更反请求）")
    @ApiOperation(value = "反请求列表（包括变更反请求）")
    @GetMapping(value="/back/{caseId}/request")
    public ApiResultVO<RequestVO> backRequestList(@PathVariable("caseId") String caseId){
    	return litigantCaseSercvice.getBackRequestList(caseId, getSessionUser().getUserInfoId());
    }
    
    @WebLog("变更请求申请文书")
    @ApiOperation(value="变更请求申请文书内容")
    @GetMapping("/{changeId}/changeDoc")
    public ApiResultVO<PayAndChangeInfoVO> changeDoc(@PathVariable String changeId,ChangeDocDTO formData){
    	formData.setUserId(getSessionUser().getUserInfoId());
    	return litigantCaseSercvice.changeDoc(changeId, formData);
    }

    @WebLog("延期答辩")
    @ApiOperation(value = "延期答辩")
    @PostMapping("/{caseId}/delayedReply")
    public ApiResultVO delayedReply(@PathVariable("caseId") String caseId,@RequestBody DelayedReplyDTO formData) {
        formData.setUserId(getSessionUser().getUserInfoId());
        formData.setCaseId(caseId);
        return litigantCaseSercvice.delayedReply(formData.getCaseId(), formData);
    }

    @WebLog("变更反请求申请文书")
    @ApiOperation(value="变更请求反申请文书内容")
    @GetMapping("/back/{changeId}/changeDoc")
    public ApiResultVO<PayAndChangeInfoVO> backChangeDoc(@PathVariable String changeId,ChangeDocDTO formData){
    	formData.setUserId(getSessionUser().getUserInfoId());
    	return litigantCaseSercvice.backChangeDoc(changeId, formData);
    }
    
    @WebLog("答辩书文书")
    @ApiOperation(value="答辩文书内容")
    @GetMapping("/{caseId}/replyDoc")
    public ApiResultVO<ReplyDocVO> replyDoc(@PathVariable String caseId,ReplyDocDTO formData){
    	formData.setUserId(getSessionUser().getUserInfoId());
    	return litigantCaseSercvice.replyDoc(caseId, formData);
    }
    
    @WebLog("反请求答辩书文书")
    @ApiOperation(value="反请求答辩文书内容")
    @GetMapping("/back/{caseId}/replyDoc")
    public ApiResultVO<ReplyDocVO> backReplyDoc(@PathVariable String caseId,ReplyDocDTO formData){
    	formData.setUserId(getSessionUser().getUserInfoId());
    	return litigantCaseSercvice.backReplyDoc(caseId, formData);
    }
    
    @WebLog("倒计时")
    @ApiOperation("倒计时")
    @GetMapping("/{caseId}/countDown")
    public ApiResultVO<List<CountDownVO>> countDown(@PathVariable("caseId")String caseId){
    	return litigantCaseSercvice.countDown(caseId, getSessionUser().getUserInfoId());
    }
    
    @WebLog("撤案消息")
    @ApiOperation("撤案消息")
    @GetMapping("/{caseId}/withdrawMsg")
    public ApiResultVO<WithdrawMessageVO> withdrawMsg(@PathVariable("caseId") String caseId){
    	return litigantCaseSercvice.withdrawMsg(caseId, getSessionUser().getUserInfoId());
    }
}
