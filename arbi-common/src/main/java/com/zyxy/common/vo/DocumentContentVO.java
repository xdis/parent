package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 案件申请书/决定书对象
 */
@ApiModel("案件申请书/决定书对象")
public class DocumentContentVO {

	/**
	 * 文书id
	 */
	private String docId;

	/**
	 * 文书类型id
	 */
	private String docContentId;

	/**
	 * 文书类型
	 */
	@ApiModelProperty("文书类型")
	private String docType;

	/**
	 * 正文
	 */
	@ApiModelProperty("正文")
	private String bodyText;

	/**
	 * 意见
	 */
	@ApiModelProperty("意见")
	private String opinion;

	/**
	 * 最终决定
	 */
	@ApiModelProperty("最终决定")
	private String finalDecision;

	/**
	 * 出具类型
	 */
	@ApiModelProperty("出具类型")
	private String issueType;

	/**
	 * 出具人
	 */
	@ApiModelProperty("出具人")
	private String issueId;

	/**
	 * 出具时间
	 */
	@ApiModelProperty("出具时间")
	private String createTime;

	/**
	 * 秘书名称
	 */
	@ApiModelProperty("秘书")
	private String secretaries;

	/**
	 * 仲裁员名称
	 */
	@ApiModelProperty("仲裁员")
	private String arbitrator;

	/**
	 * 是否是草稿 0-是草稿 1-不是草稿
	 */
	private String saveAdraft;
	
	/**
	 * 年编号
	 */
	private String docYearNumber;
	
	/**
	 * 序列号
	 */
	private String docSerialNumber;

	/**
	 * 最终出具时间
	 */
	private Date issusTime;

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getDocContentId() {
		return docContentId;
	}

	public void setDocContentId(String docContentId) {
		this.docContentId = docContentId;
	}

	public String getBodyText() {
		return bodyText;
	}

	public void setBodyText(String bodyText) {
		this.bodyText = bodyText;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public String getFinalDecision() {
		return finalDecision;
	}

	public void setFinalDecision(String finalDecision) {
		this.finalDecision = finalDecision;
	}

	public String getIssueType() {
		return issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

	public String getIssueId() {
		return issueId;
	}

	public void setIssueId(String issueId) {
		this.issueId = issueId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getSecretaries() {
		return secretaries;
	}

	public void setSecretaries(String secretaries) {
		this.secretaries = secretaries;
	}

	public String getArbitrator() {
		return arbitrator;
	}

	public void setArbitrator(String arbitrator) {
		this.arbitrator = arbitrator;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getSaveAdraft() {
		return saveAdraft;
	}

	public void setSaveAdraft(String saveAdraft) {
		this.saveAdraft = saveAdraft;
	}

	public String getDocYearNumber() {
		return docYearNumber;
	}

	public void setDocYearNumber(String docYearNumber) {
		this.docYearNumber = docYearNumber;
	}

	public String getDocSerialNumber() {
		return docSerialNumber;
	}

	public void setDocSerialNumber(String docSerialNumber) {
		this.docSerialNumber = docSerialNumber;
	}


	public Date getIssusTime() {
		return issusTime;
	}

	public void setIssusTime(Date issusTime) {
		this.issusTime = issusTime;
	}
}
