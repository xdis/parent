package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *  案件代理人关系对象
 */
@ApiModel(value="案件代理人关系对象")
public class CaseAgentVO {

    @ApiModelProperty(value="代理人姓名")
    private String name;
    
    @ApiModelProperty(value="代理人职务")
    private String duties;

    @ApiModelProperty(value="代理人类型，0-申请人代理人，1-被申请人代理人")
    private String litigantType;
    
    @ApiModelProperty(value="代理人职业")
    private String vocation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLitigantType() {
        return litigantType;
    }

    public void setLitigantType(String litigantType) {
        this.litigantType = litigantType;
    }

	public String getVocation() {
		return vocation;
	}

	public void setVocation(String vocation) {
		this.vocation = vocation;
	}
}
