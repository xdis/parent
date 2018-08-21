package com.zyxy.common.vo;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 仲裁委端-仲裁员信息列表
 */
@ApiModel("仲裁员信息列表")
public class ArbitratorInformationVO {
	
	/**
	 * 仲裁员表Id
	 */
	@ApiModelProperty("仲裁员表Id")
	private String id;
	
	/**
	 * 姓名
	 */
	@ApiModelProperty("姓名")
	private String name;
	
	/**
	 * 用户Id
	 */
	@ApiModelProperty("用户Id")
	private String userId;

	/**
	 * 职业
	 */
	@ApiModelProperty("职业")
	private String vocation;

	/**
	 * 专长
	 */
	@ApiModelProperty("专长")
	private String specialty;

	/**
	 * 图像
	 */
	@ApiModelProperty("图像")
	private String headPhoto;

	/**
	 * 创建时间
	 */
	@ApiModelProperty("创建时间")
	private Date createTime;

	/**
	 * 地址
	 */
	@ApiModelProperty("地址")
	private String address;

	/**
	 * 手机号
	 */
	@ApiModelProperty("手机号")
	private String phone;

	/**
	 * 出生日期
	 */
	@ApiModelProperty("出生日期")
	private String dateOfBirth;
	
	
	/**
	 * 是否加入黑名单(0-不是1-是)
	 */
	@ApiModelProperty("是否加入黑名单(0-不是1-是)")
	private String blackList;
	
	/**
	 * 创建日期
	 */
	@ApiModelProperty("创建日期")
	private String createDate;
	
	/**
	 * 判断是否需要修改信息
	 */
	@ApiModelProperty("判断是否需要修改信息0-需要修改")
	private String  status; 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVocation() {
		return vocation;
	}

	public void setVocation(String vocation) {
		this.vocation = vocation;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getHeadPhoto() {
		return headPhoto;
	}

	public void setHeadPhoto(String headPhoto) {
		this.headPhoto = headPhoto;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getBlackList() {
		return blackList;
	}

	public void setBlackList(String blackList) {
		this.blackList = blackList;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
