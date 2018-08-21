package com.zyxy.admin.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.admin.service.CompromiseRecordService;
import com.zyxy.common.domain.CaseInfoExample;
import com.zyxy.common.domain.CompromiseRecord;
import com.zyxy.common.enums.CasePersonnelTypeEnum;
import com.zyxy.common.enums.CompromiseRecordTypeEnum;
import com.zyxy.common.enums.ManagerInfoTypeEnum;
import com.zyxy.common.enums.QuizObjectEnum;
import com.zyxy.common.mapper.CaseInfoMapper;
import com.zyxy.common.mapper.CompromiseRecordMapper;
import com.zyxy.common.mapper.QuizAnswerRecordMapper;
import com.zyxy.common.mapper.QuizRecordMapper;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.CaseCompromiseRecordVO;
import com.zyxy.common.vo.QuestionAnswerListVO;
import com.zyxy.common.vo.QuestionAnswerVO;
import com.zyxy.common.vo.QuizAnswerVO;
import com.zyxy.common.vo.QuizRecordVO;

/**
 * 和解记录serviceImpl
 */
@Service
public class CompromiseRecordServiceImpl implements CompromiseRecordService {

    @Autowired
    private CaseInfoMapper caseInfoMapper;

    @Autowired
    private CompromiseRecordMapper compromiseRecordMapper;
    
    @Autowired
    private SequenceService sequenceService;
    
    @Autowired
	private QuizRecordMapper quizRecordMapper;
    
    @Autowired
	private QuizAnswerRecordMapper quizAnswerRecordMapper;

    /**
     * 业务验证
     * @param caseId
     * @return
     */
    @Override
    public BusiValidResult queryCompromiseRecordBusiValid(String caseId) {

        CaseInfoExample caseInfoExample = new CaseInfoExample();
        caseInfoExample.createCriteria().andIdEqualTo(caseId);
        //根据案件id查询该案件存不存在
        int i = caseInfoMapper.countByExample(caseInfoExample);
        if(i<=0){
            return BusiValidResult.builderErrorResult(ApiResultVO.Coder.NOT_FOUND);
        }
        return BusiValidResult.builderSuccessResult();
    }

    /**
     * 业务处理
     * @param caseId
     * @return
     */
    @Override
    public List<CaseCompromiseRecordVO> queryCompromiseRecordBusiExecute(String caseId) {
        return this.queryCompromiseRecord(caseId);
    }

    /**
     * 新增和解聊天记录业务处理
     * @param formData
     * @return
     */
    @Override
    public boolean insertCompromseRecordBusiExecute(CompromiseRecord formData) {
    	String compromiseRecordId = "CR" + sequenceService.getCommonID();
    	formData.setId(compromiseRecordId);
        formData.setCreateTime(new Date());
        formData.setSenderType(ManagerInfoTypeEnum.ARBITRATION_SECRETARY.getCode());
        formData.setContentType(CompromiseRecordTypeEnum.COMPROMISE.getValue());
        return this.insertCompromseRecord(formData);
    }




    /*************私有service*************/
    /**
     * 根据案件id查询出该案件和解记录
     * @param caseId
     * @return
     */
    public List<CaseCompromiseRecordVO> queryCompromiseRecord(String caseId) {
        return compromiseRecordMapper.queryCompromiseRecord(caseId);
    }


    /**
     * 新增和解聊天记录
     * @param formData
     * @return
     */
    public boolean insertCompromseRecord(CompromiseRecord formData) {
        int low = compromiseRecordMapper.insert(formData);
        if(low<=0){
            return false;
        }
        return true;
    }
    
    /**
     * 查询仲裁员、当事人问答记录
     * @return 
     */
	@Override
	public QuestionAnswerListVO questionAnswer(String caseId) {
		List<QuizRecordVO> list  = quizRecordMapper.selectQuizRecord(caseId);
		QuestionAnswerListVO answerListVO = new QuestionAnswerListVO();
		List<QuestionAnswerVO> propList = new ArrayList<QuestionAnswerVO>();
		List<QuestionAnswerVO> defeList = new ArrayList<QuestionAnswerVO>();
		
		for (QuizRecordVO quizRecordVO : list) {
			if (QuizObjectEnum.PROPOSER.getValue().equals(quizRecordVO.getQuizObject())) {
				QuestionAnswerVO propAnswerVO = new QuestionAnswerVO();
				propAnswerVO.setQuizObject(quizRecordVO.getQuizObject());
				propAnswerVO.setId(quizRecordVO.getId());
				propAnswerVO.setArbiName(quizRecordVO.getArbiName());
				propAnswerVO.setQuestion(quizRecordVO.getQuizContent());
				propAnswerVO.setQuestionTime(quizRecordVO.getQuizCreateTime());
				List<QuizAnswerVO> answerVOs =quizAnswerRecordMapper.selectQuizAnswer(quizRecordVO.getId(), CasePersonnelTypeEnum.PROPOSER.getValue());
				if (answerVOs.size()>0) {
					propAnswerVO.setQuizAnswers(answerVOs);
				}
				propList.add(propAnswerVO);
				
			}else if (QuizObjectEnum.DEFENDANT.getValue().equals(quizRecordVO.getQuizObject())) {
				QuestionAnswerVO defeAnswerVO = new QuestionAnswerVO();
				defeAnswerVO.setQuizObject(quizRecordVO.getQuizObject());
				defeAnswerVO.setId(quizRecordVO.getId().toString());
				defeAnswerVO.setArbiName(quizRecordVO.getArbiName());
				defeAnswerVO.setQuestion(quizRecordVO.getQuizContent());
				defeAnswerVO.setQuestionTime(quizRecordVO.getQuizCreateTime());
				List<QuizAnswerVO> answerVOs =quizAnswerRecordMapper.selectQuizAnswer(quizRecordVO.getId(), CasePersonnelTypeEnum.DEFENDANT.getValue());
				if (answerVOs.size()>0) {
					defeAnswerVO.setQuizAnswers(answerVOs);
				}
				defeList.add(defeAnswerVO);
			}else if (QuizObjectEnum.BOTH.getValue().equals(quizRecordVO.getQuizObject())) {
				//申请方
				QuestionAnswerVO propAnswerVO = new QuestionAnswerVO();
				propAnswerVO.setQuizObject(quizRecordVO.getQuizObject());
				propAnswerVO.setArbiName(quizRecordVO.getArbiName());
				propAnswerVO.setId(quizRecordVO.getId().toString());
				propAnswerVO.setQuestion(quizRecordVO.getQuizContent());
				propAnswerVO.setQuestionTime(quizRecordVO.getQuizCreateTime());
				List<QuizAnswerVO> answerVOs =quizAnswerRecordMapper.selectQuizAnswer(quizRecordVO.getId(), CasePersonnelTypeEnum.PROPOSER.getValue());
				if (answerVOs.size()>0) {
					propAnswerVO.setQuizAnswers(answerVOs);
				}
				propList.add(propAnswerVO);
				//被申请方
				QuestionAnswerVO defeAnswerVO = new QuestionAnswerVO();
				defeAnswerVO.setQuizObject(quizRecordVO.getQuizObject());
				defeAnswerVO.setArbiName(quizRecordVO.getArbiName());
				defeAnswerVO.setId(quizRecordVO.getId().toString());
				defeAnswerVO.setQuestion(quizRecordVO.getQuizContent());
				defeAnswerVO.setQuestionTime(quizRecordVO.getQuizCreateTime());
				List<QuizAnswerVO> answerVOs2 =quizAnswerRecordMapper.selectQuizAnswer(quizRecordVO.getId(), CasePersonnelTypeEnum.DEFENDANT.getValue());
				if (answerVOs.size()>0) {
					defeAnswerVO.setQuizAnswers(answerVOs2);
				}
				defeList.add(defeAnswerVO);
			}
		}
		answerListVO.setPropQuestionAnswers(propList);
		answerListVO.setDefeQuestionAnswers(defeList);
		
		return answerListVO;
	}
}
