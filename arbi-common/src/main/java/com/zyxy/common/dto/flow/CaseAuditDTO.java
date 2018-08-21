package com.zyxy.common.dto.flow;

import com.zyxy.common.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 案件审核DTO
 */
@ApiModel(value="案件审核DTO")
public class CaseAuditDTO extends BaseDTO{

    /**
     * 案件ID
     */
    @ApiModelProperty("案件ID")
    @NotNull(message="案件ID不为空")
    private String caseId;

    /**
     * 审核结果
     * 0- 通过，1- 不通过
     */
    @ApiModelProperty("审核结果，0- 通过，1- 不通过")
    @NotNull(message="审核结果不能为空")
    private String result;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
