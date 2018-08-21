package com.zyxy.common.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.zyxy.common.constants.RegexpConstant;

/**
 * 变更仲裁请求DTO
 *
 */
public class CaseChangeRecordDTO extends BaseDTO {

	/**
	 * 案件id
	 */
	@NotNull(message = "案件id不能为空")
	private String caseId;

	/**
	 * 用户id
	 */
	private String userId;

	/**
	 * 请求标志 0-本请求 1-反请求
	 */
	@NotNull(message = "请求标志不能为空")
	@Pattern(regexp = RegexpConstant.CASE_COUNTERCLAIM_FLAG, message = "请求标志出错")
	private String counterclaimFlag;

	/**
	 * 审批类型不能为空
	 */
	@NotNull(message = "审批类型不能为空")
	private String approveType;

	/**
	 * 文书类型
	 */
	private String docType;

	/**
	 * 出具类型 0-正（同意模板文书） 1-反（不同意模板文书）
	 */
	private String issueType;

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCounterclaimFlag() {
		return counterclaimFlag;
	}

	public void setCounterclaimFlag(String counterclaimFlag) {
		this.counterclaimFlag = counterclaimFlag;
	}

	public String getApproveType() {
		return approveType;
	}

	public void setApproveType(String approveType) {
		this.approveType = approveType;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getIssueType() {
		return issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

}
