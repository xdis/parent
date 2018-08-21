package com.zyxy.common.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 财务VO
 */
public class FinanceVO {

    /**
     * 案件id
     */
    private String caseId;

    /**
     * 文书年编号
     */
    private String docYearNumber;

    /**
     * 文书序列号
     */
    private String docSerialNumber;

    /**
     * 申请人
     */
    private String propName;

    /**
     * 被申请人
     */
    private String defeName;

    /**
     * 案件受理时间
     */
    private Date registerTime;

    /**
     * 案件进展
     */
    private String caseProgress;

    /**
     * 仲裁费
     */
    private BigDecimal arbitrationFee;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getDocYearNumber() {
        return docYearNumber;
    }

    public void setDocYearNumber(String docYearNumber) {
        this.docYearNumber = docYearNumber;
    }

    public String getDocSerialNumber() {
        return docSerialNumber;
    }

    public void setDocSerialNumber(String docSerialNumber) {
        this.docSerialNumber = docSerialNumber;
    }

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public String getDefeName() {
        return defeName;
    }

    public void setDefeName(String defeName) {
        this.defeName = defeName;
    }

    public BigDecimal getArbitrationFee() {
        return arbitrationFee;
    }

    public void setArbitrationFee(BigDecimal arbitrationFee) {
        this.arbitrationFee = arbitrationFee;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getCaseProgress() {
        return caseProgress;
    }

    public void setCaseProgress(String caseProgress) {
        this.caseProgress = caseProgress;
    }
}
