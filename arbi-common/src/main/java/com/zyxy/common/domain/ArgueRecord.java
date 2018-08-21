package com.zyxy.common.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 辩论
 */
@ApiModel("辩论")
public class ArgueRecord implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column argue_record.ID
     *
     * @mbggenerated
     */
	@ApiModelProperty("辩论ID")
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column argue_record.CASE_ID
     *
     * @mbggenerated
     */
	@ApiModelProperty("案件ID")
    private String caseId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column argue_record.SEND_TYPE
     *
     * @mbggenerated
     */
    @ApiModelProperty("发送方类型。0- 申请人,1- 被申请人,2- 仲裁员")
    private String sendType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column argue_record.CREATER_ID
     *
     * @mbggenerated
     */
	@ApiModelProperty("创建者ID")
    private String createrId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column argue_record.CREATE_TIME
     *
     * @mbggenerated
     */
	@ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column argue_record.CONTENT
     *
     * @mbggenerated
     */
	@ApiModelProperty("内容")
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table argue_record
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column argue_record.ID
     *
     * @return the value of argue_record.ID
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column argue_record.ID
     *
     * @param id the value for argue_record.ID
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column argue_record.CASE_ID
     *
     * @return the value of argue_record.CASE_ID
     *
     * @mbggenerated
     */
    public String getCaseId() {
        return caseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column argue_record.CASE_ID
     *
     * @param caseId the value for argue_record.CASE_ID
     *
     * @mbggenerated
     */
    public void setCaseId(String caseId) {
        this.caseId = caseId == null ? null : caseId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column argue_record.SEND_TYPE
     *
     * @return the value of argue_record.SEND_TYPE
     *
     * @mbggenerated
     */
    public String getSendType() {
        return sendType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column argue_record.SEND_TYPE
     *
     * @param sendType the value for argue_record.SEND_TYPE
     *
     * @mbggenerated
     */
    public void setSendType(String sendType) {
        this.sendType = sendType == null ? null : sendType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column argue_record.CREATER_ID
     *
     * @return the value of argue_record.CREATER_ID
     *
     * @mbggenerated
     */
    public String getCreaterId() {
        return createrId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column argue_record.CREATER_ID
     *
     * @param createrId the value for argue_record.CREATER_ID
     *
     * @mbggenerated
     */
    public void setCreaterId(String createrId) {
        this.createrId = createrId == null ? null : createrId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column argue_record.CREATE_TIME
     *
     * @return the value of argue_record.CREATE_TIME
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column argue_record.CREATE_TIME
     *
     * @param createTime the value for argue_record.CREATE_TIME
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column argue_record.CONTENT
     *
     * @return the value of argue_record.CONTENT
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column argue_record.CONTENT
     *
     * @param content the value for argue_record.CONTENT
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}