package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 *
 * sms_record
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="SmsRecord")
public class SmsRecord implements Serializable {

    /**
     * ID sms_record.ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "ID")
    private String id;
    /**
     * 手机号 sms_record.PHONE_NO
     * @mbggenerated
     */
    @ApiModelProperty(value = "手机号")
    private String phoneNo;
    /**
     * 短信模板编号 sms_record.TPL_ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "短信模板编号")
    private String tplId;
    /**
     * 用户ID sms_record.USER_ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户ID")
    private String userId;
    /**
     * 业务ID(冗余) sms_record.BUZZ_ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "业务ID(冗余)")
    private String buzzId;
    /**
     * 发送渠道编号 sms_record.CHANNEL_CODE
     * @mbggenerated
     */
    @ApiModelProperty(value = "发送渠道编号")
    private String channelCode;
    /**
     * 发送状态：0-发送中，1-成功，2-失败 sms_record.STATUS
     * @mbggenerated
     */
    @ApiModelProperty(value = "发送状态：0-发送中，1-成功，2-失败")
    private Integer status;
    /**
     * 创建时间 sms_record.CREATE_TIME
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * sms_record
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
     * 短信模板编号
     * @return  短信模板编号
     * @mbggenerated
     */
    public String getTplId() {
        return tplId;
    }

    /**
     * 短信模板编号
     * @param tplId  短信模板编号
     * @mbggenerated
     */
    public void setTplId(String tplId) {
        this.tplId = tplId == null ? null : tplId.trim();
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
     * 业务ID(冗余)
     * @return  业务ID(冗余)
     * @mbggenerated
     */
    public String getBuzzId() {
        return buzzId;
    }

    /**
     * 业务ID(冗余)
     * @param buzzId  业务ID(冗余)
     * @mbggenerated
     */
    public void setBuzzId(String buzzId) {
        this.buzzId = buzzId == null ? null : buzzId.trim();
    }

    /**
     * 发送渠道编号
     * @return  发送渠道编号
     * @mbggenerated
     */
    public String getChannelCode() {
        return channelCode;
    }

    /**
     * 发送渠道编号
     * @param channelCode  发送渠道编号
     * @mbggenerated
     */
    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode == null ? null : channelCode.trim();
    }

    /**
     * 发送状态：0-发送中，1-成功，2-失败
     * @return  发送状态：0-发送中，1-成功，2-失败
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 发送状态：0-发送中，1-成功，2-失败
     * @param status  发送状态：0-发送中，1-成功，2-失败
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
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
}