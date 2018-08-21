package com.zyxy.common.dto;

import com.zyxy.common.constants.RegexpConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 代理授权对象
 */
public class AuthDelegateDTO extends BaseDTO{

	/**
	 * 审批授权id
	 */
	@NotNull
	private String approveTypeIds;

	/**
	 * 被授权人id
	 */
	@NotNull
	private String delegateUserId;

	/**
	 * 开始日期
	 */
	@NotNull
	@Pattern(regexp = RegexpConstant.DATE_REGEX, message = "开始日期格式错误")
	private String startDate;

	/**
	 * 结束日期
	 */
	@NotNull
	@Pattern(regexp = RegexpConstant.DATE_REGEX, message = "结束日期格式错误")
	private String endDate;

	public String getApproveTypeIds() {
		return approveTypeIds;
	}

	public void setApproveTypeIds(String approveTypeIds) {
		this.approveTypeIds = approveTypeIds;
	}

	public String getDelegateUserId() {
		return delegateUserId;
	}

	public void setDelegateUserId(String delegateUserId) {
		this.delegateUserId = delegateUserId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
