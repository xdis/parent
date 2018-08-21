package com.zyxy.common.web.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zyxy.common.vo.ApiResultVO;

public class RequestUtil {

	
	private static final Logger logger = LoggerFactory
			.getLogger(RequestUtil.class);
	
	/**
	 * 将 ParameterMap<String, String[]> 转 <String, String> String[]默认取 最后的值
	 * 
	 * @param reqMap
	 * @return
	 */
	public static Map<String, String> getParamMap(Map<String, String[]> reqMap) {
		if (reqMap == null) {
			return null;
		}
		Map<String, String> ret = new HashMap<String, String>();
		for (Entry<String, String[]> entry : reqMap.entrySet()) {
			String[] value = entry.getValue();
			ret.put(entry.getKey(),
					value != null && value.length > 0 ? value[value.length - 1]
							: null);
		}
		return ret;
	}

	/**
     * 将 request 参数转为 map
     * 
     * @param reqMap
     * @return
     */
    public static Map<String, String> getParamMap(HttpServletRequest request) {
        return getParamMap(request.getParameterMap());
    }
	
	public static String getIp(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("PRoxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		String[] ipStr = ip.split(",");
		if (ipStr.length > 1) {
			ip = ipStr[0];
		}
		return ip;
	}

	/**
	 * 将 ParameterMap<String, String[]> 转TreeMap <String, String> String[]默认取 最后的值
	 * @param reqMap
	 * @return
	 */
	public static Map<String, String> getParamTreeMap(Map<String, String[]> reqMap) {
		if (reqMap == null) {
			return null;
		}
		Map<String, String> ret = new TreeMap<String, String>();
		for (Entry<String, String[]> entry : reqMap.entrySet()) {
			String[] value = entry.getValue();
			ret.put(entry.getKey(),
					value != null && value.length > 0 ? value[value.length - 1]
							: null);
		}
		return ret;
	}
	

	public static String getFormatedCoderUrl(String url, ApiResultVO.Coder coder) {
		try {
			url  = url + (url.indexOf("?") > 0 ? "&" : "?") + "code=" + coder.getCode() + "&message=" + URLEncoder.encode(coder.getMessage(), "UTF-8");
			return url;
		} catch (UnsupportedEncodingException e) {
			logger.error("url[{}] encode failed", e);
		}
		return url;
	}
	

	public static String getContextUrl(HttpServletRequest request) {
		String baseUrl = request.getScheme() + "://" + request.getServerName();
		if (request.getServerPort() != 80 && request.getServerPort() != 443 || (request.getServerPort() == 80 && "https".equals(request.getScheme())) || (request.getServerPort() == 443 && "http".equals(request.getScheme()))) {
			baseUrl += ":" + request.getServerPort(); //端口号 
		}
		baseUrl += request.getContextPath();
		return baseUrl;
	}
	
	
}
