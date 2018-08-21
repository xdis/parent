package com.zyxy.common.mapper;

import com.zyxy.common.domain.LitigantInfo;
import com.zyxy.common.domain.LitigantInfoExample;
import com.zyxy.common.vo.UserBaseInfoVO;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface LitigantInfoMapper {
    /**
     * litigant_info
     *
     * @mbggenerated
     */
    int countByExample(LitigantInfoExample example);

    /**
     * litigant_info
     *
     * @mbggenerated
     */
    int deleteByExample(LitigantInfoExample example);

    /**
     * litigant_info
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * litigant_info
     *
     * @mbggenerated
     */
    int insert(LitigantInfo record);

    /**
     * litigant_info
     *
     * @mbggenerated
     */
    int insertSelective(LitigantInfo record);

    /**
     * litigant_info
     *
     * @mbggenerated
     */
    List<LitigantInfo> selectByExample(LitigantInfoExample example);

    /**
     * litigant_info
     *
     * @mbggenerated
     */
    LitigantInfo selectByPrimaryKey(String id);

    /**
     * litigant_info
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") LitigantInfo record, @Param("example") LitigantInfoExample example);

    /**
     * litigant_info
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") LitigantInfo record, @Param("example") LitigantInfoExample example);

    /**
     * litigant_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(LitigantInfo record);

    /**
     * litigant_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(LitigantInfo record);

    /**
     * litigant_info
     *
     * @mbggenerated
     */
    LitigantInfo selectByUserId(String userId);
    
    /**
     * 查询用户基本信息
     * @param userId
     * @return
     */
    UserBaseInfoVO selectUserBaseInfo(String userId);
}