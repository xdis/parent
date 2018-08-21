package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 * 
 *   角色表
 *
 * sys_role
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="SysRole")
public class SysRole implements Serializable {

    /**
     * ID sys_role.ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "ID")
    private String id;
    /**
     * 角色名 sys_role.ROLE_NAME
     * @mbggenerated
     */
    @ApiModelProperty(value = "角色名")
    private String roleName;
    /**
     * 角色状态：0-不可用，1-正常 sys_role.STATUS
     * @mbggenerated
     */
    @ApiModelProperty(value = "角色状态：0-不可用，1-正常")
    private Integer status;
    /**
     * 创建人ID sys_role.CREATE_ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建人ID")
    private String createId;
    /**
     * 更新人ID sys_role.UPDATE_ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新人ID")
    private String updateId;
    /**
     * 创建时间 sys_role.CREATE_TIME
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 更新时间 sys_role.UPDATE_TIME
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    /**
     * sys_role
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * ID
     * @return  ID
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * ID
     * @param id  ID
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 角色名
     * @return  角色名
     * @mbggenerated
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 角色名
     * @param roleName  角色名
     * @mbggenerated
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * 角色状态：0-不可用，1-正常
     * @return  角色状态：0-不可用，1-正常
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 角色状态：0-不可用，1-正常
     * @param status  角色状态：0-不可用，1-正常
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 创建人ID
     * @return  创建人ID
     * @mbggenerated
     */
    public String getCreateId() {
        return createId;
    }

    /**
     * 创建人ID
     * @param createId  创建人ID
     * @mbggenerated
     */
    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
    }

    /**
     * 更新人ID
     * @return  更新人ID
     * @mbggenerated
     */
    public String getUpdateId() {
        return updateId;
    }

    /**
     * 更新人ID
     * @param updateId  更新人ID
     * @mbggenerated
     */
    public void setUpdateId(String updateId) {
        this.updateId = updateId == null ? null : updateId.trim();
    }

    /**
     * 创建时间
     * @return  创建时间
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime  创建时间
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     * @return  更新时间
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     * @param updateTime  更新时间
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}