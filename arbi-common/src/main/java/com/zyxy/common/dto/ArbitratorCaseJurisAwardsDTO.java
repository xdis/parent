package com.zyxy.common.dto;

import com.zyxy.common.constants.RegexpConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 仲裁员出具管辖权异议决定书DTO
 */
@ApiModel(value = "仲裁员出具管辖权异议决定书DTO")
public class ArbitratorCaseJurisAwardsDTO extends BaseDTO {

    /**
     * 决定内容
     */
    @ApiModelProperty("决定内容")
    @NotNull
    private String content;

    /**
     * 案件Id
     */
    @ApiModelProperty("案件Id")
    @NotNull
    @Pattern(regexp = RegexpConstant.CASE_ID_REGEX, message = "案件Id格式错误")
    private String caseId;

    /**
     * 仲裁员意见
     */
    @ApiModelProperty("仲裁员意见，0- 同意，1- 不同意")
    @NotNull
    @Pattern(regexp = RegexpConstant.OPINIONS_OF_ARBITRATOR_REGEX, message = "仲裁员意见格式错误")
    private String opinion;

    /**
     * 仲裁员意见内容
     */
    @ApiModelProperty("仲裁员意见")
    @NotNull
    private String opinionStr;

    @ApiModelProperty("请求标志，0- 本请求，1- 反请求")
    @NotNull
    @Pattern(regexp = RegexpConstant.OPINIONS_OF_ARBITRATOR_REGEX, message = "请求标志错误")
    private String requestType;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getOpinionStr() {
        return opinionStr;
    }

    public void setOpinionStr(String opinionStr) {
        this.opinionStr = opinionStr;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }
}
