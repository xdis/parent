package com.zyxy.common.vo;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 调节协议书VO
 */
public class ProtocolDocInfoVO extends DocHeadVO {
	
	/**
	 * 协议内容
	 */
	@ApiModelProperty("协议内容")
	private String protocolContent;
	
	/**
	 * 仲裁员意见
	 */
	@ApiModelProperty("仲裁员意见")
	private String arbiContent;
	
	/**
	 * 事实与理由
	 */
	@ApiModelProperty("事实与理由")
	private String factAndReason;
	
	/**
	 * 申请时间
	 */
	@ApiModelProperty("申请时间")
	private Date applyTime;
	
	/**
	 * 落款人
	 */
	@ApiModelProperty("落款人")
	private String inscribeName;
	
	/**
	 * 落款时间（yyyy年MM月dd日）
	 */
	@ApiModelProperty("落款时间（yyyy年MM月dd日）")
	private String caseApplyTime;

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

	public String getFactAndReason() {
		return factAndReason;
	}

	public void setFactAndReason(String factAndReason) {
		this.factAndReason = factAndReason;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public String getInscribeName() {
		return inscribeName;
	}

	public void setInscribeName(String inscribeName) {
		this.inscribeName = inscribeName;
	}

	public String getCaseApplyTime() {
		return caseApplyTime;
	}

	public void setCaseApplyTime(String caseApplyTime) {
		this.caseApplyTime = caseApplyTime;
	}

	@Override
	public String toString() {
		return "ProtocolDocInfoVO [protocolContent=" + protocolContent
				+ ", arbiContent=" + arbiContent + ", factAndReason="
				+ factAndReason + ", applyTime=" + applyTime
				+ ", inscribeName=" + inscribeName + ", caseApplyTime="
				+ caseApplyTime + "]";
	}
	
}
