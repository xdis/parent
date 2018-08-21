package com.zyxy.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 活体验证token
 * Created on 2017/11/27.
 */
@ApiModel("活体验证token")
public class LivenessTokenVO {

    /**
     * token
     */
    @ApiModelProperty("token")
    private String token;

    /**
     * 活体验证连接
     */
    @ApiModelProperty("活体验证连接")
    private String url;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
