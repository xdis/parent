package com.zyxy.common.vo;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;


/**
 * 消息中心VO
 *
 */
@ApiModel("消息中心")
public class MessageCenterVO {

	/**
	 * 未读信息数量
	 */
	@ApiModelProperty("未读计数")
	private Integer unReadNum;

	/**
	 * 信息列表
	 */
	@ApiModelProperty("分页对象")
	private PageInfo<MessageRecordListVO> list;

	public Integer getUnReadNum() {
		return unReadNum;
	}

	public void setUnReadNum(Integer unReadNum) {
		this.unReadNum = unReadNum;
	}

	public PageInfo<MessageRecordListVO> getList() {
		return list;
	}

	public void setList(PageInfo<MessageRecordListVO> list) {
		this.list = list;
	}
}
