package com.zyxy.service.micro.core.service;

import com.zyxy.common.dto.CompromiseOperationDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.CompromiseInfoVO;

/**
 * 和解按钮操作
 */
public interface CompromiseOperationService {

	/**
	 * 和解按钮业务验证
	 * @param formData
	 * @return
	 */
	BusiValidResult compromiseOperationValid(CompromiseOperationDTO formData);
	
	/**
	 * 和解按钮业务处理
	 * @param formData
	 * @return
	 */
	BusiExecuteResult<?> compromiseOperationExcute(CompromiseOperationDTO formData);
	
	/**
	 * 和解信息业务验证
	 * @param CaseId
	 * @param userId
	 * @return
	 */
	BusiExecuteResult<CompromiseInfoVO> compromiseInfo(String caseId,String userId);
	
	
}
