package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 仲裁委案件撤回决定书
 */
@ApiModel(value="仲裁委案件撤回决定书")
public class ArbitrationCaseDecisionVO {
	/**
	 * 文书年编号
	 */
	@ApiModelProperty(value="文书年编号")
	private String docYearNo;

	/**
	 * 文书序列号
	 */
	@ApiModelProperty(value="文书序列号")
	private String docSerialNo;
	
	/**
	 * 仲裁员id
	 */
	@ApiModelProperty(value="仲裁员id")
	private String arbitratorId;
	
	/**
	 * 仲裁员姓名
	 */
	@ApiModelProperty(value="仲裁员姓名")
	private String arbitratorName;
	
	/**
	 * 仲裁秘书id
	 */
	@ApiModelProperty(value="仲裁秘书id")
	private String arbitrationSecretaryId;
	
	/**
	 * 仲裁秘书
	 */
	@ApiModelProperty(value="仲裁秘书")
	private String arbitrationSecretaryName;
	
	/**
	 * 正文
	 */
	@ApiModelProperty(value="正文")
	private String bodyText;
	
	/**
	 * 最终决定
	 */
	@ApiModelProperty(value="最终决定")
	private String finalDecision;
	
	/**
	 * 意见
	 */
	@ApiModelProperty(value="意见")
	private String opinion;
	
	/**
	 * 决定书书写时间
	 */
	@ApiModelProperty(value="决定书书写时间")
	private Date decisionWriteTime;
	
	/**
	 * 保存草稿 0-是  1-否
	 */
	@ApiModelProperty(value="保存草稿 0-是  1-否")
	private String saveAsDraft;
	
	public String getDocYearNo() {
		return docYearNo;
	}

	public void setDocYearNo(String docYearNo) {
		this.docYearNo = docYearNo;
	}

	public String getDocSerialNo() {
		return docSerialNo;
	}

	public void setDocSerialNo(String docSerialNo) {
		this.docSerialNo = docSerialNo;
	}

	public String getArbitratorName() {
		return arbitratorName;
	}

	public void setArbitratorName(String arbitratorName) {
		this.arbitratorName = arbitratorName;
	}

	public String getArbitrationSecretaryName() {
		return arbitrationSecretaryName;
	}

	public void setArbitrationSecretaryName(String arbitrationSecretaryName) {
		this.arbitrationSecretaryName = arbitrationSecretaryName;
	}

	public Date getDecisionWriteTime() {
		return decisionWriteTime;
	}

	public void setDecisionWriteTime(Date decisionWriteTime) {
		this.decisionWriteTime = decisionWriteTime;
	}

	public String getArbitratorId() {
		return arbitratorId;
	}

	public void setArbitratorId(String arbitratorId) {
		this.arbitratorId = arbitratorId;
	}

	public String getArbitrationSecretaryId() {
		return arbitrationSecretaryId;
	}

	public void setArbitrationSecretaryId(String arbitrationSecretaryId) {
		this.arbitrationSecretaryId = arbitrationSecretaryId;
	}

	public String getBodyText() {
		return bodyText;
	}

	public void setBodyText(String bodyText) {
		this.bodyText = bodyText;
	}

	public String getFinalDecision() {
		return finalDecision;
	}

	public void setFinalDecision(String finalDecision) {
		this.finalDecision = finalDecision;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public String getSaveAsDraft() {
		return saveAsDraft;
	}

	public void setSaveAsDraft(String saveAsDraft) {
		this.saveAsDraft = saveAsDraft;
	}
	
}