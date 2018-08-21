package com.zyxy.common.mapper;

import com.zyxy.common.domain.SignCreateOrganizationLog;
import com.zyxy.common.domain.SignCreateOrganizationLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SignCreateOrganizationLogMapper {
    /**
     * sign_create_organization_log
     *
     * @mbggenerated
     */
    int countByExample(SignCreateOrganizationLogExample example);

    /**
     * sign_create_organization_log
     *
     * @mbggenerated
     */
    int deleteByExample(SignCreateOrganizationLogExample example);

    /**
     * sign_create_organization_log
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * sign_create_organization_log
     *
     * @mbggenerated
     */
    int insert(SignCreateOrganizationLog record);

    /**
     * sign_create_organization_log
     *
     * @mbggenerated
     */
    int insertSelective(SignCreateOrganizationLog record);

    /**
     * sign_create_organization_log
     *
     * @mbggenerated
     */
    List<SignCreateOrganizationLog> selectByExampleWithBLOBs(SignCreateOrganizationLogExample example);

    /**
     * sign_create_organization_log
     *
     * @mbggenerated
     */
    List<SignCreateOrganizationLog> selectByExample(SignCreateOrganizationLogExample example);

    /**
     * sign_create_organization_log
     *
     * @mbggenerated
     */
    SignCreateOrganizationLog selectByPrimaryKey(String id);

    /**
     * sign_create_organization_log
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SignCreateOrganizationLog record, @Param("example") SignCreateOrganizationLogExample example);

    /**
     * sign_create_organization_log
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") SignCreateOrganizationLog record, @Param("example") SignCreateOrganizationLogExample example);

    /**
     * sign_create_organization_log
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SignCreateOrganizationLog record, @Param("example") SignCreateOrganizationLogExample example);

    /**
     * sign_create_organization_log
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SignCreateOrganizationLog record);

    /**
     * sign_create_organization_log
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(SignCreateOrganizationLog record);

    /**
     * sign_create_organization_log
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SignCreateOrganizationLog record);
}