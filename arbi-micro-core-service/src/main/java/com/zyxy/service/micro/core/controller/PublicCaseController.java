package com.zyxy.service.micro.core.controller;

import com.alibaba.fastjson.JSONObject;
import com.zyxy.common.dto.*;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.*;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.service.AmendmentService;
import com.zyxy.service.micro.core.service.PublicCaseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 公共案件模块
 */
@Api(description="公共案件模块")
@RequestMapping("/public/case")
@RestController
public class PublicCaseController extends BaseController {

    @Autowired
    private PublicCaseService publicCaseService;

    @Autowired
    private AmendmentService adjudicationAmendmentService;

    @ApiOperation(value = "本人立案缺省信息")
    @RequestMapping(value = "selfCaseApplyInfo")
    public ApiResultVO<CaseDefaultInfoVO> selfCaseApplyInfo(@RequestBody @Valid BaseDTO formData) {
        BusiExecuteResult<CaseDefaultInfoVO> busiExecuteResult = publicCaseService.selfCaseApplyInfoBusiExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
        }
        // 该日志必不可少
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

    @ApiOperation(value="立案申请")
    @RequestMapping(value = "caseApply")
    public ApiResultVO<String> caseApply(@RequestBody @Valid RegisterCaseDTO formData, BindingResult bindingResult) {
        /*
         * 参数验证
         */
        if (bindingResult.hasErrors()) {
            logger.info(JSONObject.toJSONString(bindingResult.getAllErrors()));
            return super.validError();
        }
        BusiValidResult busiValidResult = publicCaseService.caseApplyBusiValid(formData);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        /*
         * 核心业务处理，业务处理统一返回boolean，有错误时，在DTO中调用processRetMsg设置具体枚举
         * 业务处理命名规范：业务名称+BusiExecute
         * 例：acceptCaseBusiExecute
         */
        BusiExecuteResult<String> busiExecuteResult = publicCaseService.caseApplyBusiExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
        }
        // 该日志必不可少
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

    @ApiOperation(value="立案申请存草稿")
    @RequestMapping(value = "caseApplyDraft")
    public ApiResultVO<String> caseApplyDraft(@RequestBody @Valid RegisterCaseDTO formData, BindingResult bindingResult) {
        /*
         * 参数验证
         */
//        if (bindingResult.hasErrors()) {
//            return super.validError();
//        }
        BusiValidResult busiValidResult = publicCaseService.caseApplyDraftBusiValid(formData);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        /*
         * 核心业务处理，业务处理统一返回boolean，有错误时，在DTO中调用processRetMsg设置具体枚举
         * 业务处理命名规范：业务名称+BusiExecute
         * 例：acceptCaseBusiExecute
         */
        BusiExecuteResult<String> busiExecuteResult = publicCaseService.caseApplyDraftBusiExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
        }
        // 该日志必不可少
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

    @ApiOperation(value = "得到立案申请存草稿")
    @RequestMapping(value = "getCaseApplyDraft")
    public ApiResultVO<CaseApplyDraftVO> getCaseApplyDraft(@RequestBody @Valid GetCaseDraftDTO formData) {
        BusiValidResult busiValidResult = publicCaseService.getCaseApplyDraftBusiValid(formData);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult<CaseApplyDraftVO> busiExecuteResult = publicCaseService.getCaseApplyDraftBusiExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
        }
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

    @ApiOperation(value="请求答辩")
    @PostMapping(value = "/{caseId}/caseReply")
    public ApiResultVO<String> caseReply(@RequestBody @Valid CaseReplyDTO formData, BindingResult bindingResult) {
        /*
         * 参数验证
         */
        if (bindingResult.hasErrors()) {
            return super.validError();
        }
        BusiValidResult busiValidResult = publicCaseService.caseReplyBusiValid(formData);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        /*
         * 核心业务处理，业务处理统一返回boolean，有错误时，在DTO中调用processRetMsg设置具体枚举
         * 业务处理命名规范：业务名称+BusiExecute
         * 例：acceptCaseBusiExecute
         */
        BusiExecuteResult busiExecuteResult = publicCaseService.caseReplyBusiExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
        }
        // 该日志必不可少
        return super.busiExecuteSuccess();
    }
    
    @ApiOperation(value="修改答辩")
    @PostMapping(value = "/{caseId}/rejoin")
    public ApiResultVO<String> rejoinAmend(@RequestBody @Valid CaseRejoinUpdateDTO formData,
    		BindingResult bindingResult){
    	if (bindingResult.hasErrors()) {
			return super.validError();
		}
    	BusiValidResult busiValidResult = publicCaseService.caseRejoinAmendValid(formData);
    	if (busiValidResult.hasError()) {
			return super.busiValidError(busiValidResult.getCode(),busiValidResult.getMsg());
		}
    	BusiExecuteResult<String> busiExecuteResult = publicCaseService.caseRejoinAmendExecute(formData);
    	if (busiExecuteResult.hasError()) {
			return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
		}
    	return super.ok();
    }
}
