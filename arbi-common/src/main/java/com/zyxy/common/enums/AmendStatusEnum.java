package com.zyxy.common.enums;

/**
 * 补正状态枚举
 */
public enum AmendStatusEnum {
	
	WAIT("0","待审核"),
	
	SUCCESS("1","审核成功"),
	
	FAIL("2","审核失败");
	
	private String value;
	
	
	private String remark;


	private AmendStatusEnum(String value, String remark) {
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
