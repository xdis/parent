package com.zyxy.common.vo;

import io.swagger.annotations.ApiModelProperty;

import com.zyxy.common.domain.CaseDocContentWithBLOBs;

public class CaseDocContentVO extends CaseDocContentWithBLOBs{
	/**
	 * 仲裁秘书姓名
	 */
	@ApiModelProperty(value="仲裁秘书姓名")
	private String arbiSecretaryName;
	
	/**
	 * 仲裁员姓名
	 */
	@ApiModelProperty(value="仲裁员姓名")
	private String arbitratorName;

	public String getArbiSecretaryName() {
		return arbiSecretaryName;
	}

	public void setArbiSecretaryName(String arbiSecretaryName) {
		this.arbiSecretaryName = arbiSecretaryName;
	}

	public String getArbitratorName() {
		return arbitratorName;
	}

	public void setArbitratorName(String arbitratorName) {
		this.arbitratorName = arbitratorName;
	}
	
}
