package com.zyxy.common.vo;

import java.util.Date;

/**
 * 代理授权数据接收
 */
public class AgentAuthorDataVO {

	private String caseType;
	
	private String agentType;
	
	private Date applyTime;

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

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	@Override
	public String toString() {
		return "AgentAuthorDataVO [caseType=" + caseType + ", agentType="
				+ agentType + ", applyTime=" + applyTime + "]";
	}
	
	
}
