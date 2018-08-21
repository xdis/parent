package com.zyxy.service.micro.core.service;

import com.zyxy.common.dto.LitigantAnswerQuestionDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.QuestionAnswerListVO;

/**
 * 当事人回答Service
 */
public interface LitigantAnswerService {
	
	/**
	 * 当事人回答业务验证
	 * @param formData
	 * @return
	 */
	BusiValidResult litigantAnswerValid(LitigantAnswerQuestionDTO formData);
	
	/**
	 * 当事人回答业务处理
	 * @param formData
	 * @return
	 */
	BusiExecuteResult<String> litigantAnswerExecute(LitigantAnswerQuestionDTO formData);
	
	/**
	 * 当事人问答列表业务验证
	 * @param formData
	 * @return
	 */
	BusiValidResult litigantQuesAnsListValid(String caseId,String userId);

	/**
	 * 当事人问答列表业务执行
	 * @param formData
	 * @return
	 */
	BusiExecuteResult<QuestionAnswerListVO> litigantQuesAnsListExecute(String caseId,String userId);
	
}
