package com.zyxy.common.vo;

import com.zyxy.common.vo.doc.CaseDocAgentVO;
import com.zyxy.common.vo.doc.CaseDocLitigantVO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 委托书预览VO
 */
@ApiModel("委托书预览VO")
public class AuthorDocVO {
	
	/**
	 * 委托人
	 */
	@ApiModelProperty("委托人")
	private CaseDocLitigantVO Clientele;
	
	/**
	 * 代理
	 */
	@ApiModelProperty("代理")
	private CaseDocAgentVO CaseDocAgent;
	
	/**
	 * 案由
	 */
	@ApiModelProperty("案由")
	private String caseType;
	
	/**
	 * 授权类型
	 */
	@ApiModelProperty("授权类型")
	private String agentType;
	
	/**
	 * 落款时间
	 */
	@ApiModelProperty("落款时间")
	private String inscribeTime;
	
	/**
	 * 对方姓名
	 */
	@ApiModelProperty("对方姓名")
	private String oppositeName;

	public CaseDocLitigantVO getClientele() {
		return Clientele;
	}

	public void setClientele(CaseDocLitigantVO clientele) {
		Clientele = clientele;
	}

	public CaseDocAgentVO getCaseDocAgent() {
		return CaseDocAgent;
	}

	public void setCaseDocAgent(CaseDocAgentVO caseDocAgent) {
		CaseDocAgent = caseDocAgent;
	}

	public String getCaseType() {
		return caseType;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	public String getAgentType() {
		return agentType;
	}

	public void setAgentType(String agentType) {
		this.agentType = agentType;
	}

	public String getInscribeTime() {
		return inscribeTime;
	}

	public void setInscribeTime(String inscribeTime) {
		this.inscribeTime = inscribeTime;
	}

	public String getOppositeName() {
		return oppositeName;
	}

	public void setOppositeName(String oppositeName) {
		this.oppositeName = oppositeName;
	}

	@Override
	public String toString() {
		return "AuthorDocVO [Clientele=" + Clientele + ", CaseDocAgent="
				+ CaseDocAgent + ", caseType=" + caseType + ", agentType="
				+ agentType + ", inscribeTime=" + inscribeTime
				+ ", oppositeName=" + oppositeName + "]";
	}
	
}
