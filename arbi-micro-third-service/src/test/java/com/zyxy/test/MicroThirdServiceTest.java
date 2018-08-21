package com.zyxy.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zyxy.common.vo.BuzzResultVO;
import com.zyxy.service.micro.third.service.PayService;


public class MicroThirdServiceTest extends BaseTest{
	
    @Autowired
    private PayService payService;
    
	@Test
	public void sendMail() {
	    BuzzResultVO<String> ret = payService.getPayNoteQrCode("20171117174343068756");
	    logger.info(ret.getAttach());
	}
	
    
}
