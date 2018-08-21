package com.zyxy.service.micro.core.controller;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.dto.BasePageDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ArbitratorListVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.service.PublicArbitratorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 公共仲裁员模块
 */
@Api(description="公共仲裁员模块")
@RequestMapping("/public/arbitrator")
@RestController
public class PublicArbitratorController extends BaseController {

    @Autowired
    private PublicArbitratorService publicArbitratorService;

    @ApiOperation(value="仲裁员列表")
    @RequestMapping(value = "")
    public ApiResultVO<PageInfo<ArbitratorListVO>> list(@RequestBody @Valid BasePageDTO formData, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return super.validError();
        }
        BusiExecuteResult<PageInfo<ArbitratorListVO>> busiExecuteResult = publicArbitratorService.queryArbitratorsBusiExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
        }
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }
}
