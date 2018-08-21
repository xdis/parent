package com.zyxy.common.mapper;

import com.zyxy.common.domain.SysUser;
import com.zyxy.common.domain.SysUserExample;
import java.util.List;

import com.zyxy.common.dto.ArbitrationUserInfoDTO;
import com.zyxy.common.vo.ArbitrationUserInfoVO;
import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {

    /**
     * sys_user
     * @mbggenerated
     */
    int countByExample(SysUserExample example);

    /**
     * sys_user
     * @mbggenerated
     */
    int deleteByExample(SysUserExample example);

    /**
     * sys_user
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * sys_user
     * @mbggenerated
     */
    int insert(SysUser record);

    /**
     * sys_user
     * @mbggenerated
     */
    int insertSelective(SysUser record);

    /**
     * sys_user
     * @mbggenerated
     */
    List<SysUser> selectByExample(SysUserExample example);

    /**
     * sys_user
     * @mbggenerated
     */
    SysUser selectByPrimaryKey(String id);

    /**
     * sys_user
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysUser record,
            @Param("example") SysUserExample example);

    /**
     * sys_user
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysUser record,
            @Param("example") SysUserExample example);

    /**
     * sys_user
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysUser record);

    /**
     * sys_user
     * @mbggenerated
     */
    int updateByPrimaryKey(SysUser record);


    /**
     * 查询仲裁委后台用户管理列表
      * @param formData
     * @return
     */
    List<ArbitrationUserInfoVO> selectArbitrationUserInfo(ArbitrationUserInfoDTO formData);
}