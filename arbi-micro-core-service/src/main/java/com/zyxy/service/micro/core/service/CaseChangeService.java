package com.zyxy.service.micro.core.service;

import com.zyxy.common.dto.CaseChangeRecordInsertDTO;
import com.zyxy.common.service.BusiExecuteResult;

/**
 * 更改仲裁请求Service
 */
public interface CaseChangeService {

	/**
	 * 插入更改仲裁申请记录
	 * @param formData
	 * @return
	 */
	BusiExecuteResult<String> insertCaseChangeRecordBusiExecute(CaseChangeRecordInsertDTO formData);
}
