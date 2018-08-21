package com.zyxy.common.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
/**
 * @author tanquan
 * 
 *   签章记录表
 *
 * sign_signet_log
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="SignSignetLog")
public class SignSignetLogWithBLOBs extends SignSignetLog implements Serializable {

    /**
     * 附件文件ID集合 sign_signet_log.MET_FILE_ID_LIST
     * @mbggenerated
     */
    @ApiModelProperty(value = "附件文件ID集合")
    private String metFileIdList;
    /**
     * 签章人信息集合 sign_signet_log.SIGNATORY_LIST
     * @mbggenerated
     */
    @ApiModelProperty(value = "签章人信息集合")
    private String signatoryList;
    /**
     * sign_signet_log
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 附件文件ID集合
     * @return  附件文件ID集合
     * @mbggenerated
     */
    public String getMetFileIdList() {
        return metFileIdList;
    }

    /**
     * 附件文件ID集合
     * @param metFileIdList  附件文件ID集合
     * @mbggenerated
     */
    public void setMetFileIdList(String metFileIdList) {
        this.metFileIdList = metFileIdList == null ? null : metFileIdList
                .trim();
    }

    /**
     * 签章人信息集合
     * @return  签章人信息集合
     * @mbggenerated
     */
    public String getSignatoryList() {
        return signatoryList;
    }

    /**
     * 签章人信息集合
     * @param signatoryList  签章人信息集合
     * @mbggenerated
     */
    public void setSignatoryList(String signatoryList) {
        this.signatoryList = signatoryList == null ? null : signatoryList
                .trim();
    }
}