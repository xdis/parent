package com.zyxy.common.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.zyxy.common.constants.RegexpConstant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * 答辩记录修改DTO
 */
@ApiModel("答辩记录修改")
public class CaseRejoinUpdateDTO {
	
	/**
	 * 答辩书类型
	 */
	@ApiModelProperty("答辩书类型0请求1变更请求")
	@NotNull(message="答辩书类型不为空")
	@Pattern(regexp="[01]",message="答辩书类型出错")
	private String type;
	
	/**
	 * 案件ID
	 */
	@ApiModelProperty("案件ID")
	@NotNull(message="案件ID不为空")
	private String caseId;
	
	/**
	 * 答辩内容
	 */
	@ApiModelProperty("答辩内容")
	@NotNull(message="答辩内容不为空")
	private String replyContent;
	
	/**
	 * 用户user_id
	 */
	@ApiModelProperty("用户user_id")
	@NotNull(message="用户user_id不为空")
	private String userId;
	
	 /**
     * 证据列表
     */
    @ApiModelProperty("证据")
    List<CaseEvidenceDTO> caseEvidences;
    

	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<CaseEvidenceDTO> getCaseEvidences() {
		return caseEvidences;
	}

	public void setCaseEvidences(List<CaseEvidenceDTO> caseEvidences) {
		this.caseEvidences = caseEvidences;
	}



	@Override
	public String toString() {
		return "CaseRejoinUpdateDTO [type=" + type + ", caseId=" + caseId
				+ ", replyContent=" + replyContent + ", userId=" + userId
				+ ", caseEvidences=" + caseEvidences + "]";
	}

	
	
}
