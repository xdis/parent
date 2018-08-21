package com.zyxy.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 切换角色接口
 */
@ApiModel("切换角色接口")
public class ChangeRoleDTO extends BaseDTO {

    /**
     * role 0-申请人,1-被申请人,2-代理人
     */
    @ApiModelProperty("role")
    @NotNull
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
