package com.zyxy.admin.service;

import com.zyxy.common.dto.SaveCaseDocDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.AvoidListVO;

/**
 * 仲裁员回避审核Service
 *
 */
public interface ArbitratorAvoidService {
	
	/**
	 * 审核案件业务验证 判断案件是否存在，是否不在审核通过状态，是否轮到该仲裁员审核
	 * @param caseId  案件Id
	 * @param userId  当前仲裁委的userId
	 * @param approveId  审批Id
	 * @return 是否有效
	 */
	BusiValidResult auditBusiValid(String caseId, String userId,String approveId);
	
	/**
	 * 仲裁员回避申请业务处理
	 * @param approveId 审批Id
	 * @param userId 用户Id
	 * @return
	 */
	AvoidListVO arbitratorAvoidBusiExecute(String approveId,String userId);
	
	
	/**审核仲裁员回避业务处理
	 * @param formData 仲裁回避审核DTO
	 * @return 审核结果
	 */
	BusiExecuteResult auditArbitratorBusiExecute(SaveCaseDocDTO formData);
	
	
	/**
	 * 仲裁秘书回避申请业务处理
	 * @param approveId 审批Id
	 * @param userId 当前用户Id
	 * @return 仲裁员回避审核信息
	 */
	AvoidListVO secretariesAvoidBusiExecute(String approveId,String userId);
	
	
	/**审核秘书回避业务处理
	 * @param formData 秘书回避审核DTO
	 * @return 审核结果
	 */
	BusiExecuteResult auditSecretariesBusiExecute(
			SaveCaseDocDTO formData);
	
	
	

}
