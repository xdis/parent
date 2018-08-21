package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 *
 * message_record
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="MessageRecord")
public class MessageRecord implements Serializable {
    /**
     * message_record.ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private Integer id;

    /**
     * message_record.TITLE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String title;

    /**
     * message_record.CREATER_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String createrId;

    /**
     * message_record.RELEASE_TYPE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String releaseType;

    /**
     * message_record.CREATE_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private Date createTime;

    /**
     * message_record.MESSAGE_BODY
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String messageBody;

    /**
     * message_record
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     * 
     * @return 
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * 
     * @param id 
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * 
     * @return 
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * 
     * @param title 
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 
     * 
     * @return 
     *
     * @mbggenerated
     */
    public String getCreaterId() {
        return createrId;
    }

    /**
     * 
     * 
     * @param createrId 
     *
     * @mbggenerated
     */
    public void setCreaterId(String createrId) {
        this.createrId = createrId == null ? null : createrId.trim();
    }

    /**
     * 
     * 
     * @return 
     *
     * @mbggenerated
     */
    public String getReleaseType() {
        return releaseType;
    }

    /**
     * 
     * 
     * @param releaseType 
     *
     * @mbggenerated
     */
    public void setReleaseType(String releaseType) {
        this.releaseType = releaseType == null ? null : releaseType.trim();
    }

    /**
     * 
     * 
     * @return 
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * 
     * @param createTime 
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 
     * 
     * @return 
     *
     * @mbggenerated
     */
    public String getMessageBody() {
        return messageBody;
    }

    /**
     * 
     * 
     * @param messageBody 
     *
     * @mbggenerated
     */
    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody == null ? null : messageBody.trim();
    }
}