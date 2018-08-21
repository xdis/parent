package com.zyxy.common.mapper;

import com.zyxy.common.domain.ArgueRecord;
import com.zyxy.common.domain.ArgueRecordExample;
import java.util.List;

import com.zyxy.common.vo.ArgueRecordVO;
import org.apache.ibatis.annotations.Param;

public interface ArgueRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table argue_record
     *
     * @mbggenerated
     */
    int countByExample(ArgueRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table argue_record
     *
     * @mbggenerated
     */
    int deleteByExample(ArgueRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table argue_record
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table argue_record
     *
     * @mbggenerated
     */
    int insert(ArgueRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table argue_record
     *
     * @mbggenerated
     */
    int insertSelective(ArgueRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table argue_record
     *
     * @mbggenerated
     */
    List<ArgueRecord> selectByExampleWithBLOBs(ArgueRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table argue_record
     *
     * @mbggenerated
     */
    List<ArgueRecord> selectByExample(ArgueRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table argue_record
     *
     * @mbggenerated
     */
    ArgueRecord selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table argue_record
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ArgueRecord record, @Param("example") ArgueRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table argue_record
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") ArgueRecord record, @Param("example") ArgueRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table argue_record
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ArgueRecord record, @Param("example") ArgueRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table argue_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ArgueRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table argue_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(ArgueRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table argue_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ArgueRecord record);

    List<ArgueRecordVO> queryArgueRecordVOByCaseId(@Param("caseId") String caseId);
}