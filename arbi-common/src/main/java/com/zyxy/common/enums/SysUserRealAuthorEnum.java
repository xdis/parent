package com.zyxy.common.enums;

/**
 * 系统用户活体认证
 */
public enum SysUserRealAuthorEnum {
	
	/**
	 * 没有认证
	 */
	NO("0","没有认证"),
	
	/**
	 * 已认证
	 */
	YES("1","已认证")
	;
	private String value;
	
	private String remark;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	private SysUserRealAuthorEnum(String value, String remark) {
		this.value = value;
		this.remark = remark;
	}
	
}
