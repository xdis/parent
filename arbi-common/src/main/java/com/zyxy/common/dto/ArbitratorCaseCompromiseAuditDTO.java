package com.zyxy.common.dto;

import com.zyxy.common.constants.RegexpConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * 仲裁员和解审核DTO
 */
@ApiModel(value = "仲裁员和解审核DTO")
public class ArbitratorCaseCompromiseAuditDTO extends BaseDTO {

    /**
     * 开始时间,格式yyyy-MM-dd
     */
    @ApiModelProperty("开始时间,格式yyyy-MM-dd")
    private String startDate;

    /**
     * 处理结果,0、同意，1、不同意
     */
    @ApiModelProperty("处理结果,0、同意，1、不同意")
    @NotNull
    private String result;

    /**
     * 意见
     */
    @ApiModelProperty("意见")
    @NotNull
    private String opinion;

    /**
     * 案件Id
     */
    @ApiModelProperty("案件Id")
    @NotNull
    @Pattern(regexp = RegexpConstant.CASE_ID_REGEX, message = "案件Id格式错误")
    private String caseId;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
}
