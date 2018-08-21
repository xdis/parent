package com.zyxy.test;

import java.io.File;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.zyxy.common.dto.MailInfoDTO;
import com.zyxy.common.dto.MailInfoDTO.Attachment;
import com.zyxy.service.micro.message.service.MailService;


public class MailTest extends BaseTest{
	
    @Autowired
    private MailService mailService;
    
	@Rollback(value=false)
	@Test
	public void sendMail() {
	    MailInfoDTO info = new MailInfoDTO();
	    info.setAttachments(new Attachment[]{new Attachment(new File("E:/仲裁平台表设计.zip")), new Attachment(new File("E:/2016113016144800000803_20171107.txt"))});
	    info.setTo(new String[]{"tan.quan@seata.cn"});
	    info.setCc(new String[] {"718001160@qq.com", "tan.quan@ielpm.com"});
	    info.setIsSimmple(false);
	    info.setSubject("来自sonta的测试邮件");
	    info.setContent("请见附件");
	    logger.info(mailService.send(info));
	}
	
    
}
