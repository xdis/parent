package com.zyxy.service.micro.core.api.controller;

import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.CaseEvaluationDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.CaseEvaluationVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.api.service.CaseEvaluationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(description = "案件评论模块")
@Controller
@RequestMapping("/api/arbitrator/caseEvaluation")
public class ApiCaseEvaluationController extends BaseController {

    @Autowired
    private CaseEvaluationService evaluationService;

    @WebLog("仲裁员-获取案件评价")
    @GetMapping(value = "")
    @ApiOperation(value = "案件评论列表")
    @ResponseBody
    public ApiResultVO<CaseEvaluationVO> query(CaseEvaluationDTO formData) {
        formData.setUserId(getSessionUser().getUserInfoId());
        return evaluationService.query(formData);
    }
}
