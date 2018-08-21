package com.zyxy.common.enums;

/**
 * 调节状态枚举类
 */
public enum CaseMediateProcessStatusEnum {
	
	/**
	 *  等待仲裁员出具调解书
	 */
	WAIT_PROTOCOL_DOC("0"," 等待仲裁员出具调解书"),
	
	/**
	 * 等待双方签字
	 */
	WAIT_LITIGANT_SIGN("1","等待双方签字"),
	
	/**
	 * 终止调解
	 */
	STOP_PROTOCOL("2","终止调解"),
	
	/**
	 * 完成调解
	 */
	FINISH_PROTOCOL("3","完成调解"),
	;
	
	private String value;
	
	private String remark;

	public String getValue() {
		return value;
	}

	public String getRemark() {
		return remark;
	}

	private CaseMediateProcessStatusEnum(String value, String remark) {
		this.value = value;
		this.remark = remark;
	}
	
}
