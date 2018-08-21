package com.zyxy.service.micro.core.controller;

import com.zyxy.common.dto.flow.*;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.service.CaseFlowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 案件流程模块
 */
@Api(description="案件流程模块")
@RequestMapping("/caseFlow/{caseId}")
@RestController
public class CaseFlowController extends BaseController {

    @Autowired
    private CaseFlowService caseFlowService;

    @ApiOperation(value="立案审核")
    @RequestMapping(value = "audit", method = RequestMethod.POST)
    public ApiResultVO<String> audit(@RequestBody @Valid CaseAuditDTO formData, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return super.validError();
        }
        BusiValidResult busiValidResult = caseFlowService.caseAuditBusiValid(formData);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult busiExecuteResult = caseFlowService.caseAuditBusiExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
        }
        // 该日志必不可少
        return super.busiExecuteSuccess();
    }

    @ApiOperation(value="缴费通过")
    @RequestMapping(value = "pay", method = RequestMethod.POST)
    public ApiResultVO<String> pay(@RequestBody @Valid CasePayDTO formData, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return super.validError();
        }
        BusiValidResult busiValidResult = caseFlowService.casePayBusiValid(formData);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult busiExecuteResult = caseFlowService.casePayBusiExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
        }
        // 该日志必不可少
        return super.busiExecuteSuccess();
    }

    @ApiOperation(value = "中途退出和解")
    @RequestMapping(value = "compromiseExit", method = RequestMethod.POST)
    public ApiResultVO<String> compromiseExit(@PathVariable("caseId") String caseId) {
        BusiValidResult busiValidResult = caseFlowService.caseCompromiseExitBusiValid(caseId);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult busiExecuteResult = caseFlowService.caseCompromiseExitBusiExecute(caseId);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
        }
        return super.busiExecuteSuccess();
    }

    @ApiOperation(value = "结案")
    @RequestMapping(value = "caseOver", method = RequestMethod.POST)
    public ApiResultVO<String> caseOver(@RequestBody @Valid CaseOverDTO formData, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return super.validError();
        }
        BusiValidResult busiValidResult = caseFlowService.caseOverBusiValid(formData);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult busiExecuteResult = caseFlowService.caseOverBusiExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
        }
        return super.busiExecuteSuccess();
    }

    @ApiOperation(value = "和解结束")
    @RequestMapping(value = "compromiseOver", method = RequestMethod.POST)
    public ApiResultVO<String> compromiseOver(@RequestBody @Valid CaseCompromiseOverDTO formData, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return super.validError();
        }
        BusiValidResult busiValidResult = caseFlowService.compromiseOverBusiValid(formData);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult busiExecuteResult = caseFlowService.compromiseOverBusiExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
        }
        return super.busiExecuteSuccess();
    }

    @ApiOperation(value = "放弃答辩期")
    @RequestMapping(value = "giveReply", method = RequestMethod.POST)
    public ApiResultVO<String> giveReply(@RequestBody @Valid CaseGiveReplyDTO formData, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return super.validError();
        }
        BusiValidResult busiValidResult = caseFlowService.giveReplyBusiValid(formData);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult busiExecuteResult = caseFlowService.giveReplyBusiExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
        }
        return super.busiExecuteSuccess();
    }

    @ApiOperation(value = "撤案")
    @RequestMapping(value = "cancelCase", method = RequestMethod.POST)
    public ApiResultVO<String> cancelCase(@RequestBody @Valid CaseCancelDTO formData, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return super.validError();
        }
        BusiValidResult busiValidResult = caseFlowService.cancelCaseBusiValid(formData);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        BusiExecuteResult busiExecuteResult = caseFlowService.cancelCaseBusiExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
        }
        return super.busiExecuteSuccess();
    }
}
