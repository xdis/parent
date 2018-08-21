package com.zyxy.common.vo;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 和解申请VO
 */
public class ComproiseApplyVO {

    /**
     * 和解申请id
     */
    private String applyId;
    
    /**
     * 案件id
     */
    private String caseId;

    /**
     * 申请时间
     */
    private Timestamp createTime;

    /**
     * 申请类型 0-申请人发起，1-被申请人发起
     */
    private String applyType;

    /**
     * 申请人意见 0-同意，1-拒绝
     */
    private String propOpinion;

    /**
     * 被申请人意见 0-同意，1-拒绝
     */
    private String defeOpinion;

    /**
     * 仲裁委意见 0-同意，1-拒绝
     */
    private String managerOpinion;

    /**
     * 申请方名字
     */
    private String propName;
    
    /**
     * 被申请方名字
     */
    private String defeName;

    /**
     * 状态
     */
    private String status;

    /**
     * 对方操作时间
     */
    private Timestamp otherOperatingTime;

    /**
     * 仲裁委/仲裁员操作时间
     */
    private Timestamp managerOperatingTime;
    
    /**
     * 仲裁委名字
     */
    private String managerName;
    
    /**
     * 职务
     */
    private String duties;
    
    
    /**
     * 是否申请过回避
     * 0-申请过
     * 1-未申请
     */
    private String isApplyAvoid;


    /**
     * 审核人类型
     * 0- 仲裁秘书审核
     * 1- 仲裁员审核
     */
    private String auditType;

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }


    public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType;
    }

    public String getPropOpinion() {
        return propOpinion;
    }

    public void setPropOpinion(String propOpinion) {
        this.propOpinion = propOpinion;
    }

    public String getDefeOpinion() {
        return defeOpinion;
    }

    public void setDefeOpinion(String defeOpinion) {
        this.defeOpinion = defeOpinion;
    }

    public String getManagerOpinion() {
        return managerOpinion;
    }

    public void setManagerOpinion(String managerOpinion) {
        this.managerOpinion = managerOpinion;
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

	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getDuties() {
		return duties;
	}

	public void setDuties(String duties) {
		this.duties = duties;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getOtherOperatingTime() {
		return otherOperatingTime;
	}

	public void setOtherOperatingTime(Timestamp otherOperatingTime) {
		this.otherOperatingTime = otherOperatingTime;
	}

	public Timestamp getManagerOperatingTime() {
		return managerOperatingTime;
	}

	public void setManagerOperatingTime(Timestamp managerOperatingTime) {
		this.managerOperatingTime = managerOperatingTime;
	}

	public String getIsApplyAvoid() {
		return isApplyAvoid;
	}

	public void setIsApplyAvoid(String isApplyAvoid) {
		this.isApplyAvoid = isApplyAvoid;
	}

    public String getAuditType() {
        return auditType;
    }

    public void setAuditType(String auditType) {
        this.auditType = auditType;
    }
}
