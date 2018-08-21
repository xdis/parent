package com.zyxy.common.domain;


import java.io.Serializable;

/**
 * 数据统计model
 */
public class DataStatistics implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 待审核
     */
    private Integer notAudited;

    /**
     * 审核通过
     */
    private Integer auditAdopt;

    /**
     * 审核未通过
     */
    private Integer auditNotPass;

    /**
     * 待审核和审核通过总数
     */
    private Integer stayAndNotAuditTotal;

    /**
     * 总数
     */
    private Integer total;

    public Integer getNotAudited() {
        return notAudited;
    }

    public void setNotAudited(Integer notAudited) {
        this.notAudited = notAudited;
    }

    public Integer getAuditAdopt() {
        return auditAdopt;
    }

    public void setAuditAdopt(Integer auditAdopt) {
        this.auditAdopt = auditAdopt;
    }

    public Integer getAuditNotPass() {
        return auditNotPass;
    }

    public void setAuditNotPass(Integer auditNotPass) {
        this.auditNotPass = auditNotPass;
    }

    public Integer getStayAndNotAuditTotal() {
        return stayAndNotAuditTotal;
    }

    public void setStayAndNotAuditTotal(Integer stayAndNotAuditTotal) {
        this.stayAndNotAuditTotal = stayAndNotAuditTotal;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
