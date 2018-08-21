package com.zyxy.common.dto;

import com.zyxy.common.constants.RegexpConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 当事人案件列表对象
 */
@ApiModel(value ="当事人案件列表对象")
public class PartyCaseListDTO extends BasePageDTO {

    /**
     * 当事人身份类型
     */
    @NotNull(message = "当事人身份不能为空")
    @ApiModelProperty(value = "当事人身份")
    @Pattern(regexp = RegexpConstant.PARTY_CURRENT_ROLE_REGEX, message = "当事人身份类型错误")
    private String currentRole;

    @ApiModelProperty(value = "流程筛选参数")
    private Integer currentMainNode;

    public String getCurrentRole() {
        return currentRole;
    }

    public void setCurrentRole(String currentRole) {
        this.currentRole = currentRole;
    }

    public Integer getCurrentMainNode() {
        return currentMainNode;
    }

    public void setCurrentMainNode(Integer currentMainNode) {
        this.currentMainNode = currentMainNode;
    }
}
