package com.zyxy.service.micro.api.service.cert;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.StringUtil;
import com.zyxy.common.domain.ApiOrgCertExample;
import com.zyxy.common.domain.ApiOrgCertWithBLOBs;
import com.zyxy.common.enums.CacheTypeEnum;
import com.zyxy.common.service.CacheService;
import com.zyxy.service.micro.api.service.ApiOrgCertService;
import com.zyxy.service.micro.api.service.SysSecretService;

@Service("secretService")
public class SecretService {
	private static final Logger logger = LoggerFactory.getLogger(SecretService.class);
	
	@Autowired
	private ApiOrgCertService orgCertService;
	
	private static String SIGN_PARAM_SEPARATOR = "&";
	
	@Autowired
	SysSecretService sysService;
	@Autowired
	CacheService cacheService;
	
	public String sign(String orgNo, String content) throws Exception {
		return get(orgNo).sign(content);
	}

	public String decrypt(String orgNo, String content) throws Exception {
		return get(orgNo).decrypt(content);
	}

	public String encrypt(String orgNo, String content) throws Exception {
		return get(orgNo).encrypt(content);
	}

	public boolean verify(String orgNo, String content, String sign) throws Exception {
		return get(orgNo).verify(content, sign);
	}
	
	public boolean isExist(String orgNo) {
		return get(orgNo) != null;
	}
	
	public String getSignContent (Map<String, ?> map){
        if (map == null || map.isEmpty()) {
            return null;
        }
        Map<String, String> signMap = new TreeMap<String, String>();
        for (Entry<String, ?> entry : map.entrySet()) {
            signMap.put(entry.getKey(), (String)entry.getValue());
        }
        StringBuffer sb = new StringBuffer();
        for(Entry<String, String> entry : signMap.entrySet()){
            String value = entry.getValue();
            if (value == null || "".equals(value)) { // 空参数不参与签名
                continue;
            }
            sb.append(entry.getKey()).append("=").append(value).append(SIGN_PARAM_SEPARATOR);
        }
        if(sb.indexOf(SIGN_PARAM_SEPARATOR) > -1){
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString().replaceAll(" ", "+");
    }
	
	/**
	 * 获取缓存
	 * @param orgNo 机构/用户编号
	 * @return
	 */
	private Secret get(String orgNo){
		Object cache = cacheService.getCache(CacheTypeEnum.ORG_CERT.getCode(), orgNo);
		if (cache != null) {
			return (Secret)cache;
		}
		ApiOrgCertWithBLOBs orgCertInfo = this.getEnableCertInfo(orgNo);
		if (orgCertInfo == null) {
			logger.error("机构/用户{}-无有效证书");
			return null;
		}
		String storepass = sysService.decrypt(orgCertInfo.getPltPrivateKeyStorePass()).getAttach();
		String keypass = sysService.decrypt(orgCertInfo.getPltPrivateKeyPass()).getAttach();
		if (StringUtil.isEmpty(storepass) || StringUtil.isEmpty(keypass)) {
			logger.error("获取storepass 或  keypass 解密信息失败");
			return null;
		}
		cache = new Secret(new SecretConfig(orgCertInfo.getCltPublicKey(), orgCertInfo.getPltPrivateCert(), storepass, keypass));
		cacheService.addCache(CacheTypeEnum.ORG_CERT.getCode(), orgNo, cache);
		return (Secret)cache;
	}
	
	private ApiOrgCertWithBLOBs getEnableCertInfo(String orgNo) {
	    ApiOrgCertExample ex = new ApiOrgCertExample();
	    ex.createCriteria().andOrgIdEqualTo(orgNo);
	    List<ApiOrgCertWithBLOBs> list = orgCertService.selectByExampleWithBLOBs(ex);
		if (list == null || list.isEmpty() ||  list.get(0).getStatus() != 1) {
			logger.error("无有效证书信息");
			return null;
		}
		return list.get(0);
	}
	
}
