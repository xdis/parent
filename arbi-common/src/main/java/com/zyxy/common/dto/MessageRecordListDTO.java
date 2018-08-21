package com.zyxy.common.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;

/**
 * 查询消息列表DTO
 *
 */
@ApiModel("消息列表")
public class MessageRecordListDTO extends BasePageDTO{
	
	/**
	 * 用户id
	 */
	@NotNull
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	

}
