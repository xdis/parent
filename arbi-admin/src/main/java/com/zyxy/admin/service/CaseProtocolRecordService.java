package com.zyxy.admin.service;

import com.zyxy.common.domain.CaseProtocolRecordWithBLOBs;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;

/**
 * 调解协议申请
 *
 */
public interface CaseProtocolRecordService {

	/**
	 * 查询调解协议申请业务验证
	 * @param caseId
	 * @return
	 */
	BusiValidResult queryCaseProtocolRecordBusiValid(String caseId);
	
	
	/**
	 * 查询调解协议申请业务处理
	 * @param caseId
	 * @return
	 */
	BusiExecuteResult<CaseProtocolRecordWithBLOBs> queryCaseProtocolRecordBusiExecute(String caseId);
}
