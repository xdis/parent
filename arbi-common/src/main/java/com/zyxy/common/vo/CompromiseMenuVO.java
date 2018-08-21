package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 和解状态和按钮返回
 */
@ApiModel("和解状态和按钮VO")
public class CompromiseMenuVO {
	
	/**
	 * 当前状态
	 */
	@ApiModelProperty("和解当前状态")
	private String status;
	
	/**
	 * 按钮
	 */
	@ApiModelProperty("按钮")
	private List<MenuVO> menuVOs;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<MenuVO> getMenuVOs() {
		return menuVOs;
	}

	public void setMenuVOs(List<MenuVO> menuVOs) {
		this.menuVOs = menuVOs;
	}

	@Override
	public String toString() {
		return "CompromiseMenuVO [status=" + status + ", menuVOs=" + menuVOs
				+ "]";
	}
	
}
