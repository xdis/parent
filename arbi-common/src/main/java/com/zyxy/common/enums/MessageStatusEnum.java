package com.zyxy.common.enums;

/**
 *消息状态 
 *
 */
public enum MessageStatusEnum {
	
	/**
	 * 消息未读
	 */
	UN_READED("0"),
	
	/**
	 * 消息已读
	 */
	READED("1");
	
	private String code;
	
	private MessageStatusEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
