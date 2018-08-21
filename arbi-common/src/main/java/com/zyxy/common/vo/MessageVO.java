package com.zyxy.common.vo;

/**
 * 授权短信输出
 */
public class MessageVO {
	
	private String name;
	
	private String phone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "MessageVO [name=" + name + ", phone=" + phone + ", getName()="
				+ getName() + ", getPhone()=" + getPhone() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}
