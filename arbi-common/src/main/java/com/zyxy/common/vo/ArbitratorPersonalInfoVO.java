package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 仲裁员基本信息VO
 */
@ApiModel(value="仲裁员基本信息")
public class ArbitratorPersonalInfoVO {
	/**
	 * 仲裁员姓名
	 */
	@ApiModelProperty(value="仲裁员姓名")
	private String name;
	
	/**
	 * 年龄
	 */
	@ApiModelProperty(value="年龄")
	private String birthday;
	
	/**
	 * 仲裁员职业
	 */
	@ApiModelProperty(value="仲裁员职业")
	private String vocation;
	
	/**
	 * 仲裁员专长
	 */
	@ApiModelProperty(value="仲裁员专长")
	private String specialty;
	
	/**
	 * 仲裁员居住地
	 */
	@ApiModelProperty(value="仲裁员居住地")
	private String address;
	
	/**
	 * 仲裁员接案状态
	 */
	@ApiModelProperty(value="仲裁员接案状态")
	private String acceptStatus;
	
	/**
	 * 仲裁员头像
	 */
	@ApiModelProperty("仲裁员头像")
	private String headImg;
	
	/**
	 * 仲裁员选择方类型
	 */
	@ApiModelProperty("仲裁员选择方类型 0-申请方 1-被申请方 2-系统")
	private String type;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getVocation() {
		return vocation;
	}
	public void setVocation(String vocation) {
		this.vocation = vocation;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAcceptStatus() {
		return acceptStatus;
	}
	public void setAcceptStatus(String acceptStatus) {
		this.acceptStatus = acceptStatus;
	}
	
}
