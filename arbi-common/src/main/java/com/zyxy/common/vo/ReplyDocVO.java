package com.zyxy.common.vo;


import java.util.Date;

import com.zyxy.common.vo.doc.CaseDocLitigantVO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 答辩书VO
 */
@ApiModel("答辩书VO")
public class ReplyDocVO extends DocFootVO{
	
	/**
	 * 案由
	 */
	@ApiModelProperty("案由")
	private String caseType;
	
	/**
	 * 答辩记录ID
	 */
	@ApiModelProperty("答辩记录ID")
	private String id;
	
	/**
	 * 答辩内容
	 */
	@ApiModelProperty("答辩内容")
	private String rejoinText;
	
	/**
	 * 答辩人信息
	 */
	@ApiModelProperty("答辩人信息")
	private CaseDocLitigantVO repliedVO;
	
	/**
	 * 被答辩人信息
	 */
	@ApiModelProperty("被答辩人信息")
	private CaseDocLitigantVO beRepliedVO;

	public String getCaseType() {
		return caseType;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	public String getRejoinText() {
		return rejoinText;
	}

	public void setRejoinText(String rejoinText) {
		this.rejoinText = rejoinText;
	}

	public CaseDocLitigantVO getRepliedVO() {
		return repliedVO;
	}

	public void setRepliedVO(CaseDocLitigantVO repliedVO) {
		this.repliedVO = repliedVO;
	}

	public CaseDocLitigantVO getBeRepliedVO() {
		return beRepliedVO;
	}

	public void setBeRepliedVO(CaseDocLitigantVO beRepliedVO) {
		this.beRepliedVO = beRepliedVO;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ReplyDocVO [caseType=" + caseType + ", id=" + id
				+ ", rejoinText=" + rejoinText + ", repliedVO=" + repliedVO
				+ ", beRepliedVO=" + beRepliedVO + "]";
	}
	
}
