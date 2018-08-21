package com.zyxy.common.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.zyxy.common.constants.RegexpConstant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * 举证DTO
 */
@ApiModel("举证DTO")
public class EnumerateEvidenceDTO {
	
	/**
	 * 案件ID
	 */
	@ApiModelProperty("案件ID")
	@NotNull(message="案件ID不为空")
	private String caseId;
	
	/**
	 * 证据来源
	 */
	/*@ApiModelProperty("证据来源0申请方 1 被申请方")
	@NotNull(message="证据来源不为空")
	@Pattern(message="证据来源出错",regexp=RegexpConstant.CASE_EVIDENCE_TYPE)*/
	@ApiParam(hidden=true)
	private String evidenceType;
	
	/**
	 * 用户ID
	 */
	@ApiModelProperty("用户ID")
	@NotNull(message="用户ID不为空")
	private String userId;
	
	/**
	 * 证据
	 */
	@ApiModelProperty("证据")
	private List<CaseEvidenceDTO> caseEvidences;

	/**
	 * @return the caseId
	 */
	public String getCaseId() {
		return caseId;
	}

	/**
	 * @param caseId the caseId to set
	 */
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	/**
	 * @return the evidenceType
	 */
	public String getEvidenceType() {
		return evidenceType;
	}

	/**
	 * @param evidenceType the evidenceType to set
	 */
	public void setEvidenceType(String evidenceType) {
		this.evidenceType = evidenceType;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the caseEvidences
	 */
	public List<CaseEvidenceDTO> getCaseEvidences() {
		return caseEvidences;
	}

	/**
	 * @param caseEvidences the caseEvidences to set
	 */
	public void setCaseEvidences(List<CaseEvidenceDTO> caseEvidences) {
		this.caseEvidences = caseEvidences;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ListEvidenceDTO [caseId=" + caseId + ", evidenceType="
				+ evidenceType + ", userId=" + userId + ", caseEvidences="
				+ caseEvidences + "]";
	}
	
}
