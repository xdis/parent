package com.zyxy.common.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 *
 * sms_record
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="SmsRecord")
public class SmsRecordWithBLOBs extends SmsRecord implements Serializable {

    /**
     * 短信模板内容 sms_record.TPL_CNT
     * @mbggenerated
     */
    @ApiModelProperty(value = "短信模板内容")
    private String tplCnt;
    /**
     * 短信模板参数 sms_record.TPL_PARAMS
     * @mbggenerated
     */
    @ApiModelProperty(value = "短信模板参数")
    private String tplParams;
    /**
     * sms_record
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 短信模板内容
     * @return  短信模板内容
     * @mbggenerated
     */
    public String getTplCnt() {
        return tplCnt;
    }

    /**
     * 短信模板内容
     * @param tplCnt  短信模板内容
     * @mbggenerated
     */
    public void setTplCnt(String tplCnt) {
        this.tplCnt = tplCnt == null ? null : tplCnt.trim();
    }

    /**
     * 短信模板参数
     * @return  短信模板参数
     * @mbggenerated
     */
    public String getTplParams() {
        return tplParams;
    }

    /**
     * 短信模板参数
     * @param tplParams  短信模板参数
     * @mbggenerated
     */
    public void setTplParams(String tplParams) {
        this.tplParams = tplParams == null ? null : tplParams.trim();
    }
}