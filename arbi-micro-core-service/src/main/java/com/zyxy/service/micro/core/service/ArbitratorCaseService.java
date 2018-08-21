package com.zyxy.service.micro.core.service;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.domain.ArgueRecord;
import com.zyxy.common.dto.*;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 仲裁员案件相关服务
 */
public interface ArbitratorCaseService {
    /**
     * 根据表单信息查询案件列表
     *
     * @param formData 表单信息
     */
    BusiExecuteResult<PageInfo<ArbitratorCaseListVO>> queryCaseListBusiExecute(ArbitratorCaseListDTO formData, String arbitratorId);

    /**
     * 受理案件业务验证
     *
     * @param formData
     * @return
     */
    BusiValidResult acceptCaseBusiValid(ArbitratorCaseAcceptDTO formData);

    /**
     * 受理案件业务处理
     *
     * @param formData
     * @return
     */
    @Transactional
    BusiExecuteResult acceptCaseBusiExecute(ArbitratorCaseAcceptDTO formData);

    /**
     * 案件基本信息业务验证
     *
     * @param caseId 案件Id
     * @param userId 仲裁员Id
     * @return
     */
    BusiValidResult caseBaseInfoBusiValid(String caseId, String userId);

    /**
     * 案件基本信息业务处理
     *
     * @param caseId 案件Id
     * @param userId 仲裁员Id
     * @return
     */
    BusiExecuteResult<ArbitratorCaseBaseInfoVO> caseBaseInfoBusiExecute(String caseId, String userId, String requestFlag);

    /**
     * 案件公共信息业务验证
     *
     * @param caseId 案件Id
     * @param userId 仲裁员Id
     * @return
     */
    BusiValidResult caseCommInfoBusiValid(String caseId, String userId);

    /**
     * 案件公共信息业务处理
     *
     * @param caseId 案件Id
     * @param userId 仲裁员Id
     * @return
     */
    BusiExecuteResult<CaseCommInfoVO> caseCommInfoBusiExecute(String caseId, String userId);

    /**
     * 案件请求信息业务验证
     *
     * @param caseId 案件Id
     * @param userId 仲裁员Id
     * @return
     */
    BusiValidResult caseRequestInfoBusiValid(String caseId, String userId);

    /**
     * 案件请求信息业务处理
     *
     * @param caseId 案件Id
     * @param flag   请求标志，0- 正请求，1-反请求
     * @return
     */
    BusiExecuteResult<ArbitratorCaseRequestInfoVO> caseRequestInfoBusiExecute(String caseId, String flag);

    /**
     * 案件答辩信息业务验证
     *
     * @param caseId 案件Id
     * @param userId 仲裁员Id
     * @return
     */
    BusiValidResult caseReplyInfoBusiValid(String caseId, String userId);

    /**
     * 案件答辩信息业务处理
     *
     * @param caseId 案件Id
     * @param flag   请求标志，0- 正请求，1-反请求
     * @return
     */
    BusiExecuteResult<ArbitratorCaseReplyInfoVO> caseReplyInfoBusiExecute(String caseId, String flag);

    /**
     * 案件流程信息业务验证
     *
     * @param caseId 案件Id
     * @param userId 仲裁员Id
     * @return
     */
    BusiValidResult caseFlowInfoBusiValid(String caseId, String userId);

    /**
     * 案件流程信息业务处理
     *
     * @param caseId 案件Id
     * @return
     */
    BusiExecuteResult<CaseFlowVO> caseFlowInfoBusiExecute(String caseId);

    /**
     * 案件和解信息业务验证
     *
     * @param caseId 案件Id
     * @param userId 仲裁员Id
     * @return
     */
    BusiValidResult caseCompromiseInfoBusiValid(String caseId, String userId);

    /**
     * 案件和解信息业务处理
     *
     * @param caseId 案件Id
     * @return
     */
    BusiExecuteResult<CaseCompromiseVO> caseCompromiseInfoBusiExecute(String caseId);

    /**
     * 案件和解审核业务验证
     *
     * @param formData DTO
     * @return
     */
    BusiValidResult caseCompromiseAuditBusiValid(ArbitratorCaseCompromiseAuditDTO formData);

    /**
     * 案件和解审核业务处理
     *
     * @param formData DTO
     * @return
     */
    BusiExecuteResult caseCompromiseAuditBusiExecute(ArbitratorCaseCompromiseAuditDTO formData);

    /**
     * 案件和解回复业务验证
     *
     * @param formData DTO
     * @return
     */
    BusiValidResult caseCompromiseReplyBusiValid(ArbitratorCaseCompromiseReplyDTO formData);

    /**
     * 案件和解回复业务处理
     *
     * @param formData DTO
     * @return
     */
    BusiExecuteResult caseCompromiseReplyBusiExecute(ArbitratorCaseCompromiseReplyDTO formData);

    /**
     * 案件裁决信息业务验证
     *
     * @param caseId 案件Id
     * @param userId 仲裁员Id
     * @return
     */
    BusiValidResult caseArbitrationInfoBusiValid(String caseId, String userId);

    /**
     * 案件裁决信息业务处理
     *
     * @param caseId 案件Id
     * @return
     */
    BusiExecuteResult<CaseArbitrationInfoVO> caseArbitrationInfoBusiExecute(String caseId);

    /**
     * 案件辩论回复业务验证
     *
     * @param formData DTO
     * @return
     */
    BusiValidResult caseArgueReplyBusiValid(ArbitratorCaseArgueReplyDTO formData);

    /**
     * 案件辩论回复业务处理
     *
     * @param formData DTO
     * @return
     */
    BusiExecuteResult caseArgueReplyBusiExecute(ArbitratorCaseArgueReplyDTO formData);

    /**
     * 案件辩论业务验证
     *
     * @param caseId DTO
     * @param userId DTO
     * @return
     */
    BusiValidResult caseArgueBusiValid(String caseId, String userId);

    /**
     * 案件辩论业务处理
     *
     * @param caseId DTO
     * @param userId DTO
     * @return
     */
    BusiExecuteResult<List<ArgueRecordVO>> caseArgueBusiExecute(String caseId, String userId);

    /**
     * 案件出具裁决书业务验证
     *
     * @param formData DTO
     * @return
     */
    BusiValidResult caseArbitralAwardsBusiValid(ArbitratorCaseArbitralAwardsDTO formData);

    /**
     * 案件出具裁决书业务处理
     *
     * @param formData DTO
     * @return
     */
    BusiExecuteResult caseArbitralAwardsBusiExecute(ArbitratorCaseArbitralAwardsDTO formData);

    /**
     * 案件出具裁决书修改业务验证
     *
     * @param formData DTO
     * @return
     */
    BusiValidResult caseArbitralAwardsChangeBusiValid(ArbitratorCaseArbitralAwardsDTO formData);

    /**
     * 案件出具裁决书修改业务处理
     *
     * @param formData DTO
     * @return
     */
    BusiExecuteResult caseArbitralAwardsChangeBusiExecute(ArbitratorCaseArbitralAwardsDTO formData);

    /**
     * 案件出具裁决书草稿业务验证
     *
     * @param formData DTO
     * @return
     */
    BusiValidResult caseArbitralAwardsDraftBusiValid(ArbitratorCaseArbitralAwardsDTO formData);

    /**
     * 案件出具裁决书草稿业务处理
     *
     * @param formData DTO
     * @return
     */
    BusiExecuteResult caseArbitralAwardsDraftBusiExecute(ArbitratorCaseArbitralAwardsDTO formData);

    /**
     * 案件出具裁决书状态业务验证
     *
     * @return
     */
    BusiValidResult caseArbitralAwardsStatusBusiValid(String caseId, String userId);

    /**
     * 案件出具裁决书状态业务处理
     *
     * @return
     */
    BusiExecuteResult<ArbitratorCaseArbitralAwardStatusVO> caseArbitralAwardsStatusBusiExecute(String caseId, String userId);

    /**
     * 案件出具调解书业务验证
     *
     * @param caseId 案件Id
     * @param userId 用户Id
     * @return
     */
    BusiValidResult caseMediateAwardsBusiValid(String caseId, String userId);

    /**
     * 案件出具调解书业务处理
     *
     * @param caseId 案件Id
     * @param userId 用户Id
     * @return
     */
    BusiExecuteResult caseMediateAwardsBusiExecute(String caseId, String userId);

    /**
     * 案件出具裁决书状态业务验证
     *
     * @return
     */
    BusiValidResult caseMediateAwardsStatusBusiValid(String caseId, String userId);

    /**
     * 案件出具裁决书状态业务处理
     *
     * @return
     */
    BusiExecuteResult<ArbitratorCaseMediateAwardStatusVO> caseMediateAwardsStatusBusiExecute(String caseId, String userId);

    /**
     * 案件出具调解书修改业务验证
     *
     * @param caseId 案件Id
     * @param userId 用户Id
     * @return
     */
    BusiValidResult caseMediateAwardsChangeBusiValid(String caseId, String userId);

    /**
     * 案件出具调解书修改业务处理
     *
     * @param caseId 案件Id
     * @param userId 用户Id
     * @return
     */
    BusiExecuteResult caseMediateAwardsChangeBusiExecute(String caseId, String userId);


    /**
     * 案件出具管辖权异议决定书业务验证
     *
     * @param formData DTO
     * @return
     */
    BusiValidResult caseJurisAwardsBusiValid(ArbitratorCaseJurisAwardsDTO formData);

    /**
     * 案件出具管辖权异议决定书业务处理
     *
     * @param formData DTO
     * @return
     */
    BusiExecuteResult caseJurisAwardsBusiExecute(ArbitratorCaseJurisAwardsDTO formData);

    /**
     * 案件出具管辖权异议决定书修改业务验证
     *
     * @param formData DTO
     * @return
     */
    BusiValidResult caseJurisAwardsChangeBusiValid(ArbitratorCaseJurisAwardsDTO formData);

    /**
     * 案件出具管辖权异议决定书修改业务处理
     *
     * @param formData DTO
     * @return
     */
    BusiExecuteResult caseJurisAwardsChangeBusiExecute(ArbitratorCaseJurisAwardsDTO formData);

    /**
     * 案件出具管辖权异议决定书状态业务验证
     *
     * @return
     */
    BusiValidResult caseJurisAwardsStatusBusiValid(ArbitratorCaseJurisAwardsStatusDTO formData);

    /**
     * 案件出具管辖权异议决定书状态业务处理
     *
     * @return
     */
    BusiExecuteResult<ArbitratorCaseJurisAwardStatusVO> caseJurisAwardsStatusBusiExecute(ArbitratorCaseJurisAwardsStatusDTO formData);

    /**
     * 案件出具撤案决定书业务验证
     *
     * @return
     */
    BusiValidResult caseWithdrawAwardsBusiValid(ArbitratorCaseWithdrawAwardsDTO formData);

    /**
     * 案件出具撤案决定书业务处理
     *
     * @return
     */
    BusiExecuteResult caseWithdrawAwardsBusiExecute(ArbitratorCaseWithdrawAwardsDTO formData);

}
