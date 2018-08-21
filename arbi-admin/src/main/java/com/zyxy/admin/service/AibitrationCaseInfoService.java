package com.zyxy.admin.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.domain.ArgueRecord;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ArbitratorCaseReplyInfoVO;
import com.zyxy.common.vo.ArbitratorCaseRequestInfoVO;
import com.zyxy.common.vo.CaseArbitrationInfoVO;
import com.zyxy.common.vo.ChangeRequestContentVO;
import com.zyxy.common.vo.EvidenceVO;

/**
 * 仲裁委案件信息service
 */
public interface AibitrationCaseInfoService {

   

    /**
     * 案件请求信息业务处理
     * @param caseId 案件Id
     * @param flag 请求标志，0- 正请求，1-反请求
     * @return
     */
    BusiExecuteResult<ArbitratorCaseRequestInfoVO> caseRequestInfoBusiExecute(String caseId, String flag);


    /**
     * 案件信息业务验证
     * @param caseId 案件Id
     * @param userId 仲裁员Id
     * @return
     */
    BusiValidResult caseInfoBusiValid(String caseId, String userId);


    /**
     * 案件答辩信息业务处理
     * @param caseId 案件Id
     * @param flag 请求标志，0- 正请求，1-反请求
     * @return
     */
    BusiExecuteResult<ArbitratorCaseReplyInfoVO> caseReplyInfoBusiExecute(String caseId, String flag);
    
    
    /**
     * 案件变更仲裁请求信息业务处理
     * @param caseId 案件Id
     * @param flag 请求标志，0- 正请求，1-反请求
     * @return 
     */
    BusiExecuteResult<List<ChangeRequestContentVO>> changeRequestBusiExecute(String caseId, String flag);
    
    /**
     * 案件变更仲裁请求答辩信息业务处理
     * @param caseId 案件Id
     * @param flag 请求标志，0- 正请求，1-反请求
     * @return 
     */
    BusiExecuteResult<List<ArbitratorCaseReplyInfoVO>> changeDebateRequestBusiExecute(String caseId, String flag);

    /**
     * 举证信息业务处理
     * @param caseId 案件Id
     * @param createrType matType
     * @return 
     */
    BusiExecuteResult<List<EvidenceVO>> caseProofBusiExecute(String caseId);



    /**
     * 案件裁决信息业务处理
     * @param caseId 案件Id
     * @return
     */
    BusiExecuteResult<CaseArbitrationInfoVO> caseArbitrationInfoBusiExecute(String caseId);

    /**
     * 查询指定案件补正列表
     * @param caseId 案件ID
     * @return 指定案件补正列表
     */
    BusiExecuteResult amendmentInfoBusiExecute(String caseId);

    /**
     * 查询辩论记录列表业务处理
     * @param caseId
     * @return
     */
    BusiExecuteResult<PageInfo<ArgueRecord>> argueRecordListBusiExecute(String caseId);
}
