package com.zyxy.common.mapper;

import com.zyxy.common.domain.RealNameAuthRecord;
import com.zyxy.common.domain.RealNameAuthRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RealNameAuthRecordMapper {

    /**
     * real_name_auth_record
     * @mbggenerated
     */
    int countByExample(RealNameAuthRecordExample example);

    /**
     * real_name_auth_record
     * @mbggenerated
     */
    int deleteByExample(RealNameAuthRecordExample example);

    /**
     * real_name_auth_record
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * real_name_auth_record
     * @mbggenerated
     */
    int insert(RealNameAuthRecord record);

    /**
     * real_name_auth_record
     * @mbggenerated
     */
    int insertSelective(RealNameAuthRecord record);

    /**
     * real_name_auth_record
     * @mbggenerated
     */
    List<RealNameAuthRecord> selectByExample(RealNameAuthRecordExample example);

    /**
     * real_name_auth_record
     * @mbggenerated
     */
    RealNameAuthRecord selectByPrimaryKey(String id);

    /**
     * real_name_auth_record
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") RealNameAuthRecord record,
            @Param("example") RealNameAuthRecordExample example);

    /**
     * real_name_auth_record
     * @mbggenerated
     */
    int updateByExample(@Param("record") RealNameAuthRecord record,
            @Param("example") RealNameAuthRecordExample example);

    /**
     * real_name_auth_record
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(RealNameAuthRecord record);

    /**
     * real_name_auth_record
     * @mbggenerated
     */
    int updateByPrimaryKey(RealNameAuthRecord record);
}