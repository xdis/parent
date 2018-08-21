package com.zyxy.common.enums;

public enum SysResourceTypeEnum {
	MENU(1, "菜单"),
	BUTTON(2, "按钮"),
	DATA(3, "数据");
	
	private int value;
	private String remark;
	
	private SysResourceTypeEnum(int value, String remark) {
	    this.value = value;
	    this.remark = remark;
	}
	
	public int getValue() {
	    return value;
	}
	public String getRemark() {
	    return remark;
	}
	
	public static SysResourceTypeEnum getByValue(int value) {
	    for (SysResourceTypeEnum o : SysResourceTypeEnum.values()) {
	        if (o.getValue() == value) {
	            return o;
	        }
	    }
	    return null;
	}
}
