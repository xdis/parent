package com.zyxy.common.dto;

import com.zyxy.common.constants.RegexpConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * 立案草稿DTO
 */
@ApiModel(value = "立案草稿DTO")
public class GetCaseDraftDTO extends BaseDTO {

    /**
     * 案件Id
     */
    @ApiModelProperty("案件Id")
    @Pattern(regexp = RegexpConstant.CASE_ID_REGEX, message = "案件Id错误")
    private String caseId;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }
}
