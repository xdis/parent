package com.zyxy.admin.service;

import com.zyxy.common.dto.CaseApproveSuggestDTO;
import com.zyxy.common.dto.CaseChangeRecordDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.CaseChangeRecordVO;

/**
 * 变更仲裁请求service
 *
 */
public interface CaseChangeRecordService {
	
	/**
	 * 查询变更仲裁请求业务验证
	 * @param userId
	 * @param approveId
	 * @return
	 */
	BusiValidResult queryCaseChangeRecordBusiValid(String userId,String approveId);
	

	/**
	 * 查询变更仲裁请求业务处理
	 * @param userId
	 * @param approveId
	 * @return
	 */
	BusiExecuteResult<CaseChangeRecordVO> queryCaseChangeRecordBusiExecuteResult(String userId,String approveId);
	
	/**
	 * 变更仲裁请求审核业务验证
	 * @param caseId
	 * @param userId
	 * @param approveId
	 * @param caseChangeRecordId
	 * @return
	 */
	BusiValidResult auditCaseChangeRecordBusiValid(String caseId, String userId,String approveId,String caseChangeRecordId);
	
	/**
	 * 变更仲裁请求审批业务处理
	 * @param formData
	 * @param caseChangeRecordId
	 * @return
	 */
	BusiExecuteResult auditCaseChangeRecordBusiExecute(CaseApproveSuggestDTO formData,String caseChangeRecordId);

}
