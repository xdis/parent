package com.zyxy.common.enums;


/**
 * 案件进展节点Enum
 */
public enum CaseMainNodeEnum {

	/**
     * 立案审核
	 */
	CASE_CHECK(1),
	/**
     * 立案审核不通过
	 */
	CASE_CHECK_NOT_PASS(2),
	/**
	 * 立案缴费
	 */
	CASE_PAY(3),
	/**
	 * 立案失败
	 */
	CASE_FAIL(9),
	/**
	 * 答辩期
	 */
	CASE_REPLY(4),
	/**
	 * 审理期
	 */
	CASE_PROCESSING(5),
	/**
	 * 裁决期
	 */
	CASE_ARBI(6),
	/**
	 * 案件结案
	 */
	CASE_OVER(7),
	/**
	 * 案件补正
	 */
    CASE_OFFSET(8),
    /**
     * 案件转线下
     */
    CASE_TO_OFFLINE(10);

	private Integer code;

	private CaseMainNodeEnum(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
