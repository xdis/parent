package com.zyxy.common.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.zyxy.common.constants.RegexpConstant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * 反请求立案DTO
 * 
 */
@ApiModel("反请求立案DTO")
public class BackRegisterCaseDTO {
	
	/**
	 * 案件ID
	 */
	@ApiModelProperty("案件ID")
	@NotNull(message="案件ID不为空")
	private String caseId;
	
	/**
	 * 收案号
	 */
	/*@ApiModelProperty("收案号")
	@NotNull(message="收案号不为空")*/
	private String acceptanceNo;
	
	/**
	 * 代理标志
	 */
//	@ApiModelProperty("代理标志0-本人 1-代理人")
//	@NotNull(message="代理标志不为空")
//	@Pattern(regexp=RegexpConstant.CASE_ANGENT_FLAG,message="代理标志出错")
	@ApiParam(hidden=true)
	private String angentFlag;
	
	/**
	 * 仲裁请求
	 */
	@ApiModelProperty("仲裁请求")
	@NotNull(message="仲裁请求不为空")
	private String arbClaim;
	
	/**
	 * 事实与理由
	 */
	@ApiModelProperty("事实")
	@NotNull(message="事实与理由不为空")
	private String fact;
	
	/**
	 * 理由
	 */
/*	@ApiModelProperty("理由")
	@NotNull(message="理由不为空")
	private String reason;*/
	
	/**
	 * 创建人
	 */
	@ApiParam(hidden=true)
	private String createrId;
	
	 /**
     * 附件列表
     */
/*    @ApiModelProperty("附件")
    List<CaseAttachmentDTO> caseAttachments;*/

    /**
     * 证据列表
     */
    @ApiModelProperty("证据")
    List<CaseEvidenceDTO> caseEvidences;

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getAcceptanceNo() {
		return acceptanceNo;
	}

	public void setAcceptanceNo(String acceptanceNo) {
		this.acceptanceNo = acceptanceNo;
	}

	public String getAngentFlag() {
		return angentFlag;
	}

	public void setAngentFlag(String angentFlag) {
		this.angentFlag = angentFlag;
	}

	public String getArbClaim() {
		return arbClaim;
	}

	public void setArbClaim(String arbClaim) {
		this.arbClaim = arbClaim;
	}

	public String getFact() {
		return fact;
	}

	public void setFact(String fact) {
		this.fact = fact;
	}

/*	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}*/

	public String getCreaterId() {
		return createrId;
	}

	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}

/*    public List<CaseAttachmentDTO> getCaseAttachments() {
        return caseAttachments;
    }

    public void setCaseAttachments(List<CaseAttachmentDTO> caseAttachments) {
        this.caseAttachments = caseAttachments;
    }*/

    public List<CaseEvidenceDTO> getCaseEvidences() {
        return caseEvidences;
    }

    public void setCaseEvidences(List<CaseEvidenceDTO> caseEvidences) {
        this.caseEvidences = caseEvidences;
    }

	@Override
	public String toString() {
		return "BackRegisterCaseDTO [caseId=" + caseId + ", acceptanceNo="
				+ acceptanceNo + ", angentFlag=" + angentFlag + ", arbClaim="
				+ arbClaim + ", fact=" + fact + ", createrId=" + createrId
				+ ", caseEvidences=" + caseEvidences + "]";
	}
    
    
	

}
