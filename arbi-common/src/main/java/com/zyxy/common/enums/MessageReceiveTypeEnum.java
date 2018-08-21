package com.zyxy.common.enums;

/**
 * 消息接受方类型
 */
public enum MessageReceiveTypeEnum {
	
	ALL("0","全部"),
	
	PROPOSER("1","申请人"),
	
	DEFENDANT("2","被申请人"),
	
	AGENT("3","代理人"),
	
	ARBTRATOR("4","仲裁员");
	
	private String value;
	
	private String remark;

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

	private MessageReceiveTypeEnum(String value, String remark) {
		this.value = value;
		this.remark = remark;
	}
	
	

}
