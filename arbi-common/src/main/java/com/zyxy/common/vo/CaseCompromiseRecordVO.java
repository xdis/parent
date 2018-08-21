package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 *   和解记录VO
 */
@ApiModel(value ="和解记录VO")
public class CaseCompromiseRecordVO {
    /**
     *   编号
     */
    @ApiModelProperty(value = "编号")
    private String id;

    /**
     *   案件ID
     */
    @ApiModelProperty(value = "案件ID")
    private String caseId;

    /**
     *   发送方类型。0- 申请人,1- 被申请人,2- 仲裁秘书,3- 仲裁员
     */
    @ApiModelProperty(value = "发送方类型。0- 申请人,1- 被申请人,2- 仲裁秘书,3- 仲裁员")
    private String senderType;

    /**
     *   创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     *   内容
     */
    @ApiModelProperty(value = "内容")
    private String content;

    /**
     * 申请人姓名
     */
    @ApiModelProperty(value = "申请人姓名")
    private String propName;

    /**
     * 被申请人姓名
     */
    @ApiModelProperty(value = "被申请人姓名")
    private String defeName;

    /**
     * 仲裁秘书姓名
     */
    @ApiModelProperty(value = "仲裁秘书姓名")
    private String arbiSecretariesName;

    /**
     * 申请人代理人姓名
     */
    @ApiModelProperty(value = "申请人代理人姓名")
    private String propAgentName;

    /**
     * 被申请人代理人姓名
     */
    @ApiModelProperty(value = "被申请人代理人姓名")
    private String defeAgentName;
    
    /**
     * 是否申请过回避
     * 0-申请过
     * 1-未申请
     */
    private String isApplyAvoid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId == null ? null : caseId.trim();
    }

    public String getSenderType() {
        return senderType;
    }

    public void setSenderType(String senderType) {
        this.senderType = senderType == null ? null : senderType.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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

    public String getArbiSecretariesName() {
        return arbiSecretariesName;
    }

    public void setArbiSecretariesName(String arbiSecretariesName) {
        this.arbiSecretariesName = arbiSecretariesName;
    }

    public String getPropAgentName() {
        return propAgentName;
    }

    public void setPropAgentName(String propAgentName) {
        this.propAgentName = propAgentName;
    }

    public String getDefeAgentName() {
        return defeAgentName;
    }

    public void setDefeAgentName(String defeAgentName) {
        this.defeAgentName = defeAgentName;
    }

	public String getIsApplyAvoid() {
		return isApplyAvoid;
	}

	public void setIsApplyAvoid(String isApplyAvoid) {
		this.isApplyAvoid = isApplyAvoid;
	}
    
}