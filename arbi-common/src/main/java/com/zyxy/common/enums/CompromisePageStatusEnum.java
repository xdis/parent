package com.zyxy.common.enums;

/**
 * 和解返回页面状态枚举
 */
public enum CompromisePageStatusEnum {
	
	NO_COMPROMISE("0","无和解"),
	
	WAIT_OPPSITE_RESPONSE("1","等待对方和解回应"),
	
	WAIT_OUR_RESPONSE("2","等待我方和解反应"),
	
	WAIT_ARBITRATOR_RESPONSE("3","等待第三方和解回应"),
	
	COMPROMISING("4","和解中"),
	
	REFUSE_COMPROMISE("5","拒绝和解"),
	
	WAIT_OPPSITE_PROTOCOL_RESPONSE("6","等待对方调解协议回应"),
	
	WAIT_OUR_PROTOCOL_RESPONSE("7","等待我方调解协议回应"),
	
	FINISH_COMPROMISE("8","和解完成"),
	
	GENERAL_AGENT_OPERATION("9","一般代理操作"),
	
	;
	private String value;
	
	private String remark;

	public String getValue() {
		return value;
	}

	public String getRemark() {
		return remark;
	}

	private CompromisePageStatusEnum(String value, String remark) {
		this.value = value;
		this.remark = remark;
	}
	
}
