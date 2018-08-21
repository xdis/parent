package com.zyxy.common.mapper;

import com.zyxy.common.domain.ArbitratorChangeProfileRecord;
import com.zyxy.common.domain.ArbitratorChangeProfileRecordExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ArbitratorChangeProfileRecordMapper {
    /**
     * arbitrator_change_profile_record
     *
     * @mbggenerated
     */
    int countByExample(ArbitratorChangeProfileRecordExample example);

    /**
     * arbitrator_change_profile_record
     *
     * @mbggenerated
     */
    int deleteByExample(ArbitratorChangeProfileRecordExample example);

    /**
     * arbitrator_change_profile_record
     *
     * @mbggenerated
     */
    int insert(ArbitratorChangeProfileRecord record);

    /**
     * arbitrator_change_profile_record
     *
     * @mbggenerated
     */
    int insertSelective(ArbitratorChangeProfileRecord record);

    /**
     * arbitrator_change_profile_record
     *
     * @mbggenerated
     */
    List<ArbitratorChangeProfileRecord> selectByExample(ArbitratorChangeProfileRecordExample example);

    /**
     * arbitrator_change_profile_record
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ArbitratorChangeProfileRecord record, @Param("example") ArbitratorChangeProfileRecordExample example);

    /**
     * arbitrator_change_profile_record
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ArbitratorChangeProfileRecord record, @Param("example") ArbitratorChangeProfileRecordExample example);
    
    /**
     * 更新修改状态
     * @param status
     * @return
     */
    int updateStatus(@Param("status") String status,@Param("id") String id);
}