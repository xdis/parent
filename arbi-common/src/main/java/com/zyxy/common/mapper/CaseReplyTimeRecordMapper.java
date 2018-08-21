package com.zyxy.common.mapper;

import com.zyxy.common.domain.CaseReplyTimeRecord;
import com.zyxy.common.domain.CaseReplyTimeRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CaseReplyTimeRecordMapper {
    /**
     * case_reply_time_record
     *
     * @mbggenerated
     */
    int countByExample(CaseReplyTimeRecordExample example);

    /**
     * case_reply_time_record
     *
     * @mbggenerated
     */
    int deleteByExample(CaseReplyTimeRecordExample example);

    /**
     * case_reply_time_record
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * case_reply_time_record
     *
     * @mbggenerated
     */
    int insert(CaseReplyTimeRecord record);

    /**
     * case_reply_time_record
     *
     * @mbggenerated
     */
    int insertSelective(CaseReplyTimeRecord record);

    /**
     * case_reply_time_record
     *
     * @mbggenerated
     */
    List<CaseReplyTimeRecord> selectByExample(CaseReplyTimeRecordExample example);

    /**
     * case_reply_time_record
     *
     * @mbggenerated
     */
    CaseReplyTimeRecord selectByPrimaryKey(String id);

    /**
     * case_reply_time_record
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") CaseReplyTimeRecord record, @Param("example") CaseReplyTimeRecordExample example);

    /**
     * case_reply_time_record
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") CaseReplyTimeRecord record, @Param("example") CaseReplyTimeRecordExample example);

    /**
     * case_reply_time_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CaseReplyTimeRecord record);

    /**
     * case_reply_time_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CaseReplyTimeRecord record);

    CaseReplyTimeRecord selectCaseReplyTimeInfo(CaseReplyTimeRecord caseReplyTimeRecord);

    int updateReplyTime(@Param("caseId") String caseId, @Param("day") Long day);
}