package com.zyxy.common.vo;

import com.zyxy.common.domain.CaseChangeRecordWithBLOBs;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 仲裁变更记录信息VO
 */
@ApiModel("仲裁变更记录信息")
public class CaseArbitrationChangeRecordVO {

    /**
     * 变更时间
     */
    @ApiModelProperty("变更时间")
    private Date time;

    /**
     * 变更状态
     * 0-待审核,1-审核通过,2-审核未通过
     */
    @ApiModelProperty("变更状态。0-待审核,1-审核通过,2-审核未通过")
    private String status;

    /**
     * 变更内容
     */
    @ApiModelProperty("变更内容")
    private String content;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static CaseArbitrationChangeRecordVO convertFormCaseChangeRecord(CaseChangeRecordWithBLOBs caseChangeRecord) {
        CaseArbitrationChangeRecordVO vo = new CaseArbitrationChangeRecordVO();
        vo.setContent(caseChangeRecord.getChangeRequest());
        vo.setStatus(caseChangeRecord.getStatus());
        vo.setTime(caseChangeRecord.getCreateTime());
        return vo;
    }
}
