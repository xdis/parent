package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 *
 *   案件文书内容表
 *
 * case_doc_content
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="CaseDocContent")
public class CaseDocContent implements Serializable {
    /**
     * 
     *   id
     * case_doc_content.ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "id")
    private String id;

    /**
     * 
     *   案件id
     * case_doc_content.CASE_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "案件id")
    private String caseId;

    /**
     * case_doc_content.REQUEST_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String requestId;

    /**
     *
     *   出具类型 0-正（同意模板文书） 1-反（不同意模板文书）
     * case_doc_content.ISSUE_TYPE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "出具类型 0-正（同意模板文书） 1-反（不同意模板文书）")
    private Integer issueType;

    /**
     * 
     *   出具人id
     * case_doc_content.ISSUE_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "出具人id")
    private String issueId;

    /**
     * 
     *   出具时间
     * case_doc_content.ISSUS_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "出具时间")
    private Date issusTime;

    /**
     * 
     *   创建时间
     * case_doc_content.CREATE_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 
     *   文书id
     * case_doc_content.DOC_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文书id")
    private String docId;

    /**
     * 
     *   秘书ID
     * case_doc_content.SECRETARY_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "秘书ID")
    private String secretaryId;

    /**
     * 
     *   仲裁员ID
     * case_doc_content.ARBITRATOR_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "仲裁员ID")
    private String arbitratorId;

    /**
     * 
     *   是否为草稿0-是1-否
     * case_doc_content.SAVE_A_DRAFT
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否为草稿0-是1-否")
    private String saveADraft;

    /**
     * case_doc_content
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * id
     * 
     * @return id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * id
     * 
     * @param id id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 案件id
     * 
     * @return 案件id
     *
     * @mbggenerated
     */
    public String getCaseId() {
        return caseId;
    }

    /**
     * 案件id
     * 
     * @param caseId 案件id
     *
     * @mbggenerated
     */
    public void setCaseId(String caseId) {
        this.caseId = caseId == null ? null : caseId.trim();
    }

    /**
     * 
     * 
     * @return 
     *
     * @mbggenerated
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * 
     * 
     * @param requestId 
     *
     * @mbggenerated
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId == null ? null : requestId.trim();
    }

    /**
     * 出具类型 0-正（同意模板文书） 1-反（不同意模板文书）
     *
     * @return 出具类型 0-正（同意模板文书） 1-反（不同意模板文书）
     *
     * @mbggenerated
     */
    public Integer getIssueType() {
        return issueType;
    }

    /**
     * 出具类型 0-正（同意模板文书） 1-反（不同意模板文书）
     *
     * @param issueType 出具类型 0-正（同意模板文书） 1-反（不同意模板文书）
     *
     * @mbggenerated
     */
    public void setIssueType(Integer issueType) {
        this.issueType = issueType;
    }

    /**
     * 出具人id
     * 
     * @return 出具人id
     *
     * @mbggenerated
     */
    public String getIssueId() {
        return issueId;
    }

    /**
     * 出具人id
     * 
     * @param issueId 出具人id
     *
     * @mbggenerated
     */
    public void setIssueId(String issueId) {
        this.issueId = issueId == null ? null : issueId.trim();
    }

    /**
     * 出具时间
     * 
     * @return 出具时间
     *
     * @mbggenerated
     */
    public Date getIssusTime() {
        return issusTime;
    }

    /**
     * 出具时间
     * 
     * @param issusTime 出具时间
     *
     * @mbggenerated
     */
    public void setIssusTime(Date issusTime) {
        this.issusTime = issusTime;
    }

    /**
     * 创建时间
     * 
     * @return 创建时间
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * 
     * @param createTime 创建时间
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 文书id
     * 
     * @return 文书id
     *
     * @mbggenerated
     */
    public String getDocId() {
        return docId;
    }

    /**
     * 文书id
     * 
     * @param docId 文书id
     *
     * @mbggenerated
     */
    public void setDocId(String docId) {
        this.docId = docId == null ? null : docId.trim();
    }

    /**
     * 秘书ID
     * 
     * @return 秘书ID
     *
     * @mbggenerated
     */
    public String getSecretaryId() {
        return secretaryId;
    }

    /**
     * 秘书ID
     * 
     * @param secretaryId 秘书ID
     *
     * @mbggenerated
     */
    public void setSecretaryId(String secretaryId) {
        this.secretaryId = secretaryId == null ? null : secretaryId.trim();
    }

    /**
     * 仲裁员ID
     * 
     * @return 仲裁员ID
     *
     * @mbggenerated
     */
    public String getArbitratorId() {
        return arbitratorId;
    }

    /**
     * 仲裁员ID
     * 
     * @param arbitratorId 仲裁员ID
     *
     * @mbggenerated
     */
    public void setArbitratorId(String arbitratorId) {
        this.arbitratorId = arbitratorId == null ? null : arbitratorId.trim();
    }

    /**
     * 是否为草稿0-是1-否
     * 
     * @return 是否为草稿0-是1-否
     *
     * @mbggenerated
     */
    public String getSaveADraft() {
        return saveADraft;
    }

    /**
     * 是否为草稿0-是1-否
     * 
     * @param saveADraft 是否为草稿0-是1-否
     *
     * @mbggenerated
     */
    public void setSaveADraft(String saveADraft) {
        this.saveADraft = saveADraft == null ? null : saveADraft.trim();
    }
}