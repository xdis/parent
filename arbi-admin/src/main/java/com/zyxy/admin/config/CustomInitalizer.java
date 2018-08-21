package com.zyxy.admin.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 
 * @author tanquan
 */
@Component
@PropertySource("classpath:application.properties")
public class CustomInitalizer implements CommandLineRunner {
	@SuppressWarnings("unused")
	private final static Logger logger = LoggerFactory.getLogger(CustomInitalizer.class);

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	/*@Autowired
	private SResourceService sResourceService;
	@Autowired
	private SRoleResourceService sRoleResourceService;
	
	@Value("${system.init-super-role}")
	private Boolean initSuperRole;
	
	@Override
	public void run(String... arg0) throws Exception {
		initSuperRoleResource();
	}
	
	*//**
	 * 初始化超级管理员的资源
	 *//*
	public void initSuperRoleResource() {
		if (initSuperRole == null || !initSuperRole) {
			return;
		}
		logger.info("to load system super role resources");
		List<SResource> resList = sResourceService.selectByExample(null);
		if (resList == null || resList.isEmpty()) {
			logger.warn("system has no resources..");
			return;
		}
		SRoleResourceExample rrEx = new SRoleResourceExample();
		rrEx.createCriteria().andRoleIdEqualTo(Constant.SYSTEM_SUPER_ROLE);
		sRoleResourceService.deleteByExample(rrEx);
		SRoleResourceKey record = new SRoleResourceKey();
		record.setRoleId(Constant.SYSTEM_SUPER_ROLE);
		for (SResource res : resList) {
			record.setResId(res.getResId());
			sRoleResourceService.insert(record);
		}
		logger.info("load system super role resources complete");
	}*/
}
