package com.zyxy.common.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 代理草稿代理信息
 */
public class CaseDraftAgentAuthorVO {
  
	/**
	 * 授权类型1一般代理 2特殊代理
	 */
	@ApiModelProperty("代理类型1一般代理2特殊代理")
	private String  agentType;
	
	/**
	 * 代理人身份类型0律师1公民
	 */
	@ApiModelProperty("代理人身份类型0律师1公民")
	private String agentStyle;
	
	/**
	 * 所函
	 */
	@ApiModelProperty("所函")
	private String lawFirm;
	
	/**
	 * 律师证
	 */
	@ApiModelProperty("律师证")
	private String lawerCertificate;
	
	/**
	 * 案由
	 */
	@ApiModelProperty("案由")
	private String caseType;

	public String getAgentType() {
		return agentType;
	}

	public void setAgentType(String agentType) {
		this.agentType = agentType;
	}

	public String getAgentStyle() {
		return agentStyle;
	}

	public void setAgentStyle(String agentStyle) {
		this.agentStyle = agentStyle;
	}

	public String getLawFirm() {
		return lawFirm;
	}

	public void setLawFirm(String lawFirm) {
		this.lawFirm = lawFirm;
	}

	public String getLawerCertificate() {
		return lawerCertificate;
	}

	public void setLawerCertificate(String lawerCertificate) {
		this.lawerCertificate = lawerCertificate;
	}

	@Override
	public String toString() {
		return "CaseDraftAgentAuthorVO [agentType=" + agentType
				+ ", agentStyle=" + agentStyle + ", lawFirm=" + lawFirm
				+ ", lawerCertificate=" + lawerCertificate + "]";
	}
	
	
	
}
