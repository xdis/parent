package com.zyxy.common.mapper;

import com.zyxy.common.domain.SignSignatureLog;
import com.zyxy.common.domain.SignSignatureLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SignSignatureLogMapper {

    /**
     * sign_signature_log
     * @mbggenerated
     */
    int countByExample(SignSignatureLogExample example);

    /**
     * sign_signature_log
     * @mbggenerated
     */
    int deleteByExample(SignSignatureLogExample example);

    /**
     * sign_signature_log
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * sign_signature_log
     * @mbggenerated
     */
    int insert(SignSignatureLog record);

    /**
     * sign_signature_log
     * @mbggenerated
     */
    int insertSelective(SignSignatureLog record);

    /**
     * sign_signature_log
     * @mbggenerated
     */
    List<SignSignatureLog> selectByExampleWithBLOBs(
            SignSignatureLogExample example);

    /**
     * sign_signature_log
     * @mbggenerated
     */
    List<SignSignatureLog> selectByExample(SignSignatureLogExample example);

    /**
     * sign_signature_log
     * @mbggenerated
     */
    SignSignatureLog selectByPrimaryKey(String id);

    /**
     * sign_signature_log
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SignSignatureLog record,
            @Param("example") SignSignatureLogExample example);

    /**
     * sign_signature_log
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") SignSignatureLog record,
            @Param("example") SignSignatureLogExample example);

    /**
     * sign_signature_log
     * @mbggenerated
     */
    int updateByExample(@Param("record") SignSignatureLog record,
            @Param("example") SignSignatureLogExample example);

    /**
     * sign_signature_log
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SignSignatureLog record);

    /**
     * sign_signature_log
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(SignSignatureLog record);

    /**
     * sign_signature_log
     * @mbggenerated
     */
    int updateByPrimaryKey(SignSignatureLog record);
}