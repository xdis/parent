package com.zyxy.common.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * 案件当事人验证
 */
@ApiModel("当事人案件验证DTO")
public class CaseLitigantValidDTO {
	
	/**
	 * 当事人姓名
	 */
	@ApiModelProperty("当事人姓名")
	@NotNull(message="当事人姓名不为空")
	private String name;
	
	/**
	 * 当事人身份证
	 */
	@ApiModelProperty("当事人身份证")
	@NotNull(message="当事人身份证")
	private String cardId;
	
	/**
	 * 案号
	 */
	@ApiModelProperty("案号")
	@NotNull(message="案号不为空")
	private String caseNo;
	
	/**
	 * 类型
	 */
	@ApiModelProperty("代理类型0申请人1被申请人")
	@NotNull(message="代理类型不为空")
	@Pattern(regexp="[01]",message="代理类型出错")
	private String agentRole;
	
	@ApiParam(hidden=true)
	private String userId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getAgentRole() {
		return agentRole;
	}

	public void setAgentRole(String agentRole) {
		this.agentRole = agentRole;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "CaseLitigantValidDTO [name=" + name + ", cardId=" + cardId
				+ ", caseNo=" + caseNo + ", agentRole=" + agentRole
				+ ", userId=" + userId + "]";
	}
	
	
}
