package com.zyxy.service.micro.third.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyxy.common.dto.BankFourElementDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.BuzzResultVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.common.web.util.RequestUtil;
import com.zyxy.service.micro.third.service.AuthService;

/**
 * 认证服务模块
 * @author tanquan
 */
@Api(description="认证服务模块")
@RequestMapping("/auth")
@Controller
public class AuthenticationController extends BaseController{

	@Autowired
	private AuthService authService;
    
	/**
	 * 银行卡四要素认证
	 * @param request
	 * @param payInfo
	 * @param bdResult
	 * @return
	 */
	@ApiOperation(value="银行卡四要素认证")
	@RequestMapping(value = "/bankFourElement.do", method = {RequestMethod.POST})
	@ResponseBody
	public ApiResultVO<String> bankFourElement(HttpServletRequest request
	        ,@Valid @RequestBody BankFourElementDTO elemInfo
	        ,BindingResult bdResult
	        ) {
        // 该日志必不可少
        String busiDesr = "银行卡四要素认证";
        logger.info("开始业务[{}]-参数:{}",  RequestUtil.getParamMap(request));
        
        if (bdResult.hasErrors()) {
            return super.error(bdResult.getFieldError());
        }
        
        BuzzResultVO<String> ret = authService.verifyBankFourElement(elemInfo);
        
        if (!ret.getOk()) {
            return error(ApiResultVO.Coder.AUTH_FAIL.setMessage(ret.getMessage()));
        }
        
        // 该日志必不可少
        logger.info("执行业务[{}]成功", busiDesr);
        return ok(ret.getAttach());
	}
}
