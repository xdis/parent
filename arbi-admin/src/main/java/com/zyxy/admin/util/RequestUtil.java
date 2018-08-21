package com.zyxy.admin.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {

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
}
