package com.zyxy.common.dto;

/**
 * 仲裁委案件关系表
 */
public class CaseManagerDTO {

    /**
     * 仲裁委user_info id
     */
    private String id;

    /**
     * 案件id
     */
    private String caseId;

    /**
     * 仲裁委工作人员状态，0-有效 1-回避
     */
    private String status;

    public String getId() {
        return id;
    }

    public String getCaseId() {
        return caseId;
    }

    public String getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
