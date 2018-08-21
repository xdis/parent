package com.zyxy.service.micro.core.api.controller;

import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.dto.LostSmsSendDTO;
import com.zyxy.common.dto.SmsSendDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.api.service.SmsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 公共信息发送模块
 */
@Api(description="公共信息发送模块")
@RequestMapping("/api/public/sms")
@RestController
public class ApiPublicSmsController extends BaseController {

    @Autowired
    private SmsService smsService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @WebLog("公共-发送手机验证码")
    @ApiOperation(value = "公共-发送手机验证码")
    @PostMapping(value = "send")
    public ApiResultVO<String> send(@RequestBody @Valid SmsSendDTO formData, BindingResult bindingResult) {
        /*
         * 参数验证
         */
        if (bindingResult.hasErrors()) {
            return super.validError();
        }
        BusiValidResult busiValidResult = smsService.sendSmsBusiValid(formData);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }
        /*
         * 核心业务处理，业务处理统一返回boolean，有错误时，在DTO中调用processRetMsg设置具体枚举
         * 业务处理命名规范：业务名称+BusiExecute
         * 例：acceptCaseBusiExecute
         */
        BusiExecuteResult busiExecuteResult = smsService.sendSmsBusiExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
        }
        return super.busiExecuteSuccess();
    }

    /**
     * 发送登录验证短信
     */
    @WebLog("公共-发送登录验证短信")
    @ApiOperation(value="公共-发送登录验证短信")
    @PostMapping(value = "/login/code")
    @ResponseBody
    public ApiResultVO<String> sendSmsLogin(@RequestBody @Valid SmsSendDTO formData, BindingResult bindingResult) {
        /*
         * 参数验证
         */
        if (bindingResult.hasErrors()) {
            return super.validError();
        }
        BusiValidResult busiValidResult = smsService.sendSmsLoginValid(formData);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }

        BusiExecuteResult busiExecuteResult = smsService.sendSmsLoginExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
        }
        return super.busiExecuteSuccess();
    }

    /**
     * 发送登录验证短信
     */
    @WebLog("公共-发送登录验证短信")
    @ApiOperation(value = "公共-发送登录验证短信")
    @PostMapping(value = "/lost/code")
    @ResponseBody
    public ApiResultVO<String> sendSmsLost(@RequestBody @Valid LostSmsSendDTO formData, BindingResult bindingResult) {
        /*
         * 参数验证
         */
        if (bindingResult.hasErrors()) {
            return super.validError();
        }
        BusiValidResult busiValidResult = smsService.sendSmsLostValid(formData);
        if (busiValidResult.hasError()) {
            return super.busiValidError(busiValidResult.getCode(), busiValidResult.getMsg());
        }

        BusiExecuteResult busiExecuteResult = smsService.sendSmsLostExecute(formData);
        if (busiExecuteResult.hasError()) {
            return super.busiExecuteError(busiExecuteResult.getCode(), busiExecuteResult.getMsg());
        }
        return super.busiExecuteSuccess();
    }
}
