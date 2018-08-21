package com.zyxy.service.micro.third.service;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.domain.PayOrder;
import com.zyxy.common.domain.PayOrderExample;
import com.zyxy.common.mapper.PayOrderMapper;


/**
 * 支付记录服务模块
 * @author tanquan
 *
 */
public interface PayOrderService extends PayOrderMapper{
	
	/**
	 * 分页查询
	 * @param page 当前页
	 * @param pageSize 页面大小
	 * @param example 查询条件
	 * @return
	 */
	PageInfo<PayOrder> selectPagedByExample(Integer page, Integer pageSize,
			PayOrderExample example);
}
