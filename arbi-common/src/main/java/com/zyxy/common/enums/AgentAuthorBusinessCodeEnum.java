package com.zyxy.common.enums;

/**
 * 代理授权业务码
 */
public enum AgentAuthorBusinessCodeEnum {
	
	/**
	 * 申请人邀请代理授权
	 */
	PROPOSER_INVITE_AGENT("0","申请人邀请代理授权"),
	
	/**
	 * 被申请人邀请代理授权
	 */
	DEFENDANT_INVITE_AGENT("1","被申请人邀请代理授权"),
	
	/**
	 * 代理申请人主动授权
	 */
	AGENT_INVITE_PROPOSER("2","代理申请人主动授权"),
	
	/**
	 * 代理被申请人主动授权
	 */
	AGENT_INVITE_DEFENDANT("3","代理被申请人主动授权"),
	;
	private String value;
	
	private String remark;

	public String getValue() {
		return value;
	}

	public String getRemark() {
		return remark;
	}

	private AgentAuthorBusinessCodeEnum(String value, String remark) {
		this.value = value;
		this.remark = remark;
	}
	
	
}
