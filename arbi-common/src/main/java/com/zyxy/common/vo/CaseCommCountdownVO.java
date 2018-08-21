package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 案件公共倒计时信息
 */
@ApiModel("案件公共倒计时信息")
public class CaseCommCountdownVO {

    /**
     * 审限期倒计时
     */
    @ApiModelProperty("审限期倒计时")
    private Long processing;

    /**
     * 和解期倒计时
     */
    @ApiModelProperty("和解期倒计时")
    private Long compromise;

    public void setProcessing(Long processing) {
        this.processing = processing;
    }

    public void setCompromise(Long compromise) {
        this.compromise = compromise;
    }

    public Long getProcessing() {
        return processing;
    }

    public Long getCompromise() {
        return compromise;
    }
}
