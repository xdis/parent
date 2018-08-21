package com.zyxy.common.domain;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

public class CaseMatWithBLOBs extends CaseMat implements Serializable {

    /**
     * 附件内容 case_mat.ATTACH_CONTENT
     * @mbggenerated
     */
    @ApiModelProperty(value = "附件内容")
    private String attachContent;
    /**
     * 质证 case_mat.OPPUGN_EVIDENCE
     * @mbggenerated
     */
    @ApiModelProperty(value = "质证")
    private String oppugnEvidence;
    /**
     * case_mat
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 附件内容
     * @return  附件内容
     * @mbggenerated
     */
    public String getAttachContent() {
        return attachContent;
    }

    /**
     * 附件内容
     * @param attachContent  附件内容
     * @mbggenerated
     */
    public void setAttachContent(String attachContent) {
        this.attachContent = attachContent == null ? null : attachContent
                .trim();
    }

    /**
     * 质证
     * @return  质证
     * @mbggenerated
     */
    public String getOppugnEvidence() {
        return oppugnEvidence;
    }

    /**
     * 质证
     * @param oppugnEvidence  质证
     * @mbggenerated
     */
    public void setOppugnEvidence(String oppugnEvidence) {
        this.oppugnEvidence = oppugnEvidence == null ? null : oppugnEvidence
                .trim();
    }
}