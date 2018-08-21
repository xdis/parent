package com.zyxy.service.micro.scheduler.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.web.util.RequestUtil;

/**
 * 公共访问类（无需登录）
 *
 * @author tanquan
 */
@Api(description="公共访问模块（无需登录）")
@RequestMapping("/public")
@Controller
public class TemplateController {

	private final static Logger logger = LoggerFactory.getLogger(TemplateController.class);


	@ApiOperation(value="controller-模板")
	@RequestMapping(value = "/template", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public ApiResultVO<String> template(HttpServletRequest request) {
		ApiResultVO<String> ret = new ApiResultVO<String>();
		String reqIp = RequestUtil.getIp(request);
		logger.info("请求模板controller，IP:{}", reqIp);
		return ret.setCoder(ApiResultVO.Coder.SUCCESS).setBody("IP：" + reqIp + "已成功请求 third-service template controller");
	}
    
}
