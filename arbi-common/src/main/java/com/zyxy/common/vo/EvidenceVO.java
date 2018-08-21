package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 证据材料对象
 */
@ApiModel("证据材料对象")
public class EvidenceVO {
	
	
    /**
     * 材料类型 1请求证据
     */
    @ApiModelProperty("材料类型")
    private String matType;
    
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
     * 证据涞源
     */
    @ApiModelProperty("证据涞源")
    private String sourceEvidence;
    
    /**
     * 文件名
     */
    @ApiModelProperty("文件名")
    private String docName;
    
    /**
     * 文件ID
     */
    @ApiModelProperty("文件ID")
    private String fileId;
    
    /**
     * 文件类型
     */
    @ApiModelProperty("文件类型")
    private String docType;
    
    /**
     * 身份类型
     */
    @ApiModelProperty(value="身份类型")
    private String createrType;
    
    /**
     * 请求标志
     */
    @ApiModelProperty(value="请求标志")
    private String counterclamFlag;
    
    @ApiModelProperty("质证")
    private String  oppugnEvidence;
    
	public String getOppugnEvidence() {
		return oppugnEvidence;
	}
	public void setOppugnEvidence(String oppugnEvidence) {
		this.oppugnEvidence = oppugnEvidence;
	}
	public String getMatType() {
		return matType;
	}
	public void setMatType(String matType) {
		this.matType = matType;
	}
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
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
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
	public String getCreaterType() {
		return createrType;
	}
	public void setCreaterType(String createrType) {
		this.createrType = createrType;
	}
	/**
	 * @return the counterclamFlag
	 */
	public String getCounterclamFlag() {
		return counterclamFlag;
	}
	/**
	 * @param counterclamFlag the counterclamFlag to set
	 */
	public void setCounterclamFlag(String counterclamFlag) {
		this.counterclamFlag = counterclamFlag;
	}
	@Override
	public String toString() {
		return "EvidenceVO [matType=" + matType + ", evidenceMat="
				+ evidenceMat + ", purposeEvidence=" + purposeEvidence
				+ ", sourceEvidence=" + sourceEvidence + ", docName=" + docName
				+ ", fileId=" + fileId + ", docType=" + docType
				+ ", createrType=" + createrType + ", counterclamFlag="
				+ counterclamFlag + ", oppungEvidence=" + oppugnEvidence + "]";
	}
	
}
