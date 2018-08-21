package com.zyxy.common.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *审核裁决书DTO
 */
@ApiModel(value="审核裁决书DTO")
public class AuditRulingModificationDTO extends AuditPublicDTO {
	 /**
     * 仲裁员id
     */
    @NotNull(message="仲裁员id不能为空")
    @ApiModelProperty(value="仲裁员id")
    private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
    
    
	
	
	
	
	

}
