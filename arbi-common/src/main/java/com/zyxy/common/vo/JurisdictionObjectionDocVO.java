package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 管辖权异议VO
 */
@ApiModel("管辖权异议VO")
public class JurisdictionObjectionDocVO {
	
	/**
	 * 管辖权异议申请
	 */
	@ApiModelProperty("管辖权异议申请")
	private JurisdictionObjectionApplyDocVO applyDocVO;
	
	/**
	 * 管辖权异议回应
	 */
	@ApiModelProperty("管辖权异议回应")
	private JurisdictionObjectionFeedbackDocVO feedbackDocVO;

	public JurisdictionObjectionApplyDocVO getApplyDocVO() {
		return applyDocVO;
	}

	public void setApplyDocVO(JurisdictionObjectionApplyDocVO applyDocVO) {
		this.applyDocVO = applyDocVO;
	}

	public JurisdictionObjectionFeedbackDocVO getFeedbackDocVO() {
		return feedbackDocVO;
	}

	public void setFeedbackDocVO(JurisdictionObjectionFeedbackDocVO feedbackDocVO) {
		this.feedbackDocVO = feedbackDocVO;
	}

	@Override
	public String toString() {
		return "JurisdictionObjectionDocVO [applyDocVO=" + applyDocVO
				+ ", feedbackDocVO=" + feedbackDocVO + "]";
	}
	
}
