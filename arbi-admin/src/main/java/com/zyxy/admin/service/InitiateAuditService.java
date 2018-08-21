package com.zyxy.admin.service;

import com.zyxy.common.dto.AuditPutOnRecordDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.InitiateAuditVO;
import org.springframework.transaction.annotation.Transactional;

/**
 * 立案审核页面
 */
public interface InitiateAuditService {

	/**
	 * 立案审核页面业务处理
	 * @param approveId 审批Id
	 * @param userId 用户Id
	 * @return
	 */
	InitiateAuditVO initiateAuditBusiExecute(String approveId, String userId);


	/**
	 *  审核立案申请业务处理
	 * @param formData 立案审核DTO
	 * @return
	 */
	BusiExecuteResult auditTheCaseBusiExecute(
			AuditPutOnRecordDTO formData);
	

}
