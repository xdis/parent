package com.zyxy.common.mapper;

import com.zyxy.common.domain.SysResource;
import com.zyxy.common.domain.SysResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysResourceMapper {

    /**
     * sys_resource
     * @mbggenerated
     */
    int countByExample(SysResourceExample example);

    /**
     * sys_resource
     * @mbggenerated
     */
    int deleteByExample(SysResourceExample example);

    /**
     * sys_resource
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * sys_resource
     * @mbggenerated
     */
    int insert(SysResource record);

    /**
     * sys_resource
     * @mbggenerated
     */
    int insertSelective(SysResource record);

    /**
     * sys_resource
     * @mbggenerated
     */
    List<SysResource> selectByExample(SysResourceExample example);

    /**
     * sys_resource
     * @mbggenerated
     */
    SysResource selectByPrimaryKey(String id);

    /**
     * sys_resource
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysResource record,
            @Param("example") SysResourceExample example);

    /**
     * sys_resource
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysResource record,
            @Param("example") SysResourceExample example);

    /**
     * sys_resource
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysResource record);

    /**
     * sys_resource
     * @mbggenerated
     */
    int updateByPrimaryKey(SysResource record);

    /**
     * 根据userid查询用户拥有的资源
     * @param userId
     * @return
     */
    List<SysResource> selectUserResource(String userId);
    
    List<String> listAllCodeByUserId(String userId);
}