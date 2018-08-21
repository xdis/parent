package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

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
public class FaceAuthRecord implements Serializable {
    /**
     * 
     *   id
     * face_auth_record.id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "id")
    private String id;

    /**
     * 
     *   身份证姓名
     * face_auth_record.id_card_name
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "身份证姓名")
    private String idCardName;

    /**
     * 
     *   身份证号
     * face_auth_record.id_card_num
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "身份证号")
    private String idCardNum;

    /**
     * 
     *   用户Id
     * face_auth_record.user_id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户Id")
    private String userId;

    /**
     * 
     *   状态,0- 待验证,1- 通过,2- 不通过,3- getToken接口异常,4- token过期
     * face_auth_record.status
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态,0- 待验证,1- 通过,2- 不通过,3- getToken接口异常,4- token过期")
    private String status;

    /**
     * 
     *   活体验证token
     * face_auth_record.token
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "活体验证token")
    private String token;

    /**
     * 
     *   需达到的相识度
     * face_auth_record.similarity
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "需达到的相识度")
    private Float similarity;

    /**
     * 
     *   用户识别相识度
     * face_auth_record.similarity_result
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户识别相识度")
    private Float similarityResult;

    /**
     * 
     *   face++反查Id
     * face_auth_record.request_id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "face++反查Id")
    private String requestId;

    /**
     * 
     *   token有效时间
     * face_auth_record.token_expired_time
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "token有效时间")
    private Date tokenExpiredTime;

    /**
     * face_auth_record
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * id
     * 
     * @return id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * id
     * 
     * @param id id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 身份证姓名
     * 
     * @return 身份证姓名
     *
     * @mbggenerated
     */
    public String getIdCardName() {
        return idCardName;
    }

    /**
     * 身份证姓名
     * 
     * @param idCardName 身份证姓名
     *
     * @mbggenerated
     */
    public void setIdCardName(String idCardName) {
        this.idCardName = idCardName == null ? null : idCardName.trim();
    }

    /**
     * 身份证号
     * 
     * @return 身份证号
     *
     * @mbggenerated
     */
    public String getIdCardNum() {
        return idCardNum;
    }

    /**
     * 身份证号
     * 
     * @param idCardNum 身份证号
     *
     * @mbggenerated
     */
    public void setIdCardNum(String idCardNum) {
        this.idCardNum = idCardNum == null ? null : idCardNum.trim();
    }

    /**
     * 用户Id
     * 
     * @return 用户Id
     *
     * @mbggenerated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 用户Id
     * 
     * @param userId 用户Id
     *
     * @mbggenerated
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 状态,0- 待验证,1- 通过,2- 不通过,3- getToken接口异常,4- token过期
     * 
     * @return 状态,0- 待验证,1- 通过,2- 不通过,3- getToken接口异常,4- token过期
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态,0- 待验证,1- 通过,2- 不通过,3- getToken接口异常,4- token过期
     * 
     * @param status 状态,0- 待验证,1- 通过,2- 不通过,3- getToken接口异常,4- token过期
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 活体验证token
     * 
     * @return 活体验证token
     *
     * @mbggenerated
     */
    public String getToken() {
        return token;
    }

    /**
     * 活体验证token
     * 
     * @param token 活体验证token
     *
     * @mbggenerated
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    /**
     * 需达到的相识度
     * 
     * @return 需达到的相识度
     *
     * @mbggenerated
     */
    public Float getSimilarity() {
        return similarity;
    }

    /**
     * 需达到的相识度
     * 
     * @param similarity 需达到的相识度
     *
     * @mbggenerated
     */
    public void setSimilarity(Float similarity) {
        this.similarity = similarity;
    }

    /**
     * 用户识别相识度
     * 
     * @return 用户识别相识度
     *
     * @mbggenerated
     */
    public Float getSimilarityResult() {
        return similarityResult;
    }

    /**
     * 用户识别相识度
     * 
     * @param similarityResult 用户识别相识度
     *
     * @mbggenerated
     */
    public void setSimilarityResult(Float similarityResult) {
        this.similarityResult = similarityResult;
    }

    /**
     * face++反查Id
     * 
     * @return face++反查Id
     *
     * @mbggenerated
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * face++反查Id
     * 
     * @param requestId face++反查Id
     *
     * @mbggenerated
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId == null ? null : requestId.trim();
    }

    /**
     * token有效时间
     * 
     * @return token有效时间
     *
     * @mbggenerated
     */
    public Date getTokenExpiredTime() {
        return tokenExpiredTime;
    }

    /**
     * token有效时间
     * 
     * @param tokenExpiredTime token有效时间
     *
     * @mbggenerated
     */
    public void setTokenExpiredTime(Date tokenExpiredTime) {
        this.tokenExpiredTime = tokenExpiredTime;
    }
}