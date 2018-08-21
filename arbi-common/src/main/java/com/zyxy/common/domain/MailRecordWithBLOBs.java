package com.zyxy.common.domain;

import java.io.Serializable;

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
public class MailRecordWithBLOBs extends MailRecord implements Serializable {

    /**
     * 邮件内容 mail_record.CONTENT
     * @mbggenerated
     */
    @ApiModelProperty(value = "邮件内容")
    private String content;
    /**
     * 邮件附件（ID 或 文件名） mail_record.ATTACHMENT
     * @mbggenerated
     */
    @ApiModelProperty(value = "邮件附件（ID 或 文件名）")
    private String attachment;
    /**
     * mail_record
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 邮件内容
     * @return  邮件内容
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * 邮件内容
     * @param content  邮件内容
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 邮件附件（ID 或 文件名）
     * @return  邮件附件（ID 或 文件名）
     * @mbggenerated
     */
    public String getAttachment() {
        return attachment;
    }

    /**
     * 邮件附件（ID 或 文件名）
     * @param attachment  邮件附件（ID 或 文件名）
     * @mbggenerated
     */
    public void setAttachment(String attachment) {
        this.attachment = attachment == null ? null : attachment.trim();
    }
}