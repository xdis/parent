package com.zyxy.common.vo;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 文书底部VO
 */
@ApiModel("文书底部VO")
public class DocFootVO {
	
	/**
	 * 落款人
	 */
	@ApiModelProperty("落款人")
	private String inscribeName;
	
	/**
	 * 落款时间
	 */
	@ApiModelProperty("落款时间yyyy年MM月dd日")
	private String inscribeTime;
	
	/**
	 * 申请时间
	 */
	private Date applyTime;

	public String getInscribeName() {
		return inscribeName;
	}

	public void setInscribeName(String inscribeName) {
		this.inscribeName = inscribeName;
	}

	public String getInscribeTime() {
		return inscribeTime;
	}

	public void setInscribeTime(String inscribeTime) {
		this.inscribeTime = inscribeTime;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	@Override
	public String toString() {
		return "DocFootVO [inscribeName=" + inscribeName + ", inscribeTime="
				+ inscribeTime + ", applyTime=" + applyTime + "]";
	}

	
	
}
