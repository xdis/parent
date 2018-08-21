package com.zyxy.common.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * 仲裁委案件决定书处理对象
 */
@ApiModel(value="仲裁委案件决定书处理对象")
public class ArbitrationCaseDecisionHandleDTO extends BaseDTO{
	/**
	 * 处理正文
	 */
	@ApiModelProperty(value="处理正文")
	private String bodyText;
	
	/**
	 * 意见
	 */
	@ApiModelProperty(value="意见")
	private String opinion;
	
	/**
	 * 最终决定
	 */
	@ApiModelProperty(value="最终决定")
	private String finalDecision;

	/**
	 * 审批意见
	 */
	@ApiModelProperty(value="审批意见")
	private String approveSuggest;
	
	/**
	 * 意见状态
	 */
	@ApiModelProperty(value="意见状态")
	private String opinionStatus;
	
	/**
	 * 审批id
	 */
	@ApiModelProperty(value="审批id")
	@NotNull
	private String approveId;
	
	/**
	 * 出具类型
	 */
	@NotNull
	@ApiModelProperty(value="出具类型")
	private Integer issueType;

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

	public String getApproveSuggest() {
		return approveSuggest;
	}

	public void setApproveSuggest(String approveSuggest) {
		this.approveSuggest = approveSuggest;
	}

	public String getOpinionStatus() {
		return opinionStatus;
	}

	public void setOpinionStatus(String opinionStatus) {
		this.opinionStatus = opinionStatus;
	}

	public String getApproveId() {
		return approveId;
	}

	public void setApproveId(String approveId) {
		this.approveId = approveId;
	}

	public Integer getIssueType() {
		return issueType;
	}

	public void setIssueType(Integer issueType) {
		this.issueType = issueType;
	}

}
