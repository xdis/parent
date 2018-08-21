package com.zyxy.service.micro.core.controller;

import com.zyxy.common.dto.ArbitratorChangeProfileDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ArbitratorBaseInfoVO;
import com.zyxy.common.vo.ArbitratorPersonalInfoVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.service.ArbitratorInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * 仲裁员信息模块
 *
 * @author tanquan
 */
@Api(description = "仲裁员信息模块")
@RequestMapping("/arbitrator")
@RestController
public class ArbitratorController extends BaseController {

    @Autowired
    private ArbitratorInfoService arbitratorInfoService;

    @ApiOperation("仲裁员个人信息")
    @RequestMapping("/personalInfo")
    public ApiResultVO<?> queryArbitratorPersonalInfo(HttpServletRequest request, String userId) {
        BusiExecuteResult<ArbitratorPersonalInfoVO> busiExecuteResult = arbitratorInfoService.arbitratorPersonalInfoBusiExecute(userId);
        // 该日志必不可少
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

    @ApiOperation("仲裁员基本信息")
    @RequestMapping("/baseInfo")
    public ApiResultVO<?> queryArbitratorBaseInfo(HttpServletRequest request, String userId) {
        BusiExecuteResult<ArbitratorBaseInfoVO> busiExecuteResult = arbitratorInfoService.arbitratorBaseInfoBusiExecute(userId);
        // 该日志必不可少
        return super.busiExecuteSuccess(busiExecuteResult.getBody());
    }

    @ApiOperation("仲裁员修改信息申请")
    @RequestMapping("/change")
    public ApiResultVO change(@RequestBody @Valid ArbitratorChangeProfileDTO formData, BindingResult bindingResult) {
        //参数认证
        if (bindingResult.hasErrors()) {
            return super.validError();
        }
        //业务验证
        BusiValidResult busiValidResult = arbitratorInfoService.arbitratorChangeBusiValid(formData);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        //业务执行
        BusiExecuteResult busiExecuteResult = arbitratorInfoService.arbitratorChangeBusiExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiValidError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
        }
        return super.busiExecuteSuccess();
    }
}
