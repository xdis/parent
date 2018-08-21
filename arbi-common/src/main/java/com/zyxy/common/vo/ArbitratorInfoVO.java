package com.zyxy.common.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 当事人仲裁员
 */
public class ArbitratorInfoVO {
	
	/**
	 * 申请方
	 */
	@ApiModelProperty("申请方")
	private LitigantArbitratorInfoVO propArbitrator;
	
	/**
	 * 被申请
	 */
	@ApiModelProperty("被申请方")
	private LitigantArbitratorInfoVO defeArbitrator;
	
	/**
	 * 当前
	 */
	@ApiModelProperty("当前")	
	private LitigantArbitratorInfoVO sysArbitrator;

	public LitigantArbitratorInfoVO getPropArbitrator() {
		return propArbitrator;
	}

	public void setPropArbitrator(LitigantArbitratorInfoVO propArbitrator) {
		this.propArbitrator = propArbitrator;
	}

	public LitigantArbitratorInfoVO getDefeArbitrator() {
		return defeArbitrator;
	}

	public void setDefeArbitrator(LitigantArbitratorInfoVO defeArbitrator) {
		this.defeArbitrator = defeArbitrator;
	}

	public LitigantArbitratorInfoVO getSysArbitrator() {
		return sysArbitrator;
	}

	public void setSysArbitrator(LitigantArbitratorInfoVO sysArbitrator) {
		this.sysArbitrator = sysArbitrator;
	}

	@Override
	public String toString() {
		return "ArbitratorInfoVO [propArbitrator=" + propArbitrator
				+ ", defeArbitrator=" + defeArbitrator + ", sysArbitrator="
				+ sysArbitrator + "]";
	}
	
}
