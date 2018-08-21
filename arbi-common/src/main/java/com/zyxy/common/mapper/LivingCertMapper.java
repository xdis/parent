package com.zyxy.common.mapper;

import com.zyxy.common.domain.LivingCert;
import com.zyxy.common.domain.LivingCertExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LivingCertMapper {
    /**
     * living_cert
     *
     * @mbggenerated
     */
    int countByExample(LivingCertExample example);

    /**
     * living_cert
     *
     * @mbggenerated
     */
    int deleteByExample(LivingCertExample example);

    /**
     * living_cert
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * living_cert
     *
     * @mbggenerated
     */
    int insert(LivingCert record);

    /**
     * living_cert
     *
     * @mbggenerated
     */
    int insertSelective(LivingCert record);

    /**
     * living_cert
     *
     * @mbggenerated
     */
    List<LivingCert> selectByExample(LivingCertExample example);

    /**
     * living_cert
     *
     * @mbggenerated
     */
    LivingCert selectByPrimaryKey(String id);

    /**
     * living_cert
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") LivingCert record, @Param("example") LivingCertExample example);

    /**
     * living_cert
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") LivingCert record, @Param("example") LivingCertExample example);

    /**
     * living_cert
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(LivingCert record);

    /**
     * living_cert
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(LivingCert record);
}