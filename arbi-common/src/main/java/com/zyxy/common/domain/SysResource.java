package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 * 
 *   资源菜单表
 *
 * sys_resource
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="SysResource")
public class SysResource implements Serializable {

    /**
     * ID sys_resource.ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "ID")
    private String id;
    /**
     * 资源菜单名 sys_resource.NAME
     * @mbggenerated
     */
    @ApiModelProperty(value = "资源菜单名")
    private String name;
    /**
     * 父id sys_resource.PARENT_ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "父id")
    private String parentId;
    /**
     * 地址 sys_resource.URL
     * @mbggenerated
     */
    @ApiModelProperty(value = "地址")
    private String url;
    /**
     * 资源类型  1菜单  2资源 sys_resource.RES_TYPE
     * @mbggenerated
     */
    @ApiModelProperty(value = "资源类型  1菜单  2资源")
    private String resType;
    /**
     * 资源菜单code sys_resource.CODE
     * @mbggenerated
     */
    @ApiModelProperty(value = "资源菜单code")
    private String code;
    /**
     * 排序序号 sys_resource.ORDER_NUM
     * @mbggenerated
     */
    @ApiModelProperty(value = "排序序号")
    private Integer orderNum;
    /**
     * 资源菜单状态：0-不可用，1-正常 sys_resource.STATUS
     * @mbggenerated
     */
    @ApiModelProperty(value = "资源菜单状态：0-不可用，1-正常")
    private Integer status;
    /**
     * 创建人ID sys_resource.CREATE_ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建人ID")
    private String createId;
    /**
     * 更新人ID sys_resource.UPDATE_ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新人ID")
    private String updateId;
    /**
     * 创建时间 sys_resource.CREATE_TIME
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 更新时间 sys_resource.UPDATE_TIME
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    /**
     * sys_resource
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
     * 资源菜单名
     * @return  资源菜单名
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 资源菜单名
     * @param name  资源菜单名
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 父id
     * @return  父id
     * @mbggenerated
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 父id
     * @param parentId  父id
     * @mbggenerated
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * 地址
     * @return  地址
     * @mbggenerated
     */
    public String getUrl() {
        return url;
    }

    /**
     * 地址
     * @param url  地址
     * @mbggenerated
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 资源类型  1菜单  2资源
     * @return  资源类型  1菜单  2资源
     * @mbggenerated
     */
    public String getResType() {
        return resType;
    }

    /**
     * 资源类型  1菜单  2资源
     * @param resType  资源类型  1菜单  2资源
     * @mbggenerated
     */
    public void setResType(String resType) {
        this.resType = resType == null ? null : resType.trim();
    }

    /**
     * 资源菜单code
     * @return  资源菜单code
     * @mbggenerated
     */
    public String getCode() {
        return code;
    }

    /**
     * 资源菜单code
     * @param code  资源菜单code
     * @mbggenerated
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 排序序号
     * @return  排序序号
     * @mbggenerated
     */
    public Integer getOrderNum() {
        return orderNum;
    }

    /**
     * 排序序号
     * @param orderNum  排序序号
     * @mbggenerated
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 资源菜单状态：0-不可用，1-正常
     * @return  资源菜单状态：0-不可用，1-正常
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 资源菜单状态：0-不可用，1-正常
     * @param status  资源菜单状态：0-不可用，1-正常
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