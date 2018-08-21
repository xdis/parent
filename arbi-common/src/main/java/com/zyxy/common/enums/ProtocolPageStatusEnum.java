package com.zyxy.common.enums;

/**
 * 调节协议申请页面状态显示枚举
 */
public enum ProtocolPageStatusEnum {
	WAIT_OUR_RESPONSE("1","等待我方回应"),
	
	WAIT_OPPOSITE_RESPONSE("2","等待对方回应"),
	
	WAIT_PROTOCL("3","等待出具调解书"),
	
	COMPROMISE_OVER("4","和解终止"),
	
	WAIT_DECISION("5","等待出具裁决书"),
	
	COMPROMISE_FINISH("6","和解完成"),
	;
	private String code;
	
	private String statusName;

	private ProtocolPageStatusEnum(String code, String statusName) {
		this.code = code;
		this.statusName = statusName;
	}

	public String getCode() {
		return code;
	}

	public String getStatusName() {
		return statusName;
	}
	
}
