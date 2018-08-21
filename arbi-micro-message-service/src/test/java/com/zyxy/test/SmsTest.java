package com.zyxy.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.zyxy.common.util.JsonUtil;
import com.zyxy.service.micro.message.config.SmsTplConfig;
import com.zyxy.service.micro.message.service.SmsService;


public class SmsTest extends BaseTest{
	
    @Autowired
    private SmsTplConfig config;
    
    @Autowired
    private SmsService service;
    
    //@Test
	public void TestConfig() {
	    logger.info(JsonUtil.toJson(config));
	}
	
	//@Rollback(value=false)
	//@Test
	public void sendSms() {
	    Map<String, String> params = new HashMap<>();
	    params.put("code", "10001");
	    service.send("15673237766", "1001", JsonUtil.toJson(params), "", "");
	}
	
    
}
