package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 * 
 *   文件数据表
 *
 * sys_file
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="SysFile")
public class SysFile implements Serializable {

    /**
     * ID sys_file.ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "ID")
    private String id;
    /**
     * 文件原名 sys_file.FILE_ORIGN_NAME
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件原名")
    private String fileOrignName;
    /**
     * 文件大小 sys_file.FILE_SIZE
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件大小")
    private Long fileSize;
    /**
     * 文件后缀 sys_file.FILE_EXT
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件后缀")
    private String fileExt;
    /**
     * 保存路径 sys_file.SYS_PATH
     * @mbggenerated
     */
    @ApiModelProperty(value = "保存路径")
    private String sysPath;
    /**
     * 文件用途（common通用） sys_file.BUZZ_TYPE
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件用途（common通用）")
    private String buzzType;
    /**
     * 创建用户ID sys_file.CREATE_ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建用户ID")
    private String createId;
    /**
     * 创建时间 sys_file.CREATE_TIME
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 更新时间 sys_file.UPDATE_TIME
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    /**
     * 删除标识：0-未删除，1-已删除 sys_file.DELETED_FLAG
     * @mbggenerated
     */
    @ApiModelProperty(value = "删除标识：0-未删除，1-已删除")
    private Integer deletedFlag;
    /**
     * sys_file
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
     * 文件原名
     * @return  文件原名
     * @mbggenerated
     */
    public String getFileOrignName() {
        return fileOrignName;
    }

    /**
     * 文件原名
     * @param fileOrignName  文件原名
     * @mbggenerated
     */
    public void setFileOrignName(String fileOrignName) {
        this.fileOrignName = fileOrignName == null ? null : fileOrignName
                .trim();
    }

    /**
     * 文件大小
     * @return  文件大小
     * @mbggenerated
     */
    public Long getFileSize() {
        return fileSize;
    }

    /**
     * 文件大小
     * @param fileSize  文件大小
     * @mbggenerated
     */
    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * 文件后缀
     * @return  文件后缀
     * @mbggenerated
     */
    public String getFileExt() {
        return fileExt;
    }

    /**
     * 文件后缀
     * @param fileExt  文件后缀
     * @mbggenerated
     */
    public void setFileExt(String fileExt) {
        this.fileExt = fileExt == null ? null : fileExt.trim();
    }

    /**
     * 保存路径
     * @return  保存路径
     * @mbggenerated
     */
    public String getSysPath() {
        return sysPath;
    }

    /**
     * 保存路径
     * @param sysPath  保存路径
     * @mbggenerated
     */
    public void setSysPath(String sysPath) {
        this.sysPath = sysPath == null ? null : sysPath.trim();
    }

    /**
     * 文件用途（common通用）
     * @return  文件用途（common通用）
     * @mbggenerated
     */
    public String getBuzzType() {
        return buzzType;
    }

    /**
     * 文件用途（common通用）
     * @param buzzType  文件用途（common通用）
     * @mbggenerated
     */
    public void setBuzzType(String buzzType) {
        this.buzzType = buzzType == null ? null : buzzType.trim();
    }

    /**
     * 创建用户ID
     * @return  创建用户ID
     * @mbggenerated
     */
    public String getCreateId() {
        return createId;
    }

    /**
     * 创建用户ID
     * @param createId  创建用户ID
     * @mbggenerated
     */
    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
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
     * 删除标识：0-未删除，1-已删除
     * @return  删除标识：0-未删除，1-已删除
     * @mbggenerated
     */
    public Integer getDeletedFlag() {
        return deletedFlag;
    }

    /**
     * 删除标识：0-未删除，1-已删除
     * @param deletedFlag  删除标识：0-未删除，1-已删除
     * @mbggenerated
     */
    public void setDeletedFlag(Integer deletedFlag) {
        this.deletedFlag = deletedFlag;
    }
}