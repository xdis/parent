package com.zyxy.service.micro.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.common.domain.CaseArbitrator;
import com.zyxy.common.domain.CaseArbitratorExample;
import com.zyxy.common.domain.QuizRecord;
import com.zyxy.common.domain.QuizRecordExample;
import com.zyxy.common.dto.ArbitratorQuestionDTO;
import com.zyxy.common.dto.QuestionInfoDTO;
import com.zyxy.common.enums.CaseArbitratorStatusEnum;
import com.zyxy.common.mapper.CaseArbitratorMapper;
import com.zyxy.common.mapper.QuizRecordMapper;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.vo.ApiResultVO.Coder;
import com.zyxy.service.micro.core.service.ArbitratorQuestionService;

/**
 * 仲裁员提问Service实现类
 */
@Service
public class ArbitratorQuestionServiceImpl implements ArbitratorQuestionService {
	
	@Autowired
	private CaseArbitratorMapper caseArbitratorMapper;
	@Autowired
	private QuizRecordMapper quizRecordMapper;
	@Autowired
	private SequenceService sequenceService;

	@Override
	public BusiValidResult arbitratorQuestionValid(
			ArbitratorQuestionDTO formData) {
		String caseId = formData.getCaseId();
		String userId = formData.getUserId();
		//判断案件当前案件与仲裁员是否匹配--根据案件ID查询当前有效的仲裁员
		CaseArbitratorExample caseArbitratorExample = new CaseArbitratorExample();
		caseArbitratorExample.
			createCriteria().
				andCaseIdEqualTo(caseId).
					andStatusEqualTo(CaseArbitratorStatusEnum.OK.getCode());
		List<CaseArbitrator> caseArbitrators = caseArbitratorMapper.selectByExample(caseArbitratorExample);
		
		if (caseArbitrators.size()<0) {
			
			return BusiValidResult.builderErrorResult(Coder.CASE_NOT_OK_ARBITRATOR);
			
		}else if(caseArbitrators.size()>0&&!userId.equals(caseArbitrators.get(0).getArbitratorId())){
			
			return BusiValidResult.builderErrorResult(Coder.ARBITRATOR_NOT_MATCH_ARBITRATOR_FOR_CASE);
		}
		return BusiValidResult.builderSuccessResult();
	}

	@Override
	public BusiExecuteResult<String> arbitratorExecute(
			ArbitratorQuestionDTO formData) {
		if (null != formData.getQuestions()) {
			for (QuestionInfoDTO question : formData.getQuestions()) {
				question.setId(sequenceService.getCommonID());
			}
		}
		int rows = quizRecordMapper.insertQuizRecord(formData.getQuestions(),formData.getCaseId(),
				formData.getUserId());
		if (rows<1) {
			BusiExecuteResult.builderErrorResult(Coder.DB_INSERT_ERROR);
		}
		
		return BusiExecuteResult.builderSuccessResult();
	}

}
