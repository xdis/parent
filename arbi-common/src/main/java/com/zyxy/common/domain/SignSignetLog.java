package com.zyxy.common.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
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
public class SignSignetLog implements Serializable {

    /**
     * ID sign_signet_log.ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "ID")
    private String id;
    /**
     * 签章PDF文件ID sign_signet_log.DOC_FILE_ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "签章PDF文件ID")
    private String docFileId;
    /**
     * 合同名称（这个内容在易保全后台的『合同管理』中『API签约管理』中显示） sign_signet_log.CONTRACT_NAME
     * @mbggenerated
     */
    @ApiModelProperty(value = "合同名称（这个内容在易保全后台的『合同管理』中『API签约管理』中显示）")
    private String contractName;
    /**
     * 签章等级 0: 标准图形章,1: 公章或手写 sign_signet_log.SIGN_LEVEL_CODE
     * @mbggenerated
     */
    @ApiModelProperty(value = "签章等级 0: 标准图形章,1: 公章或手写")
    private String signLevelCode;
    /**
     * 签章类型 0：手动签章,1自动签章 sign_signet_log.DEAL_TYPE_CODE
     * @mbggenerated
     */
    @ApiModelProperty(value = "签章类型 0：手动签章,1自动签章")
    private String dealTypeCode;
    /**
     * 状态：-1-签约未初始化完成、0-未签、1-已签、2-拒签、3-保全、4-失败 sign_signet_log.STATUS
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态：-1-签约未初始化完成、0-未签、1-已签、2-拒签、3-保全、4-失败")
    private Integer status;
    /**
     * 签章ID（易保全平台上是签约编号） sign_signet_log.APPLY_NO
     * @mbggenerated
     */
    @ApiModelProperty(value = "签章ID（易保全平台上是签约编号）")
    private String applyNo;
    /**
     * 备案号 sign_signet_log.RECORD_NO
     * @mbggenerated
     */
    @ApiModelProperty(value = "备案号")
    private String recordNo;
    /**
     * 创建时间 sign_signet_log.CREATE_TIME
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 更新时间 sign_signet_log.UPDATE_TIME
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    /**
     * sign_signet_log
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
     * 签章PDF文件ID
     * @return  签章PDF文件ID
     * @mbggenerated
     */
    public String getDocFileId() {
        return docFileId;
    }

    /**
     * 签章PDF文件ID
     * @param docFileId  签章PDF文件ID
     * @mbggenerated
     */
    public void setDocFileId(String docFileId) {
        this.docFileId = docFileId == null ? null : docFileId.trim();
    }

    /**
     * 合同名称（这个内容在易保全后台的『合同管理』中『API签约管理』中显示）
     * @return  合同名称（这个内容在易保全后台的『合同管理』中『API签约管理』中显示）
     * @mbggenerated
     */
    public String getContractName() {
        return contractName;
    }

    /**
     * 合同名称（这个内容在易保全后台的『合同管理』中『API签约管理』中显示）
     * @param contractName  合同名称（这个内容在易保全后台的『合同管理』中『API签约管理』中显示）
     * @mbggenerated
     */
    public void setContractName(String contractName) {
        this.contractName = contractName == null ? null : contractName.trim();
    }

    /**
     * 签章等级 0: 标准图形章,1: 公章或手写
     * @return  签章等级 0: 标准图形章,1: 公章或手写
     * @mbggenerated
     */
    public String getSignLevelCode() {
        return signLevelCode;
    }

    /**
     * 签章等级 0: 标准图形章,1: 公章或手写
     * @param signLevelCode  签章等级 0: 标准图形章,1: 公章或手写
     * @mbggenerated
     */
    public void setSignLevelCode(String signLevelCode) {
        this.signLevelCode = signLevelCode == null ? null : signLevelCode
                .trim();
    }

    /**
     * 签章类型 0：手动签章,1自动签章
     * @return  签章类型 0：手动签章,1自动签章
     * @mbggenerated
     */
    public String getDealTypeCode() {
        return dealTypeCode;
    }

    /**
     * 签章类型 0：手动签章,1自动签章
     * @param dealTypeCode  签章类型 0：手动签章,1自动签章
     * @mbggenerated
     */
    public void setDealTypeCode(String dealTypeCode) {
        this.dealTypeCode = dealTypeCode == null ? null : dealTypeCode.trim();
    }

    /**
     * 状态：-1-签约未初始化完成、0-未签、1-已签、2-拒签、3-保全、4-失败
     * @return  状态：-1-签约未初始化完成、0-未签、1-已签、2-拒签、3-保全、4-失败
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态：-1-签约未初始化完成、0-未签、1-已签、2-拒签、3-保全、4-失败
     * @param status  状态：-1-签约未初始化完成、0-未签、1-已签、2-拒签、3-保全、4-失败
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 签章ID（易保全平台上是签约编号）
     * @return  签章ID（易保全平台上是签约编号）
     * @mbggenerated
     */
    public String getApplyNo() {
        return applyNo;
    }

    /**
     * 签章ID（易保全平台上是签约编号）
     * @param applyNo  签章ID（易保全平台上是签约编号）
     * @mbggenerated
     */
    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo == null ? null : applyNo.trim();
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
}