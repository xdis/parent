package com.zyxy.service.micro.core.controller;

import com.zyxy.common.dto.CaseChangeRecordInsertDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.service.CaseChangeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 变更仲裁请求
 */
@Api(description = "变更仲裁请求")
@RequestMapping("/public/case/change")
@RestController
public class CaseChangeController extends BaseController {

    @Autowired
    private CaseChangeService caseChangeService;

    @ApiOperation("公共-变更仲裁申请")
    @RequestMapping("")
    public ApiResultVO<String> add(@Valid @RequestBody CaseChangeRecordInsertDTO formData, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return super.validError();
        }
        BusiExecuteResult<String> busiExecuteResult = caseChangeService.insertCaseChangeRecordBusiExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
        }
        return super.ok();
    }

}
