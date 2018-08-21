package com.zyxy.common.vo;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 进展内容vo
 */
@ApiModel(value="进展内容")
public class ProgressContentVO {
	/**
	 * 审批id
	 */
	@ApiModelProperty(value="审批id")
	private String approveId;
	
	/**
	 * 标记
	 */
	@ApiModelProperty(value="标记")
	private String mark;
	
	/**
	 * 进展时间
	 */
	@ApiModelProperty(value="进展时间")
	private Date time;
	
	public String getApproveId() {
		return approveId;
	}
	public void setApproveId(String approveId) {
		this.approveId = approveId;
	}

	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
}
