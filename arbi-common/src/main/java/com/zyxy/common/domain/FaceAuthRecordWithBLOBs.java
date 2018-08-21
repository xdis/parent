package com.zyxy.common.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 * 
 *   face认证记录表
 *
 * face_auth_record
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="FaceAuthRecord")
public class FaceAuthRecordWithBLOBs extends FaceAuthRecord implements Serializable {
    /**
     * 
     *   回调信息
     * face_auth_record.callback_info
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "回调信息")
    private String callbackInfo;

    /**
     * 
     *   getToken接口返回信息
     * face_auth_record.get_token_api_result_info
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "getToken接口返回信息")
    private String getTokenApiResultInfo;

    /**
     * face_auth_record
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 回调信息
     * 
     * @return 回调信息
     *
     * @mbggenerated
     */
    public String getCallbackInfo() {
        return callbackInfo;
    }

    /**
     * 回调信息
     * 
     * @param callbackInfo 回调信息
     *
     * @mbggenerated
     */
    public void setCallbackInfo(String callbackInfo) {
        this.callbackInfo = callbackInfo == null ? null : callbackInfo.trim();
    }

    /**
     * getToken接口返回信息
     * 
     * @return getToken接口返回信息
     *
     * @mbggenerated
     */
    public String getGetTokenApiResultInfo() {
        return getTokenApiResultInfo;
    }

    /**
     * getToken接口返回信息
     * 
     * @param getTokenApiResultInfo getToken接口返回信息
     *
     * @mbggenerated
     */
    public void setGetTokenApiResultInfo(String getTokenApiResultInfo) {
        this.getTokenApiResultInfo = getTokenApiResultInfo == null ? null : getTokenApiResultInfo.trim();
    }
}