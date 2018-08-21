package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 当事人授权
 */
@ApiModel("当事人授权存储信息VO")
public class LitigantAuthorStorageVO {
	
	/**
	 * 代理姓名
	 */
	@ApiModelProperty("代理姓名")
	private String agentName;
	
	/**
	 * 代理身份证
	 */
	@ApiModelProperty("代理身份证")
	private String agentCardId;
	
	/**
	 * 授权类型1一般代理 2特殊代理
	 */
	@ApiModelProperty("代理类型1一般代理2特殊代理")
	private String agentType;
	
	/**
	 * 代理人身份类型0律师1公民
	 */
	@ApiModelProperty("代理人身份类型0律师1公民")
	private String agentStyle;
	
	/**
	 * 案由
	 */
	@ApiModelProperty("案由")
	private String caseType;
	
	/**
	 * 律师事务所
	 */
	@ApiModelProperty("律师事务所")
	private String duties;

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getAgentCardId() {
		return agentCardId;
	}

	public void setAgentCardId(String agentCardId) {
		this.agentCardId = agentCardId;
	}

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

	public String getCaseType() {
		return caseType;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	public String getDuties() {
		return duties;
	}

	public void setDuties(String duties) {
		this.duties = duties;
	}

	@Override
	public String toString() {
		return "LitigantAuthorStorageVO [agentName=" + agentName
				+ ", agentCardId=" + agentCardId + ", agentType=" + agentType
				+ ", agentStyle=" + agentStyle + ", caseType=" + caseType
				+ ", duties=" + duties + "]";
	}
	
}
