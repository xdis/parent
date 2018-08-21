package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 案件公共流程信息
 */
@ApiModel("案件公共流程信息")
public class CaseCommProgressInfoVO {

    /**
     * 当前进度,1-立案,2-答辩,3-审理,4-裁决,5-结案,6-补正
     */
    @ApiModelProperty("当前进度,1-立案,2-答辩,3-审理,4-裁决,5-结案,6-补正")
    private String currentProgress;

    /**
     * 立案时间
     */
    @ApiModelProperty("立案时间,yyyy-MM-dd")
    private String registerCaseDate;

    /**
     * 答辩开始时间
     */
    @ApiModelProperty("答辩开始时间,yyyy-MM-dd")
    private String replyDate;

    /**
     * 审理开始时间
     */
    @ApiModelProperty("审理开始时间,yyyy-MM-dd")
    private String trialDate;

    /**
     * 裁决开始时间
     */
    @ApiModelProperty("裁决开始时间,yyyy-MM-dd")
    private String arbitratorDate;

    /**
     * 结案时间
     */
    @ApiModelProperty("结案时间,yyyy-MM-dd")
    private String completeDate;

    /**
     * 补正开始时间
     */
    @ApiModelProperty("补正开始时间,yyyy-MM-dd")
    private String offsetDate;

    public String getCurrentProgress() {
        return currentProgress;
    }

    public void setCurrentProgress(String currentProgress) {
        this.currentProgress = currentProgress;
    }

    public String getRegisterCaseDate() {
        return registerCaseDate;
    }

    public void setRegisterCaseDate(String registerCaseDate) {
        this.registerCaseDate = registerCaseDate;
    }

    public String getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(String replyDate) {
        this.replyDate = replyDate;
    }

    public String getTrialDate() {
        return trialDate;
    }

    public void setTrialDate(String trialDate) {
        this.trialDate = trialDate;
    }

    public String getArbitratorDate() {
        return arbitratorDate;
    }

    public void setArbitratorDate(String arbitratorDate) {
        this.arbitratorDate = arbitratorDate;
    }

    public String getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(String completeDate) {
        this.completeDate = completeDate;
    }

    public String getOffsetDate() {
        return offsetDate;
    }

    public void setOffsetDate(String offsetDate) {
        this.offsetDate = offsetDate;
    }
}
