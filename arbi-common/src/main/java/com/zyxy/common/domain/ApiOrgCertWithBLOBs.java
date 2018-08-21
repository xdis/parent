package com.zyxy.common.domain;

import java.io.Serializable;

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
public class ApiOrgCertWithBLOBs extends ApiOrgCert implements Serializable {

    /**
     * 客户端公钥 api_org_cert.CLT_PUBLIC_KEY
     * @mbggenerated
     */
    @ApiModelProperty(value = "客户端公钥")
    private byte[] cltPublicKey;
    /**
     * 客户端私钥证书 api_org_cert.CLT_PRIVATE_CERT
     * @mbggenerated
     */
    @ApiModelProperty(value = "客户端私钥证书")
    private byte[] cltPrivateCert;
    /**
     * 平台公钥 api_org_cert.PLT_PUBLIC_KEY
     * @mbggenerated
     */
    @ApiModelProperty(value = "平台公钥")
    private byte[] pltPublicKey;
    /**
     * 平台私钥证书 api_org_cert.PLT_PRIVATE_CERT
     * @mbggenerated
     */
    @ApiModelProperty(value = "平台私钥证书")
    private byte[] pltPrivateCert;
    /**
     * api_org_cert
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 客户端公钥
     * @return  客户端公钥
     * @mbggenerated
     */
    public byte[] getCltPublicKey() {
        return cltPublicKey;
    }

    /**
     * 客户端公钥
     * @param cltPublicKey  客户端公钥
     * @mbggenerated
     */
    public void setCltPublicKey(byte[] cltPublicKey) {
        this.cltPublicKey = cltPublicKey;
    }

    /**
     * 客户端私钥证书
     * @return  客户端私钥证书
     * @mbggenerated
     */
    public byte[] getCltPrivateCert() {
        return cltPrivateCert;
    }

    /**
     * 客户端私钥证书
     * @param cltPrivateCert  客户端私钥证书
     * @mbggenerated
     */
    public void setCltPrivateCert(byte[] cltPrivateCert) {
        this.cltPrivateCert = cltPrivateCert;
    }

    /**
     * 平台公钥
     * @return  平台公钥
     * @mbggenerated
     */
    public byte[] getPltPublicKey() {
        return pltPublicKey;
    }

    /**
     * 平台公钥
     * @param pltPublicKey  平台公钥
     * @mbggenerated
     */
    public void setPltPublicKey(byte[] pltPublicKey) {
        this.pltPublicKey = pltPublicKey;
    }

    /**
     * 平台私钥证书
     * @return  平台私钥证书
     * @mbggenerated
     */
    public byte[] getPltPrivateCert() {
        return pltPrivateCert;
    }

    /**
     * 平台私钥证书
     * @param pltPrivateCert  平台私钥证书
     * @mbggenerated
     */
    public void setPltPrivateCert(byte[] pltPrivateCert) {
        this.pltPrivateCert = pltPrivateCert;
    }
}