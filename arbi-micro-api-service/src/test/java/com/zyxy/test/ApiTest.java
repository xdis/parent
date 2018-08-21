package com.zyxy.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.zyxy.common.service.SequenceService;
import com.zyxy.service.micro.api.service.api.PersonRegisterService;


public class ApiTest extends BaseTest{
	
    @Autowired
    private PersonRegisterService registerService;
    @Autowired
    private SequenceService sequenceService;
    
	/*@Test*/
	public void sendMail() {
	    //ReqRegisterVO vo = new ReqRegisterVO();
	}
	
	@Rollback(value=false)
	@Test
	public void transationTest() {
	    sequenceService.getCertSeq();
	}
    
}
