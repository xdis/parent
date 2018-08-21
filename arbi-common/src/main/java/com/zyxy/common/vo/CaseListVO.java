package com.zyxy.common.vo;

import java.sql.Timestamp;

/**
 * 案件列表返回对象
 */
public class CaseListVO{

    /**
     * 案件id
     */
    private String caseId;

    /**
     * 申请人
     */
    private String proposerName;


    /**
     * 被申请人
     */
    private String defendantName;

    /**
     * 案件状态
     */
    private String approveStatus;


    /**
     * 申请时间
     */
    private Timestamp applyTime;

    /**
     * 当前责任人
     */
    private String ownnerName;

    /**
     * 仲裁委工作人员职务
     * 0-立案秘书
     * 1-立案部长
     * 2-仲裁秘书
     * 3-仲裁部长
     * 4-主任
     * 5-副主任
     */
    private String duties;

    /**
     * 审核期计划结束时间
     */
    private Timestamp timeSet;

    /**
     * 秘书查看案件详情的权限，0-有，1-无
     */
    private String primiss;
    
    
    /**
     * 案件状态，0-代表该案件是属于自己的，1-代表案件不属于自己
     */
    private String caseStatus;

    /**
     * 是否授权给别人
     * 0-未授权
     * 1-已授权
     */
    private String isArantAuthOther;

    /**
     * 被授权的职务
     * 为NULL代表没有被授权
     */
    private String managerType;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getProposerName() {
        return proposerName;
    }

    public void setProposerName(String proposerName) {
        this.proposerName = proposerName;
    }

    public String getDefendantName() {
        return defendantName;
    }

    public void setDefendantName(String defendantName) {
        this.defendantName = defendantName;
    }

    public String getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(String approveStatus) {
        this.approveStatus = approveStatus;
    }

    public Timestamp getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Timestamp applyTime) {
        this.applyTime = applyTime;
    }

    public String getOwnnerName() {
        return ownnerName;
    }

    public void setOwnnerName(String ownnerName) {
        this.ownnerName = ownnerName;
    }

    public String getDuties() {
        return duties;
    }

    public void setDuties(String duties) {
        this.duties = duties;
    }

    public Timestamp getTimeSet() {
        return timeSet;
    }

    public void setTimeSet(Timestamp timeSet) {
        this.timeSet = timeSet;
    }

    public String getPrimiss() {
        return primiss;
    }

    public void setPrimiss(String primiss) {
        this.primiss = primiss;
    }

	public String getCaseStatus() {
		return caseStatus;
	}

	public void setCaseStatus(String caseStatus) {
		this.caseStatus = caseStatus;
	}


    public String getIsArantAuthOther() {
        return isArantAuthOther;
    }

    public void setIsArantAuthOther(String isArantAuthOther) {
        this.isArantAuthOther = isArantAuthOther;
    }

    public String getManagerType() {
        return managerType;
    }

    public void setManagerType(String managerType) {
        this.managerType = managerType;
    }
}
