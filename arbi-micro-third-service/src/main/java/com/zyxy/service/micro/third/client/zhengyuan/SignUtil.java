package com.zyxy.service.micro.third.client.zhengyuan;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import cn.seata.credit.sdk.secret.CertUtil;






public class SignUtil {
	
	private static String SIGN_PARAM_SEPARATOR = "&";
	
	/**
	 * 获取商户参数待签名字符串 （签名组串）
	 * @param map
	 * @return
	 */
	public static String getMerSignContent (Map<String, String> map){
		if (map == null || map.isEmpty()) {
			return null;
		}
		if (!(map instanceof TreeMap)) {
			Map<String, String> temp = new TreeMap<String, String>();
			temp.putAll(map);
			map = temp;
		}
        StringBuffer sb = new StringBuffer();
        for(Entry<String, String> entry : map.entrySet()){
        	if (entry.getValue() == null || "".equals(entry.getValue())) { // 空值不参与签名组串
        		continue;
        	}
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append(SIGN_PARAM_SEPARATOR);
        }
        if(sb.indexOf(SIGN_PARAM_SEPARATOR) > -1){
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
	
	/**
	 * 生成签名
	 * @param content
	 * @return
	 */
	public static String sign(String content) {
		try {
			return CertUtil.getInstance().sign(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 验签
	 * @param content
	 * @param sign
	 * @return
	 */
	public static boolean verify(String content, String sign) {
		try {
			return CertUtil.getInstance().verify(content, sign);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 加密
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String data){
		try {
			return CertUtil.getInstance().encrypt(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 解密
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String data){
		try {
			return CertUtil.getInstance().decrypt(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
