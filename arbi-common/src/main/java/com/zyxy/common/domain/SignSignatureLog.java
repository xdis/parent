package com.zyxy.common.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
/**
 * @author tanquan
 * 
 *   签名记录表
 *
 * sign_signature_log
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="SignSignatureLog")
public class SignSignatureLog implements Serializable {

    /**
     * ID sign_signature_log.ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "ID")
    private String id;
    /**
     * 签名文件ID sign_signature_log.FILE_ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "签名文件ID")
    private String fileId;
    /**
     * 标题，易保全后台显示 sign_signature_log.PRESERVATION_TITLE
     * @mbggenerated
     */
    @ApiModelProperty(value = "标题，易保全后台显示")
    private String preservationTitle;
    /**
     * 用户ID sign_signature_log.SOURCE_REGISTRY_ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户ID")
    private String sourceRegistryId;
    /**
     * 状态：-1-签约未初始化完成，1-签名成功，2-签名失败 sign_signature_log.STATUS
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态：-1-签约未初始化完成，1-签名成功，2-签名失败")
    private Integer status;
    /**
     * 签名ID（易保全平台上是保全ID） sign_signature_log.PRESERVATION_ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "签名ID（易保全平台上是保全ID）")
    private String preservationId;
    /**
     * 备案号 sign_signature_log.RECORD_NO
     * @mbggenerated
     */
    @ApiModelProperty(value = "备案号")
    private String recordNo;
    /**
     * 创建时间 sign_signature_log.CREATE_TIME
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 更新时间 sign_signature_log.UPDATE_TIME
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    /**
     * 签名用户信息，SignatoryDTO类的JSON格式数据 sign_signature_log.SIGNATORY
     * @mbggenerated
     */
    @ApiModelProperty(value = "签名用户信息，SignatoryDTO类的JSON格式数据")
    private String signatory;
    /**
     * sign_signature_log
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * ID
     * @return  ID
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * ID
     * @param id  ID
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 签名文件ID
     * @return  签名文件ID
     * @mbggenerated
     */
    public String getFileId() {
        return fileId;
    }

    /**
     * 签名文件ID
     * @param fileId  签名文件ID
     * @mbggenerated
     */
    public void setFileId(String fileId) {
        this.fileId = fileId == null ? null : fileId.trim();
    }

    /**
     * 标题，易保全后台显示
     * @return  标题，易保全后台显示
     * @mbggenerated
     */
    public String getPreservationTitle() {
        return preservationTitle;
    }

    /**
     * 标题，易保全后台显示
     * @param preservationTitle  标题，易保全后台显示
     * @mbggenerated
     */
    public void setPreservationTitle(String preservationTitle) {
        this.preservationTitle = preservationTitle == null ? null
                : preservationTitle.trim();
    }

    /**
     * 用户ID
     * @return  用户ID
     * @mbggenerated
     */
    public String getSourceRegistryId() {
        return sourceRegistryId;
    }

    /**
     * 用户ID
     * @param sourceRegistryId  用户ID
     * @mbggenerated
     */
    public void setSourceRegistryId(String sourceRegistryId) {
        this.sourceRegistryId = sourceRegistryId == null ? null
                : sourceRegistryId.trim();
    }

    /**
     * 状态：-1-签约未初始化完成，1-签名成功，2-签名失败
     * @return  状态：-1-签约未初始化完成，1-签名成功，2-签名失败
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态：-1-签约未初始化完成，1-签名成功，2-签名失败
     * @param status  状态：-1-签约未初始化完成，1-签名成功，2-签名失败
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 签名ID（易保全平台上是保全ID）
     * @return  签名ID（易保全平台上是保全ID）
     * @mbggenerated
     */
    public String getPreservationId() {
        return preservationId;
    }

    /**
     * 签名ID（易保全平台上是保全ID）
     * @param preservationId  签名ID（易保全平台上是保全ID）
     * @mbggenerated
     */
    public void setPreservationId(String preservationId) {
        this.preservationId = preservationId == null ? null : preservationId
                .trim();
    }

    /**
     * 备案号
     * @return  备案号
     * @mbggenerated
     */
    public String getRecordNo() {
        return recordNo;
    }

    /**
     * 备案号
     * @param recordNo  备案号
     * @mbggenerated
     */
    public void setRecordNo(String recordNo) {
        this.recordNo = recordNo == null ? null : recordNo.trim();
    }

    /**
     * 创建时间
     * @return  创建时间
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime  创建时间
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     * @return  更新时间
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     * @param updateTime  更新时间
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 签名用户信息，SignatoryDTO类的JSON格式数据
     * @return  签名用户信息，SignatoryDTO类的JSON格式数据
     * @mbggenerated
     */
    public String getSignatory() {
        return signatory;
    }

    /**
     * 签名用户信息，SignatoryDTO类的JSON格式数据
     * @param signatory  签名用户信息，SignatoryDTO类的JSON格式数据
     * @mbggenerated
     */
    public void setSignatory(String signatory) {
        this.signatory = signatory == null ? null : signatory.trim();
    }
}