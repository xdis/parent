package com.zyxy.service.micro.core.service;

import com.zyxy.common.dto.ArbitratorQuestionDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;

/**
 *	仲裁员提问 Service
 */
public interface ArbitratorQuestionService {
	
	/**
	 * 仲裁员提问业务验证
	 * @param formData
	 * @return
	 */
	BusiValidResult arbitratorQuestionValid(ArbitratorQuestionDTO formData);
	
	/**
	 * 仲裁员提问业务执行
	 * @param formData
	 * @return
	 */
	BusiExecuteResult<String> arbitratorExecute(ArbitratorQuestionDTO formData);

}
