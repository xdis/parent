package com.zyxy.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.File;
import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.zyxy.common.exception.BuzzException;
import com.zyxy.common.util.FileUtil;

/**
 * 邮件待发送信息对象
 * @author tanquan
 *
 */
@ApiModel(value ="邮件信息对象")
public class MailInfoDTO implements Serializable{
	/**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 接收人地址
     */
	@ApiModelProperty("接收人地址")
	@NotEmpty(message="邮箱地址必填")
	@Size(min=1, max=100)
    private String[] to;
	
	/**
	 * 抄送地址
	 */
	@ApiModelProperty("抄送地址")
	@Size(max=100)
	private String[] cc;
	
    /**
     * 邮件标题
     */
	@ApiModelProperty("邮件标题")
	@NotNull(message="邮件标题不能为空")
    private String subject;
	
	/**
     * 邮件内容
     */
	@ApiModelProperty("邮件内容")
    @NotNull(message="邮件内容不能为空")
    private String content;
	
	/**
	 * 是否为纯文本简单邮件 -true时 所有内容将作为纯文本发送，且不会添加附件、静态图片等资源
	 */
	@ApiModelProperty("是否为纯文本简单邮件")
	private Boolean isSimmple = false;
	
	/**
     * 附件（文件流形式）
     */
    @ApiModelProperty("附件")
	private Attachment[] attachments;
    
    /**
     * 附件（文件服务ID形式）
     */
    @ApiModelProperty("附件IDs")
    private String[] attachmentIDs;
    

    /**
     * 邮件内容-静态资源（一般是图片）：在邮件内容中，需要包括一个静态资源的rscId，比如：<img src=\"cid:rscId01\" >
     */
    @ApiModelProperty("邮件内容-静态资源（一般是图片）")
    private InlineRes[] images;
	
    /**
     * 发送用户ID
     */
    @ApiModelProperty("发送用户ID")
    private String userId;
    
    /**
     * 业务ID（冗余如案件ID）
     */
    @ApiModelProperty("业务ID（冗余如案件ID）")
    private String buzzId;
    


    public String[] getTo() {
        return to;
    }


    public void setTo(String[] to) {
        this.to = to;
    }


    public String[] getCc() {
        return cc;
    }


    public void setCc(String[] cc) {
        this.cc = cc;
    }


    public String getSubject() {
        return subject;
    }


    public void setSubject(String subject) {
        this.subject = subject;
    }


    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }


    public Attachment[] getAttachments() {
        return attachments;
    }


    public void setAttachments(Attachment[] attachments) {
        this.attachments = attachments;
    }


    public InlineRes[] getImages() {
        return images;
    }


    public void setImages(InlineRes[] images) {
        this.images = images;
    }


    public Boolean getIsSimmple() {
        return isSimmple;
    }


    public void setIsSimmple(Boolean isSimmple) {
        this.isSimmple = isSimmple;
    }
    
    public String[] getAttachmentIDs() {
        return attachmentIDs;
    }


    public void setAttachmentIDs(String[] attachmentIDs) {
        this.attachmentIDs = attachmentIDs;
    }


    public String getUserId() {
        return userId;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getBuzzId() {
        return buzzId;
    }


    public void setBuzzId(String buzzId) {
        this.buzzId = buzzId;
    }
	
    public static class InlineRes implements Serializable{
        /**
         * 
         */
        private static final long serialVersionUID = 1L;
        /**
         * 资源ID 与<img src=\"cid:rscId01\" >众rscId01对应
         */
        private String rscId;
        /**
         * 资源图片base64字符串
         */
        private String imgBase64;
        public String getRscId() {
            return rscId;
        }
        public void setRscId(String rscId) {
            this.rscId = rscId;
        }
        public String getImgBase64() {
            return imgBase64;
        }
        public void setImgBase64(String imgBase64) {
            this.imgBase64 = imgBase64;
        }
    }
    
    public static class Attachment implements Serializable{
        private static final long serialVersionUID = 765926525182548850L;
        
        public Attachment() {}
        
        public Attachment(File file) {
            if (!file.exists()) {
                throw new BuzzException("请确认文件[" + file.getAbsolutePath() + "]是否存在");
            } 
            this.fileName = file.getName();
            this.bytes = FileUtil.getFileBytes(file);
        }
        
        private String fileName;
        private byte[] bytes;
        public String getFileName() {
            return fileName;
        }
        public void setFileName(String fileName) {
            this.fileName = fileName;
        }
        public byte[] getBytes() {
            return bytes;
        }
        public void setBytes(byte[] bytes) {
            this.bytes = bytes;
        }
    }
	
}
