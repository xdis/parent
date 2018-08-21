package com.zyxy.common.vo;

import com.zyxy.common.domain.CaseJurisDis;
import com.zyxy.common.domain.CaseJurisDisWithBLOBs;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 *   案件管辖权异议VO
 */
@ApiModel(value ="案件管辖权异议VO")
public class CaseJurisDisVO implements Serializable {
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
     *   理由
     */
    @ApiModelProperty(value = "理由")
    private String reason;

    /**
     *   异议人名称
     */
    @ApiModelProperty(value = "异议人名称")
    private String jurisName;

    /**
     *   状态。0-待审核，1-审核通过，2-审核未通过
     */
    @ApiModelProperty(value = "状态。0-待审核，1-审核通过，2-审核未通过")
    private String status;

    /**
     *   失败原因
     */
    @ApiModelProperty(value = "失败原因")
    private String failReason;

    /**
     * 申请时间
     */
    @ApiModelProperty(value="申请时间")
    private Date createTime;

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
        this.caseId = caseId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getJurisName() {
        return jurisName;
    }

    public void setJurisName(String jurisName) {
        this.jurisName = jurisName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFailReason() {
        return failReason;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    public static CaseJurisDisVO convertFormCaseJurisDis(CaseJurisDisWithBLOBs domain) {
        CaseJurisDisVO vo = new CaseJurisDisVO();
        vo.setCaseId(domain.getCaseId());
        vo.setFailReason(domain.getFailReason());
        vo.setId(domain.getId());
        vo.setReason(domain.getReason());
        vo.setStatus(domain.getStatus());
        vo.setCreateTime(domain.getCreateTime());
        return vo;
    }
}