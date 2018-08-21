package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 和解沟通记录VO
 */
@ApiModel("和解沟通记录VO")
public class CompromiseRecordVO {
	
	/**
	 * 记录ID
	 */
	@ApiModelProperty("记录ID")
	private String id;
	
	/**
	 * 案件ID
	 */
	@ApiModelProperty("案件ID")
	private String caseId;
	
	/**
     * 发送人类型0申请方 1被申请方 3第三方
     */
    @ApiModelProperty("发送人类型0申请方 1被申请方 3第三方")
    private String SendType;
	
	/**
	 * 内容类型
	 */
	@ApiModelProperty("内容类型")
	private String contentType;
	
	/**
	 * 发送人Id
	 */
	@ApiModelProperty("发送人Id")
	private String createrId;
	
	/**
	 * 时间
	 */
	@ApiModelProperty("时间")
	private String createTime;
	
	/**
	 * 内容
	 */
	@ApiModelProperty("内容")
	private String content;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getSendType() {
		return SendType;
	}

	public void setSendType(String sendType) {
		SendType = sendType;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getCreaterId() {
		return createrId;
	}

	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "CompromiseRecordVO [id=" + id + ", caseId=" + caseId
				+ ", SendType=" + SendType + ", contentType=" + contentType
				+ ", createrId=" + createrId + ", createTime=" + createTime
				+ ", content=" + content + "]";
	}
	
	

}
