package com.zyxy.common.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.zyxy.common.constants.RegexpConstant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * 案件管辖权异议
 */
@ApiModel("申请管辖权异议")
public class CaseJurisDisInsertDTO {
	
	/**
	 * 案件id
	 */
	@ApiModelProperty("案件id")
	@NotNull(message="案件id不为空")
	private String caseId;
	
	/**
	 * 管辖权异议事实与理由
	 */
	@ApiModelProperty("事实与理由")
	@NotNull(message="事实与理由不为空")
	private String reason;
	
	/**
	 * 请求事项
	 */
	@ApiModelProperty("请求事项")
	@NotNull(message="请求事项不为空")
	private String requestItem;
	
	/**
	 * 请求类型
	 */
	/*@ApiModelProperty("请求标志 0正请求1反请求")
	@NotNull(message="请求类型不为空")
	@Pattern(regexp = RegexpConstant.CASE_COUNTERCLAIM_FLAG,message="请求标志出错")*/
	@ApiParam(hidden=true)
	private String counterclaimFlag;
	
	/**
	 * 申请人ID
	 */
	@ApiModelProperty("当前用户Id")
	@NotNull(message="当前用户Id不为空")
	private String createrId;

	
	/**
	 * @return the caseId
	 */
	public String getCaseId() {
		return caseId;
	}



	/**
	 * @param caseId the caseId to set
	 */
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}



	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}



	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}



	/**
	 * @return the requestItem
	 */
	public String getRequestItem() {
		return requestItem;
	}



	/**
	 * @param requestItem the requestItem to set
	 */
	public void setRequestItem(String requestItem) {
		this.requestItem = requestItem;
	}



	/**
	 * @return the counterclaimFlag
	 */
	public String getCounterclaimFlag() {
		return counterclaimFlag;
	}



	/**
	 * @param counterclaimFlag the counterclaimFlag to set
	 */
	public void setCounterclaimFlag(String counterclaimFlag) {
		this.counterclaimFlag = counterclaimFlag;
	}



	/**
	 * @return the createrId
	 */
	public String getCreaterId() {
		return createrId;
	}



	/**
	 * @param createrId the createrId to set
	 */
	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}



	@Override
	public String toString() {
		return "CaseJurisDisInsertDTO [caseId=" + caseId + ", reason=" + reason
				+ ", requestItem=" + requestItem + ", counterclaimFlag="
				+ counterclaimFlag + ", createrId=" + createrId + "]";
	}
	
}
