package com.zyxy.common.enums;

/**
 * 和解消息枚举
 */
public enum CompromiseMessageEnum {
	
	OUR_SIDE_AGREE("我方同意"),
	
	OUR_SIDE_REFUSE("我方拒绝"),
	
	OPPPOSITE_SIDE_AGREE("对方同意"),
	
	OPPOSITE_SIDE_REFUSE("对方拒绝"),
	
	ARBITRATOR_AGREE("第三方同意"),
	
	ARBITRATOR_REFUSE("第三方拒绝")
	
	;
	private String value;

	public String getValue() {
		return value;
	}

	private CompromiseMessageEnum(String value) {
		this.value = value;
	}
	
	
}
