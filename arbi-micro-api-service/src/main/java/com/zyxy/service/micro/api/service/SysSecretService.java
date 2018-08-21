/**
 * 
 */
package com.zyxy.service.micro.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.common.domain.SysDataDic;
import com.zyxy.common.domain.SysDataDicKey;
import com.zyxy.common.service.SysDataDicService;
import com.zyxy.common.util.AESUtil;
import com.zyxy.common.util.StringUtil;
import com.zyxy.common.vo.BuzzResultVO;

@Service
public class SysSecretService {
	
	private final static Logger logger = LoggerFactory.getLogger(SysSecretService.class);
	
	@Autowired
	SysDataDicService dataDicService;
	
	public BuzzResultVO<String> encrypt(String content) {
	    BuzzResultVO<String>  ret = new BuzzResultVO<String>();
		String sec = getGlobalSecret();
		if (sec == null) {
		    ret.setOk(false).setMessage("获取全局secret失败");
			logger.error(ret.getMessage());
			return ret;
		}
		String encCotent = AESUtil.parseByte2HexStr(AESUtil.encrypt(content, sec));
		if (encCotent == null) {
		    ret.setOk(false).setMessage("加密失败");
            logger.error(ret.getMessage());
            return ret;
		}
		return ret.setOk(true).setAttach(encCotent);
	}

	public BuzzResultVO<String> decrypt(String encData) {
	    BuzzResultVO<String>  ret = new BuzzResultVO<String>();
		byte[]  encContentByte = AESUtil.parseHexStr2Byte(encData);
		if (encContentByte == null) {
		    ret.setOk(false).setMessage("获取utf-8字节流异常");
            logger.error(ret.getMessage());
            return ret;
		}
		String decContent = null;
		String sec = getGlobalSecret();
		if (sec == null) {
		    ret.setOk(false).setMessage("获取全局secret失败");
            logger.error(ret.getMessage());
            return ret;
		}
		try {
			decContent = new String(AESUtil.decrypt(encContentByte, sec));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (decContent == null) {
		    ret.setOk(false).setMessage("解密失败");
            logger.error(ret.getMessage());
            return ret;
		}
		return ret.setOk(true).setAttach(decContent);
	}
	
	/**
	 * 获取全局secret
	 * @return
	 */
	private String getGlobalSecret() {
		SysDataDic dic = dataDicService.selectCacheByPrimaryKey(SysDataDicKey.GLOBAL_SECRET_KEY);
		String ori = dic.getDicValue();
		if (StringUtil.isEmpty(ori)) {
			logger.error("无法获取全局加密解密secret,请确认已初始化：{}-{}", SysDataDicKey.GLOBAL_SECRET_KEY.getDicGroup(), SysDataDicKey.GLOBAL_SECRET_KEY.getDicKey());
			return null;
		}
		return parseSecret(ori);
	}
	
	/**
	 * 解析全局secret
	 * @param secret
	 * @return
	 */
	private String parseSecret(String secret) {
		String[] p = secret.split("\\|");
		if (p.length != 2) {
			logger.error("secret格式错误");
			return null;
		}
		StringBuilder s = new StringBuilder();
		s.append("\u0064\u0065\u0073\u0069\u0067\u006e\u005f\u0069\u006e\u005f").append(p[1]);
		String r = null;
		logger.info("secret:{}", s);
		try {
			r = new String(AESUtil.decrypt(AESUtil.parseHexStr2Byte(p[0]), s.toString()));
		} catch (Exception e) {
			logger.error("{}", e);
		}
		if (r == null) {
			logger.error("secret parse error");
			return null;
		}
		StringBuilder r1 = new StringBuilder();
		r1.append("\u0064\u0065\u0073\u0069\u0067\u006e\u005f\u0062\u0079\u005f").append(r).append("\u005f\u0073\u006f\u006e\u0074\u0061");
		return r1.toString();
	}
}
