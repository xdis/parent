package com.zyxy.admin.service;

import com.zyxy.common.dto.ArbitrationCaseDecisionHandleDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.vo.ArbitrationWithdrawCaseDecisionVO;

public interface WithdrawCaseService {
	/**
	 * 仲裁委-撤销仲裁请求内容业务执行
	 * @param approveId 审批id
	 * @param userId 用户id
	 * @return 审批页面信息
	 */
	BusiExecuteResult<ArbitrationWithdrawCaseDecisionVO> arbitrationWithdrawCaseContentBusiExecute(
			String approveId, String userId);
	
	/**
	 * 仲裁委 - 撤销仲裁请求审批业务执行
	 * @param dto 表单数据
	 * @return 审批结果
	 */
	BusiExecuteResult arbitrationWithdrawCaseApproveBusiExecute(ArbitrationCaseDecisionHandleDTO formData);

}
