package com.zyxy.common.enums;

/**
 *	是否系统推荐枚举
 */
public enum SysRecommendFlagEnum {

	/**
	 * 系统推荐
	 */
	SYS_RECOMMEND("0", "系统推荐"),
	
	/**
	 * 自己选择
	 */
	SELF_CHOICE("1","自己选择");
	
	private String value;
	
	private String remark;

	private SysRecommendFlagEnum(String value, String remark) {
		this.value = value;
		this.remark = remark;
	}

	public String getValue() {
		return value;
	}

	public String getRemark() {
		return remark;
	}
	
}
