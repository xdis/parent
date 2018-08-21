package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 沟通记录
 */
@ApiModel("沟通记录")
public class ArgueRecordVO implements Serializable {

    @ApiModelProperty("发送方类型。0- 申请人,1- 被申请人,2- 仲裁秘书,3- 仲裁员")
    private String sendType;

    @ApiModelProperty("创建者ID")
    private String name;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("内容")
    private String content;

    private static final long serialVersionUID = 1L;

    public String getSendType() {
        return sendType;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}