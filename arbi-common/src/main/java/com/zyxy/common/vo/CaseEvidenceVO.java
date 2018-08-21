package com.zyxy.common.vo;

import com.zyxy.common.domain.CaseMat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 案件证据信息VO
 */
@ApiModel("案件证据信息")
public class CaseEvidenceVO {

    /**
     *   名称
     */
    @ApiModelProperty("名称")
    private String docName;

    /**
     *   文件Id
     */
    @ApiModelProperty("文件Id")
    private String fileId;

    /**
     *   证据材料
     */
    @ApiModelProperty("证据材料")
    private String evidenceMat;

    /**
     *   证据目的
     */
    @ApiModelProperty("证据目的")
    private String purposeEvidence;

    /**
     *   证据来源
     */
    @ApiModelProperty("证据来源")
    private String sourceEvidence;

    /**
     *   文件类型
     */
    @ApiModelProperty("文件类型")
    private String fileType;

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

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
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

    public static CaseEvidenceVO convertFormCaseMat(CaseMat caseMat) {
        CaseEvidenceVO vo = new CaseEvidenceVO();
        vo.setDocName(caseMat.getDocName());
        vo.setFileId(caseMat.getFileId());
        vo.setFileType(caseMat.getDocType());
        vo.setEvidenceMat(caseMat.getEvidenceMat());
        vo.setPurposeEvidence(caseMat.getPurposeEvidence());
        vo.setSourceEvidence(caseMat.getSourceEvidence());
        return vo;
    }
}
