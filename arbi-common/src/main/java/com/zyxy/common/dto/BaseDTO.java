package com.zyxy.common.dto;

import io.swagger.annotations.ApiParam;

/**
 * BaseDTO
 */
public class BaseDTO {

    @ApiParam(hidden = true)
    protected String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
