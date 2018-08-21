package com.zyxy.service.micro.core.api.controller;

import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.*;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.CaseApplyDraftVO;
import com.zyxy.common.vo.CaseDefaultInfoVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.api.service.PublicCaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 公共案件模块
 */
@Api(description = "公共案件模块")
@RequestMapping("/api/public/case")
@RestController
public class ApiPublicCaseController extends BaseController {

    private final PublicCaseService publicCaseService;

    @Autowired
    public ApiPublicCaseController(PublicCaseService publicCaseService) {
        this.publicCaseService = publicCaseService;
    }

    @WebLog("公共模块-本人立案缺省信息")
    @ApiOperation(value = "本人立案缺省信息")
    @GetMapping(value = "selfCaseApplyInfo")
    public ApiResultVO<CaseDefaultInfoVO> selfCaseApplyInfo() {
        BaseDTO formData = new BaseDTO();
        formData.setUserId(getSessionUser().getUserInfoId());
        return publicCaseService.selfCaseApplyInfo(formData);
    }

    @WebLog("公共模块-立案申请")
    @ApiOperation(value = "立案申请")
    @PostMapping(value = "caseApply")
    public ApiResultVO<String> caseApply(@RequestBody RegisterCaseDTO formData) {
        formData.setUserId(getSessionUser().getUserInfoId());
        return publicCaseService.caseApply(formData);
    }

    @WebLog("公共模块-立案申请草稿")
    @ApiOperation(value = "立案申请草稿")
    @PostMapping(value = "caseApplyDraft")
    public ApiResultVO<String> caseApplyDraft(@RequestBody RegisterCaseDTO formData) {
        formData.setUserId(getSessionUser().getUserInfoId());
        return publicCaseService.caseApplyDraft(formData);
    }

    @WebLog("公共模块-得到立案申请存草稿")
    @ApiOperation(value = "得到立案申请存草稿")
    @PostMapping(value = "getCaseApplyDraft")
    public ApiResultVO<CaseApplyDraftVO> getCaseApplyDraft(@RequestBody GetCaseDraftDTO formData) {
        formData.setUserId(getSessionUser().getUserInfoId());
        return publicCaseService.getCaseApplyDraft(formData);
    }

    @ApiOperation(value="请求答辩")
    @PostMapping(value = "/{caseId}/caseReply")
    public ApiResultVO<String> caseReply(@PathVariable("caseId") String caseId,@RequestBody CaseReplyDTO formData) {
        formData.setUserId(getSessionUser().getUserInfoId());
        formData.setCaseId(caseId);
        return publicCaseService.caseReply(formData.getCaseId(), formData);
    }
    
    @WebLog("公共模块-答辩修改")
    @ApiOperation(value="答辩修改")
    @PutMapping(value="/{caseId}/rejoin")
    public ApiResultVO<String> rejoin(@RequestBody CaseRejoinUpdateDTO formData){
        formData.setUserId(getSessionUser().getUserInfoId());
        return publicCaseService.rejoinAmend(formData.getCaseId(), formData);
    }
}