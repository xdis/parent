package com.zyxy.service.micro.scheduler.util.wxpay;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zyxy.common.enums.CacheTypeEnum;
import com.zyxy.common.service.CacheService;
import com.zyxy.common.util.HttpUtil;
import com.zyxy.common.util.JsonUtil;
import com.zyxy.common.util.StringUtil;

@Component
public class JSSDKConfig {
    private static final Logger logger = LoggerFactory.getLogger(JSSDKConfig.class);
    
    @Autowired
    private CacheService cacheService;
    
    /**
     * 前端 jssdk 页面配置需要用到的配置参数
     */
    public HashMap<String, String> getJSSDKConfig(String getTokenUrl, String appid, String secret, String getTicketUrl, String url) {
        String jsapiTicket = getJsapiTicket(getTokenUrl, appid, secret, getTicketUrl);
        if (StringUtil.isEmpty(jsapiTicket)) {
            logger.error("get jsapiTicket is empty, url : {}", url);
            return null;
        }
        String nonce_str = create_nonce_str();
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
        // 注意这里参数名必须全部小写，且必须有序
        String string1 = "jsapi_ticket=" + jsapiTicket + "&noncestr=" + nonce_str
                + "&timestamp=" + timestamp + "&url=" + url;
        String signature = null;
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            logger.error("get jssdk signature error", e);
        }
        HashMap<String, String> jssdk = new HashMap<>();
        jssdk.put("appId", appid);
        jssdk.put("timestamp", timestamp);
        jssdk.put("nonceStr", nonce_str);
        jssdk.put("signature", signature);
        return jssdk;
    }

    private String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    private String create_nonce_str() {
        return UUID.randomUUID().toString();
    }

    public String getJsapiTicket(String getTokenUrl, String appid, String secret, String getTicketUrl) {
        Map<String, String> accessTokenParams = new HashMap<>();
        accessTokenParams.put("appid", appid);
        accessTokenParams.put("secret", secret);
        accessTokenParams.put("grant_type", "client_credential");
        String accessTokenBody = HttpUtil.sendPost(getTokenUrl, accessTokenParams);
        Map<String, Object> accessTokenMap = JsonUtil.jsonToMap(accessTokenBody);

        String accessToken = (String)cacheService.getCache(CacheTypeEnum.WX_ACCESS_TOKEN.getCode(), CacheTypeEnum.WX_ACCESS_TOKEN.getCode());
        if (accessTokenMap != null && accessToken == null) {
            if (accessTokenMap.containsKey("errcode")) {
                logger.error("request get access_token error, getTokenUrl : {}, accessTokenParams : {}, errcode : {} ", getTokenUrl, accessTokenParams, accessTokenMap.get("errcode"));
            } else {
                accessToken = (String) accessTokenMap.get("access_token");
                cacheService.addCache(CacheTypeEnum.WX_ACCESS_TOKEN.getCode(), CacheTypeEnum.WX_ACCESS_TOKEN.getCode(), accessToken);
            }
        }

        String jsapiTicket = (String)cacheService.getCache(CacheTypeEnum.WX_TICKET.getCode(), CacheTypeEnum.WX_TICKET.getCode());;
        if (StringUtil.isNotEmpty(accessToken) && jsapiTicket == null) {
            Map<String, String> jsticketParams = new HashMap<>();
            jsticketParams.put("access_token", accessToken);
            jsticketParams.put("type", "jsapi");
            String jsticketBody = HttpUtil.sendPost(getTicketUrl, jsticketParams);
            Map<String, Object> jsticketMap = JsonUtil.jsonToMap(jsticketBody);
            if (jsticketMap != null) {
                Integer errcode = (Integer) jsticketMap.get("errcode");
                if (errcode == null || errcode != 0) {
                    logger.error("request get jsapiTicket error, getTicketUrl : {}, jsticketParams : {}, errcode : {} ", getTicketUrl, jsticketParams, errcode);
                } else {
                    jsapiTicket = (String) jsticketMap.get("ticket");
                    cacheService.addCache(CacheTypeEnum.WX_TICKET.getCode(), CacheTypeEnum.WX_TICKET.getCode(), jsapiTicket);
                }
            }

            if (StringUtil.isEmpty(jsapiTicket)) {
                logger.error("request get jsapiTicket is empty, getTicketUrl : {}, jsticketParams : {}, ", getTicketUrl, jsticketParams);
            }
        } else {
            logger.error("request get access_token is empty, getTokenUrl : {}, accessTokenParams : {}", getTokenUrl, accessTokenParams);
        }
        return jsapiTicket;
    }
}
