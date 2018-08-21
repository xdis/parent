package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 * 
 *   系统配置数据字典表
 *
 * sys_data_dic
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="SysDataDic")
public class SysDataDic extends SysDataDicKey implements Serializable {

    /**
     * 字典key对应的值 sys_data_dic.DIC_VALUE
     * @mbggenerated
     */
    @ApiModelProperty(value = "字典key对应的值")
    private String dicValue;
    /**
     * 字典描述 sys_data_dic.DIC_DESCR
     * @mbggenerated
     */
    @ApiModelProperty(value = "字典描述")
    private String dicDescr;
    /**
     * 创建时间 sys_data_dic.CREATE_TIME
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 更新时间 sys_data_dic.UPDATE_TIME
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    /**
     * sys_data_dic
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 字典key对应的值
     * @return  字典key对应的值
     * @mbggenerated
     */
    public String getDicValue() {
        return dicValue;
    }

    /**
     * 字典key对应的值
     * @param dicValue  字典key对应的值
     * @mbggenerated
     */
    public void setDicValue(String dicValue) {
        this.dicValue = dicValue == null ? null : dicValue.trim();
    }

    /**
     * 字典描述
     * @return  字典描述
     * @mbggenerated
     */
    public String getDicDescr() {
        return dicDescr;
    }

    /**
     * 字典描述
     * @param dicDescr  字典描述
     * @mbggenerated
     */
    public void setDicDescr(String dicDescr) {
        this.dicDescr = dicDescr == null ? null : dicDescr.trim();
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