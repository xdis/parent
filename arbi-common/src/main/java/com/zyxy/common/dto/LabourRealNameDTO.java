package com.zyxy.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 人工实名审核DTO
 */
@ApiModel("人工实名审核DTO")
public class LabourRealNameDTO extends BaseDTO {

    /**
     * 手持身份证
     */
    @ApiModelProperty("手持身份证")
    private String idCard;

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
