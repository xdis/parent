package com.zyxy.service.micro.core.service;

import com.zyxy.common.dto.BackRegisterCaseDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.DocHeadVO;

/**
 * 案件反请求Service
 */
public interface CaseBackRegisterService {
	
	/**
	 * 案件反请求业务验证
	 * @param formData
	 * @return
	 */
	BusiValidResult caseBackRegisterBusiValid(BackRegisterCaseDTO formData);

	/**
	 * 案件反请求业务处理
	 * @param formData
	 * @return
	 */
	BusiExecuteResult<String> caseBackRegisterBusiExecute(BackRegisterCaseDTO formData);
	
	/**
	 * 获取申请人本申请人信息业务验证
	 * @param caseId
	 * @param userId
	 * @return
	 */
	BusiValidResult docHeadValid(String caseId,String userId);
	
	/**
	 * 获取申请人本申请人信息业务处理
	 * @param caseId
	 * @param userId
	 * @return
	 */
	BusiExecuteResult<DocHeadVO> docHeadExecute(String caseId,String userId);
}
