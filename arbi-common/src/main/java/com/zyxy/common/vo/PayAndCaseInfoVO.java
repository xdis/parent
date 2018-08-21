package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.zyxy.common.vo.LitigantCaseBaseInfoVO;
import com.zyxy.common.vo.PayOrderVO;

/**
 * 请求列表展开数据
 */
@ApiModel("请求展开数据")
public class PayAndCaseInfoVO {
	
	/**
	 * 案件请求信息
	 */
	@ApiModelProperty("案件请求信息")
	private LitigantCaseBaseInfoVO baseInfo;
	
	/**
	 * 缴费明细
	 */
	@ApiModelProperty("缴费信息")
	private PayOrderVO payInfo;

	public LitigantCaseBaseInfoVO getBaseInfo() {
		return baseInfo;
	}

	public void setBaseInfo(LitigantCaseBaseInfoVO baseInfo) {
		this.baseInfo = baseInfo;
	}

	public PayOrderVO getPayInfo() {
		return payInfo;
	}

	public void setPayInfo(PayOrderVO payInfo) {
		this.payInfo = payInfo;
	}

	@Override
	public String toString() {
		return "PayAndCaseInfoVO [baseInfo=" + baseInfo + ", payInfo="
				+ payInfo + "]";
	}
	
	

}
