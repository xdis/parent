package com.zyxy.common.enums;
/**
 * 撤案类型枚举
 */
public enum WithdrawCaseTypeEnum {
	/** 当事人撤案  **/
	LITIGANT_WITHDRAW_CASE("0"),
	
	/** 双方撤案  **/
	BOTH_WITHDRAW_CASE("1");
	
	private String code;
	private WithdrawCaseTypeEnum(String code){
		this.code = code;
	}
	public String getCode() {
		return code;
	}
}
