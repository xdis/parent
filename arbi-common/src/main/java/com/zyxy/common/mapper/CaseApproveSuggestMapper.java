package com.zyxy.common.mapper;

import com.zyxy.common.domain.CaseApproveSuggest;
import com.zyxy.common.domain.CaseApproveSuggestExample;
import com.zyxy.common.vo.ApproveRecordVO;
import com.zyxy.common.vo.CaseApproveSuggestVO;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CaseApproveSuggestMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_approve_suggest
	 * @mbggenerated
	 */
	int countByExample(CaseApproveSuggestExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_approve_suggest
	 * @mbggenerated
	 */
	int deleteByExample(CaseApproveSuggestExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_approve_suggest
	 * @mbggenerated
	 */
	int insert(CaseApproveSuggest record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_approve_suggest
	 * @mbggenerated
	 */
	int insertSelective(CaseApproveSuggest record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_approve_suggest
	 * @mbggenerated
	 */
	List<CaseApproveSuggest> selectByExampleWithBLOBs(
			CaseApproveSuggestExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_approve_suggest
	 * @mbggenerated
	 */
	List<CaseApproveSuggest> selectByExample(CaseApproveSuggestExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_approve_suggest
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") CaseApproveSuggest record,
			@Param("example") CaseApproveSuggestExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_approve_suggest
	 * @mbggenerated
	 */
	int updateByExampleWithBLOBs(@Param("record") CaseApproveSuggest record,
			@Param("example") CaseApproveSuggestExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_approve_suggest
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") CaseApproveSuggest record,
			@Param("example") CaseApproveSuggestExample example);

	/**
     * 根据案件id查询
     */
	List<ApproveRecordVO> selectApproveSuggestByCaseId(String caseId);
	
	/**
	 * 插入审批意见
	 * @param record
	 * @return
	 */
	int insertApproveSuggest(CaseApproveSuggest record);

    /**
     * 根据审批Id及身份查询意见
     *
     * @param approveId   审批Id
     * @param managerType 身份
     * @return
     */
    CaseApproveSuggest selectApproveSuggestByApproveIdAndManagerType(@Param("approveId") String approveId, @Param("managerType") String managerType);
  
    /**
     * 根据审批id查询审批意见 
     * @param approveId 审批id
     * @return 审批意见
     */
    List<CaseApproveSuggestVO> queryApproveSuggestsByApproveId(String approveId);

}