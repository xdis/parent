package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import com.zyxy.common.vo.doc.CaseDocLitigantVO;

/**
 * 仲裁申请书VO
 */
@ApiModel("仲裁申请书VO")
public class ArbitrationApplyDocVO{
	
	/**
	 * 申请人信息
	 */
	@ApiModelProperty("申请人信息")
	private CaseDocLitigantVO proposer;
	
	/**
	 * 被申请人信息
	 */
	@ApiModelProperty("被申请人信息")
	private CaseDocLitigantVO defendant;
	
	/**
	 * 仲裁协议签订方式
	 */
	@ApiModelProperty("仲裁协议签订方式")
	private String signArbiProtocolMode;
	
	/**
	 * 签订时间
	 */
	@ApiModelProperty("签订时间")
	private String signTime;
	
	/**
	 * 协议名称
	 */
	@ApiModelProperty("协议名称")
	private String protocolName;
	
	/**
	 * 仲裁请求
	 */
	@ApiModelProperty("仲裁请求")
	private String arbiRequest;
	
	/**
	 * 事实与理由
	 */
	@ApiModelProperty("事实与理由")
	private String factReason;
	
	/**
	 * 申请时间
	 */
	@ApiModelProperty("申请时间")
	private Date applyTime;

	public CaseDocLitigantVO getProposer() {
		return proposer;
	}

	public void setProposer(CaseDocLitigantVO proposer) {
		this.proposer = proposer;
	}

	public CaseDocLitigantVO getDefendant() {
		return defendant;
	}

	public void setDefendant(CaseDocLitigantVO defendant) {
		this.defendant = defendant;
	}

	public String getSignArbiProtocolMode() {
		return signArbiProtocolMode;
	}

	public void setSignArbiProtocolMode(String signArbiProtocolMode) {
		this.signArbiProtocolMode = signArbiProtocolMode;
	}

	public String getSignTime() {
		return signTime;
	}

	public void setSignTime(String signTime) {
		this.signTime = signTime;
	}

	public String getProtocolName() {
		return protocolName;
	}

	public void setProtocolName(String protocolName) {
		this.protocolName = protocolName;
	}

	public String getArbiRequest() {
		return arbiRequest;
	}

	public void setArbiRequest(String arbiRequest) {
		this.arbiRequest = arbiRequest;
	}

	public String getFactReason() {
		return factReason;
	}

	public void setFactReason(String factReason) {
		this.factReason = factReason;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	@Override
	public String toString() {
		return "ArbitrationApplyDocVO [proposer=" + proposer + ", defendant="
				+ defendant + ", signArbiProtocolMode=" + signArbiProtocolMode
				+ ", signTime=" + signTime + ", protocolName=" + protocolName
				+ ", arbiRequest=" + arbiRequest + ", factReason=" + factReason
				+ ", applyTime=" + applyTime + "]";
	}
	
}
