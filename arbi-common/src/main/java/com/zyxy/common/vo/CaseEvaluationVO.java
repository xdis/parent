package com.zyxy.common.vo;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 评论记录VO
 */
@ApiModel("案件评论内容")
public class CaseEvaluationVO {
	/**
	 * 整体评价
	 */
	@ApiModelProperty("整体评价")
	private String overallRating;
	
	/**
	 * 列表
	 */
	@ApiModelProperty("列表")
	private PageInfo<CaseEvaluationListVO> list;

    public String getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(String overallRating) {
        this.overallRating = overallRating;
    }

    public PageInfo<CaseEvaluationListVO> getList() {
        return list;
    }

    public void setList(PageInfo<CaseEvaluationListVO> list) {
        this.list = list;
    }
}
