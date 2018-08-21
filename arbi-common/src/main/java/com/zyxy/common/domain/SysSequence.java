package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 *
 * sys_sequence
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="SysSequence")
public class SysSequence implements Serializable {

    /**
     * ID sys_sequence.ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "ID")
    private String id;
    /**
     * 序列名称 sys_sequence.SNAME
     * @mbggenerated
     */
    @ApiModelProperty(value = "序列名称")
    private String sname;
    /**
     * 最小值 sys_sequence.SMIN
     * @mbggenerated
     */
    @ApiModelProperty(value = "最小值")
    private Integer smin;
    /**
     * 最大值 sys_sequence.SMAX
     * @mbggenerated
     */
    @ApiModelProperty(value = "最大值")
    private Integer smax;
    /**
     * 当前值 sys_sequence.SCURRENT
     * @mbggenerated
     */
    @ApiModelProperty(value = "当前值")
    private Integer scurrent;
    /**
     * 创建时间 sys_sequence.CREATE_TIME
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 更新时间 sys_sequence.UPDATE_TIME
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    /**
     * sys_sequence
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
     * 序列名称
     * @return  序列名称
     * @mbggenerated
     */
    public String getSname() {
        return sname;
    }

    /**
     * 序列名称
     * @param sname  序列名称
     * @mbggenerated
     */
    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    /**
     * 最小值
     * @return  最小值
     * @mbggenerated
     */
    public Integer getSmin() {
        return smin;
    }

    /**
     * 最小值
     * @param smin  最小值
     * @mbggenerated
     */
    public void setSmin(Integer smin) {
        this.smin = smin;
    }

    /**
     * 最大值
     * @return  最大值
     * @mbggenerated
     */
    public Integer getSmax() {
        return smax;
    }

    /**
     * 最大值
     * @param smax  最大值
     * @mbggenerated
     */
    public void setSmax(Integer smax) {
        this.smax = smax;
    }

    /**
     * 当前值
     * @return  当前值
     * @mbggenerated
     */
    public Integer getScurrent() {
        return scurrent;
    }

    /**
     * 当前值
     * @param scurrent  当前值
     * @mbggenerated
     */
    public void setScurrent(Integer scurrent) {
        this.scurrent = scurrent;
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