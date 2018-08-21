package com.zyxy.admin.service;

import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ArbitratorCaseBaseInfoVO;
import com.zyxy.common.vo.AuthorizationDelegateVO;

/**
 * 仲裁委案件关系
 */
public interface CaseManagerService {

    /**
     * 仲裁委案件关系业务验证
     * @param caseId
     * @param userId
     * @return
     */
    BusiValidResult caseRequestInfoBusiValid(String caseId, String userId);


    /**
     * 案件基本信息业务处理
     * @param caseId 案件Id
     * @param userId 仲裁员Id
     * @return
     */
    BusiExecuteResult<ArbitratorCaseBaseInfoVO> caseBaseInfoBusiExecute(String caseId, String userId, String requestFlag);


    /**
     * 根据案件id和用户id查询出该案件是否属于该仲裁委工作人员
     * @param caseId
     * @param userId
     * @return
     */
    boolean queryCaseManagerInfo(String caseId,String userId);

    /**
     * 查询授权情况
     * @param caseId
     * @param userId
     * @param approveType
     * @return
     */
    AuthorizationDelegateVO queryAuthorizationDelegateDuties(String caseId, String userId, String approveType);
}
