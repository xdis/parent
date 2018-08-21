package com.zyxy.common.enums;

/**
 * 和解状态枚举
 */
public enum CompromiseStatusEnum {
	
	WAIT_AUDIT("0","待审核"),
	
	ONGOINF("1","和解中"),
	
	REFUSE("2","拒绝和解"),

	COMPLETE("3", "完成"),

	WAIT_START("4", "等待开始"),

	WAIT_ECHO("5", "等待对方回应");
	
	private String value;
	
	private String remark;

	private CompromiseStatusEnum(String value, String remark) {
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
