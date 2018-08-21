package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 案件进展VO
 */
@ApiModel(value="案件进展")
public class CaseProgressListVO {
	/**
	 * id
	 */
	@ApiModelProperty(value="id")
	private String id;
	
	/**
	 * 进展类型
	 */
	@ApiModelProperty(value="进展类型")
	private String approveType;
	
	/**
	 * 进展内容
	 */
	@ApiModelProperty(value="进展内容")
	private List<ProgressContentVO> progressCont;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getApproveType() {
		return approveType;
	}
	public void setApproveType(String approveType) {
		this.approveType = approveType;
	}
	public List<ProgressContentVO> getProgressCont() {
		return progressCont;
	}
	public void setProgressCont(List<ProgressContentVO> progressCont) {
		this.progressCont = progressCont;
	}
}
