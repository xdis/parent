package com.zyxy.common.enums;


/**
 * 案件节点记录状态Enum
 */
public enum CaseNodeOperDealStatusEnum {

	/**
     * 初始
	 */
	INIT("0"),
	/**
     * 成功
	 */
	SUCCESS("1"),
	/**
	 * 失败
	 */
	Fail("2"),
	/**
	 * 终止
	 */
	TERMINATION("3");

	private String code;

	private CaseNodeOperDealStatusEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
