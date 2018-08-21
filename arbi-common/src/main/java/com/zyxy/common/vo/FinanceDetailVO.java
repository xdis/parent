package com.zyxy.common.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 财务模块详情
 */
public class FinanceDetailVO {

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
     * 状态 0-待支付，1-成功，2-失败
     */
    private Integer status;

    /**
     * 支付金额
     */
    private BigDecimal amount;

    /**
     * 账户名
     */
    private String accountName;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
