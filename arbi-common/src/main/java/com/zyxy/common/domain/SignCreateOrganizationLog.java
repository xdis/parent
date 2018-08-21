package com.zyxy.common.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
/**
 * @author tanquan
 * 
 *   企业信息认证表
 *
 * sign_create_organization_log
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="SignCreateOrganizationLog")
public class SignCreateOrganizationLog implements Serializable {
    /**
     * 
     *   ID
     * sign_create_organization_log.ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "ID")
    private String id;

    /**
     * 
     *   公司名称
     * sign_create_organization_log.NAME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "公司名称")
    private String name;

    /**
     * 
     *   邮箱
     * sign_create_organization_log.EMAIL
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "邮箱")
    private String email;

    /**
     * 
     *   公司类型，0-企业，1-事业单位
     * sign_create_organization_log.ORGANIZATION_TYPE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "公司类型，0-企业，1-事业单位")
    private Integer organizationType;

    /**
     * 
     *   证件类型：0-传统多证，1-三证合一
     * sign_create_organization_log.IDENTIFICATION_TYPE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "证件类型：0-传统多证，1-三证合一")
    private Integer identificationType;

    /**
     * 
     *   统一社会信用代码
     * sign_create_organization_log.ORGANIZATION_REG_NO
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "统一社会信用代码")
    private String organizationRegNo;

    /**
     * 
     *   彩色三证合一营业执照ID
     * sign_create_organization_log.ORGANIZATION_REG_IMG
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "彩色三证合一营业执照ID")
    private String organizationRegImg;

    /**
     * 
     *   君子签企业服务授权书扫描件ID
     * sign_create_organization_log.SIGN_APPLICATION
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "君子签企业服务授权书扫描件ID")
    private String signApplication;

    /**
     * 
     *   状态：-1-上传认证初始化，1-认证成功，2-认证失败
     * sign_create_organization_log.STATUS
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态：-1-上传认证初始化，1-认证成功，2-认证失败")
    private Integer status;

    /**
     * 
     *   创建时间
     * sign_create_organization_log.CREATE_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 
     *   更新时间
     * sign_create_organization_log.UPDATE_TIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
     * 
     *   失败返回原因
     * sign_create_organization_log.ERROR_INFO
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "失败返回原因")
    private String errorInfo;

    /**
     * sign_create_organization_log
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * ID
     * 
     * @return ID
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * ID
     * 
     * @param id ID
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 公司名称
     * 
     * @return 公司名称
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 公司名称
     * 
     * @param name 公司名称
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 邮箱
     * 
     * @return 邮箱
     *
     * @mbggenerated
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     * 
     * @param email 邮箱
     *
     * @mbggenerated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 公司类型，0-企业，1-事业单位
     * 
     * @return 公司类型，0-企业，1-事业单位
     *
     * @mbggenerated
     */
    public Integer getOrganizationType() {
        return organizationType;
    }

    /**
     * 公司类型，0-企业，1-事业单位
     * 
     * @param organizationType 公司类型，0-企业，1-事业单位
     *
     * @mbggenerated
     */
    public void setOrganizationType(Integer organizationType) {
        this.organizationType = organizationType;
    }

    /**
     * 证件类型：0-传统多证，1-三证合一
     * 
     * @return 证件类型：0-传统多证，1-三证合一
     *
     * @mbggenerated
     */
    public Integer getIdentificationType() {
        return identificationType;
    }

    /**
     * 证件类型：0-传统多证，1-三证合一
     * 
     * @param identificationType 证件类型：0-传统多证，1-三证合一
     *
     * @mbggenerated
     */
    public void setIdentificationType(Integer identificationType) {
        this.identificationType = identificationType;
    }

    /**
     * 统一社会信用代码
     * 
     * @return 统一社会信用代码
     *
     * @mbggenerated
     */
    public String getOrganizationRegNo() {
        return organizationRegNo;
    }

    /**
     * 统一社会信用代码
     * 
     * @param organizationRegNo 统一社会信用代码
     *
     * @mbggenerated
     */
    public void setOrganizationRegNo(String organizationRegNo) {
        this.organizationRegNo = organizationRegNo == null ? null : organizationRegNo.trim();
    }

    /**
     * 彩色三证合一营业执照ID
     * 
     * @return 彩色三证合一营业执照ID
     *
     * @mbggenerated
     */
    public String getOrganizationRegImg() {
        return organizationRegImg;
    }

    /**
     * 彩色三证合一营业执照ID
     * 
     * @param organizationRegImg 彩色三证合一营业执照ID
     *
     * @mbggenerated
     */
    public void setOrganizationRegImg(String organizationRegImg) {
        this.organizationRegImg = organizationRegImg == null ? null : organizationRegImg.trim();
    }

    /**
     * 君子签企业服务授权书扫描件ID
     * 
     * @return 君子签企业服务授权书扫描件ID
     *
     * @mbggenerated
     */
    public String getSignApplication() {
        return signApplication;
    }

    /**
     * 君子签企业服务授权书扫描件ID
     * 
     * @param signApplication 君子签企业服务授权书扫描件ID
     *
     * @mbggenerated
     */
    public void setSignApplication(String signApplication) {
        this.signApplication = signApplication == null ? null : signApplication.trim();
    }

    /**
     * 状态：-1-上传认证初始化，1-认证成功，2-认证失败
     * 
     * @return 状态：-1-上传认证初始化，1-认证成功，2-认证失败
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态：-1-上传认证初始化，1-认证成功，2-认证失败
     * 
     * @param status 状态：-1-上传认证初始化，1-认证成功，2-认证失败
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 创建时间
     * 
     * @return 创建时间
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * 
     * @param createTime 创建时间
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     * 
     * @return 更新时间
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     * 
     * @param updateTime 更新时间
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 失败返回原因
     * 
     * @return 失败返回原因
     *
     * @mbggenerated
     */
    public String getErrorInfo() {
        return errorInfo;
    }

    /**
     * 失败返回原因
     * 
     * @param errorInfo 失败返回原因
     *
     * @mbggenerated
     */
    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo == null ? null : errorInfo.trim();
    }
}