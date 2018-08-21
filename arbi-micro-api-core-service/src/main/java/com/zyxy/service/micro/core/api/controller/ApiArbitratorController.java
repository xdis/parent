package com.zyxy.service.micro.core.api.controller;

import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.ArbitratorChangeProfileDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.api.service.ArbitratorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 仲裁员信息模块
 *
 * @author tanquan
 */
@Api(description = "仲裁员信息模块")
@RequestMapping("/api/arbitrator")
@RestController
public class ApiArbitratorController extends BaseController {

    @Autowired
    private ArbitratorService arbitratorInfoService;

    @WebLog("仲裁员-个人信息查询")
    @ApiOperation("仲裁员个人信息")
    @GetMapping("/personalInfo")
    public ApiResultVO<?> queryArbitratorPersonalInfo() {
        return arbitratorInfoService.queryArbitratorPersonalInfo(getSessionUser().getUserInfoId());
    }

    @WebLog("仲裁员-基本信息查询")
    @ApiOperation("仲裁员基本信息")
    @GetMapping("/baseInfo")
    public ApiResultVO<?> queryArbitratorBaseInfo() {
        return arbitratorInfoService.queryArbitratorBaseInfo(getSessionUser().getUserInfoId());
    }

    @WebLog("仲裁员-基本信息修改申请")
    @ApiOperation("仲裁员基本信息修改申请")
    @PutMapping("/baseInfo")
    public ApiResultVO<?> change(@RequestBody ArbitratorChangeProfileDTO formData) {
        formData.setUserId(getSessionUserId());
        return arbitratorInfoService.change(formData);
    }

}
