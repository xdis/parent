package com.zyxy.admin.service;

import com.zyxy.common.domain.CompromiseRecord;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.CaseCompromiseRecordVO;
import com.zyxy.common.vo.QuestionAnswerListVO;

import java.util.List;

/**
 * 和解记录service
 */
public interface CompromiseRecordService {


    /**
     * 业务验证
     * @param caseId
     * @return
     */
    BusiValidResult queryCompromiseRecordBusiValid(String caseId);

    /**
     * 业务处理
     * @param caseId
     * @return
     */
    List<CaseCompromiseRecordVO> queryCompromiseRecordBusiExecute(String caseId);

    /**
     * 新增和解聊天记录业务处理
     * @param formData
     * @return
     */
    boolean insertCompromseRecordBusiExecute(CompromiseRecord formData);

    /**
     * 查询仲裁员当事人问答记录
     * @param caseId
     * @return 
     */
	QuestionAnswerListVO questionAnswer(String caseId);

}
