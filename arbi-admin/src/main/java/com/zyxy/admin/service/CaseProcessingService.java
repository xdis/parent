package com.zyxy.admin.service;

import com.zyxy.common.dto.AuditPutOnRecordDTO;
import com.zyxy.common.dto.ChangeCounterclaimDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.AhangeCounterclaimtVO;
import com.zyxy.common.vo.InitiateAuditVO;

/**
 * 
 * 案件处理信息service
 *
 */
public interface CaseProcessingService {

	/**
	 * 判断案件是否存在，是否属于该仲裁委人员
	 * 
	 * @param approveId
	 *            审批Id
	 * @param userId
	 *            当前仲裁委的userId
	 * @return 是否有效
	 */
	BusiValidResult auditTheCaseBusiValid(String approveId, String userId);

	/**
	 * 审核案件业务验证 判断案件是否存在，是否在待审核状态，是否轮到该仲裁员审核
	 * @param approveId 审批Id
	 * @return 是否有效
	 */
	BusiValidResult auditBusiValid(String approveId,String caseId,String userId);

	/**
	 * 审批业务验证(驳回时仍需审批的相关审批)
	 * 判断案件是否存在，是否属于该仲裁委人员,是否有权限操作该案件
	 * @param caseId 案件id
	 * @param userId 用户id 
	 * @param approveType 审批类型
	 * @return
	 */
	BusiValidResult approveBusiValid(String approveId , String userId);
	
	/**
	 * 查看审批详情业务验证 
	 * @param approveId 审批id
	 * @param userId 用户id
	 * @return
	 */
	BusiValidResult seeDetailInfoBusiValid(String approveId,String userId);
	
	/**
	 * 反请求审核业务处理
	 * @param approveId 审批Id
	 * @param userId 用户Id
	 * @return 
	 */
	InitiateAuditVO beCounterclaimAuditBusiExecute(String approveId, String userId);

	/**
	 * 审核反请求业务处理
	 *
	 * @param formData
	 * @return
	 */
	BusiExecuteResult auditBeCounterclaimBusiExecute(AuditPutOnRecordDTO formData);

	/**
	 * 变更仲裁反请求业务处理
	 * @param approveId 审批Id
	 * @param userId 用户Id
	 * @return 变更仲裁反请求页面信息
	 */
	AhangeCounterclaimtVO changeCounterclaimtBusiExecute(String approveId,String userId);

	/**
	 * 审核变更仲裁反请求业务处理
	 *
	 * @param formData
	 *            变更仲裁请求DTO
	 * @return
	 */
	BusiExecuteResult auditChangeCounterclaimBusiExecute(
			ChangeCounterclaimDTO formData);

}
