package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 仲裁员基本信息vo
 */
@ApiModel(value="仲裁员基本信息")
public class ArbitratorBaseInfoVO {
	/**
	 * 仲裁员姓名
	 */
	@ApiModelProperty(value="仲裁员姓名")
	private String name;
	
	/**
	 * 仲裁员电话
	 */
	@ApiModelProperty(value="仲裁员电话")
	private String phone;

	/**
	 * 服务费总计
	 * @return
	 */
	@ApiModelProperty(value="服务费总计")
	private Double totalMoney;

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

	public Double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}
}
