package com.zyxy.service.micro.message.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.BuzzResultVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.common.web.util.RequestUtil;
import com.zyxy.service.micro.message.service.SmsService;

/**
 * 消息服务模块
 *
 * @author tanquan
 */
@Api(description="短信服务模块")
@RequestMapping("/sms")
@RestController
public class SmsController extends BaseController{

	private final static Logger logger = LoggerFactory.getLogger(SmsController.class);


	@Autowired
	private SmsService smsService;
    
	/**
	 * 短信发送
	 * @param request
	 * @param phoneNo
	 * @param tplCode
	 * @param tplJsonCnt
	 * @param signCode
	 * @return
	 */
    @ApiOperation(value = "短信发送")
    @RequestMapping(value = "tpl/send", method = {RequestMethod.POST, RequestMethod.GET})
    public ApiResultVO<String> sendTplSms(
    		HttpServletRequest request,
            @ApiParam(value = "手机号") @RequestParam(required = true) String phoneNo
            ,@ApiParam(value = "模板编号") @RequestParam(required = true) String tplId
            ,@ApiParam(value = "模板内容(json key value 字符串)") @RequestParam(required = true)String tplParams
            ,@ApiParam(value = "用户编号") @RequestParam(required = false) String userId
            ,@ApiParam(value = "业务编号") @RequestParam(required = false) String buzzId
    ) {
		// 该日志必不可少
		String busiDesr = "短信发送";
		logger.info("开始业务[{}]-参数:{}", busiDesr, RequestUtil.getParamMap(request));
    	
		BuzzResultVO<String> ret = smsService.send(phoneNo, tplId, tplParams, userId, buzzId);
		
		if (!ret.getOk()) {
		    return error(ApiResultVO.Coder.CALL_SERV_ERROR.setMessage(ret.getMessage()));
		}
		
		// 该日志必不可少
        logger.info("执行业务[{}]成功", busiDesr);
        return ok(ret.getAttach());
    }
	
}
