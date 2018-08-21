package com.zyxy.common.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 * 
 *   API-机构表
 *
 * api_orgnazation
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="ApiOrgnazation")
public class ApiOrgnazation implements Serializable {

    /**
     * ID api_orgnazation.ID
     * @mbggenerated
     */
    @ApiModelProperty(value = "ID")
    private String id;
    /**
     * 机构名称(简称) api_orgnazation.NAME
     * @mbggenerated
     */
    @ApiModelProperty(value = "机构名称(简称)")
    private String name;
    /**
     * 机构全称 api_orgnazation.REG_NAME
     * @mbggenerated
     */
    @ApiModelProperty(value = "机构全称")
    private String regName;
    /**
     * 机构网址 api_orgnazation.ORG_SITE
     * @mbggenerated
     */
    @ApiModelProperty(value = "机构网址")
    private String orgSite;
    /**
     * 机构所在国家 api_orgnazation.COUNTRY
     * @mbggenerated
     */
    @ApiModelProperty(value = "机构所在国家")
    private String country;
    /**
     * 机构所在省份 api_orgnazation.PROVINCE
     * @mbggenerated
     */
    @ApiModelProperty(value = "机构所在省份")
    private String province;
    /**
     * 机构所在城市 api_orgnazation.CITY
     * @mbggenerated
     */
    @ApiModelProperty(value = "机构所在城市")
    private String city;
    /**
     * 创建时间 api_orgnazation.CREATE_TIME
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * IP白名单：[IP1,IP2..] api_orgnazation.IP_WHITE_LIST
     * @mbggenerated
     */
    @ApiModelProperty(value = "IP白名单：[IP1,IP2..]")
    private String ipWhiteList;
    /**
     * api_orgnazation
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
     * 机构名称(简称)
     * @return  机构名称(简称)
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 机构名称(简称)
     * @param name  机构名称(简称)
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 机构全称
     * @return  机构全称
     * @mbggenerated
     */
    public String getRegName() {
        return regName;
    }

    /**
     * 机构全称
     * @param regName  机构全称
     * @mbggenerated
     */
    public void setRegName(String regName) {
        this.regName = regName == null ? null : regName.trim();
    }

    /**
     * 机构网址
     * @return  机构网址
     * @mbggenerated
     */
    public String getOrgSite() {
        return orgSite;
    }

    /**
     * 机构网址
     * @param orgSite  机构网址
     * @mbggenerated
     */
    public void setOrgSite(String orgSite) {
        this.orgSite = orgSite == null ? null : orgSite.trim();
    }

    /**
     * 机构所在国家
     * @return  机构所在国家
     * @mbggenerated
     */
    public String getCountry() {
        return country;
    }

    /**
     * 机构所在国家
     * @param country  机构所在国家
     * @mbggenerated
     */
    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    /**
     * 机构所在省份
     * @return  机构所在省份
     * @mbggenerated
     */
    public String getProvince() {
        return province;
    }

    /**
     * 机构所在省份
     * @param province  机构所在省份
     * @mbggenerated
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * 机构所在城市
     * @return  机构所在城市
     * @mbggenerated
     */
    public String getCity() {
        return city;
    }

    /**
     * 机构所在城市
     * @param city  机构所在城市
     * @mbggenerated
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
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
     * IP白名单：[IP1,IP2..]
     * @return  IP白名单：[IP1,IP2..]
     * @mbggenerated
     */
    public String getIpWhiteList() {
        return ipWhiteList;
    }

    /**
     * IP白名单：[IP1,IP2..]
     * @param ipWhiteList  IP白名单：[IP1,IP2..]
     * @mbggenerated
     */
    public void setIpWhiteList(String ipWhiteList) {
        this.ipWhiteList = ipWhiteList == null ? null : ipWhiteList.trim();
    }
}