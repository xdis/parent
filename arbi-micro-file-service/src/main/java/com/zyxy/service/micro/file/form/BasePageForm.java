package com.zyxy.service.micro.file.form;

import io.swagger.annotations.ApiModelProperty;

/**
 * 基础请求对象
 * 分页请求统一基础该类
 * Created on 2017/11/5.
 * @author xuyh
 */
public class BasePageForm {
    /**
     * 页码
     */
	@ApiModelProperty("页码")
    private Integer pageNum;
    /**
     * 每页数量
     */
	@ApiModelProperty("每页数量")
    private Integer pageSize;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
