package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 * 
 *   API-机构证书表
 *
 * api_org_cert
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="ApiOrgCert")
public class ApiOrgCert implements Serializable {

    /**
     * ID api_org_cert.ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "ID")
    private String id;
    /**
     * 机构ID api_org_cert.ORG_ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "机构ID")
    private String orgId;
    /**
     * 版本号 api_org_cert.VERSION
     * @mbggenerated
     */
    @ApiModelProperty(value = "版本号")
    private Integer version;
    /**
     * 客户端私钥密钥 api_org_cert.CLT_PRIVATE_KEY_PASS
     * @mbggenerated
     */
    @ApiModelProperty(value = "客户端私钥密钥")
    private String cltPrivateKeyPass;
    /**
     * 客户端私钥库密钥 api_org_cert.CLT_PRIVATE_KEY_STORE_PASS
     * @mbggenerated
     */
    @ApiModelProperty(value = "客户端私钥库密钥")
    private String cltPrivateKeyStorePass;
    /**
     * 客户端公钥文件名 api_org_cert.CLT_PUBLIC_KEY_NAME
     * @mbggenerated
     */
    @ApiModelProperty(value = "客户端公钥文件名")
    private String cltPublicKeyName;
    /**
     * 客户端私钥库文件名 api_org_cert.CLT_PRIVATE_CERT_NAME
     * @mbggenerated
     */
    @ApiModelProperty(value = "客户端私钥库文件名")
    private String cltPrivateCertName;
    /**
     * 平台私钥密钥 api_org_cert.PLT_PRIVATE_KEY_PASS
     * @mbggenerated
     */
    @ApiModelProperty(value = "平台私钥密钥")
    private String pltPrivateKeyPass;
    /**
     * 平台私钥库密钥 api_org_cert.PLT_PRIVATE_KEY_STORE_PASS
     * @mbggenerated
     */
    @ApiModelProperty(value = "平台私钥库密钥")
    private String pltPrivateKeyStorePass;
    /**
     * 平台公钥文件名 api_org_cert.PLT_PUBLIC_KEY_NAME
     * @mbggenerated
     */
    @ApiModelProperty(value = "平台公钥文件名")
    private String pltPublicKeyName;
    /**
     * 平台私钥库文件名 api_org_cert.PLT_PRIVATE_CERT_NAME
     * @mbggenerated
     */
    @ApiModelProperty(value = "平台私钥库文件名")
    private String pltPrivateCertName;
    /**
     * 状态：0-初始，1-正常（使用中），2-失效（过期） api_org_cert.STATUS
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态：0-初始，1-正常（使用中），2-失效（过期）")
    private Integer status;
    /**
     * 创建时间 api_org_cert.CREATE_TIME
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * api_org_cert
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
     * 机构ID
     * @return  机构ID
     * @mbggenerated
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * 机构ID
     * @param orgId  机构ID
     * @mbggenerated
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    /**
     * 版本号
     * @return  版本号
     * @mbggenerated
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 版本号
     * @param version  版本号
     * @mbggenerated
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 客户端私钥密钥
     * @return  客户端私钥密钥
     * @mbggenerated
     */
    public String getCltPrivateKeyPass() {
        return cltPrivateKeyPass;
    }

    /**
     * 客户端私钥密钥
     * @param cltPrivateKeyPass  客户端私钥密钥
     * @mbggenerated
     */
    public void setCltPrivateKeyPass(String cltPrivateKeyPass) {
        this.cltPrivateKeyPass = cltPrivateKeyPass == null ? null
                : cltPrivateKeyPass.trim();
    }

    /**
     * 客户端私钥库密钥
     * @return  客户端私钥库密钥
     * @mbggenerated
     */
    public String getCltPrivateKeyStorePass() {
        return cltPrivateKeyStorePass;
    }

    /**
     * 客户端私钥库密钥
     * @param cltPrivateKeyStorePass  客户端私钥库密钥
     * @mbggenerated
     */
    public void setCltPrivateKeyStorePass(String cltPrivateKeyStorePass) {
        this.cltPrivateKeyStorePass = cltPrivateKeyStorePass == null ? null
                : cltPrivateKeyStorePass.trim();
    }

    /**
     * 客户端公钥文件名
     * @return  客户端公钥文件名
     * @mbggenerated
     */
    public String getCltPublicKeyName() {
        return cltPublicKeyName;
    }

    /**
     * 客户端公钥文件名
     * @param cltPublicKeyName  客户端公钥文件名
     * @mbggenerated
     */
    public void setCltPublicKeyName(String cltPublicKeyName) {
        this.cltPublicKeyName = cltPublicKeyName == null ? null
                : cltPublicKeyName.trim();
    }

    /**
     * 客户端私钥库文件名
     * @return  客户端私钥库文件名
     * @mbggenerated
     */
    public String getCltPrivateCertName() {
        return cltPrivateCertName;
    }

    /**
     * 客户端私钥库文件名
     * @param cltPrivateCertName  客户端私钥库文件名
     * @mbggenerated
     */
    public void setCltPrivateCertName(String cltPrivateCertName) {
        this.cltPrivateCertName = cltPrivateCertName == null ? null
                : cltPrivateCertName.trim();
    }

    /**
     * 平台私钥密钥
     * @return  平台私钥密钥
     * @mbggenerated
     */
    public String getPltPrivateKeyPass() {
        return pltPrivateKeyPass;
    }

    /**
     * 平台私钥密钥
     * @param pltPrivateKeyPass  平台私钥密钥
     * @mbggenerated
     */
    public void setPltPrivateKeyPass(String pltPrivateKeyPass) {
        this.pltPrivateKeyPass = pltPrivateKeyPass == null ? null
                : pltPrivateKeyPass.trim();
    }

    /**
     * 平台私钥库密钥
     * @return  平台私钥库密钥
     * @mbggenerated
     */
    public String getPltPrivateKeyStorePass() {
        return pltPrivateKeyStorePass;
    }

    /**
     * 平台私钥库密钥
     * @param pltPrivateKeyStorePass  平台私钥库密钥
     * @mbggenerated
     */
    public void setPltPrivateKeyStorePass(String pltPrivateKeyStorePass) {
        this.pltPrivateKeyStorePass = pltPrivateKeyStorePass == null ? null
                : pltPrivateKeyStorePass.trim();
    }

    /**
     * 平台公钥文件名
     * @return  平台公钥文件名
     * @mbggenerated
     */
    public String getPltPublicKeyName() {
        return pltPublicKeyName;
    }

    /**
     * 平台公钥文件名
     * @param pltPublicKeyName  平台公钥文件名
     * @mbggenerated
     */
    public void setPltPublicKeyName(String pltPublicKeyName) {
        this.pltPublicKeyName = pltPublicKeyName == null ? null
                : pltPublicKeyName.trim();
    }

    /**
     * 平台私钥库文件名
     * @return  平台私钥库文件名
     * @mbggenerated
     */
    public String getPltPrivateCertName() {
        return pltPrivateCertName;
    }

    /**
     * 平台私钥库文件名
     * @param pltPrivateCertName  平台私钥库文件名
     * @mbggenerated
     */
    public void setPltPrivateCertName(String pltPrivateCertName) {
        this.pltPrivateCertName = pltPrivateCertName == null ? null
                : pltPrivateCertName.trim();
    }

    /**
     * 状态：0-初始，1-正常（使用中），2-失效（过期）
     * @return  状态：0-初始，1-正常（使用中），2-失效（过期）
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态：0-初始，1-正常（使用中），2-失效（过期）
     * @param status  状态：0-初始，1-正常（使用中），2-失效（过期）
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
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
}