package com.zyxy.service.micro.third.client.zhengyuan;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.zyxy.common.util.HttpUtil;
import com.zyxy.common.util.JsonUtil;
import com.zyxy.common.util.PropertyUtil;
import com.zyxy.common.util.StringUtil;
import com.zyxy.common.vo.ChannelResultVO;

@Component
public class ZhengyuanClient {
	
	protected static final Logger logger = LoggerFactory.getLogger(ZhengyuanClient.class);
	
	// 商户号
	private static String MERCHANT_NO = null;
	// 服务器地址
	private static String SERVER_URL = null;
	static {
		MERCHANT_NO = PropertyUtil.getValue("seata", "merchantNo");
		SERVER_URL = PropertyUtil.getValue("seata", "serverUrl");
		if (StringUtil.isEmpty(MERCHANT_NO) || StringUtil.isEmpty(SERVER_URL)) {
			logger.error("can not load property from seata.properties->merchantNo, serverUrl!!");
			System.exit(-1);
		}
	}
	
	/**
	 * 查询银行卡二三四要素信息
	 * @param verifyType 0020-二要素 卡号+户名，0021-二要素 卡号+证件，0022-二要数 卡号+手机号，0030-三要素 卡号+户名+证件，0040-四要素 卡号+户名+证件+手机号
	 * @param accNo 银行卡号
	 * @param accName 账户名
	 * @param certType 证件类型 00-身份证（默认值）
	 * @param cerNo 证件号
	 * @param phoneNo 手机号
	 * @param remark 备注
	 * @return
	 */
	public ChannelResultVO<Boolean> verifyBankInfo(String verifyType, String acctNo, String acctName, 
			String certType, String certNo, String phoneNo, String remark){
		String url = SERVER_URL + "/credit-business/api/real_name_certification";
		//组织签名数据
		Map<String, String> tranMap = new TreeMap<String, String>();
		tranMap.put("merchantNo", MERCHANT_NO);
		tranMap.put("verifyType", verifyType);
		tranMap.put("acctNo", acctNo);
		tranMap.put("acctName", acctName);
		tranMap.put("cerType", certType);
		tranMap.put("certNo", certNo);
		tranMap.put("phone", phoneNo);
		tranMap.put("remark", remark);
		//签名
		String toSignContent = SignUtil.getMerSignContent(tranMap);
		String sign = SignUtil.sign(toSignContent);
		tranMap.put("sign", sign);
		//数据加密
		if(!StringUtils.isEmpty(acctNo))
			tranMap.put("acctNo", SignUtil.encrypt(acctNo));
		if(!StringUtils.isEmpty(acctName))
			tranMap.put("acctName", SignUtil.encrypt(acctName));
		if(!StringUtils.isEmpty(certNo))
			tranMap.put("certNo", SignUtil.encrypt(certNo));
		if(!StringUtils.isEmpty(phoneNo))
			tranMap.put("phone", SignUtil.encrypt(phoneNo));
		//发送http请求
		String resp = HttpUtil.sendPost(url, tranMap);

		return this.parseResponse(resp);
	}
	
	/**
	 * 解析返回结果
	 * @param resp
	 * @return
	 */
	private ChannelResultVO<Boolean> parseResponse( String resp) {
	    ChannelResultVO<Boolean> ret = new ChannelResultVO<Boolean>();
		if(resp == null){
			logger.error("调用远程接口异常");
			return ret.setOk(false).setMessage("调用远程接口失败");
		}
		logger.info("请求渠道返回-{}", resp);
		Map<String, Object> cRet = JsonUtil.jsonToMap(resp);
		if (cRet == null) {
	        logger.error("返回数据解析错误");
		    return ret.setOk(false).setMessage("调用远程接口失败");
		}
		String channelCode =  (String)cRet.get("code"); // 响应代码
		String channelMsg = (String)cRet.get("msg"); // 响应信息
		String voucherNo = (String)cRet.get("flowNo"); // 渠道订单号
		ret.setChannelCode(channelCode);
		ret.setChannelMsg(channelMsg);
		ret.setVoucherNo(voucherNo);
		ret.setOk(true);
		if (!("0000".equals(ret.getChannelCode()) || "0100".equals(ret.getChannelCode()))) {
		    logger.error("调用正源银行卡四要素返回异常：{}-{}", ret.getChannelCode(), ret.getChannelMsg());
		    return ret.setIsFree(true).setMessage("调用认证服务失败");
		}
		if ("0000".equals(ret.getChannelCode())) {
		    ret.setIsFree(false);
		} else {
		    ret.setIsFree(true);
		}
		Map<String, Object> map = this.decryptResult(cRet.get("result"));
		String statCode = (String)map.get("statCode");
		String statMsg = (String)map.get("statMsg");
		if (!"2300".equals(statCode)) {
		    ret.setAttach(false);
		    logger.info("身份认证失败-{}", statMsg);
		    ret.setMessage("身份认证失败（四要素不匹配或银行卡状态异常，如卡被冻结、锁定、受限制等）");
		    ret.setChannelMsg(statMsg);
		    return ret;
		}
		
		return ret.setMessage("认证成功").setAttach(true);
	}
	
	/**
	 * 解密result
	 * @param result
	 * @return
	 */
	private Map<String, Object> decryptResult(Object result) {
		if (result == null || !(result instanceof String)) {
			return null;
		}
		String resultStr = (String)result;
		try {
			resultStr = URLDecoder.decode(resultStr, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		resultStr = SignUtil.decrypt(resultStr);
		logger.debug("解密-{}", resultStr);
		return JsonUtil.jsonToMap(resultStr);
	}
 
}
