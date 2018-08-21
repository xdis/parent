package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 * 
 *   用户角色关联表
 *
 * sys_user_role
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="SysUserRole")
public class SysUserRole implements Serializable {
    /**
     * 
     *   ID
     * sys_user_role.ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "ID")
    private String id;

    /**
     * 
     *   用户id
     * sys_user_role.USER_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户id")
    private String userId;

    /**
     * 
     *   角色id
     * sys_user_role.ROLE_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "角色id")
    private String roleId;

    /**
     * 
     *   创建人ID
     * sys_user_role.CREATE_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建人ID")
    private String createId;

    /**
     * 
     *   创建时间
     * sys_user_role.CREATE_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * sys_user_role
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * ID
     * 
     * @return ID
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * ID
     * 
     * @param id ID
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 用户id
     * 
     * @return 用户id
     *
     * @mbggenerated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 用户id
     * 
     * @param userId 用户id
     *
     * @mbggenerated
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 角色id
     * 
     * @return 角色id
     *
     * @mbggenerated
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * 角色id
     * 
     * @param roleId 角色id
     *
     * @mbggenerated
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    /**
     * 创建人ID
     * 
     * @return 创建人ID
     *
     * @mbggenerated
     */
    public String getCreateId() {
        return createId;
    }

    /**
     * 创建人ID
     * 
     * @param createId 创建人ID
     *
     * @mbggenerated
     */
    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
    }

    /**
     * 创建时间
     * 
     * @return 创建时间
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * 
     * @param createTime 创建时间
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}