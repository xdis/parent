package com.zyxy.service.micro.core.service;

import com.zyxy.common.dto.CaseDocDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.CaseDocVO;

/**
 * 案件文书service
 */
public interface CaseDocService {

    /**
     * 查询案件文书业务处理
     * @param caseId
     * @param userId
     * @return
     */
    BusiExecuteResult<CaseDocVO> queryCaseDocBusiExecute(String caseId,String userId);
    
    /**
     * 案件所有有效文书业务验证
     * @param caseId
     * @param userId
     * @return
     */
    BusiValidResult caseDocListBusiValid(String caseId,String userId);
    
    /**
     * 案件所有有效文书业务处理
     * @param caseId
     * @param userId
     * @return
     */
    BusiExecuteResult<?> caseDocListBusiExecute(String caseId,String userId);


    /**
     * 生成仲裁申请书
     * @param caseId
     * @return
     */
    BusiExecuteResult<String> generationapplicationArbitrationDoc(String caseId, String userId);

    /**
     * 生成仲裁裁决书
     * @param caseId
     * @param userId
     * @return
     */
    BusiExecuteResult<String> generationAdjudicationArbitrationDoc(String caseId, String userId);

    /**
     *变更仲裁请求申请书
     * @param caseId
     * @param userId
     * @param changeId
     * @return
     */
    public BusiExecuteResult<?> generationChangeapplicationArbitrationDoc(String caseId,String userId,String changeId);

    /**
     * 反请求申请书
     * @param caseId
     * @return
     */
    public BusiExecuteResult<?> generateApplicationforCounterclaimDoc(String caseId);

    /**
     * 变更仲裁反请求申请书
     * @param caseId
     * @return
     */
    public BusiExecuteResult<?> generateChangeApplicationforCounterclaimDoc(String caseId);


    /**
     * 仲裁答辩书
     * @param caseId
     * @return
     */
    public BusiExecuteResult<?> generateWrittenDefenseArbitrationDoc(String caseId);

    /**
     * 变更仲裁请求答辩书
     * @param caseId
     * @return
     */
    public BusiExecuteResult<?> generateChangeWrittenDefenseArbitrationDoc(String caseId);

    /**
     * 仲裁反请求答辩书
     * @param caseId
     * @return
     */
    public BusiExecuteResult<?> generateCounterclaimArbitrationDoc(String caseId);

    /**
     * 变更仲裁反请求答辩书
     * @param caseId
     * @return
     */
    public BusiExecuteResult<?> generateChanageCounterclaimArbitrationDoc(String caseId);

    /**
     * 受理通知书 to 申请人
     * @param caseId
     * @return
     */
    public BusiExecuteResult<?> generateNoticeActionDoc(String caseId);

    /**
     * 受理通知书 to 被申请人
     * @param caseId
     * @return
     */
    public BusiExecuteResult<?> generateNoticeActionToDefentDoc(String caseId);

    /**
     * 变更仲裁请求受理通知书 to 申请人
     * @param caseId
     * @param changeId
     * @return
     */
    public BusiExecuteResult<?> generateChangeNoticeActionDoc(String caseId,String changeId);

    /**
     * 变更仲裁请求受理通知书 to 被申请人
     * @param caseId
     * @param changeId
     * @return
     */
    public BusiExecuteResult<?> generateChangeNoticeActionToDefentDoc(String caseId,String changeId);

    /**
     * 反请求受理通知书 to 被申请人
     * @param caseId
     * @param requestId
     * @return
     */
    public BusiExecuteResult<?> generateCounterclaimNoticeActionToDefentDoc(String caseId,String requestId);

    /**
     * 反请求受理通知书 to 申请人
     * @param caseId
     * @param requestId
     * @return
     */
    public BusiExecuteResult<?> generateCounterclaimNoticeActionDoc(String caseId,String requestId);


    /**
     * 不受理本请求通知书
     * @param caseId
     * @param requestId
     * @return
     */
    public BusiExecuteResult<?> generateNoticeNonAdmissibilityDoc(String caseId,String requestId);

    /**
     * 不受理变更仲裁请求通知书 to 申请人
     * @return
     */
    public BusiExecuteResult<?> generateChangeNoticeNonAdmissibilityDoc(String caseId,String changeId);


    /**
     * 不受理反请求通知书 to 被申请人
     * @return
     */
    public BusiExecuteResult<?> generateDefentNoticeNonAdmissibilityDoc(String caseId,String requestId);

    /**
     * 不受理变更反请求通知书 to 申请人
     * @return
     */
    public BusiExecuteResult<?> generateChangeDefentNoticeNonAdmissibilityDoc(String caseId,String changeId);

    /**
     * 调解书生成
     * @param caseId
     * @return
     */
    public BusiExecuteResult<?> generateConciliationStatementDoc(String caseId);

    /**
     * 管辖权异议文书（本请求）
     * @param caseId
     * @return
     */
    public BusiExecuteResult<?> generateJurisdictionMeaningDoc(String caseId,String id);

    /**
     * 管辖权异议文书（反请求）
     * @param caseId
     * @return
     */
    public BusiExecuteResult<?> generateDefentJurisdictionMeaningDoc(String caseId,String id);


}
