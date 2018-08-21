package com.zyxy.common.enums;

/**
 * 协议申请书同意枚举
 */
public enum CaseProtocolOpinionEnum {
	
	/**
	 * 同意
	 */
	OPINION_AGREE("0","同意"),
	
	/**
	 * 拒绝
	 */
	OPINION_REFUSE("1","拒绝");
	
	private String value;
	
	private String remark;
	
	private  CaseProtocolOpinionEnum(String value, String remark) {
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
