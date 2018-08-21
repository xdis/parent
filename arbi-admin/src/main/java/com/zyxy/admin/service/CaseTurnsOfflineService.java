package com.zyxy.admin.service;

import com.zyxy.common.dto.CaseApproveSuggestDTO;
import com.zyxy.common.dto.CaseTurnsOfflineDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.CaseTurnsOfflineRecordVO;

public interface CaseTurnsOfflineService {

	/**业务验证
	 * 	案件转线下
	 * @param formData 
	 * @return 
	 */
	BusiValidResult applyBusiValid(CaseTurnsOfflineDTO formData);

	/**
	 * 业务处理-插入记录
	 * @param formData
	 * @return 
	 */
	BusiExecuteResult insert(CaseTurnsOfflineDTO formData);

	/**
	 * 业务验证-案件转线下审核
	 * @param approveId 审批id 
	 * @return 
	 */
	BusiValidResult caseBusiValid(String approveId);

	/**
	 * 业务处理-案件转线下审核
	 * @param approveId 审批id 
	 * @param userId 用户id
	 * @return 
	 */
	CaseTurnsOfflineRecordVO caseBusiValidAudit(String approveId, String userId);

	/**
	 * 业务验证-审核案件转线下
	 * @param formData
	 * @param userId 
	 * @return 
	 */
	BusiValidResult auditBusiValid(CaseApproveSuggestDTO formData, String userId);

	/**
	 * 业务处理-审核案件转线下
	 * @param formData 
	 * @return 
	 */
	BusiExecuteResult auditBusiExecute(CaseApproveSuggestDTO formData);

}
