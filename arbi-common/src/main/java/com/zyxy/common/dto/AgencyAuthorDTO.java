package com.zyxy.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * 代理授权
 */
@ApiModel("代理授权DTO")
public class AgencyAuthorDTO {
	
	/**
	 * 授权类型1一般代理 2特殊代理
	 */
	@ApiModelProperty("代理类型1一般代理2特殊代理")
	private String  agentType;
	
	/**
	 * 委托接受方姓名(代理人，申请认，被申请人)
	 */
	@ApiModelProperty("委托接受方姓名")
	private String accpetName;
	
	/**
	 * 委托接受方身份证
	 */
	@ApiModelProperty("委托接受方身份证")
	private String accpetCardId;
	
	/**
	 * 代理人身份类型0律师1公民
	 */
	@ApiModelProperty("代理人身份类型0律师1公民")
	private String agentStyle;
	
	/**
	 * 用户ID
	 */
	@ApiParam(hidden=true)
	private String userId;
	
	/**
	 * 立案号
	 */
	@ApiModelProperty("立案号")
	private String caseNo;
	
	/**
	 * 案件ID
	 */
	@ApiModelProperty("案件ID")
	private String caseId;
	
	/**
	 * 业务码
	 */
	@ApiModelProperty("业务码0申请人委托代理人1被申请人委托代理人2代理人主动请求申请人委托3代理人主动请求被申请委托")
	private String businessCode;
	
	/**
	 * 代理职业(律师所)
	 */
	@ApiModelProperty("代理职业(律师所)")
	private String duties;
	
	/**
	 * 案由
	 */
	@ApiModelProperty("案由")
	private String caseTypeId;
	
	@ApiModelProperty("所函")
	private String lawFirm;
	
	@ApiModelProperty("律师证")
	private String lawyerCertificate;
	
	@ApiModelProperty("短信验证码")
	private String messageCode;
	
	public String getMessageCode() {
		return messageCode;
	}

	public String getAgentType() {
		return agentType;
	}

	public void setAgentType(String agentType) {
		this.agentType = agentType;
	}

	public String getAccpetName() {
		return accpetName;
	}

	public void setAccpetName(String accpetName) {
		this.accpetName = accpetName;
	}

	public String getAccpetCardId() {
		return accpetCardId;
	}

	public void setAccpetCardId(String accpetCardId) {
		this.accpetCardId = accpetCardId;
	}

	public String getAgentStyle() {
		return agentStyle;
	}

	public void setAgentStyle(String agentStyle) {
		this.agentStyle = agentStyle;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getBusinessCode() {
		return businessCode;
	}

	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}
	
	public String getCaseTypeId() {
		return caseTypeId;
	}

	public void setCaseTypeId(String caseTypeId) {
		this.caseTypeId = caseTypeId;
	}
	
	public String getLawFirm() {
		return lawFirm;
	}

	public void setLawFirm(String lawFirm) {
		this.lawFirm = lawFirm;
	}

	public String getLawyerCertificate() {
		return lawyerCertificate;
	}

	public void setLawyerCertificate(String lawyerCertificate) {
		this.lawyerCertificate = lawyerCertificate;
	}
	
	public String getDuties() {
		return duties;
	}

	public void setDuties(String duties) {
		this.duties = duties;
	}

	@Override
	public String toString() {
		return "AgencyAuthorDTO [agentType=" + agentType + ", accpetName="
				+ accpetName + ", accpetCardId=" + accpetCardId
				+ ", agentStyle=" + agentStyle + ", userId=" + userId
				+ ", caseNo=" + caseNo + ", caseId=" + caseId
				+ ", businessCode=" + businessCode + ", duties=" + duties
				+ ", caseTypeId=" + caseTypeId + ", lawFirm=" + lawFirm
				+ ", lawyerCertificate=" + lawyerCertificate + ", messageCode="
				+ messageCode + "]";
	}
	
}
