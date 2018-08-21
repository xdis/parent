package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 * 
 *   消息用户关联表
 *
 * message_user
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="MessageUser")
public class MessageUser implements Serializable {
    /**
     * message_user.ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private Integer id;

    /**
     * 
     *   消息id
     * message_user.MESSAGE_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "消息id")
    private Integer messageId;

    /**
     * message_user.USER_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String userId;

    /**
     * 
     *   消息状态 0-未读 1-已读
     * message_user.STATUS
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "消息状态 0-未读 1-已读")
    private String status;

    /**
     * 
     *   删除标志 0-未删除 1-已删除
     * message_user.DEL_FLAG
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "删除标志 0-未删除 1-已删除")
    private String delFlag;

    /**
     * 
     *   创建人id
     * message_user.CREATER_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建人id")
    private String createrId;

    /**
     * 
     *   创建时间
     * message_user.CREATE_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * message_user
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
     * 消息id
     * 
     * @return 消息id
     *
     * @mbggenerated
     */
    public Integer getMessageId() {
        return messageId;
    }

    /**
     * 消息id
     * 
     * @param messageId 消息id
     *
     * @mbggenerated
     */
    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    /**
     * 
     * 
     * @return 
     *
     * @mbggenerated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 
     * 
     * @param userId 
     *
     * @mbggenerated
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 消息状态 0-未读 1-已读
     * 
     * @return 消息状态 0-未读 1-已读
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * 消息状态 0-未读 1-已读
     * 
     * @param status 消息状态 0-未读 1-已读
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 删除标志 0-未删除 1-已删除
     * 
     * @return 删除标志 0-未删除 1-已删除
     *
     * @mbggenerated
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 删除标志 0-未删除 1-已删除
     * 
     * @param delFlag 删除标志 0-未删除 1-已删除
     *
     * @mbggenerated
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    /**
     * 创建人id
     * 
     * @return 创建人id
     *
     * @mbggenerated
     */
    public String getCreaterId() {
        return createrId;
    }

    /**
     * 创建人id
     * 
     * @param createrId 创建人id
     *
     * @mbggenerated
     */
    public void setCreaterId(String createrId) {
        this.createrId = createrId == null ? null : createrId.trim();
    }

    /**
     * 创建时间
     * 
     * @return 创建时间
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * 
     * @param createTime 创建时间
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}