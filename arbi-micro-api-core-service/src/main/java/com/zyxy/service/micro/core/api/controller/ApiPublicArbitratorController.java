package com.zyxy.service.micro.core.api.controller;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.BasePageDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ArbitratorListVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.api.service.PublicArbitratorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 公共模块
 */
@Api(description="公共模块")
@RequestMapping("/api/public/arbitrator")
@RestController
public class ApiPublicArbitratorController extends BaseController {

    @Autowired
    private PublicArbitratorService publicArbitratorService;

    @WebLog("公共-仲裁员列表")
    @ApiOperation(value="公共-仲裁员列表")
    @GetMapping(value = "")
    public ApiResultVO<PageInfo<ArbitratorListVO>> list(BasePageDTO formData) {
        return publicArbitratorService.list(formData);
    }
}
