package com.zyxy.common.mapper;

import com.zyxy.common.domain.CaseArbitralProcessRecord;
import com.zyxy.common.domain.CaseArbitralProcessRecordExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CaseArbitralProcessRecordMapper {
    /**
     * case_arbitral_process_record
     *
     * @mbggenerated
     */
    int countByExample(CaseArbitralProcessRecordExample example);

    /**
     * case_arbitral_process_record
     *
     * @mbggenerated
     */
    int deleteByExample(CaseArbitralProcessRecordExample example);

    /**
     * case_arbitral_process_record
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * case_arbitral_process_record
     *
     * @mbggenerated
     */
    int insert(CaseArbitralProcessRecord record);

    /**
     * case_arbitral_process_record
     *
     * @mbggenerated
     */
    int insertSelective(CaseArbitralProcessRecord record);

    /**
     * case_arbitral_process_record
     *
     * @mbggenerated
     */
    List<CaseArbitralProcessRecord> selectByExample(CaseArbitralProcessRecordExample example);

    /**
     * case_arbitral_process_record
     *
     * @mbggenerated
     */
    CaseArbitralProcessRecord selectByPrimaryKey(String id);

    /**
     * case_arbitral_process_record
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") CaseArbitralProcessRecord record, @Param("example") CaseArbitralProcessRecordExample example);

    /**
     * case_arbitral_process_record
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") CaseArbitralProcessRecord record, @Param("example") CaseArbitralProcessRecordExample example);

    /**
     * case_arbitral_process_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CaseArbitralProcessRecord record);

    /**
     * case_arbitral_process_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CaseArbitralProcessRecord record);
}