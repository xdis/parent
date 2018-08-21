package com.zyxy.service.micro.core.service;

import com.zyxy.common.dto.flow.*;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import org.springframework.transaction.annotation.Transactional;

/**
 * 案件流程service
 */
public interface CaseFlowService {

    /**
     * 立案审核业务验证
     *
     * @param formData 立案审核DTO
     * @return 业务验证结果
     */
    BusiValidResult caseAuditBusiValid(CaseAuditDTO formData);

    /**
     * 立案审核业务执行
     *
     * @param formData 立案审核DTO
     * @return 业务执行结果
     */
    @Transactional
    BusiExecuteResult caseAuditBusiExecute(CaseAuditDTO formData);

    /**
     * 立案缴费业务验证
     *
     * @param formData 立案缴费DTO
     * @return 业务验证结果
     */
    BusiValidResult casePayBusiValid(CasePayDTO formData);

    /**
     * 立案缴费业务执行
     *
     * @param formData 立案缴费DTO
     * @return 业务执行结果
     */
    @Transactional
    BusiExecuteResult casePayBusiExecute(CasePayDTO formData);

    /**
     * 中途退出业务验证
     *
     * @param caseId 案件Id
     * @return 业务验证结果
     */
    BusiValidResult caseCompromiseExitBusiValid(String caseId);

    /**
     * 中途退出业务执行
     *
     * @param caseId 案件Id
     * @return 业务执行结果
     */
    @Transactional
    BusiExecuteResult caseCompromiseExitBusiExecute(String caseId);

    /**
     * 案件结案
     *
     * @param formData 案件结案DTO
     * @return 业务验证结果
     */
    BusiValidResult caseOverBusiValid(CaseOverDTO formData);

    /**
     * 案件结案
     *
     * @param formData 案件结案DTO
     * @return 业务执行结果
     */
    @Transactional
    BusiExecuteResult caseOverBusiExecute(CaseOverDTO formData);

    /**
     * 案件和解
     *
     * @param formData 案件和解结束DTO
     * @return 业务验证结果
     */
    BusiValidResult compromiseOverBusiValid(CaseCompromiseOverDTO formData);

    /**
     * 案件和解
     *
     * @param formData 案件和解结束DTO
     * @return 业务执行结果
     */
    @Transactional
    BusiExecuteResult compromiseOverBusiExecute(CaseCompromiseOverDTO formData);

    /**
     * 放弃答辩期
     *
     * @param formData 案件和解结束DTO
     * @return 业务验证结果
     */
    BusiValidResult giveReplyBusiValid(CaseGiveReplyDTO formData);

    /**
     * 放弃答辩期
     *
     * @param formData 案件和解结束DTO
     * @return 业务执行结果
     */
    @Transactional
    BusiExecuteResult giveReplyBusiExecute(CaseGiveReplyDTO formData);

    /**
     * 撤案
     *
     * @param formData 撤案DTO
     * @return 业务验证结果
     */
    BusiValidResult cancelCaseBusiValid(CaseCancelDTO formData);

    /**
     * 撤案
     *
     * @param formData 撤案DTO
     * @return 业务执行结果
     */
    @Transactional
    BusiExecuteResult cancelCaseBusiExecute(CaseCancelDTO formData);
}
