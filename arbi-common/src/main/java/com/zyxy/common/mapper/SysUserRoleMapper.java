package com.zyxy.common.mapper;

import com.zyxy.common.domain.SysUserRole;
import com.zyxy.common.domain.SysUserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserRoleMapper {
    /**
     * sys_user_role
     *
     * @mbggenerated
     */
    int countByExample(SysUserRoleExample example);

    /**
     * sys_user_role
     *
     * @mbggenerated
     */
    int deleteByExample(SysUserRoleExample example);

    /**
     * sys_user_role
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * sys_user_role
     *
     * @mbggenerated
     */
    int insert(SysUserRole record);

    /**
     * sys_user_role
     *
     * @mbggenerated
     */
    int insertSelective(SysUserRole record);

    /**
     * sys_user_role
     *
     * @mbggenerated
     */
    List<SysUserRole> selectByExample(SysUserRoleExample example);

    /**
     * sys_user_role
     *
     * @mbggenerated
     */
    SysUserRole selectByPrimaryKey(String id);

    /**
     * sys_user_role
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysUserRole record, @Param("example") SysUserRoleExample example);

    /**
     * sys_user_role
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysUserRole record, @Param("example") SysUserRoleExample example);

    /**
     * sys_user_role
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysUserRole record);

    /**
     * sys_user_role
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysUserRole record);
}