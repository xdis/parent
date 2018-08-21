package com.zyxy.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 仲裁委-查询仲裁员DTO
 */
@ApiModel(value = "查询仲裁员DTO")
public class ArbitratorEnquiriesDTO extends BasePageDTO {
	/**
	 * 仲裁员id
	 */
	@ApiModelProperty(value = "仲裁员id")
	private String id;

	/**
	 * 姓名
	 */
	@ApiModelProperty(value = "姓名")
	private String name;

	/**
	 * 手机号
	 */
	@ApiModelProperty(value = "手机号")
	private String phone;

	/**
	 * 状态是否正常
	 */
	@ApiModelProperty(value = "状态是否正常")
	private String status;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	private String createTime;
	
	/**
	 * 正常
	 */
	@ApiModelProperty("正常状态")
	private String toAudit;
	
	/**
	 * 黑名单状态
	 */
	@ApiModelProperty("黑名单状态")
	private String underReview;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getToAudit() {
		return toAudit;
	}

	public void setToAudit(String toAudit) {
		this.toAudit = toAudit;
	}

	public String getUnderReview() {
		return underReview;
	}

	public void setUnderReview(String underReview) {
		this.underReview = underReview;
	}

	

}
