package com.zyxy.common.enums;

/**
 * 案件材料包类型Enum
 */
public enum CaseMatTypeEnum {

	/**
	 * 附件
	 */
	ATTACHMENT("0"),
	/**
	 * 请求证据
	 */
	REQUEST_EVIDENCE("1"),
	/**
	 * 答辩证据
	 */
	REPLY_EVIDENCE("2"),
	/**
	 * 委托代理人材料
	 */
	ATTORNEY_MATERIAL("3"),
	/**
	 * 举证证据
	 */
	ENUMERATE_EVIDENCE("4"),
	/**
	 * 律师证
	 */
	LAWER_CERTIFICATE("5"),
	;
	private String code;

	private CaseMatTypeEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
