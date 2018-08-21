package com.zyxy.common.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author tanquan
 * <p>
 * 案号序列表
 * <p>
 * case_no_seq
 * @mbggenerated do_not_delete_during_merge
 */
@ApiModel(value = "CaseNoSeq")
public class CaseNoSeq implements Serializable {
    /**
     * case_no_seq.id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String id;

    /**
     * 序号
     * case_no_seq.no
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "序号")
    private Integer no;

    /**
     * 年份
     * case_no_seq.year
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "年份")
    private String year;

    /**
     * case_no_seq
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * @return
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 序号
     *
     * @return 序号
     * @mbggenerated
     */
    public Integer getNo() {
        return no;
    }

    /**
     * 序号
     *
     * @param no 序号
     * @mbggenerated
     */
    public void setNo(Integer no) {
        this.no = no;
    }

    /**
     * 年份
     *
     * @return 年份
     * @mbggenerated
     */
    public String getYear() {
        return year;
    }

    /**
     * 年份
     *
     * @param year 年份
     * @mbggenerated
     */
    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }
}