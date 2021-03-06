package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table case_approve_suggest
 *
 * @mbggenerated do_not_delete_during_merge
 */
public class CaseApproveSuggest implements Serializable {

	/**
	 * Database Column Remarks: 审批意见id This field was generated by MyBatis Generator. This field corresponds to the database column case_approve_suggest.ID
	 * @mbggenerated
	 */
	private String id;
	/**
	 * Database Column Remarks: 案件ID This field was generated by MyBatis Generator. This field corresponds to the database column case_approve_suggest.CASE_ID
	 * @mbggenerated
	 */
	private String caseId;
	/**
	 * Database Column Remarks: 审批ID This field was generated by MyBatis Generator. This field corresponds to the database column case_approve_suggest.APPROVE_ID
	 * @mbggenerated
	 */
	private String approveId;
	/**
	 * Database Column Remarks: 意见状态：0-通过1-驳回 This field was generated by MyBatis Generator. This field corresponds to the database column case_approve_suggest.OPINION_STATUS
	 * @mbggenerated
	 */
	private String opinionStatus;
	/**
	 * Database Column Remarks: 创建人 This field was generated by MyBatis Generator. This field corresponds to the database column case_approve_suggest.CREATER_ID
	 * @mbggenerated
	 */
	private String createrId;
	/**
	 * Database Column Remarks: 创建时间 This field was generated by MyBatis Generator. This field corresponds to the database column case_approve_suggest.CREATE_TIME
	 * @mbggenerated
	 */
	private Date createTime;
	/**
	 * Database Column Remarks: 审批标注 This field was generated by MyBatis Generator. This field corresponds to the database column case_approve_suggest.MARK
	 * @mbggenerated
	 */
	private String mark;
	/**
	 * Database Column Remarks: 意见人职务 This field was generated by MyBatis Generator. This field corresponds to the database column case_approve_suggest.SUGGEST_USER_DUTIES
	 * @mbggenerated
	 */
	private String suggestUserDuties;
	/**
	 * Database Column Remarks: 是否授权，0-是，1-否 This field was generated by MyBatis Generator. This field corresponds to the database column case_approve_suggest.IS_AUTHORIZED
	 * @mbggenerated
	 */
	private String isAuthorized;
	/**
	 * Database Column Remarks: 审批意见 This field was generated by MyBatis Generator. This field corresponds to the database column case_approve_suggest.APPROVE_SUGGEST
	 * @mbggenerated
	 */
	private String approveSuggest;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table case_approve_suggest
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column case_approve_suggest.ID
	 * @return  the value of case_approve_suggest.ID
	 * @mbggenerated
	 */
	public String getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column case_approve_suggest.ID
	 * @param id  the value for case_approve_suggest.ID
	 * @mbggenerated
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column case_approve_suggest.CASE_ID
	 * @return  the value of case_approve_suggest.CASE_ID
	 * @mbggenerated
	 */
	public String getCaseId() {
		return caseId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column case_approve_suggest.CASE_ID
	 * @param caseId  the value for case_approve_suggest.CASE_ID
	 * @mbggenerated
	 */
	public void setCaseId(String caseId) {
		this.caseId = caseId == null ? null : caseId.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column case_approve_suggest.APPROVE_ID
	 * @return  the value of case_approve_suggest.APPROVE_ID
	 * @mbggenerated
	 */
	public String getApproveId() {
		return approveId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column case_approve_suggest.APPROVE_ID
	 * @param approveId  the value for case_approve_suggest.APPROVE_ID
	 * @mbggenerated
	 */
	public void setApproveId(String approveId) {
		this.approveId = approveId == null ? null : approveId.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column case_approve_suggest.OPINION_STATUS
	 * @return  the value of case_approve_suggest.OPINION_STATUS
	 * @mbggenerated
	 */
	public String getOpinionStatus() {
		return opinionStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column case_approve_suggest.OPINION_STATUS
	 * @param opinionStatus  the value for case_approve_suggest.OPINION_STATUS
	 * @mbggenerated
	 */
	public void setOpinionStatus(String opinionStatus) {
		this.opinionStatus = opinionStatus == null ? null : opinionStatus
				.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column case_approve_suggest.CREATER_ID
	 * @return  the value of case_approve_suggest.CREATER_ID
	 * @mbggenerated
	 */
	public String getCreaterId() {
		return createrId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column case_approve_suggest.CREATER_ID
	 * @param createrId  the value for case_approve_suggest.CREATER_ID
	 * @mbggenerated
	 */
	public void setCreaterId(String createrId) {
		this.createrId = createrId == null ? null : createrId.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column case_approve_suggest.CREATE_TIME
	 * @return  the value of case_approve_suggest.CREATE_TIME
	 * @mbggenerated
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column case_approve_suggest.CREATE_TIME
	 * @param createTime  the value for case_approve_suggest.CREATE_TIME
	 * @mbggenerated
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column case_approve_suggest.MARK
	 * @return  the value of case_approve_suggest.MARK
	 * @mbggenerated
	 */
	public String getMark() {
		return mark;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column case_approve_suggest.MARK
	 * @param mark  the value for case_approve_suggest.MARK
	 * @mbggenerated
	 */
	public void setMark(String mark) {
		this.mark = mark == null ? null : mark.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column case_approve_suggest.SUGGEST_USER_DUTIES
	 * @return  the value of case_approve_suggest.SUGGEST_USER_DUTIES
	 * @mbggenerated
	 */
	public String getSuggestUserDuties() {
		return suggestUserDuties;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column case_approve_suggest.SUGGEST_USER_DUTIES
	 * @param suggestUserDuties  the value for case_approve_suggest.SUGGEST_USER_DUTIES
	 * @mbggenerated
	 */
	public void setSuggestUserDuties(String suggestUserDuties) {
		this.suggestUserDuties = suggestUserDuties == null ? null
				: suggestUserDuties.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column case_approve_suggest.IS_AUTHORIZED
	 * @return  the value of case_approve_suggest.IS_AUTHORIZED
	 * @mbggenerated
	 */
	public String getIsAuthorized() {
		return isAuthorized;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column case_approve_suggest.IS_AUTHORIZED
	 * @param isAuthorized  the value for case_approve_suggest.IS_AUTHORIZED
	 * @mbggenerated
	 */
	public void setIsAuthorized(String isAuthorized) {
		this.isAuthorized = isAuthorized == null ? null : isAuthorized.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column case_approve_suggest.APPROVE_SUGGEST
	 * @return  the value of case_approve_suggest.APPROVE_SUGGEST
	 * @mbggenerated
	 */
	public String getApproveSuggest() {
		return approveSuggest;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column case_approve_suggest.APPROVE_SUGGEST
	 * @param approveSuggest  the value for case_approve_suggest.APPROVE_SUGGEST
	 * @mbggenerated
	 */
	public void setApproveSuggest(String approveSuggest) {
		this.approveSuggest = approveSuggest == null ? null : approveSuggest
				.trim();
	}
}