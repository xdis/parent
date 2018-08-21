package com.zyxy.common.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author tanquan
 * <p>
 * 案件裁决书草稿
 * <p>
 * case_arbitral_awards_draft
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value = "CaseArbitralAwardsDraft")
public class CaseArbitralAwardsDraftWithBLOBs extends CaseArbitralAwardsDraft implements Serializable {
    /**
     * 正文
     * case_arbitral_awards_draft.CONTENT
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "正文")
    private String content;

    /**
     * 仲裁委意见
     * case_arbitral_awards_draft.ARBITRATION_SUGGEST
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "仲裁委意见")
    private String arbitrationSuggest;

    /**
     * 裁决内容
     * case_arbitral_awards_draft.ARBITRATOR_CONTENT
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "裁决内容")
    private String arbitratorContent;

    /**
     * case_arbitral_awards_draft
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 正文
     *
     * @return 正文
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * 正文
     *
     * @param content 正文
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 仲裁委意见
     *
     * @return 仲裁委意见
     * @mbggenerated
     */
    public String getArbitrationSuggest() {
        return arbitrationSuggest;
    }

    /**
     * 仲裁委意见
     *
     * @param arbitrationSuggest 仲裁委意见
     * @mbggenerated
     */
    public void setArbitrationSuggest(String arbitrationSuggest) {
        this.arbitrationSuggest = arbitrationSuggest == null ? null : arbitrationSuggest.trim();
    }

    /**
     * 裁决内容
     *
     * @return 裁决内容
     * @mbggenerated
     */
    public String getArbitratorContent() {
        return arbitratorContent;
    }

    /**
     * 裁决内容
     *
     * @param arbitratorContent 裁决内容
     * @mbggenerated
     */
    public void setArbitratorContent(String arbitratorContent) {
        this.arbitratorContent = arbitratorContent == null ? null : arbitratorContent.trim();
    }
}