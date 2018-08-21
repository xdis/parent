package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 *
 * living_cert
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="LivingCert")
public class LivingCert implements Serializable {
    /**
     * 
     *   编号
     * living_cert.ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "编号")
    private String id;

    /**
     * 
     *   token请求ID
     * living_cert.REQUEST_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "token请求ID")
    private String requestId;

    /**
     * living_cert.TOKEN
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String token;

    /**
     * 
     *   token请求时间
     * living_cert.EXPIRED_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "token请求时间")
    private Integer expiredTime;

    /**
     * living_cert.USER_ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String userId;

    /**
     * 
     *   失败原因
     * living_cert.FAIL_REASON
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "失败原因")
    private String failReason;

    /**
     * 
     *   0-待验证 1-验证成功 2-验证失败
     * living_cert.STATUS
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "0-待验证 1-验证成功 2-验证失败")
    private String status;

    /**
     * living_cert.CREATE_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private Date createTime;

    /**
     * living_cert
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     * 
     * @return 编号
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * 编号
     * 
     * @param id 编号
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * token请求ID
     * 
     * @return token请求ID
     *
     * @mbggenerated
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * token请求ID
     * 
     * @param requestId token请求ID
     *
     * @mbggenerated
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId == null ? null : requestId.trim();
    }

    /**
     * 
     * 
     * @return 
     *
     * @mbggenerated
     */
    public String getToken() {
        return token;
    }

    /**
     * 
     * 
     * @param token 
     *
     * @mbggenerated
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    /**
     * token请求时间
     * 
     * @return token请求时间
     *
     * @mbggenerated
     */
    public Integer getExpiredTime() {
        return expiredTime;
    }

    /**
     * token请求时间
     * 
     * @param expiredTime token请求时间
     *
     * @mbggenerated
     */
    public void setExpiredTime(Integer expiredTime) {
        this.expiredTime = expiredTime;
    }

    /**
     * 
     * 
     * @return 
     *
     * @mbggenerated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 
     * 
     * @param userId 
     *
     * @mbggenerated
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 失败原因
     * 
     * @return 失败原因
     *
     * @mbggenerated
     */
    public String getFailReason() {
        return failReason;
    }

    /**
     * 失败原因
     * 
     * @param failReason 失败原因
     *
     * @mbggenerated
     */
    public void setFailReason(String failReason) {
        this.failReason = failReason == null ? null : failReason.trim();
    }

    /**
     * 0-待验证 1-验证成功 2-验证失败
     * 
     * @return 0-待验证 1-验证成功 2-验证失败
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * 0-待验证 1-验证成功 2-验证失败
     * 
     * @param status 0-待验证 1-验证成功 2-验证失败
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 
     * 
     * @return 
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * 
     * @param createTime 
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}