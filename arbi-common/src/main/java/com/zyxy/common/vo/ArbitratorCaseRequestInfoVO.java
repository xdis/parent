package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 仲裁员案件请求信息VO
 */
@ApiModel("仲裁员案件请求信息")
public class ArbitratorCaseRequestInfoVO {

    /**
     * 案件基本信息
     */
    @ApiModelProperty("案件基本信息")
    ArbitratorCaseBaseInfoVO baseInfo;

    /**
     * 仲裁变更列表
     */
    @ApiModelProperty("仲裁变更列表")
    List<CaseArbitrationChangeRecordVO> arbitrationChangeRecords;

    /**
     * 附件列表
     */
    @ApiModelProperty("附件列表")
    List<CaseAttachmentVO> attachments;

    /**
     * 证据列表
     */
    @ApiModelProperty("证据列表")
    List<CaseEvidenceVO> caseEvidences;

    /**
     * 案件代理人材料列表
     */
    @ApiModelProperty("案件代理人材料列表")
    List<CaseAttorneyMaterialVO> caseAttorneyMaterial;

    public ArbitratorCaseBaseInfoVO getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(ArbitratorCaseBaseInfoVO baseInfo) {
        this.baseInfo = baseInfo;
    }

    public List<CaseArbitrationChangeRecordVO> getArbitrationChangeRecords() {
        return arbitrationChangeRecords;
    }

    public void setArbitrationChangeRecords(List<CaseArbitrationChangeRecordVO> arbitrationChangeRecords) {
        this.arbitrationChangeRecords = arbitrationChangeRecords;
    }

    public List<CaseAttachmentVO> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<CaseAttachmentVO> attachments) {
        this.attachments = attachments;
    }

    public List<CaseAttorneyMaterialVO> getCaseAttorneyMaterial() {
        return caseAttorneyMaterial;
    }

    public void setCaseAttorneyMaterial(List<CaseAttorneyMaterialVO> caseAttorneyMaterial) {
        this.caseAttorneyMaterial = caseAttorneyMaterial;
    }

    public List<CaseEvidenceVO> getCaseEvidences() {
        return caseEvidences;
    }

    public void setCaseEvidences(List<CaseEvidenceVO> caseEvidences) {
        this.caseEvidences = caseEvidences;
    }
}

