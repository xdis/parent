package com.zyxy.common.mapper;

import com.zyxy.common.domain.AdjudicationAmendmentRecord;
import com.zyxy.common.domain.AdjudicationAmendmentRecordExample;
import com.zyxy.common.domain.AdjudicationAmendmentRecordWithBLOBs;
import com.zyxy.common.dto.AdjudicationAmendmentDTO;
import com.zyxy.common.vo.AdjudicationAmendApplyDocVO;
import com.zyxy.common.vo.AdjudicationAmendmentVO;
import com.zyxy.common.vo.HistoryAmendRecordVO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AdjudicationAmendmentRecordMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table adjudication_amendment_record
	 * @mbggenerated
	 */
	int countByExample(AdjudicationAmendmentRecordExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table adjudication_amendment_record
	 * @mbggenerated
	 */
	int deleteByExample(AdjudicationAmendmentRecordExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table adjudication_amendment_record
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table adjudication_amendment_record
	 * @mbggenerated
	 */
	int insert(AdjudicationAmendmentRecordWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table adjudication_amendment_record
	 * @mbggenerated
	 */
	int insertSelective(AdjudicationAmendmentRecordWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table adjudication_amendment_record
	 * @mbggenerated
	 */
	List<AdjudicationAmendmentRecordWithBLOBs> selectByExampleWithBLOBs(
			AdjudicationAmendmentRecordExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table adjudication_amendment_record
	 * @mbggenerated
	 */
	List<AdjudicationAmendmentRecord> selectByExample(
			AdjudicationAmendmentRecordExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table adjudication_amendment_record
	 * @mbggenerated
	 */
	AdjudicationAmendmentRecordWithBLOBs selectByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table adjudication_amendment_record
	 * @mbggenerated
	 */
	int updateByExampleSelective(
			@Param("record") AdjudicationAmendmentRecordWithBLOBs record,
			@Param("example") AdjudicationAmendmentRecordExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table adjudication_amendment_record
	 * @mbggenerated
	 */
	int updateByExampleWithBLOBs(
			@Param("record") AdjudicationAmendmentRecordWithBLOBs record,
			@Param("example") AdjudicationAmendmentRecordExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table adjudication_amendment_record
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdjudicationAmendmentRecord record,
			@Param("example") AdjudicationAmendmentRecordExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table adjudication_amendment_record
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(AdjudicationAmendmentRecordWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table adjudication_amendment_record
	 * @mbggenerated
	 */
	int updateByPrimaryKeyWithBLOBs(AdjudicationAmendmentRecordWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table adjudication_amendment_record
	 * @mbggenerated
	 */
	int updateByPrimaryKey(AdjudicationAmendmentRecord record);

	/**
     *  查询指定案件补正记录 -->
     * @param map  caseId,requestFlag本请求
     * @return 指定被申请方案件补正记录列表
     */
    List<AdjudicationAmendmentVO> amendmentEvaluation(Map<String,String> map);
    
    /**
     * 更新裁决补正书状态
     * @param approveId 审批id
     * @param amendStatus 补正状态
     * @return
     */
    int updateAmendStatus(@Param("approveId")String approveId,@Param("amendStatus")String amendStatus);
    
    /**
     * 查询有效的裁决补正记录
     * @param caseId 案件id
     * @return 裁决补正记录列表
     */
    List<HistoryAmendRecordVO> queryValidAdjudicationAmendmentHistoryRecord(@Param("caseId")String caseId,@Param("id")String id);

    /**
     * 查询补正记录
     * @param formData 
     * @return 裁决补正记录列表
     */
	List<AdjudicationAmendmentRecordWithBLOBs> queryAdjudicationAmendment(AdjudicationAmendmentDTO formData);

    /**
     * 查询补正记录
     * @param formData 
     * @return 裁决补正记录列表
     */
	List<AdjudicationAmendmentRecordWithBLOBs> queryAdjudicationAmendment(AdjudicationAmendmentDTO formData);

    /**
     * 查询补正记录
     * @param formData 
     * @return 裁决补正记录列表
     */
	List<AdjudicationAmendmentRecordWithBLOBs> queryAdjudicationAmendment(AdjudicationAmendmentDTO formData);

    /**
     * 查询补正记录
     * @param formData 
     * @return 裁决补正记录列表
     */
	List<AdjudicationAmendmentRecordWithBLOBs> queryAdjudicationAmendment(AdjudicationAmendmentDTO formData);
}