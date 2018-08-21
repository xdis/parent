package com.zyxy.service.micro.api.dto;

/**
 * 案件发布结果返回
 * @author sonta
 *
 */
public class ResCaseRegisterDTO {
    
    /**
     * 仲裁平台案件ID
     */
    private String caseId;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }
}
