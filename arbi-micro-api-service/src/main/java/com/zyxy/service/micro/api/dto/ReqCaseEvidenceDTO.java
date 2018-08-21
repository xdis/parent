package com.zyxy.service.micro.api.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import javax.validation.constraints.NotNull;

/**
 * 证据DTO
 */
public class ReqCaseEvidenceDTO {
	
	/**
	 * 证据ID
	 */
	@ApiParam(hidden=true)
	private String id;

    /**
     * 证据材料
     */
    @ApiModelProperty("证据材料")
    @NotNull
    private String evidenceMat;

    /**
     * 证据目的
     */
    @ApiModelProperty("证据目的")
    @NotNull
    private String purposeEvidence;

    /**
     * 证据来源
     */
    @ApiModelProperty("证据来源")
    private String sourceEvidence;

    /**
     * 文件ID
     */
    @ApiModelProperty("文件ID")
    private String fileId;

    @ApiParam(hidden = true)
    private String docType;

    public String getEvidenceMat() {
        return evidenceMat;
    }

    public void setEvidenceMat(String evidenceMat) {
        this.evidenceMat = evidenceMat;
    }

    public String getPurposeEvidence() {
        return purposeEvidence;
    }

    public void setPurposeEvidence(String purposeEvidence) {
        this.purposeEvidence = purposeEvidence;
    }

    public String getSourceEvidence() {
        return sourceEvidence;
    }

    public void setSourceEvidence(String sourceEvidence) {
        this.sourceEvidence = sourceEvidence;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
}
