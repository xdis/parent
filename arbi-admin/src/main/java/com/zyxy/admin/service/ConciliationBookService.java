package com.zyxy.admin.service;

import com.zyxy.common.dto.CaseApproveDTO;
import com.zyxy.common.dto.CaseApproveSuggestDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ConciliationBookVO;

public interface ConciliationBookService {
	
	/**
	 * 调解书审核-业务验证 
	 * 判断案件是否存在，是否在待审核状态，是否属于该仲裁委人员
	 * @param formData 
	 * @return 是否有效
	 */
	BusiValidResult queryBusiValid(CaseApproveDTO formData);

	/**
	 * 调解书审核-业务处理
	 * 根据案件id查询调解书所需的数据
	 * @param formData 
	 * @return 
	 */
	ConciliationBookVO selectByCaseId(CaseApproveDTO formData);
	
	/**
	 * 审核调解书-业务验证
	 * @param approveId
	 * @param userInfoId
	 * @param approveType
	 * @return 
	 */
	BusiValidResult auditBusiValid(String approveId, String userId, String approveType);

	/**审核调解书-业务处理
	 * 插入审批意见
	 * @param formData
	 * @param userid 
	 * @return 
	 */
	BusiExecuteResult add(CaseApproveSuggestDTO formData, String userId);

}
