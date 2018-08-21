package com.zyxy.common.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.zyxy.common.constants.RegexpConstant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 申请回避记录DTO
 */
@ApiModel("申请回避记录DTO")
public class CaseAvoidRecordInsertDTO {
	
	/**
	 * 案件ID
	 */
	@ApiModelProperty("案件ID")
	@NotNull(message="案件id不能为空")
	private String caseId;
	
	/**
	 * 回避类型
	 */
	@ApiModelProperty("回避人类型 0-秘书回避 1-仲裁员回避")
	@NotNull(message="回避人类型不能为空")
	@Pattern(regexp=RegexpConstant.AVOID_TYPE_REGEX,message="回避类型出错")
	private String avoidType;
	
	/**
	 * 回避方式
	 */
	@ApiModelProperty("回避方式 0-自己回避 1-被回避")
	@NotNull(message="回避方式不能为空")
	@Pattern(regexp = RegexpConstant.AVOID_STYLE_REGEX,message="回避方式出错")
	private String avoidStyle;
	
	/**
	 * 请求事项
	 */
	@ApiModelProperty("请求事项")
	@NotNull(message="请求事项不为空")
	private String avoidRequest;
	
	/**
	 * 回避理由
	 */
	@NotNull(message="回避理由不能为空")
	@ApiModelProperty("回避理由")
	private String avoidReason;
	
	/**
	 * 创建人Id
	 */
	@NotNull(message="当前用户Id不能为空")
	@ApiModelProperty("当前用户Id")
	private String createrId;

	public String getAvoidRequest() {
		return avoidRequest;
	}

	public void setAvoidRequest(String avoidRequest) {
		this.avoidRequest = avoidRequest;
	}

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getAvoidType() {
		return avoidType;
	}

	public void setAvoidType(String avoidType) {
		this.avoidType = avoidType;
	}

	public String getAvoidStyle() {
		return avoidStyle;
	}

	public void setAvoidStyle(String avoidStyle) {
		this.avoidStyle = avoidStyle;
	}

	public String getAvoidReason() {
		return avoidReason;
	}

	public void setAvoidReason(String avoidReason) {
		this.avoidReason = avoidReason;
	}

	public String getCreaterId() {
		return createrId;
	}

	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CaseAvoidRecordInsertDTO [caseId=" + caseId + ", avoidType="
				+ avoidType + ", avoidStyle=" + avoidStyle + ", avoidRequest="
				+ avoidRequest + ", avoidReason=" + avoidReason
				+ ", createrId=" + createrId + "]";
	}


}
