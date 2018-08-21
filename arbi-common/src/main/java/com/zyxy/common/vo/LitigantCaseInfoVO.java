package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 *	当事人案件信息
 */
@ApiModel("当事人案件信息")
public class LitigantCaseInfoVO {
	
	/**
	 * 案件基本信息
	 */
	private LitigantCaseBaseInfoVO litigantCaseBaseInfoVO;
	
	
	public LitigantCaseBaseInfoVO getLitigantCaseBaseInfoVO() {
		return litigantCaseBaseInfoVO;
	}

	public void setLitigantCaseBaseInfoVO(
			LitigantCaseBaseInfoVO litigantCaseBaseInfoVO) {
		this.litigantCaseBaseInfoVO = litigantCaseBaseInfoVO;
	}


    
}
