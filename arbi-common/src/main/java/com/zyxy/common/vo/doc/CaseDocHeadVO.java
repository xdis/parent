package com.zyxy.common.vo.doc;

import io.swagger.annotations.ApiModel;

/**
 * 案件文书头部对象
 */
@ApiModel(value = "案件文书头部对象")
public class CaseDocHeadVO {

    private CaseDocLitigantVO applicant;

    private CaseDocLitigantVO beApplicant;

    private CaseDocAgentVO applicantAgent;

    private CaseDocAgentVO beApplicantAgent;

    public CaseDocLitigantVO getApplicant() {
        return applicant;
    }

    public void setApplicant(CaseDocLitigantVO applicant) {
        this.applicant = applicant;
    }

    public CaseDocLitigantVO getBeApplicant() {
        return beApplicant;
    }

    public void setBeApplicant(CaseDocLitigantVO beApplicant) {
        this.beApplicant = beApplicant;
    }

    public CaseDocAgentVO getApplicantAgent() {
        return applicantAgent;
    }

    public void setApplicantAgent(CaseDocAgentVO applicantAgent) {
        this.applicantAgent = applicantAgent;
    }

    public CaseDocAgentVO getBeApplicantAgent() {
        return beApplicantAgent;
    }

    public void setBeApplicantAgent(CaseDocAgentVO beApplicantAgent) {
        this.beApplicantAgent = beApplicantAgent;
    }

    @Override
    public String toString() {
        return "CaseDocHeadVO{" +
                "applicant=" + applicant +
                ", beApplicant=" + beApplicant +
                ", applicantAgent=" + applicantAgent +
                ", beApplicantAgent=" + beApplicantAgent +
                '}';
    }
}
