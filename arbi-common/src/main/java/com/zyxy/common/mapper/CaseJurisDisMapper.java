package com.zyxy.common.mapper;

import com.zyxy.common.domain.CaseJurisDis;
import com.zyxy.common.domain.CaseJurisDisExample;
import com.zyxy.common.domain.CaseJurisDisWithBLOBs;

import java.util.List;

import com.zyxy.common.vo.ArbiCaseJurisDisVO;
import com.zyxy.common.vo.CaseJurisDisVO;
import com.zyxy.common.vo.JurisdictionObjectionApplyDocVO;
import com.zyxy.common.vo.JurisdictionObjectionFeedbackDocVO;

import org.apache.ibatis.annotations.Param;

public interface CaseJurisDisMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_juris_dis
	 * @mbggenerated
	 */
	int countByExample(CaseJurisDisExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_juris_dis
	 * @mbggenerated
	 */
	int deleteByExample(CaseJurisDisExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_juris_dis
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_juris_dis
	 * @mbggenerated
	 */
	int insert(CaseJurisDisWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_juris_dis
	 * @mbggenerated
	 */
	int insertSelective(CaseJurisDisWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_juris_dis
	 * @mbggenerated
	 */
	List<CaseJurisDisWithBLOBs> selectByExampleWithBLOBs(
			CaseJurisDisExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_juris_dis
	 * @mbggenerated
	 */
	List<CaseJurisDis> selectByExample(CaseJurisDisExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_juris_dis
	 * @mbggenerated
	 */
	CaseJurisDisWithBLOBs selectByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_juris_dis
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") CaseJurisDisWithBLOBs record,
			@Param("example") CaseJurisDisExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_juris_dis
	 * @mbggenerated
	 */
	int updateByExampleWithBLOBs(@Param("record") CaseJurisDisWithBLOBs record,
			@Param("example") CaseJurisDisExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_juris_dis
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") CaseJurisDis record,
			@Param("example") CaseJurisDisExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_juris_dis
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(CaseJurisDisWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_juris_dis
	 * @mbggenerated
	 */
	int updateByPrimaryKeyWithBLOBs(CaseJurisDisWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table case_juris_dis
	 * @mbggenerated
	 */
	int updateByPrimaryKey(CaseJurisDis record);

	/**
     * 查询出管辖权异议
     * @param caseId
     * @param counterclaimFlag
     * @return
     */
    CaseJurisDisVO queryCaseJurisDisByCaseId(@Param("caseId") String caseId, @Param("counterclaimFlag") String counterclaimFlag);

	/**
	 * 查询出管辖权异议基本对象
	 * @param caseId
	 * @param requestType
	 * @return
	 */
	ArbiCaseJurisDisVO selectCaseJurisDisByCaseIdAndRequestType(@Param("caseId")String caseId,@Param("requestType")String requestType);
	
	
	/**
	 * 查询管辖权申请书
	 * @param caseId
	 * @param requestType
	 * @return
	 */
	JurisdictionObjectionApplyDocVO selectJurisdictionObjectionApplyDoc(@Param("caseId")String caseId,@Param("requestType")String requestType);
	
	/**
	 * 查询管辖权回应书
	 * @param caseId
	 * @param requestType
	 * @return
	 */
	JurisdictionObjectionFeedbackDocVO selectJurisdictionObjectionFeedbackDoc(@Param("caseId")String caseId,@Param("requestType")String requestType);
	
}