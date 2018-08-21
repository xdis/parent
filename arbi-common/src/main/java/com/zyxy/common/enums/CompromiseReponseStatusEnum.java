package com.zyxy.common.enums;

/**
 *	和解回应方状态
 */
public enum CompromiseReponseStatusEnum {
	
	AGREE("0","同意"),
	
	REFUSE("1","拒绝");
	

	private String value;
	
	private String remark;

	private CompromiseReponseStatusEnum(String value, String remark) {
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
