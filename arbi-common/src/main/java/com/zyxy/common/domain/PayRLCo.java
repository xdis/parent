package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 * 
 *   瑞联-单位信息表
 *
 * pay_rl_co
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="PayRLCo")
public class PayRLCo implements Serializable {

    /**
     * ID pay_rl_co.ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "ID")
    private String id;
    /**
     * 数据同步类型：1-新增，2-修改 pay_rl_co.SYNC_TYPE
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据同步类型：1-新增，2-修改")
    private Integer syncType;
    /**
     * 单位编码 pay_rl_co.CO_NO
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位编码")
    private String coNo;
    /**
     * 上级单位编码 pay_rl_co.PARENT_CO_NO
     * @mbggenerated
     */
    @ApiModelProperty(value = "上级单位编码")
    private String parentCoNo;
    /**
     * 单位名称 pay_rl_co.CO_NAME
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位名称")
    private String coName;
    /**
     * 所属区域编码 pay_rl_co.REGION_CODE
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属区域编码")
    private String regionCode;
    /**
     * 所属区域名称 pay_rl_co.REGION_NAME
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属区域名称")
    private String regionName;
    /**
     * 地址 pay_rl_co.ADDR
     * @mbggenerated
     */
    @ApiModelProperty(value = "地址")
    private String addr;
    /**
     * 联系人 pay_rl_co.CONTACT_NAME
     * @mbggenerated
     */
    @ApiModelProperty(value = "联系人")
    private String contactName;
    /**
     * 联系电话 pay_rl_co.CONTACT_TEL
     * @mbggenerated
     */
    @ApiModelProperty(value = "联系电话")
    private String contactTel;
    /**
     * 备注 pay_rl_co.REMARK
     * @mbggenerated
     */
    @ApiModelProperty(value = "备注")
    private String remark;
    /**
     * 状态：0-禁用，1-启用 pay_rl_co.STATUS
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态：0-禁用，1-启用")
    private Integer status;
    /**
     * 同步时间 pay_rl_co.SYNC_TIME
     * @mbggenerated
     */
    @ApiModelProperty(value = "同步时间")
    private Date syncTime;
    /**
     * pay_rl_co
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
     * 数据同步类型：1-新增，2-修改
     * @return  数据同步类型：1-新增，2-修改
     * @mbggenerated
     */
    public Integer getSyncType() {
        return syncType;
    }

    /**
     * 数据同步类型：1-新增，2-修改
     * @param syncType  数据同步类型：1-新增，2-修改
     * @mbggenerated
     */
    public void setSyncType(Integer syncType) {
        this.syncType = syncType;
    }

    /**
     * 单位编码
     * @return  单位编码
     * @mbggenerated
     */
    public String getCoNo() {
        return coNo;
    }

    /**
     * 单位编码
     * @param coNo  单位编码
     * @mbggenerated
     */
    public void setCoNo(String coNo) {
        this.coNo = coNo == null ? null : coNo.trim();
    }

    /**
     * 上级单位编码
     * @return  上级单位编码
     * @mbggenerated
     */
    public String getParentCoNo() {
        return parentCoNo;
    }

    /**
     * 上级单位编码
     * @param parentCoNo  上级单位编码
     * @mbggenerated
     */
    public void setParentCoNo(String parentCoNo) {
        this.parentCoNo = parentCoNo == null ? null : parentCoNo.trim();
    }

    /**
     * 单位名称
     * @return  单位名称
     * @mbggenerated
     */
    public String getCoName() {
        return coName;
    }

    /**
     * 单位名称
     * @param coName  单位名称
     * @mbggenerated
     */
    public void setCoName(String coName) {
        this.coName = coName == null ? null : coName.trim();
    }

    /**
     * 所属区域编码
     * @return  所属区域编码
     * @mbggenerated
     */
    public String getRegionCode() {
        return regionCode;
    }

    /**
     * 所属区域编码
     * @param regionCode  所属区域编码
     * @mbggenerated
     */
    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode == null ? null : regionCode.trim();
    }

    /**
     * 所属区域名称
     * @return  所属区域名称
     * @mbggenerated
     */
    public String getRegionName() {
        return regionName;
    }

    /**
     * 所属区域名称
     * @param regionName  所属区域名称
     * @mbggenerated
     */
    public void setRegionName(String regionName) {
        this.regionName = regionName == null ? null : regionName.trim();
    }

    /**
     * 地址
     * @return  地址
     * @mbggenerated
     */
    public String getAddr() {
        return addr;
    }

    /**
     * 地址
     * @param addr  地址
     * @mbggenerated
     */
    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    /**
     * 联系人
     * @return  联系人
     * @mbggenerated
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * 联系人
     * @param contactName  联系人
     * @mbggenerated
     */
    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    /**
     * 联系电话
     * @return  联系电话
     * @mbggenerated
     */
    public String getContactTel() {
        return contactTel;
    }

    /**
     * 联系电话
     * @param contactTel  联系电话
     * @mbggenerated
     */
    public void setContactTel(String contactTel) {
        this.contactTel = contactTel == null ? null : contactTel.trim();
    }

    /**
     * 备注
     * @return  备注
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark  备注
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 状态：0-禁用，1-启用
     * @return  状态：0-禁用，1-启用
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态：0-禁用，1-启用
     * @param status  状态：0-禁用，1-启用
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 同步时间
     * @return  同步时间
     * @mbggenerated
     */
    public Date getSyncTime() {
        return syncTime;
    }

    /**
     * 同步时间
     * @param syncTime  同步时间
     * @mbggenerated
     */
    public void setSyncTime(Date syncTime) {
        this.syncTime = syncTime;
    }
}