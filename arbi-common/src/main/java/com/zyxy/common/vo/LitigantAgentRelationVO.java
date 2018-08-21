package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 当事人代理关系
 */
@ApiModel("当事人代理关系")
public class LitigantAgentRelationVO {
	
	/**
	 * 姓名
	 */
	@ApiModelProperty("姓名")
	private String name;
	
	/**
	 * 年龄
	 */
	@ApiModelProperty("年龄")
	private String age;
	
	/**
	 * 身份证号
	 */
	@ApiModelProperty("身份证号")
	private String cardId;
	
	/**
	 * 电话号码
	 */
	@ApiModelProperty("电话号码")
	private String phone;
	
	/**
	 * 邮箱
	 */
	@ApiModelProperty("邮箱")
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "LitigantAgentRelationVO [name=" + name + ", age=" + age
				+ ", cardId=" + cardId + ", phone=" + phone + ", email="
				+ email + "]";
	}
	
}