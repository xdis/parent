package com.zyxy.common.vo;
 
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 倒计时VO
 */
@ApiModel("倒计时VO")
public class CountDownVO {
	
	/**
	 * 倒计时名称
	 */
	@ApiModelProperty("倒计时名称")
	private String name;
	
	/**
	 * 剩余时间
	 */
	@ApiModelProperty("剩余时间")
	private long time;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "CountDownVO [name=" + name + ", time=" + time + "]";
	}
	
}
