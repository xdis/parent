package com.zyxy.test;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.zyxy.service.micro.scheduler.SchedulerApplication;

@RunWith(SpringJUnit4ClassRunner.class)  
@SpringBootTest(classes=SchedulerApplication.class) 
@WebAppConfiguration  
public class BaseTest {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
}
