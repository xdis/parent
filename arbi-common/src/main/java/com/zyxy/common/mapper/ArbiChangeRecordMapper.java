package com.zyxy.common.mapper;

import com.zyxy.common.domain.ArbiChangeRecord;
import com.zyxy.common.domain.ArbiChangeRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArbiChangeRecordMapper {
    /**
     * arbi_change_record
     *
     * @mbggenerated
     */
    int countByExample(ArbiChangeRecordExample example);

    /**
     * arbi_change_record
     *
     * @mbggenerated
     */
    int deleteByExample(ArbiChangeRecordExample example);

    /**
     * arbi_change_record
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * arbi_change_record
     *
     * @mbggenerated
     */
    int insert(ArbiChangeRecord record);

    /**
     * arbi_change_record
     *
     * @mbggenerated
     */
    int insertSelective(ArbiChangeRecord record);

    /**
     * arbi_change_record
     *
     * @mbggenerated
     */
    List<ArbiChangeRecord> selectByExampleWithBLOBs(ArbiChangeRecordExample example);

    /**
     * arbi_change_record
     *
     * @mbggenerated
     */
    List<ArbiChangeRecord> selectByExample(ArbiChangeRecordExample example);

    /**
     * arbi_change_record
     *
     * @mbggenerated
     */
    ArbiChangeRecord selectByPrimaryKey(Integer id);

    /**
     * arbi_change_record
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ArbiChangeRecord record, @Param("example") ArbiChangeRecordExample example);

    /**
     * arbi_change_record
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") ArbiChangeRecord record, @Param("example") ArbiChangeRecordExample example);

    /**
     * arbi_change_record
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ArbiChangeRecord record, @Param("example") ArbiChangeRecordExample example);

    /**
     * arbi_change_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ArbiChangeRecord record);

    /**
     * arbi_change_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(ArbiChangeRecord record);

    /**
     * arbi_change_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ArbiChangeRecord record);
}