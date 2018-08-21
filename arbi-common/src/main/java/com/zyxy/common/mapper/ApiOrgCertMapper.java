package com.zyxy.common.mapper;

import com.zyxy.common.domain.ApiOrgCert;
import com.zyxy.common.domain.ApiOrgCertExample;
import com.zyxy.common.domain.ApiOrgCertWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApiOrgCertMapper {

    /**
     * api_org_cert
     * @mbggenerated
     */
    int countByExample(ApiOrgCertExample example);

    /**
     * api_org_cert
     * @mbggenerated
     */
    int deleteByExample(ApiOrgCertExample example);

    /**
     * api_org_cert
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * api_org_cert
     * @mbggenerated
     */
    int insert(ApiOrgCertWithBLOBs record);

    /**
     * api_org_cert
     * @mbggenerated
     */
    int insertSelective(ApiOrgCertWithBLOBs record);

    /**
     * api_org_cert
     * @mbggenerated
     */
    List<ApiOrgCertWithBLOBs> selectByExampleWithBLOBs(ApiOrgCertExample example);

    /**
     * api_org_cert
     * @mbggenerated
     */
    List<ApiOrgCert> selectByExample(ApiOrgCertExample example);

    /**
     * api_org_cert
     * @mbggenerated
     */
    ApiOrgCertWithBLOBs selectByPrimaryKey(String id);

    /**
     * api_org_cert
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ApiOrgCertWithBLOBs record,
            @Param("example") ApiOrgCertExample example);

    /**
     * api_org_cert
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") ApiOrgCertWithBLOBs record,
            @Param("example") ApiOrgCertExample example);

    /**
     * api_org_cert
     * @mbggenerated
     */
    int updateByExample(@Param("record") ApiOrgCert record,
            @Param("example") ApiOrgCertExample example);

    /**
     * api_org_cert
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ApiOrgCertWithBLOBs record);

    /**
     * api_org_cert
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(ApiOrgCertWithBLOBs record);

    /**
     * api_org_cert
     * @mbggenerated
     */
    int updateByPrimaryKey(ApiOrgCert record);
}