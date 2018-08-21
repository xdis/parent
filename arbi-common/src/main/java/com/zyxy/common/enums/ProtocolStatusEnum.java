package com.zyxy.common.enums;

/**
 * 调解协议书申请状态
 */

public enum ProtocolStatusEnum {
	/**
	 * 等待对方回应
	 */
	WAIT("0",""),
	
	
	/**
	 * 拒绝
	 */
	REFUSE("1","拒绝"),
	
	/**
	 * 同意
	 */
	AGREE("2","同意")
	
	;
	
	private String value;
	
	private String remark;

	private ProtocolStatusEnum(String value, String remark) {
		this.value = value;
		this.remark = remark;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	
	
	
	
}
