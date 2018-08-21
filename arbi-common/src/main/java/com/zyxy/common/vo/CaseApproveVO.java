package com.zyxy.common.vo;

/**
 * 案件审批VO
 *
 */
public class CaseApproveVO {
	/**
	 * 案件id
	 */
	private String caseId;

	/**
	 * 请求id
	 */
	private String requestId;

	/**
	 * 审批类型
	 */
	private String approveType;

	/**
	 * 审批类型名称
	 */
	private String approveTypeName;
	
	/**
	 * 审批url地址
	 */
	private String approveUrl;
	
	/**
	 * 审批权限，
	 * 0-有
	 * 1-无
	 */
	private String primiss;
	
	/**
	 * 当前审批是否到我这里审批
	 * 0-是
	 * 1-否
	 */
	private String isMyOperation;

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getApproveType() {
		return approveType;
	}

	public void setApproveType(String approveType) {
		this.approveType = approveType;
	}

	public String getApproveTypeName() {
		return approveTypeName;
	}

	public void setApproveTypeName(String approveTypeName) {
		this.approveTypeName = approveTypeName;
	}

	public String getApproveUrl() {
		return approveUrl;
	}

	public void setApproveUrl(String approveUrl) {
		this.approveUrl = approveUrl;
	}

	public String getPrimiss() {
		return primiss;
	}

	public void setPrimiss(String primiss) {
		this.primiss = primiss;
	}

	public String getIsMyOperation() {
		return isMyOperation;
	}

	public void setIsMyOperation(String isMyOperation) {
		this.isMyOperation = isMyOperation;
	}
}
