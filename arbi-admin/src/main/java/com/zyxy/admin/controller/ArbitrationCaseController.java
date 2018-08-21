package com.zyxy.admin.controller;

import com.zyxy.common.annotation.WebLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;
import com.zyxy.admin.service.ArbitrationCaseService;
import com.zyxy.admin.service.CaseManagerService;
import com.zyxy.admin.service.PublicCoreService;
import com.zyxy.common.dto.ArbitrationCaseListDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ArbitrationCaseListVO;
import com.zyxy.common.vo.ArbitratorCaseBaseInfoVO;
import com.zyxy.common.vo.SecurityUserVO;
import com.zyxy.common.web.BaseController;

/**
 * 仲裁委案件信息控制层
 */
@Api(description = "仲裁委服务模块")
@RequestMapping("/arbitration/case")
@RestController
public class ArbitrationCaseController extends BaseController {

    @Autowired
    private ArbitrationCaseService arbitrationCaseService;

    @Autowired
    private PublicCoreService publicCoreService;

    @Autowired
    private CaseManagerService caseManagerService;

    @WebLog("仲裁委-获取案件列表")
    @ApiOperation(value = "案件列表")
    @RequestMapping(value = "")
    public ApiResultVO<PageInfo<ArbitrationCaseListVO>> list(@RequestBody @Valid ArbitrationCaseListDTO formData, BindingResult bindingResult, HttpServletRequest request) {
        SecurityUserVO sessionUser = super.getSessionUser();

        //参数初始化
        formData.setUserId(sessionUser.getUserInfoId());

        /*
         * 参数验证
         */
        if (bindingResult.hasErrors()) {
            return super.validError();
        }

        /*
         * 业务验证，验证该仲裁委工作人员的状态是正常还是注销
         *
         */
        BusiValidResult busiValidResult = arbitrationCaseService.queryArbitrationCaseBusiValid(sessionUser.getUserInfoId());

        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }

        /*
         * 业务处理
         */
        BusiExecuteResult<PageInfo<ArbitrationCaseListVO>> pageInfoBusiExecuteResult = arbitrationCaseService.queryArbitrationCaseBusiExecute(formData);

        if(pageInfoBusiExecuteResult.hasError()){
            return super.busiExecuteError(ApiResultVO.Coder.DBERROR);
        }

        return super.busiExecuteSuccess(pageInfoBusiExecuteResult.getBody());
    }

    /**
     * 仲裁委案件信息
     *
     * @param caseId
     * @param request
     * @return
     */
    @WebLog("仲裁委-案件基本信息")
    @ApiOperation(value = "案件基本信息")
    @RequestMapping(value = "/{caseId}")
    public ApiResultVO<ArbitratorCaseBaseInfoVO> caseBaseInfo(@PathVariable("caseId") String caseId, HttpServletRequest request) {
        SecurityUserVO sessionUser = super.getSessionUser();
        /*
         * 参数验证
         */
        if (StringUtils.isBlank(caseId)) {
            return super.validError();
        }
        /*
         * 业务验证
         */
        BusiValidResult busiValidResult = caseManagerService.caseRequestInfoBusiValid(caseId,sessionUser.getUserInfoId());
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        /*
         * 业务处理
         */
        BusiExecuteResult<ArbitratorCaseBaseInfoVO> busiExecuteResult = caseManagerService.caseBaseInfoBusiExecute(caseId, sessionUser.getUserInfoId(), "0");
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

}
