package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

public class CaseProtocolRecord implements Serializable {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column case_protocol_record.ID
	 * @mbggenerated
	 */
	private String id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column case_protocol_record.CASE_ID
	 * @mbggenerated
	 */
	private String caseId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column case_protocol_record.APPLY_TYPE
	 * @mbggenerated
	 */
	private String applyType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column case_protocol_record.PROP_OPINION
	 * @mbggenerated
	 */
	private String propOpinion;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column case_protocol_record.DEFE_OPINION
	 * @mbggenerated
	 */
	private String defeOpinion;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column case_protocol_record.CREATER_TYPE
	 * @mbggenerated
	 */
	private String createrType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column case_protocol_record.STATUS
	 * @mbggenerated
	 */
	private String status;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column case_protocol_record.CREATER_ID
	 * @mbggenerated
	 */
	private String createrId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column case_protocol_record.CREATE_TIME
	 * @mbggenerated
	 */
	private Date createTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column case_protocol_record.OTHER_OPERATING_TIME
	 * @mbggenerated
	 */
	private Date otherOperatingTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column case_protocol_record.ARBITRATOR_ID
	 * @mbggenerated
	 */
	private String arbitratorId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column case_protocol_record.ARBITRATOR_TIME
	 * @mbggenerated
	 */
	private Date arbitratorTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column case_protocol_record.PROTOCOL_TYPE
	 * @mbggenerated
	 */
	private String protocolType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table case_protocol_record
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column case_protocol_record.ID
	 * @return  the value of case_protocol_record.ID
	 * @mbggenerated
	 */
	public String getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column case_protocol_record.ID
	 * @param id  the value for case_protocol_record.ID
	 * @mbggenerated
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column case_protocol_record.CASE_ID
	 * @return  the value of case_protocol_record.CASE_ID
	 * @mbggenerated
	 */
	public String getCaseId() {
		return caseId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column case_protocol_record.CASE_ID
	 * @param caseId  the value for case_protocol_record.CASE_ID
	 * @mbggenerated
	 */
	public void setCaseId(String caseId) {
		this.caseId = caseId == null ? null : caseId.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column case_protocol_record.APPLY_TYPE
	 * @return  the value of case_protocol_record.APPLY_TYPE
	 * @mbggenerated
	 */
	public String getApplyType() {
		return applyType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column case_protocol_record.APPLY_TYPE
	 * @param applyType  the value for case_protocol_record.APPLY_TYPE
	 * @mbggenerated
	 */
	public void setApplyType(String applyType) {
		this.applyType = applyType == null ? null : applyType.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column case_protocol_record.PROP_OPINION
	 * @return  the value of case_protocol_record.PROP_OPINION
	 * @mbggenerated
	 */
	public String getPropOpinion() {
		return propOpinion;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column case_protocol_record.PROP_OPINION
	 * @param propOpinion  the value for case_protocol_record.PROP_OPINION
	 * @mbggenerated
	 */
	public void setPropOpinion(String propOpinion) {
		this.propOpinion = propOpinion == null ? null : propOpinion.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column case_protocol_record.DEFE_OPINION
	 * @return  the value of case_protocol_record.DEFE_OPINION
	 * @mbggenerated
	 */
	public String getDefeOpinion() {
		return defeOpinion;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column case_protocol_record.DEFE_OPINION
	 * @param defeOpinion  the value for case_protocol_record.DEFE_OPINION
	 * @mbggenerated
	 */
	public void setDefeOpinion(String defeOpinion) {
		this.defeOpinion = defeOpinion == null ? null : defeOpinion.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column case_protocol_record.CREATER_TYPE
	 * @return  the value of case_protocol_record.CREATER_TYPE
	 * @mbggenerated
	 */
	public String getCreaterType() {
		return createrType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column case_protocol_record.CREATER_TYPE
	 * @param createrType  the value for case_protocol_record.CREATER_TYPE
	 * @mbggenerated
	 */
	public void setCreaterType(String createrType) {
		this.createrType = createrType == null ? null : createrType.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column case_protocol_record.STATUS
	 * @return  the value of case_protocol_record.STATUS
	 * @mbggenerated
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column case_protocol_record.STATUS
	 * @param status  the value for case_protocol_record.STATUS
	 * @mbggenerated
	 */
	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column case_protocol_record.CREATER_ID
	 * @return  the value of case_protocol_record.CREATER_ID
	 * @mbggenerated
	 */
	public String getCreaterId() {
		return createrId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column case_protocol_record.CREATER_ID
	 * @param createrId  the value for case_protocol_record.CREATER_ID
	 * @mbggenerated
	 */
	public void setCreaterId(String createrId) {
		this.createrId = createrId == null ? null : createrId.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column case_protocol_record.CREATE_TIME
	 * @return  the value of case_protocol_record.CREATE_TIME
	 * @mbggenerated
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column case_protocol_record.CREATE_TIME
	 * @param createTime  the value for case_protocol_record.CREATE_TIME
	 * @mbggenerated
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column case_protocol_record.OTHER_OPERATING_TIME
	 * @return  the value of case_protocol_record.OTHER_OPERATING_TIME
	 * @mbggenerated
	 */
	public Date getOtherOperatingTime() {
		return otherOperatingTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column case_protocol_record.OTHER_OPERATING_TIME
	 * @param otherOperatingTime  the value for case_protocol_record.OTHER_OPERATING_TIME
	 * @mbggenerated
	 */
	public void setOtherOperatingTime(Date otherOperatingTime) {
		this.otherOperatingTime = otherOperatingTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column case_protocol_record.ARBITRATOR_ID
	 * @return  the value of case_protocol_record.ARBITRATOR_ID
	 * @mbggenerated
	 */
	public String getArbitratorId() {
		return arbitratorId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column case_protocol_record.ARBITRATOR_ID
	 * @param arbitratorId  the value for case_protocol_record.ARBITRATOR_ID
	 * @mbggenerated
	 */
	public void setArbitratorId(String arbitratorId) {
		this.arbitratorId = arbitratorId == null ? null : arbitratorId.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column case_protocol_record.ARBITRATOR_TIME
	 * @return  the value of case_protocol_record.ARBITRATOR_TIME
	 * @mbggenerated
	 */
	public Date getArbitratorTime() {
		return arbitratorTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column case_protocol_record.ARBITRATOR_TIME
	 * @param arbitratorTime  the value for case_protocol_record.ARBITRATOR_TIME
	 * @mbggenerated
	 */
	public void setArbitratorTime(Date arbitratorTime) {
		this.arbitratorTime = arbitratorTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column case_protocol_record.PROTOCOL_TYPE
	 * @return  the value of case_protocol_record.PROTOCOL_TYPE
	 * @mbggenerated
	 */
	public String getProtocolType() {
		return protocolType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column case_protocol_record.PROTOCOL_TYPE
	 * @param protocolType  the value for case_protocol_record.PROTOCOL_TYPE
	 * @mbggenerated
	 */
	public void setProtocolType(String protocolType) {
		this.protocolType = protocolType == null ? null : protocolType.trim();
	}
}