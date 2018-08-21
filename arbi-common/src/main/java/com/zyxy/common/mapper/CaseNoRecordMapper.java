package com.zyxy.common.mapper;

import com.zyxy.common.domain.CaseNoRecord;
import com.zyxy.common.domain.CaseNoRecordExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CaseNoRecordMapper {
    /**
     * case_no_record
     *
     * @mbggenerated
     */
    int countByExample(CaseNoRecordExample example);

    /**
     * case_no_record
     *
     * @mbggenerated
     */
    int deleteByExample(CaseNoRecordExample example);

    /**
     * case_no_record
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * case_no_record
     *
     * @mbggenerated
     */
    int insert(CaseNoRecord record);

    /**
     * case_no_record
     *
     * @mbggenerated
     */
    int insertSelective(CaseNoRecord record);

    /**
     * case_no_record
     *
     * @mbggenerated
     */
    List<CaseNoRecord> selectByExample(CaseNoRecordExample example);

    /**
     * case_no_record
     *
     * @mbggenerated
     */
    CaseNoRecord selectByPrimaryKey(String id);

    /**
     * case_no_record
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") CaseNoRecord record, @Param("example") CaseNoRecordExample example);

    /**
     * case_no_record
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") CaseNoRecord record, @Param("example") CaseNoRecordExample example);

    /**
     * case_no_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CaseNoRecord record);

    /**
     * case_no_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CaseNoRecord record);
}