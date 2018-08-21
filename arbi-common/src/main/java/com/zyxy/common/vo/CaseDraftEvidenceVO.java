package com.zyxy.common.vo;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import javax.validation.constraints.NotNull;

/**
 * 证据DTO
 */
public class CaseDraftEvidenceVO {

    /**
     * 证据材料
     */
    @ApiModelProperty("证据材料")
    private String evidenceMat;

    /**
     * 证据目的
     */
    @ApiModelProperty("证据目的")
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
}
