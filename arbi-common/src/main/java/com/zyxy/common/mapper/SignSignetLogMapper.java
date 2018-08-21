package com.zyxy.common.mapper;

import com.zyxy.common.domain.SignSignetLog;
import com.zyxy.common.domain.SignSignetLogExample;
import com.zyxy.common.domain.SignSignetLogWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SignSignetLogMapper {

    /**
     * sign_signet_log
     * @mbggenerated
     */
    int countByExample(SignSignetLogExample example);

    /**
     * sign_signet_log
     * @mbggenerated
     */
    int deleteByExample(SignSignetLogExample example);

    /**
     * sign_signet_log
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * sign_signet_log
     * @mbggenerated
     */
    int insert(SignSignetLogWithBLOBs record);

    /**
     * sign_signet_log
     * @mbggenerated
     */
    int insertSelective(SignSignetLogWithBLOBs record);

    /**
     * sign_signet_log
     * @mbggenerated
     */
    List<SignSignetLogWithBLOBs> selectByExampleWithBLOBs(
            SignSignetLogExample example);

    /**
     * sign_signet_log
     * @mbggenerated
     */
    List<SignSignetLog> selectByExample(SignSignetLogExample example);

    /**
     * sign_signet_log
     * @mbggenerated
     */
    SignSignetLogWithBLOBs selectByPrimaryKey(String id);

    /**
     * sign_signet_log
     * @mbggenerated
     */
    int updateByExampleSelective(
            @Param("record") SignSignetLogWithBLOBs record,
            @Param("example") SignSignetLogExample example);

    /**
     * sign_signet_log
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(
            @Param("record") SignSignetLogWithBLOBs record,
            @Param("example") SignSignetLogExample example);

    /**
     * sign_signet_log
     * @mbggenerated
     */
    int updateByExample(@Param("record") SignSignetLog record,
            @Param("example") SignSignetLogExample example);

    /**
     * sign_signet_log
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SignSignetLogWithBLOBs record);

    /**
     * sign_signet_log
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(SignSignetLogWithBLOBs record);

    /**
     * sign_signet_log
     * @mbggenerated
     */
    int updateByPrimaryKey(SignSignetLog record);
}