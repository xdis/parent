package com.zyxy.common.dto;

import com.zyxy.common.constants.RegexpConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 当事人
 */
@ApiModel(value ="当事人案件受理对象")
public class ArbitratorCaseAcceptDTO extends BaseDTO {

    /**
     * 受理状态,0、接受，1、不接受
     */
    @ApiModelProperty("受理状态,0、接受，1、不接受")
    @NotNull
    @Pattern(regexp = RegexpConstant.ARBITRATOR_CASE_ACCEPT_REGEX, message = "受理状态错误")
    private String status;

    /**
     * 案件Id
     */
    @ApiModelProperty("案件Id")
    @NotNull
    @Pattern(regexp = RegexpConstant.CASE_ID_REGEX, message = "案件Id格式错误")
    private String caseId;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }
}
