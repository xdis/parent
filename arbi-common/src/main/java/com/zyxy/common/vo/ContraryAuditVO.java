package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *	对公账户审核VO
 */
@ApiModel(value = "对公账户审核VO")
public class ContraryAuditVO {
	
	/**
	 * 对公账户审核id
	 */
	@ApiModelProperty(value = "对公账户审核id")
	private String id;
		
	/**
	 * 打款方
	 */
	@ApiModelProperty("打款方")
	private String moneyName;
	
	/**
	 * 打款金额
	 */
	@ApiModelProperty("打款金额")
	private String amount;
	
	/**
	 * 打款银行
	 */
	@ApiModelProperty("打款银行")
	private String moneyBank;
	
	/**
	 * 打款账号
	 */
	@ApiModelProperty("打款账号")
	private String moneyAccount;
	
	/**
	 * 备注
	 */
	@ApiModelProperty("备注")
	private String remark;
	
	/**
	 * 创建时间
	 */
	@ApiModelProperty("创建时间")
	private String createTime;
	
	/**
	 * 状态
	 */
	@ApiModelProperty("状态")
	private String status;
	
	/**
	 * 类型
	 * @return
	 */
	@ApiModelProperty("类型")
	private String type;

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

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getMoneyBank() {
		return moneyBank;
	}

	public void setMoneyBank(String moneyBank) {
		this.moneyBank = moneyBank;
	}

	public String getMoneyAccount() {
		return moneyAccount;
	}

	public void setMoneyAccount(String moneyAccount) {
		this.moneyAccount = moneyAccount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
