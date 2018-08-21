package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 裁决书修改建议页面对象
 */
@ApiModel(value = "裁决书修改建议页面对象")
public class RulingModificationAuditVO {

	/**
	 * 案件文书对象
	 */
	@ApiModelProperty(value = "案件文书对象")
	private CaseDocVO caseDocVO;

	/**
	 * 案件审核公共对象
	 */
	@ApiModelProperty(value = "案件审核公共对象")
	private AuditPublicVO auditPublicVO;

	public CaseDocVO getCaseDocVO() {
		return caseDocVO;
	}

	public void setCaseDocVO(CaseDocVO caseDocVO) {
		this.caseDocVO = caseDocVO;
	}

	public AuditPublicVO getAuditPublicVO() {
		return auditPublicVO;
	}

	public void setAuditPublicVO(AuditPublicVO auditPublicVO) {
		this.auditPublicVO = auditPublicVO;
	}

}
