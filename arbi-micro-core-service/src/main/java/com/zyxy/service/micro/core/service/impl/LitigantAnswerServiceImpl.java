package com.zyxy.service.micro.core.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.common.domain.CaseInfo;
import com.zyxy.common.domain.QuizAnswerRecord;
import com.zyxy.common.domain.QuizAnswerRecordExample;
import com.zyxy.common.domain.QuizRecordWithBLOBs;
import com.zyxy.common.dto.LitigantAnswerQuestionDTO;
import com.zyxy.common.enums.CasePersonnelTypeEnum;
import com.zyxy.common.enums.QuizObjectEnum;
import com.zyxy.common.mapper.CaseInfoMapper;
import com.zyxy.common.mapper.QuizAnswerRecordMapper;
import com.zyxy.common.mapper.QuizRecordMapper;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.vo.ApiResultVO.Coder;
import com.zyxy.common.vo.QuestionAnswerListVO;
import com.zyxy.common.vo.QuestionAnswerVO;
import com.zyxy.common.vo.QuizAnswerVO;
import com.zyxy.common.vo.QuizRecordVO;
import com.zyxy.service.micro.core.service.CommonService;
import com.zyxy.service.micro.core.service.LitigantAnswerService;

/**
 * 当事人案件问答Service实现类
 */
@Service
public class LitigantAnswerServiceImpl implements LitigantAnswerService {
	
	private static final Logger logger = LoggerFactory.getLogger(LitigantAnswerServiceImpl.class);

	@Autowired
	private CaseInfoMapper caseInfoMapper;
	@Autowired
	private QuizRecordMapper quizRecordMapper;
	@Autowired
	private CommonService commonService;
	@Autowired
	private QuizAnswerRecordMapper quizAnswerRecordMapper;
	@Autowired
	private SequenceService sequenceService;
	
	@Override
	public BusiValidResult litigantAnswerValid(
			LitigantAnswerQuestionDTO formData) {
		//验证案件是否存在
		CaseInfo caseInfo = caseInfoMapper.selectByPrimaryKey(formData.getCaseId());
		if(caseInfo == null){
			return BusiValidResult.builderErrorResult(Coder.CASE_NOT_EXIST);
		}
		BusiValidResult commonValid = commonService.commonCaseAndUserValid(formData.getCaseId(), formData.getUserId());
		if (commonValid.hasError()) {
			return BusiValidResult.builderErrorResult(commonValid.getCode(), commonValid.getMsg());
		}
		return BusiValidResult.builderSuccessResult();
	}

	@Override
	public BusiExecuteResult<String> litigantAnswerExecute(
			LitigantAnswerQuestionDTO formData) {
		CasePersonnelTypeEnum enums = commonService.queryCasePersonnerlTypeByUserId(formData.getCaseId(), formData.getUserId());
		QuizAnswerRecord answerRecord = new QuizAnswerRecord();
		answerRecord.setId(sequenceService.getCommonID());
		answerRecord.setCreaterId(formData.getUserId());
		answerRecord.setQuizAnswer(formData.getQuizAnswer());
		answerRecord.setQuizId(formData.getId());
		answerRecord.setCreateTime(new Date());
		answerRecord.setAnswerType(enums.getValue());
		int rows = quizAnswerRecordMapper.insertSelective(answerRecord);;
		if (rows<1) {
			BusiExecuteResult.builderErrorResult(Coder.DB_UPDATE_ERROR);
		}
		return BusiExecuteResult.builderSuccessResult();
	}
	@Override
	public BusiValidResult litigantQuesAnsListValid(
			String caseId,String userId) {
		BusiValidResult commonValid = commonService.commonCaseAndUserValid(caseId, userId);
		if (commonValid.hasError()) {
			return BusiValidResult.builderErrorResult(commonValid.getCode(), commonValid.getMsg());
		}
		return BusiValidResult.builderSuccessResult();
	}
	@Override
	public BusiExecuteResult<QuestionAnswerListVO> litigantQuesAnsListExecute(
			String caseId,String userId) {
		List<QuizRecordVO> list  = quizRecordMapper.selectQuizRecord(caseId);
		QuestionAnswerListVO answerListVO = new QuestionAnswerListVO();
		List<QuestionAnswerVO> propList = new ArrayList<QuestionAnswerVO>();
		List<QuestionAnswerVO> defeList = new ArrayList<QuestionAnswerVO>();
		
		for (QuizRecordVO quizRecordVO : list) {
			if (QuizObjectEnum.PROPOSER.getValue().equals(quizRecordVO.getQuizObject())) {
				QuestionAnswerVO propAnswerVO = new QuestionAnswerVO();
				propAnswerVO.setId(quizRecordVO.getId());
				propAnswerVO.setArbiName(quizRecordVO.getArbiName());
				propAnswerVO.setQuestion(quizRecordVO.getQuizContent());
				List<QuizAnswerVO> answerVOs =quizAnswerRecordMapper.selectQuizAnswer(quizRecordVO.getId(), CasePersonnelTypeEnum.PROPOSER.getValue());
				if (answerVOs.size()>0) {
					propAnswerVO.setQuizAnswers(answerVOs);
				}
				propList.add(propAnswerVO);
			}else if (QuizObjectEnum.DEFENDANT.getValue().equals(quizRecordVO.getQuizObject())) {
				QuestionAnswerVO defeAnswerVO = new QuestionAnswerVO();
				defeAnswerVO.setId(quizRecordVO.getId().toString());
				defeAnswerVO.setArbiName(quizRecordVO.getArbiName());
				defeAnswerVO.setQuestion(quizRecordVO.getQuizContent());
				List<QuizAnswerVO> answerVOs =quizAnswerRecordMapper.selectQuizAnswer(quizRecordVO.getId(), CasePersonnelTypeEnum.DEFENDANT.getValue());
				if (answerVOs.size()>0) {
					defeAnswerVO.setQuizAnswers(answerVOs);
				}
				defeList.add(defeAnswerVO);
			}else if (QuizObjectEnum.BOTH.getValue().equals(quizRecordVO.getQuizObject())) {
				//申请方
				QuestionAnswerVO propAnswerVO = new QuestionAnswerVO();
				propAnswerVO.setArbiName(quizRecordVO.getArbiName());
				propAnswerVO.setId(quizRecordVO.getId().toString());
				propAnswerVO.setQuestion(quizRecordVO.getQuizContent());
				List<QuizAnswerVO> answerVOs =quizAnswerRecordMapper.selectQuizAnswer(quizRecordVO.getId(), CasePersonnelTypeEnum.PROPOSER.getValue());
				if (answerVOs.size()>0) {
					propAnswerVO.setQuizAnswers(answerVOs);
				}
				propList.add(propAnswerVO);
				//被申请方
				QuestionAnswerVO defeAnswerVO = new QuestionAnswerVO();
				defeAnswerVO.setArbiName(quizRecordVO.getArbiName());
				defeAnswerVO.setId(quizRecordVO.getId().toString());
				defeAnswerVO.setQuestion(quizRecordVO.getQuizContent());
				List<QuizAnswerVO> answerVOs2 =quizAnswerRecordMapper.selectQuizAnswer(quizRecordVO.getId(), CasePersonnelTypeEnum.DEFENDANT.getValue());
				if (answerVOs.size()>0) {
					defeAnswerVO.setQuizAnswers(answerVOs2);
				}
				defeList.add(defeAnswerVO);
			}
		}
		answerListVO.setPropQuestionAnswers(propList);
		answerListVO.setDefeQuestionAnswers(defeList);
		return BusiExecuteResult.builderSuccessResult(answerListVO);
	}

}
