package com.zyxy.service.micro.core.api.controller;

import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.CaseDocVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.api.service.CaseDocService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 案件文书控制层
 */
@Api(description = "案件文书模块")
@RestController
@RequestMapping("/api/arbitrator/case")
public class ApiCaseDocController extends BaseController {

    @Autowired
    private CaseDocService caseDocService;

    @WebLog("仲裁员-预览裁决书")
    @ApiOperation(value = "预览裁决书")
    @GetMapping(value = "/{caseId}/previewArbitramentDoc")
    public ApiResultVO<CaseDocVO> get(@PathVariable String caseId) {
        return caseDocService.get(caseId, getSessionUser().getUserInfoId());
    }

}
