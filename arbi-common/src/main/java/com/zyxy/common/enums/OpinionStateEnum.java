package com.zyxy.common.enums;
/**
 * 意见状态
 */
public enum OpinionStateEnum {

	// ###############审批意见########################
	/**
	 * 通过
	 */
	GET_THROUGH("0", "通过"),
	/**
	 * 驳回
	 */
	REJECTED("1", "驳回");
	// ###############审批意见########################
	
	
	private String value;
	private String remark;

	private OpinionStateEnum(String value, String remark) {
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
