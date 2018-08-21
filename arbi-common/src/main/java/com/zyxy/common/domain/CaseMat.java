package com.zyxy.common.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 *
 * case_mat
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="CaseMat")
public class CaseMat implements Serializable {

    /**
     * 编号 case_mat.ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "编号")
    private String id;
    /**
     * 案件ID case_mat.CASE_ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "案件ID")
    private String caseId;
    /**
     * 附件名称 case_mat.ATTACH_NAME
     * @mbggenerated
     */
    @ApiModelProperty(value = "附件名称")
    private String attachName;
    /**
     * 材料类型 0-附件，1-请求证据 2 答辩证据 3委托代理材料 4举证证据 case_mat.MAT_TYPE
     * @mbggenerated
     */
    @ApiModelProperty(value = "材料类型 0-附件，1-请求证据 2 答辩证据 3委托代理材料 4举证证据")
    private String matType;
    /**
     * 节点ID case_mat.NODE_ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "节点ID")
    private Integer nodeId;
    /**
     * 证据材料 case_mat.EVIDENCE_MAT
     * @mbggenerated
     */
    @ApiModelProperty(value = "证据材料")
    private String evidenceMat;
    /**
     * 证据目的 case_mat.PURPOSE_EVIDENCE
     * @mbggenerated
     */
    @ApiModelProperty(value = "证据目的")
    private String purposeEvidence;
    /**
     * 证据来源 case_mat.SOURCE_EVIDENCE
     * @mbggenerated
     */
    @ApiModelProperty(value = "证据来源")
    private String sourceEvidence;
    /**
     * 文件吗 case_mat.DOC_NAME
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件吗")
    private String docName;
    /**
     * 备注 case_mat.REMARK
     * @mbggenerated
     */
    @ApiModelProperty(value = "备注")
    private String remark;
    /**
     * 文件ID case_mat.FILE_ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件ID")
    private String fileId;
    /**
     * 文件类型后缀名 case_mat.DOC_TYPE
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件类型后缀名")
    private String docType;
    /**
     * 请求ID case_mat.REQUEST_ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "请求ID")
    private String requestId;
    /**
     * 请求标志0正请求 1反请求 case_mat.COUNTERCLAIM_FLAG
     * @mbggenerated
     */
    @ApiModelProperty(value = "请求标志0正请求 1反请求")
    private String counterclaimFlag;
    /**
     * 身份类型,0-申请人，1-被申请人 case_mat.CREATER_TYPE
     * @mbggenerated
     */
    @ApiModelProperty(value = "身份类型,0-申请人，1-被申请人")
    private String createrType;
    /**
     * 签名记录表ID case_mat.SIGN_SIGNATURE_LOG_ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "签名记录表ID")
    private String signSignatureLogId;
    /**
     * case_mat
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     * @return  编号
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * 编号
     * @param id  编号
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 案件ID
     * @return  案件ID
     * @mbggenerated
     */
    public String getCaseId() {
        return caseId;
    }

    /**
     * 案件ID
     * @param caseId  案件ID
     * @mbggenerated
     */
    public void setCaseId(String caseId) {
        this.caseId = caseId == null ? null : caseId.trim();
    }

    /**
     * 附件名称
     * @return  附件名称
     * @mbggenerated
     */
    public String getAttachName() {
        return attachName;
    }

    /**
     * 附件名称
     * @param attachName  附件名称
     * @mbggenerated
     */
    public void setAttachName(String attachName) {
        this.attachName = attachName == null ? null : attachName.trim();
    }

    /**
     * 材料类型 0-附件，1-请求证据 2 答辩证据 3委托代理材料 4举证证据
     * @return  材料类型 0-附件，1-请求证据 2 答辩证据 3委托代理材料 4举证证据
     * @mbggenerated
     */
    public String getMatType() {
        return matType;
    }

    /**
     * 材料类型 0-附件，1-请求证据 2 答辩证据 3委托代理材料 4举证证据
     * @param matType  材料类型 0-附件，1-请求证据 2 答辩证据 3委托代理材料 4举证证据
     * @mbggenerated
     */
    public void setMatType(String matType) {
        this.matType = matType == null ? null : matType.trim();
    }

    /**
     * 节点ID
     * @return  节点ID
     * @mbggenerated
     */
    public Integer getNodeId() {
        return nodeId;
    }

    /**
     * 节点ID
     * @param nodeId  节点ID
     * @mbggenerated
     */
    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    /**
     * 证据材料
     * @return  证据材料
     * @mbggenerated
     */
    public String getEvidenceMat() {
        return evidenceMat;
    }

    /**
     * 证据材料
     * @param evidenceMat  证据材料
     * @mbggenerated
     */
    public void setEvidenceMat(String evidenceMat) {
        this.evidenceMat = evidenceMat == null ? null : evidenceMat.trim();
    }

    /**
     * 证据目的
     * @return  证据目的
     * @mbggenerated
     */
    public String getPurposeEvidence() {
        return purposeEvidence;
    }

    /**
     * 证据目的
     * @param purposeEvidence  证据目的
     * @mbggenerated
     */
    public void setPurposeEvidence(String purposeEvidence) {
        this.purposeEvidence = purposeEvidence == null ? null : purposeEvidence
                .trim();
    }

    /**
     * 证据来源
     * @return  证据来源
     * @mbggenerated
     */
    public String getSourceEvidence() {
        return sourceEvidence;
    }

    /**
     * 证据来源
     * @param sourceEvidence  证据来源
     * @mbggenerated
     */
    public void setSourceEvidence(String sourceEvidence) {
        this.sourceEvidence = sourceEvidence == null ? null : sourceEvidence
                .trim();
    }

    /**
     * 文件吗
     * @return  文件吗
     * @mbggenerated
     */
    public String getDocName() {
        return docName;
    }

    /**
     * 文件吗
     * @param docName  文件吗
     * @mbggenerated
     */
    public void setDocName(String docName) {
        this.docName = docName == null ? null : docName.trim();
    }

    /**
     * 备注
     * @return  备注
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark  备注
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 文件ID
     * @return  文件ID
     * @mbggenerated
     */
    public String getFileId() {
        return fileId;
    }

    /**
     * 文件ID
     * @param fileId  文件ID
     * @mbggenerated
     */
    public void setFileId(String fileId) {
        this.fileId = fileId == null ? null : fileId.trim();
    }

    /**
     * 文件类型后缀名
     * @return  文件类型后缀名
     * @mbggenerated
     */
    public String getDocType() {
        return docType;
    }

    /**
     * 文件类型后缀名
     * @param docType  文件类型后缀名
     * @mbggenerated
     */
    public void setDocType(String docType) {
        this.docType = docType == null ? null : docType.trim();
    }

    /**
     * 请求ID
     * @return  请求ID
     * @mbggenerated
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * 请求ID
     * @param requestId  请求ID
     * @mbggenerated
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId == null ? null : requestId.trim();
    }

    /**
     * 请求标志0正请求 1反请求
     * @return  请求标志0正请求 1反请求
     * @mbggenerated
     */
    public String getCounterclaimFlag() {
        return counterclaimFlag;
    }

    /**
     * 请求标志0正请求 1反请求
     * @param counterclaimFlag  请求标志0正请求 1反请求
     * @mbggenerated
     */
    public void setCounterclaimFlag(String counterclaimFlag) {
        this.counterclaimFlag = counterclaimFlag == null ? null
                : counterclaimFlag.trim();
    }

    /**
     * 身份类型,0-申请人，1-被申请人
     * @return  身份类型,0-申请人，1-被申请人
     * @mbggenerated
     */
    public String getCreaterType() {
        return createrType;
    }

    /**
     * 身份类型,0-申请人，1-被申请人
     * @param createrType  身份类型,0-申请人，1-被申请人
     * @mbggenerated
     */
    public void setCreaterType(String createrType) {
        this.createrType = createrType == null ? null : createrType.trim();
    }

    /**
     * 签名记录表ID
     * @return  签名记录表ID
     * @mbggenerated
     */
    public String getSignSignatureLogId() {
        return signSignatureLogId;
    }

    /**
     * 签名记录表ID
     * @param signSignatureLogId  签名记录表ID
     * @mbggenerated
     */
    public void setSignSignatureLogId(String signSignatureLogId) {
        this.signSignatureLogId = signSignatureLogId == null ? null
                : signSignatureLogId.trim();
    }
}