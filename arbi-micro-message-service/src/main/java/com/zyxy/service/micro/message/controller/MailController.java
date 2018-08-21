package com.zyxy.service.micro.message.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zyxy.common.dto.MailInfoDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.common.web.util.RequestUtil;
import com.zyxy.service.micro.message.service.MailService;

/**
 * 邮件服务模块
 *
 * @author tanquan
 */
@Api(description="邮件服务模块")
@RequestMapping("/mail")
@RestController
public class MailController extends BaseController{

	private final static Logger logger = LoggerFactory.getLogger(MailController.class);


	@Autowired
	private MailService mailService;
    
	
    @ApiOperation(value = "邮件发送")
    @RequestMapping(value = "send", method = {RequestMethod.POST})
    public ApiResultVO<String> send(
    		HttpServletRequest request
            , @Valid @RequestBody MailInfoDTO info
            , BindingResult bdResult
    ) {
		// 该日志必不可少
		String busiDesr = "邮件发送";
        logger.info("开始业务[{}]-参数:{}", busiDesr, RequestUtil.getParamMap(request));
    	
		if (bdResult.hasErrors()) {
		    return super.error(bdResult.getFieldError());
		}
		
		String id = mailService.send(info);
		if (id == null) {
		    return error(ApiResultVO.Coder.CALL_SERV_ERROR);
		}
		
		// 该日志必不可少
        logger.info("执行业务[{}]成功", busiDesr);
        return ok(id);
    }
	
}
