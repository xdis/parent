package com.zyxy.common.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.zyxy.common.constants.RegexpConstant;

/**
 * 保存文书对象DTO
 *
 */
public class SaveCaseDocDTO {

	/**
	 * 文书id
	 */
	private String docId;

	/**
	 * 文书内容id
	 */
	private String docContentId;

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
	 * 请求id
	 */
	private String requestId;

	/**
	 * 正文
	 */
	// @NotNull(message = "正文不能为空")
	private String bodyText;

	/**
	 * 意见
	 */
	// @NotNull(message = "意见不能为空")
	private String opinion;

	/**
	 * 出具类型
	 */
	private String issueType;

	/**
	 * 审批意见
	 */
	private String approveSuggest;

	/**
	 * 操作类型，是通过还是不通过
	 */
	private String opinionStatus;

	/**
	 * 审批id
	 */
	private String approveId;
	
	/**
	 * 记录表id
	 */
	private String caseJurisDisId;

	/**
	 * 案号
	 */
	private String caseNo;

	/**
	 * 请求类型
	 */
	private String requestType;

	/**
	 * 是否授权
	 */
	private String isAuthorized;

	/**
	 * 操作者职务
	 */
	private String duties;

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

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
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

	public void setFinalDecision(String finalDecision) {
		this.opinion = finalDecision;
	}

	public String getIssueType() {
		return issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
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

	public String getCaseJurisDisId() {
		return caseJurisDisId;
	}

	public void setCaseJurisDisId(String caseJurisDisId) {
		this.caseJurisDisId = caseJurisDisId;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}


	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}


	public String getIsAuthorized() {
		return isAuthorized;
	}

	public void setIsAuthorized(String isAuthorized) {
		this.isAuthorized = isAuthorized;
	}

	public String getDuties() {
		return duties;
	}

	public void setDuties(String duties) {
		this.duties = duties;
	}
}
