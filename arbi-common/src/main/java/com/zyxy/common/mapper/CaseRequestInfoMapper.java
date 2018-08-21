package com.zyxy.common.mapper;

import com.zyxy.common.domain.CaseRequestInfo;
import com.zyxy.common.domain.CaseRequestInfoExample;
import com.zyxy.common.domain.CaseRequestInfoWithBLOBs;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.zyxy.common.vo.ArbitrationApplyDocVO;
import com.zyxy.common.vo.CaseRequestInfoVO;

import org.apache.ibatis.annotations.Param;

public interface CaseRequestInfoMapper {
    /**
     * case_request_info
     *
     * @mbggenerated
     */
    int countByExample(CaseRequestInfoExample example);

    /**
     * case_request_info
     *
     * @mbggenerated
     */
    int deleteByExample(CaseRequestInfoExample example);

    /**
     * case_request_info
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * case_request_info
     *
     * @mbggenerated
     */
    int insert(CaseRequestInfoWithBLOBs record);

    /**
     * case_request_info
     *
     * @mbggenerated
     */
    int insertSelective(CaseRequestInfoWithBLOBs record);

    /**
     * case_request_info
     *
     * @mbggenerated
     */
    List<CaseRequestInfoWithBLOBs> selectByExampleWithBLOBs(CaseRequestInfoExample example);

    /**
     * case_request_info
     *
     * @mbggenerated
     */
    List<CaseRequestInfo> selectByExample(CaseRequestInfoExample example);

    /**
     * case_request_info
     *
     * @mbggenerated
     */
    CaseRequestInfoWithBLOBs selectByPrimaryKey(String id);

    /**
     * case_request_info
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") CaseRequestInfoWithBLOBs record, @Param("example") CaseRequestInfoExample example);

    /**
     * case_request_info
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") CaseRequestInfoWithBLOBs record, @Param("example") CaseRequestInfoExample example);

    /**
     * case_request_info
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") CaseRequestInfo record, @Param("example") CaseRequestInfoExample example);

    /**
     * case_request_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CaseRequestInfoWithBLOBs record);

    /**
     * case_request_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(CaseRequestInfoWithBLOBs record);

    /**
     * case_request_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CaseRequestInfo record);


    /**
     * 根据案件id查询被申请人用户ID
     * @return
     */
    String selectDefendantUserIdByCaseId(String caseId);

    /**
     * 根据参数查询代理USER_ID
     * @param caseId
     * @param litigantType
     * @return
     */
    String selectAgentUserIdByParam(@Param("caseId") String caseId,@Param("litigantType") String litigantType);


    /**
     * 根据案件id和请求类型查询出涉案金额等金额
     * @param caseId
     * @param requestType
     * @return
     */
    CaseRequestInfoVO queryAmountByCaseId(@Param("caseId")String caseId,@Param("requestType")String requestType);


    CaseRequestInfo selectRequestByParam(CaseRequestInfo caseRequestInfo);

    CaseRequestInfoWithBLOBs selectRequestInfoByParam(CaseRequestInfo caseRequestInfo);

    /**
	 * 将仲裁费用更新到请求表中
	 * @param approveId 审批Id 根据审批Id查询请求id
	 * @param amounts 涉案金额
	 * @param Handling 处理费
	 * @param theFeeFor 受理费
	 * @param behaviorCharges 行为费
	 * @return 将仲裁费用更新到请求表中
	 */
	int uqdateArbitrationFee(@Param("approveId") String approveId,@Param("amounts") BigDecimal amounts,@Param("Handling") BigDecimal Handling,
			@Param("theFeeFor") BigDecimal theFeeFor,@Param("payId") String payId,@Param("behaviorCharges") BigDecimal behaviorCharges);
	
	/**
	 * 将缴费截止时间更新到数据库
	 * @param approveId 审批Id
	 * @param payEndTime 缴费截止时间
	 * @return
	 */
	int uqdatePayEndTime(@Param("approveId") String approveId,@Param("payEndTime") Date payEndTime);
	
	/**
	 * 查询仲裁申请书内容
	 * @param caseId
	 * @param requsetType
	 * @return
	 */
	ArbitrationApplyDocVO selectArbitrationInfo(@Param("caseId")String caseId,@Param("requsetType")String requsetType);
	
	/**
	 * 通过caseId查询立案成功的案件请求信息(包括正反请求)
	 * @param caseId 案件id
	 * @return 案件基本信息
	 */
	List<CaseRequestInfo> selectCaseRequestInfoByCaseId(String caseId);
}