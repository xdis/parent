package com.zyxy.common.vo;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 调节协议状态VO
 */
@ApiModel("调节协议状态VO")
public class ProtocolInfoVO {
	
	/**
	 * 和解名称
	 */
	@ApiModelProperty("和解名称")
	private String titleName;
	
	/**
	 * 状态
	 */
	@ApiModelProperty("调节协议书状态")
	private String statusName;
	
	/**
	 * 时间
	 */
	@ApiModelProperty("时间")
	private Date time;

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "ProtocolInfoVO [titleName=" + titleName + ", statusName="
				+ statusName + ", time=" + time + "]";
	}
	
}
