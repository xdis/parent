package com.zyxy.common.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author tanquan
 *
 * case_classify
 *
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value ="CaseClassify")
public class CaseClassify implements Serializable {
    /**
     * 
     *   编号
     * case_classify.ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "编号")
    private Integer id;

    /**
     * 
     *   类型名
     * case_classify.TYPE_NAME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "类型名")
    private String typeName;

    /**
     * 
     *   案件类型 0-个人，1-企业
     * case_classify.CASE_TYPE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "案件类型 0-个人，1-企业")
    private String caseType;

    /**
     * 
     *   备注
     * case_classify.REMARK
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * case_classify
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
    public Integer getId() {
        return id;
    }

    /**
     * 编号
     * 
     * @param id 编号
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 类型名
     * 
     * @return 类型名
     *
     * @mbggenerated
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * 类型名
     * 
     * @param typeName 类型名
     *
     * @mbggenerated
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    /**
     * 案件类型 0-个人，1-企业
     * 
     * @return 案件类型 0-个人，1-企业
     *
     * @mbggenerated
     */
    public String getCaseType() {
        return caseType;
    }

    /**
     * 案件类型 0-个人，1-企业
     * 
     * @param caseType 案件类型 0-个人，1-企业
     *
     * @mbggenerated
     */
    public void setCaseType(String caseType) {
        this.caseType = caseType == null ? null : caseType.trim();
    }

    /**
     * 备注
     * 
     * @return 备注
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * 
     * @param remark 备注
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}