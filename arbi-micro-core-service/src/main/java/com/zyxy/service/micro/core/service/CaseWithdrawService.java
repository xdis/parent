package com.zyxy.service.micro.core.service;

import com.zyxy.common.dto.WithdrawRecordInsertDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;

/**
 * 撤案Service
 */
public interface CaseWithdrawService {
	
	/**
	 * 撤案业务验证
	 * @param formData
	 * @return
	 */
	BusiValidResult  caseWithDrawValid(WithdrawRecordInsertDTO formData);
	
	/**
	 * 撤案业务执行
	 * @param formData
	 * @return
	 */
	BusiExecuteResult<String> caseWithDrawExecute(WithdrawRecordInsertDTO formData);
}
