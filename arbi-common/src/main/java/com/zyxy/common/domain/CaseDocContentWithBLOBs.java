package com.zyxy.common.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 *
 *   案件文书内容表
 *
 * case_doc_content
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="CaseDocContent")
public class CaseDocContentWithBLOBs extends CaseDocContent implements Serializable {
    /**
     * 
     *   正文
     * case_doc_content.BODY_TEXT
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "正文")
    private String bodyText;

    /**
     * 
     *   意见
     * case_doc_content.OPINION
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "意见")
    private String opinion;

    /**
     * 
     *   最终决定
     * case_doc_content.FINAL_DECISION
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "最终决定")
    private String finalDecision;

    /**
     * case_doc_content
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 正文
     * 
     * @return 正文
     *
     * @mbggenerated
     */
    public String getBodyText() {
        return bodyText;
    }

    /**
     * 正文
     * 
     * @param bodyText 正文
     *
     * @mbggenerated
     */
    public void setBodyText(String bodyText) {
        this.bodyText = bodyText == null ? null : bodyText.trim();
    }

    /**
     * 意见
     * 
     * @return 意见
     *
     * @mbggenerated
     */
    public String getOpinion() {
        return opinion;
    }

    /**
     * 意见
     * 
     * @param opinion 意见
     *
     * @mbggenerated
     */
    public void setOpinion(String opinion) {
        this.opinion = opinion == null ? null : opinion.trim();
    }

    /**
     * 最终决定
     * 
     * @return 最终决定
     *
     * @mbggenerated
     */
    public String getFinalDecision() {
        return finalDecision;
    }

    /**
     * 最终决定
     * 
     * @param finalDecision 最终决定
     *
     * @mbggenerated
     */
    public void setFinalDecision(String finalDecision) {
        this.finalDecision = finalDecision == null ? null : finalDecision.trim();
    }
}