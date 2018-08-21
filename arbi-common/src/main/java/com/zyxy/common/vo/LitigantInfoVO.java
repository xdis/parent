package com.zyxy.common.vo;

/**
 * 当事人信息VO
 */
public class LitigantInfoVO {
    /**
     * 申请人手机号
     */
    private String propPhone;
    /**
     * 被申请人手机号
     */
    private String defePhone;
    /**
     * 申请人用户id
     */
    private String propUserId;
    /**
     * 被申请人用户id
     */
    private String defeUserId;

    /**
     * 申请人的代理人姓名
     */
    private String propAgentName;

    /**
     * 申请人的代理人用户id
     */
    private String propAgentUserId;

    /**
     * 申请人的代理人手机号
     */
    private String propAgentPhone;

    /**
     * 被申请人的代理人姓名
     */
    private String defeAgentName;

    /**
     * 被申请人的代理人手机号
     */
    private String defeAgentPhone;

    /**
     * 被申请人的代理人用户id
     */
    private String defeAgentUserId;

    /**
     * 案号
     */
    private String caseNo;

    public String getPropPhone() {
        return propPhone;
    }

    public void setPropPhone(String propPhone) {
        this.propPhone = propPhone;
    }

    public String getDefePhone() {
        return defePhone;
    }

    public void setDefePhone(String defePhone) {
        this.defePhone = defePhone;
    }

    public String getPropUserId() {
        return propUserId;
    }

    public void setPropUserId(String propUserId) {
        this.propUserId = propUserId;
    }

    public String getDefeUserId() {
        return defeUserId;
    }

    public void setDefeUserId(String defeUserId) {
        this.defeUserId = defeUserId;
    }


    public String getPropAgentName() {
        return propAgentName;
    }

    public void setPropAgentName(String propAgentName) {
        this.propAgentName = propAgentName;
    }

    public String getPropAgentPhone() {
        return propAgentPhone;
    }

    public void setPropAgentPhone(String propAgentPhone) {
        this.propAgentPhone = propAgentPhone;
    }

    public String getDefeAgentName() {
        return defeAgentName;
    }

    public void setDefeAgentName(String defeAgentName) {
        this.defeAgentName = defeAgentName;
    }

    public String getDefeAgentPhone() {
        return defeAgentPhone;
    }

    public void setDefeAgentPhone(String defeAgentPhone) {
        this.defeAgentPhone = defeAgentPhone;
    }

    public String getPropAgentUserId() {
        return propAgentUserId;
    }

    public void setPropAgentUserId(String propAgentUserId) {
        this.propAgentUserId = propAgentUserId;
    }

    public String getDefeAgentUserId() {
        return defeAgentUserId;
    }

    public void setDefeAgentUserId(String defeAgentUserId) {
        this.defeAgentUserId = defeAgentUserId;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }
}
