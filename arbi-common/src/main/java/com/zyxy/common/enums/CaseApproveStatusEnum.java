package com.zyxy.common.enums;

/**
 * 案件审批状态枚举
 */
public enum CaseApproveStatusEnum {
	/**
	 * 待审核状态
	 */
	WAIT_AUDIT("0", "待审核"),

	/**
	 * 审核成功状态
	 */
	SUCCESS_AUDIT("1", "审核通过"),

	/**
	 * 审核失败状态
	 */
	FAIL_AUDIT("2", "审核未通过"),
	
	/**
	 * 代缴费
	 */
	BILL_PAYMENT("3", "代缴费"),
	
	/**
	 * 缴费超时
	 */
	CAPTURE_EXPENDS_TIMEOUT("4", "缴费超时");
	

	private String value;
	private String remark;

	private CaseApproveStatusEnum(String value, String remark) {
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
