package com.zyxy.common.mapper;

import com.zyxy.common.domain.ApiOrgnazation;
import com.zyxy.common.domain.ApiOrgnazationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApiOrgnazationMapper {

    /**
     * api_orgnazation
     * @mbggenerated
     */
    int countByExample(ApiOrgnazationExample example);

    /**
     * api_orgnazation
     * @mbggenerated
     */
    int deleteByExample(ApiOrgnazationExample example);

    /**
     * api_orgnazation
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * api_orgnazation
     * @mbggenerated
     */
    int insert(ApiOrgnazation record);

    /**
     * api_orgnazation
     * @mbggenerated
     */
    int insertSelective(ApiOrgnazation record);

    /**
     * api_orgnazation
     * @mbggenerated
     */
    List<ApiOrgnazation> selectByExample(ApiOrgnazationExample example);

    /**
     * api_orgnazation
     * @mbggenerated
     */
    ApiOrgnazation selectByPrimaryKey(String id);

    /**
     * api_orgnazation
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ApiOrgnazation record,
            @Param("example") ApiOrgnazationExample example);

    /**
     * api_orgnazation
     * @mbggenerated
     */
    int updateByExample(@Param("record") ApiOrgnazation record,
            @Param("example") ApiOrgnazationExample example);

    /**
     * api_orgnazation
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ApiOrgnazation record);

    /**
     * api_orgnazation
     * @mbggenerated
     */
    int updateByPrimaryKey(ApiOrgnazation record);
}