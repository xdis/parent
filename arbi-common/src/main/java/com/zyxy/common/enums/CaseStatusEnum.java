package com.zyxy.common.enums;

/**
 * 案件状态枚举类
 * 
 */
public enum CaseStatusEnum {
	
	/**
	 * 待提交
	 */
	WAIT_COMMIT("0","待提交"),
	
	/**
	 * 待审核
	 */
	WAIT_AUDIT("1","待审核"),
	
	/**
	 * 审核成功
	 */
	SUCCESS_AUDIT("2","审核成功"),
	
	/**
	 * 待缴费
	 */
	WAIT_PAY("3","待缴费"),
	
	/**
	 * 组庭
	 */
	ORGANIZE_CSOURT("4","组庭"),
	
	/**
	 * 答辩
	 */
	ANSWER_PERIOD("5","答辩"),

	/**
	 * 裁判
	 */
	JUDGMENT_PERIOD("6","裁判"),
	
	/**
	 * 结案
	 */
	CASE_SETTLE("7","结案"),
	
	CASE_COMPROMISE("","和解"),
	
	/**
	 * 补正
	 */
	CORRECTION_PERIOD("8","补正"),
	
	/**
	 * 立案失败
	 */
	FAIL_REGISTER("9","立案失败"),
	
	/**
	 * 已撤案
	 */
	ALREADY_WITHDRAW("10","已撤案");
	
	private String value;
	
	private String remark;
	
	
	private CaseStatusEnum(String value, String remark) {
		this.value = value;
		this.remark = remark;
	}
	
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
}
