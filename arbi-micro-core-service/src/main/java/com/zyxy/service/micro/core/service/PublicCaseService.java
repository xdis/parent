package com.zyxy.service.micro.core.service;

import com.zyxy.common.dto.*;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.*;
import org.springframework.transaction.annotation.Transactional;

/**
 * 仲裁员案件相关服务
 */
public interface PublicCaseService {

    /**
     * 申请立案业务验证
     * @param formData DTO
     * @return
     */
    BusiValidResult caseApplyBusiValid(RegisterCaseDTO formData);

    /**
     * 申请立案业务处理
     * @param formData DTO
     * @return
     */
    @Transactional
    BusiExecuteResult<String> caseApplyBusiExecute(RegisterCaseDTO formData);

    /**
     * 本人申请立案缺省信息业务处理
     *
     * @param formData DTO
     * @return
     */
    @Transactional
    BusiExecuteResult<CaseDefaultInfoVO> selfCaseApplyInfoBusiExecute(BaseDTO formData);

    /**
     * 申请立案存草稿业务验证
     * @param formData DTO
     * @return
     */
    BusiValidResult caseApplyDraftBusiValid(RegisterCaseDTO formData);

    /**
     * 申请立案存草稿业务处理
     * @param formData DTO
     * @return
     */
    @Transactional
    BusiExecuteResult<String> caseApplyDraftBusiExecute(RegisterCaseDTO formData);

    /**
     * 得到申请立案存草稿业务验证
     *
     * @param formData DTO
     * @return
     */
    BusiValidResult getCaseApplyDraftBusiValid(GetCaseDraftDTO formData);

    /**
     * 得到申请立案存草稿业务处理
     *
     * @param formData DTO
     * @return
     */
    @Transactional
    BusiExecuteResult<CaseApplyDraftVO> getCaseApplyDraftBusiExecute(GetCaseDraftDTO formData);

    /**
     * 申请答辩业务验证
     * @param formData DTO
     * @return
     */
    BusiValidResult caseReplyBusiValid(CaseReplyDTO formData);

    /**
     * 申请答辩业务处理
     * @param formData DTO
     * @return
     */
    @Transactional
    BusiExecuteResult<CaseArbitrationInfoVO> caseReplyBusiExecute(CaseReplyDTO formData);
    
    /**
     * 答辩修改业务验证
     * @param formData DTO
     * @return
     */
    BusiValidResult caseRejoinAmendValid(CaseRejoinUpdateDTO formData);
    
    /**
     * 答辩修改业务处理
     * @param formData DTO
     * @return
     */
    @Transactional
    BusiExecuteResult<String> caseRejoinAmendExecute(CaseRejoinUpdateDTO formData);
    
    /**
     * 代理立案短信验证
     * @param userId
     * @param phone
     * @return
     */
    BusiExecuteResult<MessageVO> agentCaseApplyMsg(String userId,String phone);

}