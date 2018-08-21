package com.zyxy.common.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("案件审批意见")
public class CaseApproveSuggestDTO {
	/**
	 * 编号
	 */
	@ApiModelProperty("编号")
	private String id;

	/**
	 * 案件ID
	 */
	@ApiModelProperty("案件ID")
	private String caseId;

	/**
	 * 审批编号
	 */
	@ApiModelProperty("审批编号")
	private String approveId;

	/**
	 * 审批意见
	 */
	@ApiModelProperty("审批意见")
	private String approveSuggest;

	/**
	 * 意见状态 0-通过 1-驳回
	 */
	@NotNull(message = "意见状态")
	@ApiModelProperty(value = "意见状态")
	private String opinionStatus;

	/**
	 * 创建人creater_id
	 */
	@ApiModelProperty("创建人")
	private String createrId;

	/**
	 * 创建时间create_time
	 */
	@ApiModelProperty("创建时间")
	private Date createTime;

	/**
	 * 标的金额
	 */
	private BigDecimal amounts;

	/**
	 * 受理费
	 */
	private BigDecimal caseAdmissibleAmount;
	/**
	 * 处理费
	 */
	private BigDecimal caseHandlingAmount;

	/**
	 * 请求标志
	 */
	private String counterclaimFlag;


	/**
	 * 是否授权
	 */
	private String isAuthorized;

	/**
	 * 操作者职务
	 */
	private String duties;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getApproveId() {
		return approveId;
	}

	public void setApproveId(String approveId) {
		this.approveId = approveId;
	}

	public String getApproveSuggest() {
		return approveSuggest;
	}

	public void setApproveSuggest(String approveSuggest) {
		this.approveSuggest = approveSuggest;
	}

	public String getOpinionStatus() {
		return opinionStatus;
	}

	public void setOpinionStatus(String opinionStatus) {
		this.opinionStatus = opinionStatus;
	}

	public String getCreaterId() {
		return createrId;
	}

	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public BigDecimal getAmounts() {
		return amounts;
	}

	public void setAmounts(BigDecimal amounts) {
		this.amounts = amounts;
	}

	public BigDecimal getCaseAdmissibleAmount() {
		return caseAdmissibleAmount;
	}

	public void setCaseAdmissibleAmount(BigDecimal caseAdmissibleAmount) {
		this.caseAdmissibleAmount = caseAdmissibleAmount;
	}

	public BigDecimal getCaseHandlingAmount() {
		return caseHandlingAmount;
	}

	public void setCaseHandlingAmount(BigDecimal caseHandlingAmount) {
		this.caseHandlingAmount = caseHandlingAmount;
	}

	public String getCounterclaimFlag() {
		return counterclaimFlag;
	}

	public void setCounterclaimFlag(String counterclaimFlag) {
		this.counterclaimFlag = counterclaimFlag;
	}

	public String getIsAuthorized() {
		return isAuthorized;
	}

	public void setIsAuthorized(String isAuthorized) {
		this.isAuthorized = isAuthorized;
	}

	public String getDuties() {
		return duties;
	}

	public void setDuties(String duties) {
		this.duties = duties;
	}
}
