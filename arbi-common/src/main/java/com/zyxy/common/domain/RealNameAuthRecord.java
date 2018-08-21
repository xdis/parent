package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 * 
 *   实名认证记录表
 *
 * real_name_auth_record
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="RealNameAuthRecord")
public class RealNameAuthRecord implements Serializable {

    /**
     * ID real_name_auth_record.ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "ID")
    private String id;
    /**
     * 银行卡号 real_name_auth_record.CARD_NO
     * @mbggenerated
     */
    @ApiModelProperty(value = "银行卡号")
    private String cardNo;
    /**
     * 证件类型：00-身份证号 real_name_auth_record.CERT_TYPE
     * @mbggenerated
     */
    @ApiModelProperty(value = "证件类型：00-身份证号")
    private String certType;
    /**
     * 证件号 real_name_auth_record.CERT_NO
     * @mbggenerated
     */
    @ApiModelProperty(value = "证件号")
    private String certNo;
    /**
     * 姓名 real_name_auth_record.CERT_NAME
     * @mbggenerated
     */
    @ApiModelProperty(value = "姓名")
    private String certName;
    /**
     * 手机号 real_name_auth_record.PHONE_NO
     * @mbggenerated
     */
    @ApiModelProperty(value = "手机号")
    private String phoneNo;
    /**
     * 用户ID real_name_auth_record.USER_ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户ID")
    private String userId;
    /**
     * 业务ID（冗余） real_name_auth_record.BUZZ_ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "业务ID（冗余）")
    private String buzzId;
    /**
     * 业务备注 real_name_auth_record.REMARK
     * @mbggenerated
     */
    @ApiModelProperty(value = "业务备注")
    private String remark;
    /**
     * 状态：0-处理中，1-认证成功，2-认证失败 real_name_auth_record.STATUS
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态：0-处理中，1-认证成功，2-认证失败")
    private Integer status;
    /**
     * 渠道名称 real_name_auth_record.CHANNEL_NAME
     * @mbggenerated
     */
    @ApiModelProperty(value = "渠道名称")
    private String channelName;
    /**
     * 渠道返回结果代码 real_name_auth_record.CHANNEL_CODE
     * @mbggenerated
     */
    @ApiModelProperty(value = "渠道返回结果代码")
    private String channelCode;
    /**
     * 渠道返回结果消息 real_name_auth_record.CHANNEL_MSG
     * @mbggenerated
     */
    @ApiModelProperty(value = "渠道返回结果消息")
    private String channelMsg;
    /**
     * 渠道返回追溯号 real_name_auth_record.VOUCHER_NO
     * @mbggenerated
     */
    @ApiModelProperty(value = "渠道返回追溯号")
    private String voucherNo;
    /**
     * 是否免费：0-否，1-是 real_name_auth_record.BE_FREE
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否免费：0-否，1-是")
    private Integer beFree;
    /**
     * 创建时间 real_name_auth_record.CREATE_TIME
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 更新时间 real_name_auth_record.UPDATE_TIME
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    /**
     * real_name_auth_record
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
     * 银行卡号
     * @return  银行卡号
     * @mbggenerated
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * 银行卡号
     * @param cardNo  银行卡号
     * @mbggenerated
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    /**
     * 证件类型：00-身份证号
     * @return  证件类型：00-身份证号
     * @mbggenerated
     */
    public String getCertType() {
        return certType;
    }

    /**
     * 证件类型：00-身份证号
     * @param certType  证件类型：00-身份证号
     * @mbggenerated
     */
    public void setCertType(String certType) {
        this.certType = certType == null ? null : certType.trim();
    }

    /**
     * 证件号
     * @return  证件号
     * @mbggenerated
     */
    public String getCertNo() {
        return certNo;
    }

    /**
     * 证件号
     * @param certNo  证件号
     * @mbggenerated
     */
    public void setCertNo(String certNo) {
        this.certNo = certNo == null ? null : certNo.trim();
    }

    /**
     * 姓名
     * @return  姓名
     * @mbggenerated
     */
    public String getCertName() {
        return certName;
    }

    /**
     * 姓名
     * @param certName  姓名
     * @mbggenerated
     */
    public void setCertName(String certName) {
        this.certName = certName == null ? null : certName.trim();
    }

    /**
     * 手机号
     * @return  手机号
     * @mbggenerated
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * 手机号
     * @param phoneNo  手机号
     * @mbggenerated
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo == null ? null : phoneNo.trim();
    }

    /**
     * 用户ID
     * @return  用户ID
     * @mbggenerated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 用户ID
     * @param userId  用户ID
     * @mbggenerated
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 业务ID（冗余）
     * @return  业务ID（冗余）
     * @mbggenerated
     */
    public String getBuzzId() {
        return buzzId;
    }

    /**
     * 业务ID（冗余）
     * @param buzzId  业务ID（冗余）
     * @mbggenerated
     */
    public void setBuzzId(String buzzId) {
        this.buzzId = buzzId == null ? null : buzzId.trim();
    }

    /**
     * 业务备注
     * @return  业务备注
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 业务备注
     * @param remark  业务备注
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 状态：0-处理中，1-认证成功，2-认证失败
     * @return  状态：0-处理中，1-认证成功，2-认证失败
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态：0-处理中，1-认证成功，2-认证失败
     * @param status  状态：0-处理中，1-认证成功，2-认证失败
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 渠道名称
     * @return  渠道名称
     * @mbggenerated
     */
    public String getChannelName() {
        return channelName;
    }

    /**
     * 渠道名称
     * @param channelName  渠道名称
     * @mbggenerated
     */
    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    /**
     * 渠道返回结果代码
     * @return  渠道返回结果代码
     * @mbggenerated
     */
    public String getChannelCode() {
        return channelCode;
    }

    /**
     * 渠道返回结果代码
     * @param channelCode  渠道返回结果代码
     * @mbggenerated
     */
    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode == null ? null : channelCode.trim();
    }

    /**
     * 渠道返回结果消息
     * @return  渠道返回结果消息
     * @mbggenerated
     */
    public String getChannelMsg() {
        return channelMsg;
    }

    /**
     * 渠道返回结果消息
     * @param channelMsg  渠道返回结果消息
     * @mbggenerated
     */
    public void setChannelMsg(String channelMsg) {
        this.channelMsg = channelMsg == null ? null : channelMsg.trim();
    }

    /**
     * 渠道返回追溯号
     * @return  渠道返回追溯号
     * @mbggenerated
     */
    public String getVoucherNo() {
        return voucherNo;
    }

    /**
     * 渠道返回追溯号
     * @param voucherNo  渠道返回追溯号
     * @mbggenerated
     */
    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo == null ? null : voucherNo.trim();
    }

    /**
     * 是否免费：0-否，1-是
     * @return  是否免费：0-否，1-是
     * @mbggenerated
     */
    public Integer getBeFree() {
        return beFree;
    }

    /**
     * 是否免费：0-否，1-是
     * @param beFree  是否免费：0-否，1-是
     * @mbggenerated
     */
    public void setBeFree(Integer beFree) {
        this.beFree = beFree;
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