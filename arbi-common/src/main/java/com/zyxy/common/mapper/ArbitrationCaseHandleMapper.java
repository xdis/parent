package com.zyxy.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zyxy.common.dto.ArbitrationCaseDecisionHandleDTO;
import com.zyxy.common.vo.ArbitrationCaseAuditOpinionVO;
import com.zyxy.common.vo.ArbitrationCaseDecisionVO;
import com.zyxy.common.vo.ArbitrationCaseWithdrawApplyVO;

public interface ArbitrationCaseHandleMapper {
	/**
     * 查询撤案-申请书内容
     * @param caseId 案件id
     * @return
     */
    ArbitrationCaseWithdrawApplyVO queryCaseWithdrawApplyContent(@Param("caseId")String caseId,@Param("requestFlag")String requestFlag);
    
    /**
     * 查询撤案-决定书内容
     * @param caseId 案件id
     * @return
     */
    ArbitrationCaseDecisionVO queryCaseDecisionContent(@Param("caseId")String caseId,@Param("requestFlag")String requestFlag);
    
    /**
     * 查询撤案-仲裁委意见
     * @param caseId
     * @return
     */
    List<ArbitrationCaseAuditOpinionVO> queryCaseArbitrationSuggestion(@Param("caseId")String caseId);
    
    /**
     * 仲裁委-通过id查询职务
     * @param userId 用户id
     * @return
     */
    String queryDutiesById(String userId);
    
    /**
     * 通过案件id和用户id查询请求类型
     * @param caseId 案件id
     * @param userId 用户id
     * @return
     */
    String queryRequestTypeByCaseIdUserId(@Param("dto")ArbitrationCaseDecisionHandleDTO dto);
    
    /**
     * 通过caseId查询仲裁员id
     * @param caseId 案件id
     * @return
     */
    String queryArbitratorIdByCaseId(String caseId);
    
    /**
     * 查询撤案决定书ID
     * @param caseId 案件id
     * @return
     */
    String queryCaseDecisionDocId(String caseId);
    
    /**
     * 通过案件id查询出具仲裁决定书的仲裁秘书id
     * @param caseId 案件ID
     * @return
     */
    String queryArbitrationSecretaryByCaseId(String caseId);
    
    /**
     * 通过用户id查询姓名
     * @param userId 用户id
     * @return 用户姓名
     */
    String queryNameById(@Param("userId")String userId);
    
    /**
     * 通过案件id请求标志查询请求id
     * @param caseId 案件id
     * @param requestFlag 请求标志
     * @return 请求id
     */
    String queryRequestId(@Param("caseId")String caseId,@Param("requestFlag")String requestFlag);
    
    /**
     * 改变审批状态
     * @param caseId 案件id
     * @param approveType 审批类型
     * @param requestFlag 请求标志
     * @return 更新结果
     */
    int updateApproveStatus(@Param("caseId")String caseId,@Param("approveType")String approveType,@Param("requestFlag")String requestFlag,@Param("approveStatus")String status);
    
    /**
     * 修改当前审批人为上级仲裁委人员
     * @param caseId 案件id
     * @param approveType 审批类型
     * @param requestFlag 请求标志
     * @param currentApproveUser 当前审批用户
     * @return 更新结果
     */
    int updateApproveUserAsManager(@Param("caseId")String caseId,@Param("approveType")String approveType,@Param("requestFlag")String requestFlag,@Param("nextApproveUserDuties")String nextApproveUserDuties);
    
    /**
     * 修改当前审批人为仲裁秘书
     * @param caseId 案件id
     * @param approveType 审批类型
     * @param requestFlag 请求标志
     * @param currentApproveUser 当前审批用户
     * @return 更新结果
     */
    int updateApproveUserAsArbitrator(@Param("caseId")String caseId,@Param("approveType")String approveType,@Param("requestFlag")String requestFlag);
    
    /**
     * 查询组庭后文书审批的仲裁秘书
     * @param busiId 业务id
     * @return 仲裁秘书id
     */
    String querytribunalFinishedArbiSecretary(@Param("busiId")String busiId);
    
    /**
     * 查询文书出具人id
     * @param busiId 业务id
     * @return 出具人id
     */
    String queryCaseDocCreaterByBusiId(@Param("busiId")String busiId);
}
