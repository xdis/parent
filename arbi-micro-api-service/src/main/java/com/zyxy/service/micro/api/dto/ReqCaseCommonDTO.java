package com.zyxy.service.micro.api.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.zyxy.common.constants.RegexpConstant;

/**
 * 案件请求基本参数
 * @author sonta
 *
 */
public class ReqCaseCommonDTO extends ReqBaseDTO{
    
    @ApiModelProperty("案件ID")
    @NotNull(message="不能为空")
    @Pattern(regexp=RegexpConstant.ID_COMMON_REGEX, message="格式非法")
    private String caseId;

    @Override
    public String[] getSecretKeys() {
        return null;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }
}
