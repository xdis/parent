package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 仲裁委端-仲裁员信息审核对象
 */
@ApiModel("仲裁员信息审核对象")
public class ArbitratorInfoAduitVO {
	
	/**
	 * 仲裁员id
	 */
	@ApiModelProperty("仲裁员id")
	private String id;
	
	/**
	 * 姓名
	 */
	@ApiModelProperty("姓名")
	private String name;
	
	/**
	 * 出生年月
	 */
	@ApiModelProperty("出生年月")
	private String birthDates;
	
	/**
	 * 原职业
	 */
	@ApiModelProperty("原职业")
	private String sourceOccupation;
	
	/**
	 * 原专长
	 */
	@ApiModelProperty("原专长")
	private String sourceSpecialty;
	
	/**
	 * 原居住地
	 */
	@ApiModelProperty("原居住地")
	private String sourceAddress;
	
	/**
	 * 原证件照地址
	 */
	@ApiModelProperty("原证件照地址")
	private String sourceIdCard;
	
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
	 * 新证件照地址
	 */
	@ApiModelProperty("新证件照地址")
	private String newIdCard;
	
	/**
	 * 新证件照Id
	 */
	@ApiModelProperty("新证件照id")
	private String newIdentityId;
	
	/**
	 * 新说明
	 */
	@ApiModelProperty("新说明")
	private String newRemark;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDates() {
		return birthDates;
	}

	public void setBirthDates(String birthDates) {
		this.birthDates = birthDates;
	}

	public String getSourceOccupation() {
		return sourceOccupation;
	}

	public void setSourceOccupation(String sourceOccupation) {
		this.sourceOccupation = sourceOccupation;
	}

	public String getSourceSpecialty() {
		return sourceSpecialty;
	}

	public void setSourceSpecialty(String sourceSpecialty) {
		this.sourceSpecialty = sourceSpecialty;
	}

	public String getSourceAddress() {
		return sourceAddress;
	}

	public void setSourceAddress(String sourceAddress) {
		this.sourceAddress = sourceAddress;
	}

	public String getSourceIdCard() {
		return sourceIdCard;
	}

	public void setSourceIdCard(String sourceIdCard) {
		this.sourceIdCard = sourceIdCard;
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

	public String getNewIdCard() {
		return newIdCard;
	}

	public void setNewIdCard(String newIdCard) {
		this.newIdCard = newIdCard;
	}

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

	public String getNewRemark() {
		return newRemark;
	}

	public void setNewRemark(String newRemark) {
		this.newRemark = newRemark;
	}

	public String getNewIdentityId() {
		return newIdentityId;
	}

	public void setNewIdentityId(String newIdentityId) {
		this.newIdentityId = newIdentityId;
	}
	
	
	

}
