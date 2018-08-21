package com.zyxy.common.mapper;

import com.zyxy.common.domain.UserInfo;
import com.zyxy.common.domain.UserInfoExample;
import com.zyxy.common.vo.UserInfoVO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserInfoMapper {
    /**
     * user_info
     *
     * @mbggenerated
     */
    int countByExample(UserInfoExample example);

    /**
     * user_info
     *
     * @mbggenerated
     */
    int deleteByExample(UserInfoExample example);

    /**
     * user_info
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * user_info
     *
     * @mbggenerated
     */
    int insert(UserInfo record);

    /**
     * user_info
     *
     * @mbggenerated
     */
    int insertSelective(UserInfo record);

    /**
     * user_info
     *
     * @mbggenerated
     */
    List<UserInfo> selectByExample(UserInfoExample example);

    List<UserInfo> queryUserInfoByDuties(Map params);

    /**
     * user_info
     *
     * @mbggenerated
     */
    UserInfo selectByPrimaryKey(String id);

    /**
     * user_info
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    /**
     * user_info
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    /**
     * user_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(UserInfo record);

    /**
     * user_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(UserInfo record);

    /**
     * 根据userId查询当前登录人信息、职务
     * @param userId
     * @return
     */
    UserInfoVO selectUserInFoByUserId(String userId);

    /**
     * 根据userId查询仲裁员信息、职务
     *
     * @param userId
     * @return
     */
    UserInfoVO selectArbitratorUserInfoByUserId(String userId);


    /**
     * 根据userId查询出手机号
     *
     * @param userId
     * @return
     */
    UserInfoVO selectPhoneByUserId(@Param("userId") String userId);


    /**
     * 根据案件Id查询出申请人用户信息
     *
     * @param caseId 案件Id
     * @return
     */
    UserInfo queryProposerUserInfoByCaseId(@Param("caseId") String caseId);

    /**
     * 根据案件Id查询出被申请人用户信息
     * @param caseId 案件Id
     * @return
     */
    UserInfo queryDefendantUserInfoByCaseId(@Param("caseId") String caseId);
}