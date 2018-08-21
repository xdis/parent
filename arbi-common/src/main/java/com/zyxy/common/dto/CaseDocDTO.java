package com.zyxy.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;


/**
 * 案件文书对象
 */
@ApiModel(value="案件文书对象")
public class CaseDocDTO extends BaseDTO{
    /**
     * 仲裁员user_id
     */
    @ApiParam(hidden=true)
    private String userId;

    /**
     * 仲裁委类型
     * 0-立案秘书
     * 1-立案部长
     * 2-仲裁秘书
     * 3-仲裁部长
     * 4-主任
     */
    @ApiParam(hidden=true)
    private String duties;

    /**
     * 案件id
     */
    @ApiModelProperty(value="案件id")
    private String caseId;


    /**
     * 仲裁员在当前案件状态
     * 0-待受理
     * 1-不受理
     * 2-有效
     * 3-回避
     */
    @ApiParam(hidden=true)
    private String arbitratorStatus;

    /**
     * 文书状态
     * 0-正常
     * 1-废弃
     */
    @ApiParam(hidden=true)
    private String docStatus;

    /**
     * 文书类型
     * 0-撤案决定书
     * 1-裁决书
     * 2-仲裁申请书
     * 3-反请求撤案决定书
     * 4-撤案申请书
     *
     */
    @ApiParam(hidden=true)
    private String docType;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDuties() {
        return duties;
    }

    public void setDuties(String duties) {
        this.duties = duties;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getArbitratorStatus() {
        return arbitratorStatus;
    }

    public void setArbitratorStatus(String arbitratorStatus) {
        this.arbitratorStatus = arbitratorStatus;
    }

    public String getDocStatus() {
        return docStatus;
    }

    public void setDocStatus(String docStatus) {
        this.docStatus = docStatus;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }
}
