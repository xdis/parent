package com.zyxy.common.dto.flow;

import com.zyxy.common.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 案件结案DTO
 */
@ApiModel(value = "案件结案DTO")
public class CaseOverDTO extends BaseDTO {

    /**
     * 案件ID
     */
    @ApiModelProperty("案件ID")
    @NotNull(message = "案件ID不为空")
    private String caseId;

    /**
     * 类型
     * <p>
     * 0- 双方撤案，1- 下达裁决书，2- 案件转线下，3- 下达调解书
     */
    @ApiModelProperty("类型，0- 双方撤案，1- 下达裁决书，2- 案件转线下，3- 下达调解书")
    @NotNull(message = "类型不能为空")
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
