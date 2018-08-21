package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 仲裁员回避信息对象
 */
@ApiModel(value="仲裁员回避信息对象")
public class AvoidVO {
	/**
	 * 回避人
	 */
	@ApiModelProperty("回避人")
	private String avoidName;
    
    /**
	 * 回避申请人名称
	 */
	@ApiModelProperty("申请人名称")
	private String applicant;
	
	/**
	 * 请求事项
	 */
	@ApiModelProperty("请求事项")
	private String avoidRequst;
	
	/**
	 * 事实理由
	 */
	@ApiModelProperty("事实理由")
	private String avoidReason;
	
	/**
	 * 申请时间
	 */
	@ApiModelProperty("申请时间")
	private Date applicationTime;
	
	/**
	 * 回避Id
	 */
	@ApiModelProperty("回避Id")
	private String avoidId;
	
	/**
	 * 回避类型
	 */
	@ApiModelProperty("回避类型0-秘书回避1-仲裁员回避")
	private String avoidType;
	
	/**
	 * 回避方式
	 */
	@ApiModelProperty("回避方式0-申请方1-被申请方2-自己回避")
	private String avoidStyle;
	
	/**
	 * 案号
	 */
	@ApiModelProperty("案号")
	private String caseNo;
	
	/**
	 * 案件受理时间
	 */
	@ApiModelProperty("案件受理时间")
	private Date caseAcceptanceTime;
	
	/**
	 * 案件申请人
	 */
	@ApiModelProperty("案件申请人")
	private String propName;
	
	/**
	 * 案件被申请人
	 */
	@ApiModelProperty("案件被申请人")
	private String defePropName;
	
	/**
	 * 案由
	 */
	@ApiModelProperty("案由")
	private String caseTypeId;
	
	/**
	 * 仲裁员名称
	 */
	@ApiModelProperty("仲裁员名称")
	private String arbitrator;
	
	/**
	 * 秘书名称
	 */
	@ApiModelProperty("秘书名称")
	private String secretariesName;
	
	/**
	 * 组庭时间
	 */
	@ApiModelProperty("组庭时间")
	private Date triBunalTime;

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getAvoidRequst() {
		return avoidRequst;
	}

	public void setAvoidRequst(String avoidRequst) {
		this.avoidRequst = avoidRequst;
	}

	public String getAvoidReason() {
		return avoidReason;
	}

	public void setAvoidReason(String avoidReason) {
		this.avoidReason = avoidReason;
	}

	public String getAvoidId() {
		return avoidId;
	}

	public void setAvoidId(String avoidId) {
		this.avoidId = avoidId;
	}

	public String getAvoidType() {
		return avoidType;
	}

	public void setAvoidType(String avoidType) {
		this.avoidType = avoidType;
	}

	public String getAvoidStyle() {
		return avoidStyle;
	}

	public void setAvoidStyle(String avoidStyle) {
		this.avoidStyle = avoidStyle;
	}

	public String getAvoidName() {
		return avoidName;
	}

	public void setAvoidName(String avoidName) {
		this.avoidName = avoidName;
	}

	public Date getApplicationTime() {
		return applicationTime;
	}

	public void setApplicationTime(Date applicationTime) {
		this.applicationTime = applicationTime;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}



	public Date getCaseAcceptanceTime() {
		return caseAcceptanceTime;
	}

	public void setCaseAcceptanceTime(Date caseAcceptanceTime) {
		this.caseAcceptanceTime = caseAcceptanceTime;
	}

	public String getPropName() {
		return propName;
	}

	public void setPropName(String propName) {
		this.propName = propName;
	}

	public String getDefePropName() {
		return defePropName;
	}

	public void setDefePropName(String defePropName) {
		this.defePropName = defePropName;
	}

	public String getCaseTypeId() {
		return caseTypeId;
	}

	public void setCaseTypeId(String caseTypeId) {
		this.caseTypeId = caseTypeId;
	}

	public String getArbitrator() {
		return arbitrator;
	}

	public void setArbitrator(String arbitrator) {
		this.arbitrator = arbitrator;
	}

	public String getSecretariesName() {
		return secretariesName;
	}

	public void setSecretariesName(String secretariesName) {
		this.secretariesName = secretariesName;
	}

	public Date getTriBunalTime() {
		return triBunalTime;
	}

	public void setTriBunalTime(Date triBunalTime) {
		this.triBunalTime = triBunalTime;
	}
	
	
	
	
	

}
