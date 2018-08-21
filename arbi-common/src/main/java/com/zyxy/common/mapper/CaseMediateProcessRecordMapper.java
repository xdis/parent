package com.zyxy.common.mapper;

import com.zyxy.common.domain.CaseMediateProcessRecord;
import com.zyxy.common.domain.CaseMediateProcessRecordExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CaseMediateProcessRecordMapper {
    /**
     * case_mediate_process_record
     *
     * @mbggenerated
     */
    int countByExample(CaseMediateProcessRecordExample example);

    /**
     * case_mediate_process_record
     *
     * @mbggenerated
     */
    int deleteByExample(CaseMediateProcessRecordExample example);

    /**
     * case_mediate_process_record
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * case_mediate_process_record
     *
     * @mbggenerated
     */
    int insert(CaseMediateProcessRecord record);

    /**
     * case_mediate_process_record
     *
     * @mbggenerated
     */
    int insertSelective(CaseMediateProcessRecord record);

    /**
     * case_mediate_process_record
     *
     * @mbggenerated
     */
    List<CaseMediateProcessRecord> selectByExample(CaseMediateProcessRecordExample example);

    /**
     * case_mediate_process_record
     *
     * @mbggenerated
     */
    CaseMediateProcessRecord selectByPrimaryKey(String id);

    /**
     * case_mediate_process_record
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") CaseMediateProcessRecord record, @Param("example") CaseMediateProcessRecordExample example);

    /**
     * case_mediate_process_record
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") CaseMediateProcessRecord record, @Param("example") CaseMediateProcessRecordExample example);

    /**
     * case_mediate_process_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CaseMediateProcessRecord record);

    /**
     * case_mediate_process_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CaseMediateProcessRecord record);
}