package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 请求列表展开数据
 */
@ApiModel("变更请求展开数据")
public class PayAndChangeInfoVO {
	
	/**
	 * 缴费明细
	 */
	@ApiModelProperty("缴费信息")
	private PayOrderVO payInfo;
	
	/**
	 * 变更请求信息
	 */
	@ApiModelProperty("变更请求信息")
	private CaseChangeInfoVO baseInfo;

	public PayOrderVO getPayInfo() {
		return payInfo;
	}

	public void setPayInfo(PayOrderVO payInfo) {
		this.payInfo = payInfo;
	}

	public CaseChangeInfoVO getBaseInfo() {
		return baseInfo;
	}

	public void setBaseInfo(CaseChangeInfoVO baseInfo) {
		this.baseInfo = baseInfo;
	}

	@Override
	public String toString() {
		return "PayAndChangeInfoVO [payInfo=" + payInfo + ", baseInfo="
				+ baseInfo + "]";
	}
	
	

}
