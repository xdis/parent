package com.zyxy.common.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.zyxy.common.constants.RegexpConstant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("当事人-仲裁员选择")
public class CaseArbitratorOprInsertDTO extends BaseDTO {

	/**
	 * 案件ID
	 */
	@ApiModelProperty(value="案件ID")
	@NotNull(message="案件ID不为空")
	private String caseId;
	
	/**
	 * 仲裁员user_id
	 */
	@ApiModelProperty(value = "仲裁员user_id")
	private String arbitratorId;

	/**
	 * 是否系统推荐
	 */
	@ApiModelProperty(value = "是否系统推荐 0-系统推荐 1-自己选择")
	@NotNull(message="是否系统推荐不为空")
	@Pattern(regexp = RegexpConstant.ARBITRATOR_IS_SYS_RECOMMEND,message = "是否系统推荐出错")
	private String isSysRecom;
	
	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getArbitratorId() {
		return arbitratorId;
	}

	public void setArbitratorId(String arbitratorId) {
		this.arbitratorId = arbitratorId;
	}

	public String getIsSysRecom() {
		return isSysRecom;
	}

	public void setIsSysRecom(String isSysRecom) {
		this.isSysRecom = isSysRecom;
	}

	@Override
	public String toString() {
		return "CaseArbitratorOprInsertDTO{" +
				"caseId='" + caseId + '\'' +
				", arbitratorId='" + arbitratorId + '\'' +
				", isSysRecom='" + isSysRecom + '\'' +
				", userId='" + userId + '\'' +
				'}';
	}
}
