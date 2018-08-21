package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 *
 * mail_record
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="MailRecord")
public class MailRecord implements Serializable {

    /**
     * ID mail_record.ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "ID")
    private String id;
    /**
     * 邮件标题 mail_record.SUBJUCT
     * @mbggenerated
     */
    @ApiModelProperty(value = "邮件标题")
    private String subjuct;
    /**
     * 接收者 mail_record.MAIL_TO
     * @mbggenerated
     */
    @ApiModelProperty(value = "接收者")
    private String mailTo;
    /**
     * 抄送 mail_record.CC
     * @mbggenerated
     */
    @ApiModelProperty(value = "抄送")
    private String cc;
    /**
     * 发送状态：0-发送中，1-成功，2-失败 mail_record.STAUTS
     * @mbggenerated
     */
    @ApiModelProperty(value = "发送状态：0-发送中，1-成功，2-失败")
    private Integer stauts;
    /**
     * 用户ID mail_record.USER_ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户ID")
    private String userId;
    /**
     * 业务ID（比如冗余 案件ID） mail_record.BUZZ_ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "业务ID（比如冗余 案件ID）")
    private String buzzId;
    /**
     * 创建时间 mail_record.CREATE_TIME
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * mail_record
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
     * 邮件标题
     * @return  邮件标题
     * @mbggenerated
     */
    public String getSubjuct() {
        return subjuct;
    }

    /**
     * 邮件标题
     * @param subjuct  邮件标题
     * @mbggenerated
     */
    public void setSubjuct(String subjuct) {
        this.subjuct = subjuct == null ? null : subjuct.trim();
    }

    /**
     * 接收者
     * @return  接收者
     * @mbggenerated
     */
    public String getMailTo() {
        return mailTo;
    }

    /**
     * 接收者
     * @param mailTo  接收者
     * @mbggenerated
     */
    public void setMailTo(String mailTo) {
        this.mailTo = mailTo == null ? null : mailTo.trim();
    }

    /**
     * 抄送
     * @return  抄送
     * @mbggenerated
     */
    public String getCc() {
        return cc;
    }

    /**
     * 抄送
     * @param cc  抄送
     * @mbggenerated
     */
    public void setCc(String cc) {
        this.cc = cc == null ? null : cc.trim();
    }

    /**
     * 发送状态：0-发送中，1-成功，2-失败
     * @return  发送状态：0-发送中，1-成功，2-失败
     * @mbggenerated
     */
    public Integer getStauts() {
        return stauts;
    }

    /**
     * 发送状态：0-发送中，1-成功，2-失败
     * @param stauts  发送状态：0-发送中，1-成功，2-失败
     * @mbggenerated
     */
    public void setStauts(Integer stauts) {
        this.stauts = stauts;
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
     * 业务ID（比如冗余 案件ID）
     * @return  业务ID（比如冗余 案件ID）
     * @mbggenerated
     */
    public String getBuzzId() {
        return buzzId;
    }

    /**
     * 业务ID（比如冗余 案件ID）
     * @param buzzId  业务ID（比如冗余 案件ID）
     * @mbggenerated
     */
    public void setBuzzId(String buzzId) {
        this.buzzId = buzzId == null ? null : buzzId.trim();
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