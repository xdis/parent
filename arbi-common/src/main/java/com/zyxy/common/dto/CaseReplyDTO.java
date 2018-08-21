package com.zyxy.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import java.util.List;

/**
 * 公共答辩DTO
 */
@ApiModel(value ="公共答辩DTO")
public class CaseReplyDTO extends BaseDTO {
	
	/**
	 * 案件ID
	 */
	@ApiModelProperty("案件ID")
	private String caseId;

    /**
     * 请求Id
     */
    @ApiModelProperty("请求Id")
    private String requestId;
    
    /**
     * 变更请求ID
     */
    @ApiModelProperty(value="变更请求ID")
    private String changeId;
    
    @ApiModelProperty("答辩类型0请求答辩1变更请求答辩")
    private String type;
    
    /**
     * 答辩内容
     */
    @ApiModelProperty("答辩内容")
    private String replyContent;
    
    @ApiParam(hidden=true)
    private String requestFlag;

    /**
     * 附件列表
     */
    @ApiModelProperty("附件")
    private List<CaseAttachmentDTO> caseAttachments;

    /**
     * 证据列表
     */
    @ApiModelProperty("证据")
    private List<CaseEvidenceDTO> caseEvidences;

    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public List<CaseAttachmentDTO> getCaseAttachments() {
        return caseAttachments;
    }

    public void setCaseAttachments(List<CaseAttachmentDTO> caseAttachments) {
        this.caseAttachments = caseAttachments;
    }

    public List<CaseEvidenceDTO> getCaseEvidences() {
        return caseEvidences;
    }

    public void setCaseEvidences(List<CaseEvidenceDTO> caseEvidences) {
        this.caseEvidences = caseEvidences;
    }

	public String getRequestFlag() {
		return requestFlag;
	}

	public void setRequestFlag(String requestFlag) {
		this.requestFlag = requestFlag;
	}
	
	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getChangeId() {
		return changeId;
	}

	public void setChangeId(String changeId) {
		this.changeId = changeId;
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "CaseReplyDTO [caseId=" + caseId + ", requestId=" + requestId
				+ ", changeId=" + changeId + ", type=" + type
				+ ", replyContent=" + replyContent + ", requestFlag="
				+ requestFlag + ", caseAttachments=" + caseAttachments
				+ ", caseEvidences=" + caseEvidences + "]";
	}
}
