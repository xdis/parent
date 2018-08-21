package com.zyxy.common.vo;

import java.util.Date;

import com.zyxy.common.vo.doc.CaseDocAgentVO;
import com.zyxy.common.vo.doc.CaseDocLitigantVO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 和解协议
 */
@ApiModel("和解协议")
public class CompromiseProtocolDocVO {
	
	/**
	 * 申请人
	 */
	private CaseDocLitigantVO propose;
	
	/**
	 * 被申请人
	 */
	private CaseDocLitigantVO defendant;
	
	/**
	 * 申请人代理
	 */
	@ApiModelProperty("申请人代理")
	private CaseDocAgentVO proposeAgent;
	
	/**
	 * 被申请人代理
	 */
	@ApiModelProperty("被申请人代理")
	private CaseDocAgentVO defendantAgent;
	
	/**
	 * 案由
	 */
	@ApiModelProperty("案由")
	private String caseType;
	
	/**
	 * 案件号
	 */
	@ApiModelProperty("案件号")
	private String caseNo;
	
	/**
	 * 协议内容
	 */
	@ApiModelProperty("协议内容")
	private String protocolContent;
	
	/**
	 * 申请时间
	 */
	@ApiModelProperty("申请时间")
	private Date applyTime;

	public CaseDocLitigantVO getPropose() {
		return propose;
	}

	public void setPropose(CaseDocLitigantVO propose) {
		this.propose = propose;
	}

	public CaseDocLitigantVO getDefendant() {
		return defendant;
	}

	public void setDefendant(CaseDocLitigantVO defendant) {
		this.defendant = defendant;
	}

	public CaseDocAgentVO getProposeAgent() {
		return proposeAgent;
	}

	public void setProposeAgent(CaseDocAgentVO proposeAgent) {
		this.proposeAgent = proposeAgent;
	}

	public CaseDocAgentVO getDefendantAgent() {
		return defendantAgent;
	}

	public void setDefendantAgent(CaseDocAgentVO defendantAgent) {
		this.defendantAgent = defendantAgent;
	}

	public String getCaseType() {
		return caseType;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getProtocolContent() {
		return protocolContent;
	}

	public void setProtocolContent(String protocolContent) {
		this.protocolContent = protocolContent;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	@Override
	public String toString() {
		return "CompromiseProtocolDoc [propose=" + propose + ", defendant="
				+ defendant + ", proposeAgent=" + proposeAgent
				+ ", defendantAgent=" + defendantAgent + ", caseType="
				+ caseType + ", caseNo=" + caseNo + ", protocolContent="
				+ protocolContent + ", applyTime=" + applyTime + "]";
	}
	
}
