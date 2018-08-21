package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "调解协议")
public class CaseProtocolRecordVO {
	
	@ApiModelProperty(value = "调解书协议")
	private String protocolContent;
	
	@ApiModelProperty(value = "仲裁庭意见")
	private String arbiContent;

	public String getProtocolContent() {
		return protocolContent;
	}

	public void setProtocolContent(String protocolContent) {
		this.protocolContent = protocolContent;
	}

	public String getArbiContent() {
		return arbiContent;
	}

	public void setArbiContent(String arbiContent) {
		this.arbiContent = arbiContent;
	}
}
