package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 仲裁员列表信息VO
 */
@ApiModel(value ="仲裁员列表信息VO")
public class ArbitratorListVO {

	/**
	 * 头像
	 */
	@ApiModelProperty("头像")
	private String portrait;

	/**
	 * 姓名
	 */
	@ApiModelProperty("姓名")
	private String name;

	/**
	 * 性别
	 */
	@ApiModelProperty("性别,0-男 1-女")
	private String sex;
	
	/**
	 * 仲裁员ID
	 */
	@ApiModelProperty("仲裁员ID")
	private String arbitratorId;
	

	/**
	 * 年龄
	 */
	@ApiModelProperty("年龄,yyyyMMdd,前端换算")
	private String age;

	/**
	 * 职业
	 */
	@ApiModelProperty("职业")
	private String job;

	/**
	 * 特长
	 */
	@ApiModelProperty("特长")
	private String specialty;

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getArbitratorId() {
		return arbitratorId;
	}

	public void setArbitratorId(String arbitratorId) {
		this.arbitratorId = arbitratorId;
	}
	
}
