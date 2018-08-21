package com.zyxy.common.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 * 
 *   系统配置数据字典表
 *
 * sys_data_dic
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="SysDataDic")
public class SysDataDicKey implements Serializable {

    /**
     * 字典key sys_data_dic.DIC_KEY
     * @mbggenerated
     */
    @ApiModelProperty(value = "字典key")
    private String dicKey;
    /**
     * 字典key对应的分组 sys_data_dic.DIC_GROUP
     * @mbggenerated
     */
    @ApiModelProperty(value = "字典key对应的分组")
    private String dicGroup;
    /**
     * sys_data_dic
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * 字典key
     * @return  字典key
     * @mbggenerated
     */
    public String getDicKey() {
        return dicKey;
    }

    /**
     * 字典key
     * @param dicKey  字典key
     * @mbggenerated
     */
    public void setDicKey(String dicKey) {
        this.dicKey = dicKey == null ? null : dicKey.trim();
    }

    /**
     * 字典key对应的分组
     * @return  字典key对应的分组
     * @mbggenerated
     */
    public String getDicGroup() {
        return dicGroup;
    }

    /**
     * 字典key对应的分组
     * @param dicGroup  字典key对应的分组
     * @mbggenerated
     */
    public void setDicGroup(String dicGroup) {
        this.dicGroup = dicGroup == null ? null : dicGroup.trim();
    }

    public SysDataDicKey() {}
    
    /**
     * 
     * @param dicGroup 分组
     * @param dicKey 分组key
     */
    public SysDataDicKey(String dicGroup, String dicKey) {
        this.dicGroup = dicGroup;
        this.dicKey = dicKey;
    }
    
    @Override
    public String toString() {
        return this.dicGroup + this.dicKey;
    };
    
    /***** 缴费通知书-收费项目 *****/
    /***** 缴费通知书-其他 *****/
    /**
     * 缴费通知书-区域编码
     */
    public final static SysDataDicKey PAY_REGION_CODE_KEY = new SysDataDicKey("PAY", "REGION_CODE");
    /**
     * 缴费通知书-区域邮政编码
     */
    public final static SysDataDicKey PAY_REGION_ZIP_CODE_KEY = new SysDataDicKey("PAY", "REGION_ZIP_CODE");
    
    /***** 全局变量 *****/
    /**
     * 全局密钥变量
     */
    public final static SysDataDicKey GLOBAL_SECRET_KEY = new SysDataDicKey("SYSTEM", "GLOBAL_SECRET");
    
    
}