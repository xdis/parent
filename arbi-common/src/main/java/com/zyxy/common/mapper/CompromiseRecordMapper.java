package com.zyxy.common.mapper;

import com.zyxy.common.domain.CompromiseRecord;
import com.zyxy.common.domain.CompromiseRecordExample;

import java.util.List;

import com.zyxy.common.vo.ArgueRecordVO;
import com.zyxy.common.vo.CaseCompromiseRecordVO;
import com.zyxy.common.vo.CompromiseRecordVO;

import org.apache.ibatis.annotations.Param;

public interface CompromiseRecordMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table compromise_record
	 * @mbggenerated
	 */
	int countByExample(CompromiseRecordExample example);


	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table compromise_record
	 * @mbggenerated
	 */
	int deleteByExample(CompromiseRecordExample example);


	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table compromise_record
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(String id);


	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table compromise_record
	 * @mbggenerated
	 */
	int insert(CompromiseRecord record);


	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table compromise_record
	 * @mbggenerated
	 */
	int insertSelective(CompromiseRecord record);


	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table compromise_record
	 * @mbggenerated
	 */
	List<CompromiseRecord> selectByExampleWithBLOBs(
			CompromiseRecordExample example);


	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table compromise_record
	 * @mbggenerated
	 */
	List<CompromiseRecord> selectByExample(CompromiseRecordExample example);


	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table compromise_record
	 * @mbggenerated
	 */
	CompromiseRecord selectByPrimaryKey(String id);


	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table compromise_record
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") CompromiseRecord record,
			@Param("example") CompromiseRecordExample example);


	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table compromise_record
	 * @mbggenerated
	 */
	int updateByExampleWithBLOBs(@Param("record") CompromiseRecord record,
			@Param("example") CompromiseRecordExample example);


	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table compromise_record
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") CompromiseRecord record,
			@Param("example") CompromiseRecordExample example);


	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table compromise_record
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(CompromiseRecord record);


	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table compromise_record
	 * @mbggenerated
	 */
	int updateByPrimaryKeyWithBLOBs(CompromiseRecord record);


	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table compromise_record
	 * @mbggenerated
	 */
	int updateByPrimaryKey(CompromiseRecord record);


	/**
	 * 查询和解记录
	 * @param caseId
	 * @return
	 */
	List<CaseCompromiseRecordVO> queryCaseCompromiseRecordByCaseId(String caseId);


    /**
     * 仲裁委PC端查询和解记录
     * @param caseId
     * @return
     */
    List<CaseCompromiseRecordVO> queryCompromiseRecord(String caseId);
    
    /**
     * 根据案件ID查询沟通记录
     * @param caseId
     * @return
     */
    List<CompromiseRecordVO> selectCompromiseRecordList(String caseId);

	/**
	 * 根据案件ID查询沟通记录
	 *
	 * @param caseId
	 * @return
	 */
	List<ArgueRecordVO> queryArgueRecordVOByCaseId(String caseId);
}