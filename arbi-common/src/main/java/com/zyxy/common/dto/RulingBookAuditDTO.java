package com.zyxy.common.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 裁决书审核DTO
 */
@ApiModel(value = "裁决书审核DTO")
public class RulingBookAuditDTO extends BaseDTO{
	
	/**
	 * 案件id
	 */
	@NotNull(message = "案件id不能为空")
	@ApiModelProperty(value = "案件id")
	private String caseId;

	/**
	 * 审批意见
	 */
	@ApiModelProperty(value = "审批意见")
	private String approveSuggest;

	/**
	 * 意见状态
	 */
	@NotNull(message = "意见状态")
	@ApiModelProperty(value = "意见状态")
	private String opinionStatus;
	
	/**
	 * 当前审批id
	 */
	@NotNull(message = "审批Id不能为空")
	@ApiModelProperty(value = "当前审批id")
	private String approveId;

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

	public String getApproveId() {
		return approveId;
	}

	public void setApproveId(String approveId) {
		this.approveId = approveId;
	}
	

}
