package com.zyxy.service.micro.core.service;

import com.zyxy.common.dto.CaseAvoidRecordInsertDTO;
import com.zyxy.common.service.BusiExecuteResult;

/**
 *	申请回避Service
 */
public interface CaseAvoidService {
	
	/**
	 * 插入回避记录
	 * @param formData
	 * @return
	 */
	BusiExecuteResult<String> insertCaseAvoidBusiExecute(CaseAvoidRecordInsertDTO formData);

}
