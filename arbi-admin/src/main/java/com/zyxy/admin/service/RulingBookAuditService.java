package com.zyxy.admin.service;

import com.zyxy.common.dto.RulingBookAuditDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.vo.AuditRulingBookVO;

/**
 *裁决书Service
 */
public interface RulingBookAuditService {
	/**
	 *  裁决书审核业务处理
	 * @param approveId 审批Id
	 * @param userId 用户Id
	 * @return
	 */
	AuditRulingBookVO rulingBookAuditBusiExecute(String approveId,String userId);
	
	/**
	 * 审核裁决书业务处理
	 *
	 * @param formData
	 * @return
	 */
	BusiExecuteResult auditRulingBookBusiExecute(
			RulingBookAuditDTO formData);

}
