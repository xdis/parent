package com.zyxy.common.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.zyxy.common.constants.RegexpConstant;

/**
 * 添加仲裁员信息
 */
public class ArbitratorInfoDTO {
	
	@ApiModelProperty(value = "用户名")
	@NotNull(message="不能为空")
	private String name;
	
	@ApiModelProperty(value = "用户头像")
    private String headphoto;
	
	@ApiModelProperty(value = "出生年月")
	@NotNull(message="不能为空")
	private String birthday;
	
	@ApiModelProperty(value = "职业")
	@NotNull(message="不能为空")
	private String vocation;
	
	@ApiModelProperty(value = "专长")
	@NotNull(message="不能为空")
	private String specialty;
	
	@ApiModelProperty(value = "居住地")
	@NotNull(message="不能为空")
	private String address;
	
	@ApiModelProperty(value = "手机号")
	@NotNull(message="不能为空")
	@Pattern(regexp = RegexpConstant.PHONE_REGEX, message = "手机号格式错误")
	private String phone;
	
	@ApiModelProperty(value = "创建人")
	private String createrId;
	
	@ApiModelProperty(value = "创建日期")
	private String createDate;
	
	@ApiModelProperty(value = "创建时间")
	private String createTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
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

	public String getHeadphoto() {
		return headphoto;
	}

	public void setHeadphoto(String headphoto) {
		this.headphoto = headphoto;
	}

	public String getCreaterId() {
		return createrId;
	}

	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
