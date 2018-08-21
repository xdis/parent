package com.zyxy.service.micro.core.api.controller;

import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.ArbitratorAcceptStatusDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.api.service.ArbitratorAcceptStatusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 仲裁员接案状态控制层
 */
@Api(description = "仲裁员接案状态")
@RequestMapping("/api/arbitrator/acceptstatus")
@RestController
public class ApiArbitratorAcceptStatusController extends BaseController {

    @Autowired
    private ArbitratorAcceptStatusService acceptStatusService;

    @WebLog("仲裁员-改变接案状态")
    @ApiOperation(value = "更新仲裁员接案状态")
    @PutMapping(value = "/updateStatus")
    public ApiResultVO<String> updateStatus(@RequestBody ArbitratorAcceptStatusDTO formData) {
        formData.setUserId(getSessionUser().getUserInfoId());
        return acceptStatusService.updateStatus(formData);
    }
}
