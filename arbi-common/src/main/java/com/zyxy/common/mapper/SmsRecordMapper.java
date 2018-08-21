package com.zyxy.common.mapper;

import com.zyxy.common.domain.SmsRecord;
import com.zyxy.common.domain.SmsRecordExample;
import com.zyxy.common.domain.SmsRecordWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsRecordMapper {

    /**
     * sms_record
     * @mbggenerated
     */
    int countByExample(SmsRecordExample example);

    /**
     * sms_record
     * @mbggenerated
     */
    int deleteByExample(SmsRecordExample example);

    /**
     * sms_record
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * sms_record
     * @mbggenerated
     */
    int insert(SmsRecordWithBLOBs record);

    /**
     * sms_record
     * @mbggenerated
     */
    int insertSelective(SmsRecordWithBLOBs record);

    /**
     * sms_record
     * @mbggenerated
     */
    List<SmsRecordWithBLOBs> selectByExampleWithBLOBs(SmsRecordExample example);

    /**
     * sms_record
     * @mbggenerated
     */
    List<SmsRecord> selectByExample(SmsRecordExample example);

    /**
     * sms_record
     * @mbggenerated
     */
    SmsRecordWithBLOBs selectByPrimaryKey(String id);

    /**
     * sms_record
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SmsRecordWithBLOBs record,
            @Param("example") SmsRecordExample example);

    /**
     * sms_record
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") SmsRecordWithBLOBs record,
            @Param("example") SmsRecordExample example);

    /**
     * sms_record
     * @mbggenerated
     */
    int updateByExample(@Param("record") SmsRecord record,
            @Param("example") SmsRecordExample example);

    /**
     * sms_record
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SmsRecordWithBLOBs record);

    /**
     * sms_record
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(SmsRecordWithBLOBs record);

    /**
     * sms_record
     * @mbggenerated
     */
    int updateByPrimaryKey(SmsRecord record);
}