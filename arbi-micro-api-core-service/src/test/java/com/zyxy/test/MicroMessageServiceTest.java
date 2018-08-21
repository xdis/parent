package com.zyxy.test;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;

import com.zyxy.common.dto.MailInfoDTO;
import com.zyxy.common.dto.MailInfoDTO.Attachment;
import com.zyxy.common.service.micro.MicroMessageService;
import com.zyxy.common.util.JsonUtil;


public class MicroMessageServiceTest extends BaseTest{
	
    @Autowired
    private MicroMessageService microMessageService;
    
	/*@Rollback(value=false)
	@Test*/
	public void sendMail() {
	    // 微服务暂时无法通过junit 测试
	    MailInfoDTO info = new MailInfoDTO();
	    info.setAttachments(new Attachment[]{new Attachment(new File("E:/仲裁平台表设计.zip")), new Attachment(new File("E:/2016113016144800000803_20171107.txt"))});
        info.setTo(new String[]{"tan.quan@seata.cn"});
	    info.setCc(new String[] {"718001160@qq.com", "tan.quan@ielpm.com"});
	    info.setIsSimmple(false);
	    info.setSubject("来自sonta的测试邮件");
	    info.setContent("请见附件");
	    logger.info(JsonUtil.toJson(microMessageService.sendMail(info)));
	}
	
    
}
