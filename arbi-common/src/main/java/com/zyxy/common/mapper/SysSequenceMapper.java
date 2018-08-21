package com.zyxy.common.mapper;

import com.zyxy.common.domain.SysSequence;
import com.zyxy.common.domain.SysSequenceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysSequenceMapper {

    /**
     * sys_sequence
     * @mbggenerated
     */
    int countByExample(SysSequenceExample example);

    /**
     * sys_sequence
     * @mbggenerated
     */
    int deleteByExample(SysSequenceExample example);

    /**
     * sys_sequence
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * sys_sequence
     * @mbggenerated
     */
    int insert(SysSequence record);

    /**
     * sys_sequence
     * @mbggenerated
     */
    int insertSelective(SysSequence record);

    /**
     * sys_sequence
     * @mbggenerated
     */
    List<SysSequence> selectByExample(SysSequenceExample example);

    /**
     * sys_sequence
     * @mbggenerated
     */
    SysSequence selectByPrimaryKey(String id);

    /**
     * sys_sequence
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysSequence record,
            @Param("example") SysSequenceExample example);

    /**
     * sys_sequence
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysSequence record,
            @Param("example") SysSequenceExample example);

    /**
     * sys_sequence
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysSequence record);

    /**
     * sys_sequence
     * @mbggenerated
     */
    int updateByPrimaryKey(SysSequence record);

    /**
     * 序列号 +1
     * @param id
     * @return
     */
    int increaseByPrimaryKey(String id);
}