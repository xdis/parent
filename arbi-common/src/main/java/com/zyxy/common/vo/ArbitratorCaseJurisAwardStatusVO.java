package com.zyxy.common.vo;

import com.zyxy.common.domain.CaseApproveSuggest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 仲裁员案件管辖权异议决定书状态
 */
@ApiModel(value = "仲裁员案件管辖权异议决定书状态")
public class ArbitratorCaseJurisAwardStatusVO {

    /**
     * 状态
     */
    @ApiModelProperty("状态，0- 未出具管辖权异议决定书，1- 管辖权异议决定书审核中，2- 审核不通过,重新修改，3- 审核通过")
    private String status;

    /**
     * 秘书意见
     */
    @ApiModelProperty("秘书意见")
    private CaseApproveSuggest secretarySuggest;

    /**
     * 部长意见
     */
    @ApiModelProperty("部长意见")
    private CaseApproveSuggest ministerSuggest;

    /**
     * 副主任意见
     */
    @ApiModelProperty("副主任意见")
    private CaseApproveSuggest deputyDirectorSuggest;

    /**
     * 主任意见
     */
    @ApiModelProperty("主任意见")
    private CaseApproveSuggest directorSuggest;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CaseApproveSuggest getSecretarySuggest() {
        return secretarySuggest;
    }

    public void setSecretarySuggest(CaseApproveSuggest secretarySuggest) {
        this.secretarySuggest = secretarySuggest;
    }

    public CaseApproveSuggest getMinisterSuggest() {
        return ministerSuggest;
    }

    public void setMinisterSuggest(CaseApproveSuggest ministerSuggest) {
        this.ministerSuggest = ministerSuggest;
    }

    public CaseApproveSuggest getDeputyDirectorSuggest() {
        return deputyDirectorSuggest;
    }

    public void setDeputyDirectorSuggest(CaseApproveSuggest deputyDirectorSuggest) {
        this.deputyDirectorSuggest = deputyDirectorSuggest;
    }

    public CaseApproveSuggest getDirectorSuggest() {
        return directorSuggest;
    }

    public void setDirectorSuggest(CaseApproveSuggest directorSuggest) {
        this.directorSuggest = directorSuggest;
    }
}
