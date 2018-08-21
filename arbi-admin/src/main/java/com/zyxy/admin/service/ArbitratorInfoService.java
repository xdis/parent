package com.zyxy.admin.service;

import com.zyxy.common.dto.ArbitratorInfoDTO;
import com.zyxy.common.service.BusiValidResult;

public interface ArbitratorInfoService {
	/**
	 * 验证是否已经存在该用户
	 * @param formData
	 * @return
	 */
	BusiValidResult userRegisterBusiValid(ArbitratorInfoDTO formData);

	/**
	 * 插入用户信息
	 * @param formData
	 * @return 
	 */
	boolean userRegisterBusiExecute(ArbitratorInfoDTO formData);
	
}
