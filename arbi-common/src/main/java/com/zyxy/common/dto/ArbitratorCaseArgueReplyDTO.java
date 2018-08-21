package com.zyxy.common.dto;

import com.zyxy.common.constants.RegexpConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 仲裁员辩论回复DTO
 */
@ApiModel(value = "仲裁员辩论回复DTO")
public class ArbitratorCaseArgueReplyDTO extends BaseDTO {

    /**
     * 回复内容
     */
    @ApiModelProperty("回复内容")
    @NotNull
    private String content;

    /**
     * 案件Id
     */
    @ApiModelProperty("案件Id")
    @NotNull
    @Pattern(regexp = RegexpConstant.CASE_ID_REGEX, message = "案件Id格式错误")
    private String caseId;

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
}
