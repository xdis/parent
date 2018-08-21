package com.zyxy.common.dto;

import com.zyxy.common.constants.RegexpConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 仲裁员出具仲裁书DTO
 */
@ApiModel(value = "仲裁员出具仲裁书DTO")
public class ArbitratorCaseArbitralAwardsDTO extends BaseDTO {

    /**
     * 正文
     */
    @ApiModelProperty("正文")
    @NotNull
    private String content;

    /**
     * 仲裁委意见
     */
    @ApiModelProperty("仲裁委意见")
    @NotNull
    private String arbitrationSuggest;

    /**
     * 裁决内容
     */
    @ApiModelProperty("裁决内容")
    @NotNull
    private String arbitratorContent;

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

    public String getArbitrationSuggest() {
        return arbitrationSuggest;
    }

    public void setArbitrationSuggest(String arbitrationSuggest) {
        this.arbitrationSuggest = arbitrationSuggest;
    }

    public String getArbitratorContent() {
        return arbitratorContent;
    }

    public void setArbitratorContent(String arbitratorContent) {
        this.arbitratorContent = arbitratorContent;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }
}
