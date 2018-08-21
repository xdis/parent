package com.zyxy.service.micro.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;

import com.zyxy.common.util.JsonUtil;
import com.zyxy.service.micro.api.dto.ResResultDTO;
import com.zyxy.service.micro.api.enums.ApiCodeEnum;

public class BaseController {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
    
    /**
     * api 返回成功
     * @return
     */
	protected ResResultDTO ok() {
	    ResResultDTO ret = new ResResultDTO(ApiCodeEnum.SUCCESS);
    	return ret;
    }

	/**
	 * api 返回成功
	 * @param result 返回内容 body
	 * @return
	 */
	protected ResResultDTO ok(String result) {
	    ResResultDTO ret = new ResResultDTO(ApiCodeEnum.SUCCESS);
		logger.info("返回:{}-{}", ret.getCode(), ret.getMessage());
		debugLog(result);
		return ret.setResult(result);
	}

	/**
	 * api 返回错误
	 * @return
	 */
	protected ResResultDTO error(ApiCodeEnum coder, String message) {
	    ResResultDTO ret = new ResResultDTO(coder);
	    ret.setMessage(message);
		logger.error("返回:{}-{}", ret.getCode(), ret.getMessage());
		return ret;
	}
	
	/**
	 * api 返回错误
	 * @return
	 */
	protected ResResultDTO error(FieldError e) {
	    ResResultDTO ret = new ResResultDTO(ApiCodeEnum.REQ_PARAM_ILLEGAL);
	    ret.setMessage(ret.getMessage() + "-" + e.getDefaultMessage());
	    logger.error("返回:{}-{}", ret.getCode(), ret.getMessage());
	    return ret;
	}
	
	

	private void debugLog(Object obj) {
	    if (!logger.isDebugEnabled()) {
	        return;
	    }
	    String toPrintStr = "";
	    try {
	        toPrintStr = JsonUtil.toJson(obj); 
	    } catch (Exception e) {
	        toPrintStr = obj.toString();
	    }
	    logger.debug("返回内容：{}", toPrintStr);
	}
}
