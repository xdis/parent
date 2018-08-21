package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 案件公共信息
 */
@ApiModel("案件公共信息")
public class CaseCommInfoVO {

    /**
     * 基本信息
     */
    @ApiModelProperty("基本信息")
    private CaseCommBaseInfoVO info;

    /**
     * 公共倒计时
     */
    @ApiModelProperty("公共倒计时")
    private CaseCommCountdownVO countdown;
    
    /**
     * 当事人在案件中的角色
     */
    @ApiModelProperty("当事人在案件中角色0申请人1本申请人3代理申请人4代理被申请人")
    private String litigantType;

    /**
     * 进度信息
     */
    @ApiModelProperty("进度信息")
    private CaseCommProgressInfoVO progress;

    public CaseCommBaseInfoVO getInfo() {
        return info;
    }

    public void setInfo(CaseCommBaseInfoVO info) {
        this.info = info;
    }

    public CaseCommProgressInfoVO getProgress() {
        return progress;
    }

    public void setProgress(CaseCommProgressInfoVO progress) {
        this.progress = progress;
    }

	public String getLitigantType() {
		return litigantType;
	}

	public void setLitigantType(String litigantType) {
		this.litigantType = litigantType;
	}

    public CaseCommCountdownVO getCountdown() {
        return countdown;
    }

    public void setCountdown(CaseCommCountdownVO countdown) {
        this.countdown = countdown;
    }
}
