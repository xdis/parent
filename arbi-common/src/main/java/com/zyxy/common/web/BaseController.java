package com.zyxy.common.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.validation.FieldError;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.zyxy.common.util.JsonUtil;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ApiResultVO.Coder;
import com.zyxy.common.vo.SecurityUserVO;


public class BaseController {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String ANONYMOUS_USER = "anonymousUser";
	
	/**
	 * 获取当前登录的用户信息
	 * @return
	 */
    protected SecurityUserVO getSessionUser() {
        SecurityUserVO user = null;
        Authentication au = SecurityContextHolder.getContext().getAuthentication();
        if (au == null || ANONYMOUS_USER.equals(au.getPrincipal())) {
            user = new SecurityUserVO();
            user.setId("2");
            user.setUserInfoId("5");
            return user;
        }
        if(String.class.isAssignableFrom(au.getPrincipal().getClass())){
            return null;
        }else{
            return (SecurityUserVO) au.getPrincipal();
        }
    }

	/**
	 * 获取当前登录的用户Id
	 * @return
	 */
    protected String getSessionUserId() {
        Authentication au = SecurityContextHolder.getContext().getAuthentication();
        if (au == null || ANONYMOUS_USER.equals(au.getPrincipal())) {
            return "2";
        }
        if(String.class.isAssignableFrom(au.getPrincipal().getClass())){
            return null;
        }else{
            return ((SecurityUserVO) au.getPrincipal()).getUserInfoId();
        }
    }

    protected String getAccessToken() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
        return details.getTokenValue();
    }

    /**
     * 获取当前请求的cookies信息
     * @return
     */
    protected ApiResultVO.Auth getAuth() {
    	return null;
    }
    
    /**
     * 设置session
     * @param key
     * @param value
     */
    protected void setSession(String key, Object value) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            request.getSession().setAttribute(key, value);
        }
    }
    
    /**
     * 获取session
     * @param key
     * @return value
     */
    protected Object getSession(String key) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            request.getSession().getAttribute(key);
        }
        return null;
    }
    
    /**
     * api 返回成功
     * @return
     */
	protected <K> ApiResultVO<K> ok() {
    	ApiResultVO<K> ret = new ApiResultVO<>(Coder.SUCCESS, this.getAuth());
    	return ret;
    }

    /**
     * api 返回成功
     * @return
     */
	protected <K> ApiResultVO<K> busiExecuteSuccess() {
    	ApiResultVO<K> ret = new ApiResultVO<>(Coder.SUCCESS, this.getAuth());
    	return ret;
    }

    /**
     * api 返回成功
     * @return
     */
	protected <K> ApiResultVO<K> busiExecuteSuccess(K k) {
    	ApiResultVO<K> ret = new ApiResultVO<>(Coder.SUCCESS, this.getAuth());
    	debugLog(k);
    	return ret.setBody(k);
    }

	/**
	 * api 返回成功
	 * @param k 返回内容 body
	 * @return
	 */
	protected <K> ApiResultVO<K> ok(K k) {
		ApiResultVO<K> ret = new ApiResultVO<>(Coder.SUCCESS, this.getAuth());
		logger.info("返回:{}-{}", Coder.SUCCESS.getCode(), Coder.SUCCESS.getMessage());
		debugLog(k);
		return ret.setBody(k);
	}

	/**
	 * api 返回非成功请求 -> 非法的请求
	 * @return
	 */
	protected <K> ApiResultVO<K> error() {
		ApiResultVO<K> ret = new ApiResultVO<>(Coder.REQ_ERROR, this.getAuth());
		logger.error("返回:{}-{}", Coder.REQ_ERROR.getCode(), Coder.REQ_ERROR.getMessage());
		return ret;
	}

	/**
	 * api 返回非成功请求 -> 非法的请求
	 * @return
	 */
	protected <K> ApiResultVO<K> validError() {
		ApiResultVO<K> ret = new ApiResultVO<>(Coder.VALID_ERROR, this.getAuth());
		logger.error("返回:{}-{}", Coder.VALID_ERROR.getCode(), Coder.VALID_ERROR.getMessage());
		return ret;
	}

	/**
	 * api 返回非成功请求 -> 非法的请求
	 * @return
	 */
	protected <K> ApiResultVO<K> busiValidError(String code, String message) {
		ApiResultVO<K> ret = new ApiResultVO<>(code, message, this.getAuth());
		logger.error("返回:{}-{}", code, message);
		return ret;
	}

	/**
	 * api 返回非成功请求 -> 非法的请求
	 * @return
	 */
	protected <K> ApiResultVO<K> busiExecuteError(String code, String message) {
		ApiResultVO<K> ret = new ApiResultVO<>(code, message, this.getAuth());
		logger.error("返回:{}-{}", code, message);
		return ret;
	}

	/**
	 * api 返回非成功请求 -> 非法的请求
	 * @return
	 */
	protected <K> ApiResultVO<K> busiValidError(Coder coder) {
		ApiResultVO<K> ret = new ApiResultVO<>(coder.getCode(), coder.getMessage(), this.getAuth());
		logger.error("返回:{}-{}", coder.getCode(), coder.getMessage());
		return ret;
	}

	/**
	 * api 返回非成功请求 -> 非法的请求
	 * @return
	 */
	protected <K> ApiResultVO<K> busiExecuteError(Coder coder) {
		ApiResultVO<K> ret = new ApiResultVO<>(coder.getCode(), coder.getMessage(), this.getAuth());
		logger.error("返回:{}-{}", coder.getCode(), coder.getMessage());
		return ret;
	}

	/**
	 * api 返回非成功请求 -> 非法的请求
	 * @param message 自定义错误的信息
	 * @return
	 */
	protected <K> ApiResultVO<K> error(String message) {
		ApiResultVO<K> ret = new ApiResultVO<>(Coder.REQ_ERROR, this.getAuth());
		logger.error(message);
		return ret.setMessage(message);
	}
	
	/**
	 * api 返回非成功请求 -> 非法的请求
	 * @param error 自定义错误的信息
	 * @return
	 */
	protected <K> ApiResultVO<K> error(FieldError error) {
	    ApiResultVO<K> ret = new ApiResultVO<>(Coder.REQ_ERROR, this.getAuth());
	    logger.error(error.toString());
	    return ret.setMessage(error.getDefaultMessage());
	}
	
	/**
	 * api 返回非成功请求 -> ApiResultVO.Coder
	 * @param coder 错误代码
	 * @return
	 */
	protected <K> ApiResultVO<K> error(ApiResultVO.Coder coder) {
		ApiResultVO<K> ret = new ApiResultVO<>(coder, this.getAuth());
		logger.error("返回:{}-{}",coder.getCode(), coder.getMessage());
		return ret.setCoder(coder);
	}
	
	/**
	 * api 返回非成功请求 -> ApiResultVO.Coder
	 * @param coder 错误代码
	 * @param k 返回body
	 * @return
	 */
	protected <K> ApiResultVO<K> error(ApiResultVO.Coder coder, K k) {
		ApiResultVO<K> ret = new ApiResultVO<>(coder, this.getAuth());
		logger.error("返回:{}-{}",coder.getCode(), coder.getMessage());
		errorLog(k);
		return ret.setBody(k);
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
	
	private void errorLog(Object obj) {
	    String toPrintStr = "";
	    try {
	        toPrintStr = JsonUtil.toJson(obj); 
	    } catch (Exception e) {
	        toPrintStr = obj.toString();
	    }
	    logger.error("返回内容：{}", toPrintStr);
	}
}
