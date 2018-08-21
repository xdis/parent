package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * 案件和解申请
 */
@ApiModel("案件和解申请")
public class CaseCompromiseApplyVO {

    /**
     * 申请人名称
     */
    @ApiModelProperty("申请人名称")
    private String name;

    /**
     * 申请人类型
     */
    @ApiModelProperty("申请人类型，0-申请人，1-被申请人")
    private String applyType;

    /**
     * 申请时间
     */
    @ApiModelProperty("申请时间")
    private Date time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
