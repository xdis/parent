package com.zyxy.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户身份审核DTO
 *
 */
@ApiModel(value ="用户身份审核DTO")
public class UserAuditDTO extends BasePageDTO{
	/**
	 * 用户身份审批记录id
	 */
	@ApiModelProperty("用户身份审批记录id")
	private String id;
	
	
	/**
	 * 审核结果
	 */
	@ApiModelProperty("审核结果1-通过2-驳回")
	private String operation;
	
	/**
	 * 状态
	 */
	@ApiModelProperty("状态")
	private String status;
	
	/**
	 * 姓名
	 */
	@ApiModelProperty("姓名")
	private String propName ;
	
	/**
	 * 身份证号
	 */
	@ApiModelProperty("身份证号")	
	private String cardId;
	
	


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getOperation() {
		return operation;
	}


	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getCardId() {
		return cardId;
	}


	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getPropName() {
		return propName;
	}


	public void setPropName(String propName) {
		this.propName = propName;
	}
	
	
	
	

}
