package com.zyxy.service.micro.core.service;

import com.zyxy.common.dto.CaseEvaluationDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.vo.CaseEvaluationVO;

/**
 * 案件评论服务
 */
public interface CaseEvaluationService{
	/**
	 * 查询案件评价
	 * @param formData 表单信息
	 * @return 案件评价内容对象
	 */
	BusiExecuteResult<CaseEvaluationVO> queryCaseEvaluationBusiExecute(CaseEvaluationDTO formData);
}
