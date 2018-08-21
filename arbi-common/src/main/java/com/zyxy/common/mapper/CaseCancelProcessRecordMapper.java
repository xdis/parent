package com.zyxy.common.mapper;

import com.zyxy.common.domain.CaseCancelProcessRecord;
import com.zyxy.common.domain.CaseCancelProcessRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CaseCancelProcessRecordMapper {
    /**
     * case_cancel_process_record
     *
     * @mbggenerated
     */
    int countByExample(CaseCancelProcessRecordExample example);

    /**
     * case_cancel_process_record
     *
     * @mbggenerated
     */
    int deleteByExample(CaseCancelProcessRecordExample example);

    /**
     * case_cancel_process_record
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * case_cancel_process_record
     *
     * @mbggenerated
     */
    int insert(CaseCancelProcessRecord record);

    /**
     * case_cancel_process_record
     *
     * @mbggenerated
     */
    int insertSelective(CaseCancelProcessRecord record);

    /**
     * case_cancel_process_record
     *
     * @mbggenerated
     */
    List<CaseCancelProcessRecord> selectByExampleWithBLOBs(CaseCancelProcessRecordExample example);

    /**
     * case_cancel_process_record
     *
     * @mbggenerated
     */
    List<CaseCancelProcessRecord> selectByExample(CaseCancelProcessRecordExample example);

    /**
     * case_cancel_process_record
     *
     * @mbggenerated
     */
    CaseCancelProcessRecord selectByPrimaryKey(String id);

    /**
     * case_cancel_process_record
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") CaseCancelProcessRecord record, @Param("example") CaseCancelProcessRecordExample example);

    /**
     * case_cancel_process_record
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") CaseCancelProcessRecord record, @Param("example") CaseCancelProcessRecordExample example);

    /**
     * case_cancel_process_record
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") CaseCancelProcessRecord record, @Param("example") CaseCancelProcessRecordExample example);

    /**
     * case_cancel_process_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CaseCancelProcessRecord record);

    /**
     * case_cancel_process_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(CaseCancelProcessRecord record);

    /**
     * case_cancel_process_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CaseCancelProcessRecord record);
}