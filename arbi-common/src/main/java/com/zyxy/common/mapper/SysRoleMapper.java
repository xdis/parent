package com.zyxy.common.mapper;

import com.zyxy.common.domain.SysRole;
import com.zyxy.common.domain.SysRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleMapper {

    /**
     * sys_role
     * @mbggenerated
     */
    int countByExample(SysRoleExample example);

    /**
     * sys_role
     * @mbggenerated
     */
    int deleteByExample(SysRoleExample example);

    /**
     * sys_role
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * sys_role
     * @mbggenerated
     */
    int insert(SysRole record);

    /**
     * sys_role
     * @mbggenerated
     */
    int insertSelective(SysRole record);

    /**
     * sys_role
     * @mbggenerated
     */
    List<SysRole> selectByExample(SysRoleExample example);

    /**
     * sys_role
     * @mbggenerated
     */
    SysRole selectByPrimaryKey(String id);

    /**
     * sys_role
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysRole record,
            @Param("example") SysRoleExample example);

    /**
     * sys_role
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysRole record,
            @Param("example") SysRoleExample example);

    /**
     * sys_role
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysRole record);

    /**
     * sys_role
     * @mbggenerated
     */
    int updateByPrimaryKey(SysRole record);

    List<SysRole> listRoleByUserId(String userId);
}