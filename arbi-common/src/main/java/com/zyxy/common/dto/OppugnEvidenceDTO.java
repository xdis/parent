package com.zyxy.common.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.zyxy.common.constants.RegexpConstant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 *	质证
 */
@ApiModel("质证DTO")
public class OppugnEvidenceDTO {
	
	/**
	 * 证据ID
	 */
	@ApiModelProperty("证据ID")
	@NotNull(message="证据ID不为空")
	private String id;
	
	/**
	 * 案件ID
	 */
	@ApiModelProperty("案件ID")
	@NotNull(message="案件ID不为空")
	private String caseId;
	
	/**
	 * 用户userId
	 */
	@ApiModelProperty("用户userId")
	@NotNull(message="用户userId不为空")
	private String userId;
	
	/**
	 * 证据来源
	 */
	/*@ApiModelProperty("证据来源0申请方 1被申请方")
	@NotNull(message="证据来源不为空")
	@Pattern(message="证据来源出错",regexp=RegexpConstant.CASE_EVIDENCE_TYPE)*/
	@ApiParam(hidden=true)
	private String evidenceType;
	
	/**
	 * 质证内容
	 */
	@ApiModelProperty("质证内容")
	@NotNull(message="质证内容不为空")
	private String oppugnEvidence;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

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
	 * @return the oppugnEvidence
	 */
	public String getOppugnEvidence() {
		return oppugnEvidence;
	}

	/**
	 * @param oppugnEvidence the oppugnEvidence to set
	 */
	public void setOppugnEvidence(String oppugnEvidence) {
		this.oppugnEvidence = oppugnEvidence;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OppugnEvidenceDTO [id=" + id + ", caseId=" + caseId
				+ ", userId=" + userId + ", evidenceType=" + evidenceType
				+ ", oppugnEvidence=" + oppugnEvidence + "]";
	}
	
}
