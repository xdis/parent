package com.zyxy.service.micro.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.web.util.RequestUtil;
import com.zyxy.service.micro.api.dto.ReqCaseCommonDTO;
import com.zyxy.service.micro.api.dto.ReqCaseRegisterDTO;
import com.zyxy.service.micro.api.dto.ResResultDTO;
import com.zyxy.service.micro.api.service.api.CasePayInfoService;
import com.zyxy.service.micro.api.service.api.CaseRegisterService;
import com.zyxy.service.micro.api.service.api.CaseStatusService;

@Api(description="案件模块")
@RequestMapping("/api")
@RestController
public class CaseApiController extends BaseController{
    
    @Autowired
    private CaseRegisterService caseRegisterService;
    @Autowired
    private CaseStatusService caseStatusService;
    @Autowired
    private CasePayInfoService casePayInfoService;
    
	
    @WebLog("案件发布/修改（立案）")
    @ApiOperation("案件发布/修改（立案）")
    @RequestMapping(value = "/case/publish", method = {RequestMethod.POST})
    public ResResultDTO casePublish(HttpServletRequest request
            , ReqCaseRegisterDTO dto
            ) {
        ResResultDTO ret = caseRegisterService.call(dto, RequestUtil.getIp(request));
        return ret;
    }
    
    @WebLog("案件状态查询")
    @ApiOperation("案件状态查询")
    @RequestMapping(value = "/case/status", method = {RequestMethod.POST})
    public ResResultDTO getCaseStatus(HttpServletRequest request
            , ReqCaseCommonDTO dto
            ) {
        ResResultDTO ret = caseStatusService.call(dto, RequestUtil.getIp(request));
        return ret;
    }
    
    @WebLog("案件缴费信息查询")
    @ApiOperation("案件缴费信息查询")
    @RequestMapping(value = "/case/payInfo", method = {RequestMethod.POST})
    public ResResultDTO getCasePayInfo(HttpServletRequest request
            , ReqCaseCommonDTO dto
            ) {
        ResResultDTO ret = casePayInfoService.call(dto, RequestUtil.getIp(request));
        return ret;
    }
    
}
