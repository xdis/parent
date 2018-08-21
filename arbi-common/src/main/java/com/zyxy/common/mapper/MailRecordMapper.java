package com.zyxy.common.mapper;

import com.zyxy.common.domain.MailRecord;
import com.zyxy.common.domain.MailRecordExample;
import com.zyxy.common.domain.MailRecordWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MailRecordMapper {

    /**
     * mail_record
     * @mbggenerated
     */
    int countByExample(MailRecordExample example);

    /**
     * mail_record
     * @mbggenerated
     */
    int deleteByExample(MailRecordExample example);

    /**
     * mail_record
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * mail_record
     * @mbggenerated
     */
    int insert(MailRecordWithBLOBs record);

    /**
     * mail_record
     * @mbggenerated
     */
    int insertSelective(MailRecordWithBLOBs record);

    /**
     * mail_record
     * @mbggenerated
     */
    List<MailRecordWithBLOBs> selectByExampleWithBLOBs(MailRecordExample example);

    /**
     * mail_record
     * @mbggenerated
     */
    List<MailRecord> selectByExample(MailRecordExample example);

    /**
     * mail_record
     * @mbggenerated
     */
    MailRecordWithBLOBs selectByPrimaryKey(String id);

    /**
     * mail_record
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") MailRecordWithBLOBs record,
            @Param("example") MailRecordExample example);

    /**
     * mail_record
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") MailRecordWithBLOBs record,
            @Param("example") MailRecordExample example);

    /**
     * mail_record
     * @mbggenerated
     */
    int updateByExample(@Param("record") MailRecord record,
            @Param("example") MailRecordExample example);

    /**
     * mail_record
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(MailRecordWithBLOBs record);

    /**
     * mail_record
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(MailRecordWithBLOBs record);

    /**
     * mail_record
     * @mbggenerated
     */
    int updateByPrimaryKey(MailRecord record);
}