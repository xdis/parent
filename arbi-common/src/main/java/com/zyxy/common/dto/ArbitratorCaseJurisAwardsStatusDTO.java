package com.zyxy.common.dto;

import com.zyxy.common.constants.RegexpConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 仲裁员出具管辖权异议决定书状态DTO
 */
@ApiModel(value = "仲裁员出具管辖权异议决定书状态DTO")
public class ArbitratorCaseJurisAwardsStatusDTO extends BaseDTO {

    /**
     * 案件Id
     */
    @ApiModelProperty("案件Id")
    @NotNull
    @Pattern(regexp = RegexpConstant.CASE_ID_REGEX, message = "案件Id格式错误")
    private String caseId;

    @ApiModelProperty("请求标志，0- 本请求，1- 反请求")
    @NotNull
    @Pattern(regexp = RegexpConstant.OPINIONS_OF_ARBITRATOR_REGEX, message = "请求标志错误")
    private String requestType;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }
}
