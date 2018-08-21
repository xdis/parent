package com.zyxy.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 仲裁委
 *
 */
@ApiModel(value ="仲裁委案件列表对象")
public class ArbitrationCaseListDTO extends BasePageDTO{


	/**
	 * 用户编号
	 */
	private String userId;
	
	/**
	 * 参数，手机号/姓名/案号/身份证号码
	 */
	@ApiModelProperty("参数，手机号/姓名/案号/身份证号码")
	private String param;

	@Override
	public String getUserId() {
		return userId;
	}

	@Override
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}
}
