package com.zyxy.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 对公账户审核DTO
 *
 */
@ApiModel(value ="对公账户审核DTO")
public class ContraryAuditDTO extends BasePageDTO {
	/**
	 * 对公账户审核id
	 */
	@ApiModelProperty("对公账户审核id")
	private String id;
	
	/**
	 * 打款方
	 */
	@ApiModelProperty("打款方")
	private String moneyName;
	
	/**
	 * 打款账号
	 */
	@ApiModelProperty("打款账号")
	private String moneyAccount;
	
	/**
	 * 开始时间
	 */
	@ApiModelProperty("创建时间")
	private String initTime;
	
	/**
	 * 截止时间
	 */
	@ApiModelProperty("创建时间")
	private String cutoffTime;
	
	/**
	 * 状态
	 */
	@ApiModelProperty("状态")
	private String status;
	
	/**
	 * 操作状态
	 */
	@ApiModelProperty("操作状态 1-通过2-驳回")
	private String operation;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMoneyName() {
		return moneyName;
	}

	public void setMoneyName(String moneyName) {
		this.moneyName = moneyName;
	}

	public String getMoneyAccount() {
		return moneyAccount;
	}

	public void setMoneyAccount(String moneyAccount) {
		this.moneyAccount = moneyAccount;
	}

	public String getInitTime() {
		return initTime;
	}

	public void setInitTime(String initTime) {
		this.initTime = initTime;
	}

	public String getCutoffTime() {
		return cutoffTime;
	}

	public void setCutoffTime(String cutoffTime) {
		this.cutoffTime = cutoffTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
}
