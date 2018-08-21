package com.zyxy.common.dto.flow;

import com.zyxy.common.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 放弃答辩期DTO
 */
@ApiModel(value = "放弃答辩期DTO")
public class CaseGiveReplyDTO extends BaseDTO {

    /**
     * 案件ID
     */
    @ApiModelProperty("案件ID")
    @NotNull(message = "案件ID不为空")
    private String caseId;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }
}
