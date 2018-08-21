package com.zyxy.common.vo;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("仲裁员回避决定书VO")
public class ArbitratorAvoidDecisionDocVO {
	
	/**
	 * 回避申请人
	 */
	@ApiModelProperty("回避申请人")
	private String applicantName;
	
	/**
	 * 案号
	 */
	@ApiModelProperty("案号")
	private String caseNo;
	
	/**
	 * 案件受理时间
	 */
	@ApiModelProperty("案件受理时间")
	private Date acceptanceTime;
	
	/**
	 * 案件申请人姓名
	 */
	@ApiModelProperty("案件申请人姓名")
	private String propName;
	
	/**
	 * 案件被申请人姓名
	 */
	@ApiModelProperty("案件被申请人姓名")
	private String defeName;
	
	/**
	 * 案由
	 */
	@ApiModelProperty("案由")
	private String caseType;
	
	/**
	 * 仲裁员姓名
	 */
	@ApiModelProperty("仲裁员姓名")
	private String arbiName;
	
	/**
	 * 组庭时间
	 */
	@ApiModelProperty("组庭时间")
	private String groupTime;
	
	/**
	 * 回避申请时间
	 */
	@ApiModelProperty("回避申请时间")
	private String applyTime;
	
	/**
	 * 仲裁委意见
	 */
	@ApiModelProperty("仲裁委意见")
	private String advice;
	
	/**
	 * 申请结果
	 */
	@ApiModelProperty("申请结果")
	private String status;
	
	/**
	 * 秘书姓名
	 */
	@ApiModelProperty("秘书姓名")
	private String secretaryName;

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public Date getAcceptanceTime() {
		return acceptanceTime;
	}

	public void setAcceptanceTime(Date acceptanceTime) {
		this.acceptanceTime = acceptanceTime;
	}

	public String getPropName() {
		return propName;
	}

	public void setPropName(String propName) {
		this.propName = propName;
	}

	public String getDefeName() {
		return defeName;
	}

	public void setDefeName(String defeName) {
		this.defeName = defeName;
	}

	public String getCaseType() {
		return caseType;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	public String getArbiName() {
		return arbiName;
	}

	public void setArbiName(String arbiName) {
		this.arbiName = arbiName;
	}

	public String getGroupTime() {
		return groupTime;
	}

	public void setGroupTime(String groupTime) {
		this.groupTime = groupTime;
	}

	public String getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSecretaryName() {
		return secretaryName;
	}

	public void setSecretaryName(String secretaryName) {
		this.secretaryName = secretaryName;
	}

	@Override
	public String toString() {
		return "ArbitratorAvoidDecisionDocVO [applicantName=" + applicantName
				+ ", caseNo=" + caseNo + ", acceptanceTime=" + acceptanceTime
				+ ", propName=" + propName + ", defeName=" + defeName
				+ ", caseType=" + caseType + ", arbiName=" + arbiName
				+ ", groupTime=" + groupTime + ", applyTime=" + applyTime
				+ ", advice=" + advice + ", status=" + status
				+ ", secretaryName=" + secretaryName + "]";
	}
	
}
