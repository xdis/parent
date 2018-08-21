package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 当事人仲裁员
 */
@ApiModel("当事人已选择的仲裁员")
public class LitigantArbitratorInfoVO {
	
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
	 * 职业
	 */
	@ApiModelProperty("职业")
	private String job;
	
	/**
	 * 特长
	 */
	@ApiModelProperty("特长")
	private String specialty;
	
	/**
	 * 头像
	 */
	@ApiModelProperty("头像")
	private String portrait;
	
	/**
	 * 类型
	 */
	@ApiModelProperty("类型")
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

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	@Override
	public String toString() {
		return "LitigantArbitratorInfoVO [name=" + name + ", age=" + age
				+ ", job=" + job + ", specialty=" + specialty + ", portrait="
				+ portrait + "]";
	}
	
}
