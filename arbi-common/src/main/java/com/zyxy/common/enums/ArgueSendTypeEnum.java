package com.zyxy.common.enums;

public enum ArgueSendTypeEnum {
	PROPOSER("0","申请方"),
	
	DEFENDANT("1","被申请方"),
	
	ARBITRATOR("2","仲裁员");
	
	private String value;
	
	private String remark;

	private ArgueSendTypeEnum(String value, String remark) {
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
	};
}
