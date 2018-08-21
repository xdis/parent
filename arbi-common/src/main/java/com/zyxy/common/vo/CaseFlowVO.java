package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 案件流程信息
 */
@ApiModel("案件流程信息")
public class CaseFlowVO {

    /**
     * 立案状态标志
     */
    @ApiModelProperty("立案状态标志")
    private Boolean regStatus;

    /**
     * 立案时间
     */
    @ApiModelProperty("立案时间")
    private Date regDate;

    /**
     * 立案下方展示内容
     */
    @ApiModelProperty("立案下方展示内容")
    private String regContent;

    /**
     * 答辩状态标志
     */
    @ApiModelProperty("答辩状态标志")
    private Boolean replyStatus;

    /**
     * 答辩时间
     */
    @ApiModelProperty("答辩时间")
    private Date replyDate;

    /**
     * 答辩下方展示内容
     */
    @ApiModelProperty("答辩下方展示内容")
    private String replyContent;

    /**
     * 组庭状态标志
     */
    @ApiModelProperty("组庭状态标志")
    private Boolean organizeStatus;

    /**
     * 组庭时间
     */
    @ApiModelProperty("组庭时间")
    private Date organizeDate;

    /**
     * 组庭下方展示内容
     */
    @ApiModelProperty("组庭下方展示内容")
    private String organizeContent;

    /**
     * 裁决状态标志
     */
    @ApiModelProperty("裁决状态标志")
    private Boolean arbiStatus;

    /**
     * 裁决时间
     */
    @ApiModelProperty("裁决时间")
    private Date arbiDate;

    /**
     * 裁决下方展示内容
     */
    @ApiModelProperty("裁决下方展示内容")
    private String arbiContent;

    /**
     * 结案状态标志
     */
    @ApiModelProperty("结案状态标志")
    private Boolean overStatus;

    /**
     * 结案时间
     */
    @ApiModelProperty("结案时间")
    private Date overDate;

    /**
     * 结案下方展示内容
     */
    @ApiModelProperty("结案下方展示内容")
    private String overContent;

    /**
     * 补正状态标志
     */
    @ApiModelProperty("补正状态标志")
    private Boolean offsetStatus;

    /**
     * 补正时间
     */
    @ApiModelProperty("补正时间")
    private Date offsetDate;

    /**
     * 补正下方展示内容
     */
    @ApiModelProperty("补正下方展示内容")
    private String offsetContent;

    public Boolean getRegStatus() {
        return regStatus;
    }

    public void setRegStatus(Boolean regStatus) {
        this.regStatus = regStatus;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getRegContent() {
        return regContent;
    }

    public void setRegContent(String regContent) {
        this.regContent = regContent;
    }

    public Boolean getReplyStatus() {
        return replyStatus;
    }

    public void setReplyStatus(Boolean replyStatus) {
        this.replyStatus = replyStatus;
    }

    public Date getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(Date replyDate) {
        this.replyDate = replyDate;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Boolean getOrganizeStatus() {
        return organizeStatus;
    }

    public void setOrganizeStatus(Boolean organizeStatus) {
        this.organizeStatus = organizeStatus;
    }

    public Date getOrganizeDate() {
        return organizeDate;
    }

    public void setOrganizeDate(Date organizeDate) {
        this.organizeDate = organizeDate;
    }

    public String getOrganizeContent() {
        return organizeContent;
    }

    public void setOrganizeContent(String organizeContent) {
        this.organizeContent = organizeContent;
    }

    public Boolean getArbiStatus() {
        return arbiStatus;
    }

    public void setArbiStatus(Boolean arbiStatus) {
        this.arbiStatus = arbiStatus;
    }

    public Date getArbiDate() {
        return arbiDate;
    }

    public void setArbiDate(Date arbiDate) {
        this.arbiDate = arbiDate;
    }

    public String getArbiContent() {
        return arbiContent;
    }

    public void setArbiContent(String arbiContent) {
        this.arbiContent = arbiContent;
    }

    public Boolean getOverStatus() {
        return overStatus;
    }

    public void setOverStatus(Boolean overStatus) {
        this.overStatus = overStatus;
    }

    public Date getOverDate() {
        return overDate;
    }

    public void setOverDate(Date overDate) {
        this.overDate = overDate;
    }

    public String getOverContent() {
        return overContent;
    }

    public void setOverContent(String overContent) {
        this.overContent = overContent;
    }

    public Boolean getOffsetStatus() {
        return offsetStatus;
    }

    public void setOffsetStatus(Boolean offsetStatus) {
        this.offsetStatus = offsetStatus;
    }

    public Date getOffsetDate() {
        return offsetDate;
    }

    public void setOffsetDate(Date offsetDate) {
        this.offsetDate = offsetDate;
    }

    public String getOffsetContent() {
        return offsetContent;
    }

    public void setOffsetContent(String offsetContent) {
        this.offsetContent = offsetContent;
    }
}
