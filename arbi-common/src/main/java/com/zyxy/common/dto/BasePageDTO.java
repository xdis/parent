package com.zyxy.common.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.validation.constraints.Min;

/**
 * 基础请求对象
 * 分页请求统一基础该类
 * Created on 2017/11/5.
 * @author xuyh
 */
public class BasePageDTO extends BaseDTO {

    /**
     * 最大每页数量为1000
     */
    @ApiParam(hidden = true)
    @JsonIgnore
    private final Integer MAX_PAGE_SIZE = 1000;

    /**
     * 默认每页数量为10
     */
    @ApiParam(hidden = true)
    @JsonIgnore
    private final Integer DEFAULT_PAGE_SIZE = 10;

    /**
     * 页码
     */
	@ApiModelProperty("页码")
    @Min(0)
    private Integer pageNum = 0;
    /**
     * 每页数量
     */
	@ApiModelProperty("每页数量")
    @Min(0)
    private Integer pageSize = DEFAULT_PAGE_SIZE;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        if (pageSize > MAX_PAGE_SIZE) {
            return DEFAULT_PAGE_SIZE;
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
