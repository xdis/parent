package com.zyxy.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 更新仲裁员信息DTO
 */
@ApiModel(value = "更新仲裁员信息DTO")
public class ArbitratorInfoUpdateDTO extends BaseDTO{
	
	/**
	 * 仲裁员id
	 */
	@ApiModelProperty("仲裁员id")
	private String id;
	
	/**
	 * 仲裁员修改信息Id
	 */
	@ApiModelProperty("仲裁员修改信息Id")
	private String newId;
	
	/**
	 * 新职业
	 */
	@ApiModelProperty("新职业")
	private String newOccupation;
	
	/**
	 * 新专长
	 */
	@ApiModelProperty("新专长")
	private String newSpecialty;
	
	/**
	 * 新居住地
	 */
	@ApiModelProperty("新居住地")
	private String newAddress;
	
	/**
	 * 新证件照Id
	 */
	@ApiModelProperty("新证件照Id")
	private String newIdentityId;
	
	/**
	 * 更新日期
	 */
	@ApiModelProperty("更新日期")
	private String updateDate;
	
	/**
	 * 更新时间
	 */
	@ApiModelProperty("更新时间")
	private String updateTime;
	
	
	
	/**
	 * 状态0-确认修改1-驳回
	 */
	@ApiModelProperty("状态")
	private String status;
	
	/**
	 * 删除状态
	 */
	@ApiModelProperty("删除状态")
	private String deleteStatus;
	
	/**
	 * 加入黑名单状态
	 */
	@ApiModelProperty("加入黑名单状态")
	private String blackListStatus;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNewId() {
		return newId;
	}

	public void setNewId(String newId) {
		this.newId = newId;
	}

	public String getNewOccupation() {
		return newOccupation;
	}

	public void setNewOccupation(String newOccupation) {
		this.newOccupation = newOccupation;
	}

	public String getNewSpecialty() {
		return newSpecialty;
	}

	public void setNewSpecialty(String newSpecialty) {
		this.newSpecialty = newSpecialty;
	}

	public String getNewAddress() {
		return newAddress;
	}

	public void setNewAddress(String newAddress) {
		this.newAddress = newAddress;
	}

	public String getNewIdentityId() {
		return newIdentityId;
	}

	public void setNewIdentityId(String newIdentityId) {
		this.newIdentityId = newIdentityId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(String deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public String getBlackListStatus() {
		return blackListStatus;
	}

	public void setBlackListStatus(String blackListStatus) {
		this.blackListStatus = blackListStatus;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
	
	
	
	
	
}
