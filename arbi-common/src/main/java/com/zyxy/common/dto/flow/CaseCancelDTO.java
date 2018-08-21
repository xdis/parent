package com.zyxy.common.dto.flow;

import com.zyxy.common.constants.RegexpConstant;
import com.zyxy.common.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 撤案DTO
 */
@ApiModel(value = "撤案DTO")
public class CaseCancelDTO extends BaseDTO {

    /**
     * 案件ID
     */
    @ApiModelProperty("案件ID")
    @NotNull(message = "案件ID不为空")
    private String caseId;

    /**
     * 案件类型
     *
     * @see com.zyxy.common.enums.RequestTypeEnum
     */
    @ApiModelProperty("案件类型")
    @NotNull(message = "案件类型不为空")
    @Pattern(regexp = RegexpConstant.CASE_COUNTERCLAIM_FLAG)
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
