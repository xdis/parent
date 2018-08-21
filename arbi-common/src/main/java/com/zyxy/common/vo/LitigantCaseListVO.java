package com.zyxy.common.vo;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 *	当事人案件VO 
 *
 */
@ApiModel("当事人案件输出")
public class LitigantCaseListVO {
	
	/**
	 * 案子ID
	 */
	@ApiModelProperty("案件ID")
	private String id;
	
	/**
	 * 案号
	 */
	@ApiModelProperty("案号")
	private String caseNo;
	
	/**
	 * 收案号
	 */
	@ApiModelProperty("收案号")
	private String acceptanceNo;
	
	
	/**
	 * 案件当前主节点
	 */
	@ApiModelProperty("案件当前主节点")
	private String currentMainNode;
	
	/**
	 * 案件当前子节点
	 */
	@ApiModelProperty("案件当前子节点")
	private String currentChildNode;
	
	/**
	 * 案件当前状态
	 */
	@ApiParam(hidden=true)
	private String status;
	
	/**
	 * 案件申请时间
	 */
	@ApiModelProperty("案件申请时间")
	private Date caseApplyTime;
	
	/**
	 * 立案时间
	 */
	@ApiModelProperty("立案时间")
	private Date caseRegisterTime;
	
	/**
	 * 结案时间
	 */
	@ApiModelProperty("结案时间")
	private Date caseCompleteTime;
	
	/**
	 * 申请人ID
	 */
	@ApiModelProperty("申请人ID")
	private String proposerId;
	
	/**
	 * 申请人Name
	 */
	@ApiModelProperty("申请人Name")
	private String proposerName;
	
	/**
	 * 申请人类型
	 */
	@ApiModelProperty("申请人类型")
	private String proposerType;
	
	/**
	 * 被申请人ID
	 */
	@ApiModelProperty("被申请人ID")
	private String defendantId;
	
	/**
	 * 被申请人姓名
	 */
	@ApiModelProperty("被申请人姓名")
	private String defendantName;
	
	/**
	 * 被申请人类型
	 */
	@ApiModelProperty("被申请人类型")
	private String defendantType;
	
	/**
	 * 代理人ID
	 */
	@ApiModelProperty("代理人ID")
	private String agentId;
	
	/**
	 * 代理人姓名
	 */
	@ApiModelProperty("代理人姓名")
	private String agentName;
	
	/**
	 * 代理类型
	 */
	@ApiModelProperty("代理类型")
	private String litigantType;
	
	
	/**
	 * 案件仲裁费
	 */
	@ApiModelProperty("案件仲裁费")
	private double amount;
	
	/**
	 * 当前主节点截止时间
	 */
	@ApiModelProperty("当前主节点截止时间")
	private Date nodeEndTime;
	
	/**
	 * 是否有反请求
	 */
	@ApiModelProperty("是否有反请求0没有 1有")
	private Boolean isBack;
	
	@ApiModelProperty("是否含有代理")
	private Boolean hasAgent;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getAcceptanceNo() {
		return acceptanceNo;
	}

	public void setAcceptanceNo(String acceptanceNo) {
		this.acceptanceNo = acceptanceNo;
	}

	public String getCurrentMainNode() {
		return currentMainNode;
	}

	public void setCurrentMainNode(String currentMainNode) {
		this.currentMainNode = currentMainNode;
	}

	public String getCurrentChildNode() {
		return currentChildNode;
	}

	public void setCurrentChildNode(String currentChildNode) {
		this.currentChildNode = currentChildNode;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCaseApplyTime() {
		return caseApplyTime;
	}

	public void setCaseApplyTime(Date caseApplyTime) {
		this.caseApplyTime = caseApplyTime;
	}

	public Date getCaseRegisterTime() {
		return caseRegisterTime;
	}

	public void setCaseRegisterTime(Date caseRegisterTime) {
		this.caseRegisterTime = caseRegisterTime;
	}

	public Date getCaseCompleteTime() {
		return caseCompleteTime;
	}

	public void setCaseCompleteTime(Date caseCompleteTime) {
		this.caseCompleteTime = caseCompleteTime;
	}

	public String getProposerId() {
		return proposerId;
	}

	public void setProposerId(String proposerId) {
		this.proposerId = proposerId;
	}

	public String getProposerName() {
		return proposerName;
	}

	public void setProposerName(String proposerName) {
		this.proposerName = proposerName;
	}

	public String getProposerType() {
		return proposerType;
	}

	public void setProposerType(String proposerType) {
		this.proposerType = proposerType;
	}

	public String getDefendantId() {
		return defendantId;
	}

	public void setDefendantId(String defendantId) {
		this.defendantId = defendantId;
	}

	public String getDefendantName() {
		return defendantName;
	}

	public void setDefendantName(String defendantName) {
		this.defendantName = defendantName;
	}

	public String getDefendantType() {
		return defendantType;
	}

	public void setDefendantType(String defendantType) {
		this.defendantType = defendantType;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getLitigantType() {
		return litigantType;
	}

	public void setLitigantType(String litigantType) {
		this.litigantType = litigantType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getNodeEndTime() {
		return nodeEndTime;
	}

	public void setNodeEndTime(Date nodeEndTime) {
		this.nodeEndTime = nodeEndTime;
	}
	
	public Boolean getIsBack() {
		return isBack;
	}

	public void setIsBack(Boolean isBack) {
		this.isBack = isBack;
	}
	
	public Boolean getHasAgent() {
		return hasAgent;
	}

	public void setHasAgent(Boolean hasAgent) {
		this.hasAgent = hasAgent;
	}

	@Override
	public String toString() {
		return "LitigantCaseListVO [id=" + id + ", caseNo=" + caseNo
				+ ", acceptanceNo=" + acceptanceNo + ", currentMainNode="
				+ currentMainNode + ", currentChildNode=" + currentChildNode
				+ ", status=" + status + ", caseApplyTime=" + caseApplyTime
				+ ", caseRegisterTime=" + caseRegisterTime
				+ ", caseCompleteTime=" + caseCompleteTime + ", proposerId="
				+ proposerId + ", proposerName=" + proposerName
				+ ", proposerType=" + proposerType + ", defendantId="
				+ defendantId + ", defendantName=" + defendantName
				+ ", defendantType=" + defendantType + ", agentId=" + agentId
				+ ", agentName=" + agentName + ", litigantType=" + litigantType
				+ ", amount=" + amount + ", nodeEndTime=" + nodeEndTime
				+ ", isBack=" + isBack + ", hasAgent=" + hasAgent + "]";
	}



 }
