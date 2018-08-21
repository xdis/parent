package com.zyxy.common.enums;
/**
 * 和解协议Opinion枚举
 */
public enum ProtocolOpinionEnum {
	  /**
     * 同意
     */
	OPINION_AGREE("0"),

    /**
     * 拒绝
     */
	OPINION_REFUSE("1");
	private String value;
	private ProtocolOpinionEnum(String value) {
		this.value = value;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
}
