package com.zyxy.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
/**
 * 裁决补正
 *
 */
@ApiModel(value ="指定案件裁决补正列表对象")
public class AdjudicationAmendmentDTO extends BasePageDTO{
	/**
	 * 补正记录id
	 */
	@ApiModelProperty("补正记录id")
	private String adjudicationId;
	
	/**
	 * 审批id
	 */
	@ApiModelProperty("审批id")
	@NotNull
	private String approveId;
	
	/**
	 * 案件id
	 */
	private String caseId;
	
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

	public String getAdjudicationId() {
		return adjudicationId;
	}

	public void setAdjudicationId(String adjudicationId) {
		this.adjudicationId = adjudicationId;
	}

	public String getApproveId() {
		return approveId;
	}

	public void setApproveId(String approveId) {
		this.approveId = approveId;
	}

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
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

}
