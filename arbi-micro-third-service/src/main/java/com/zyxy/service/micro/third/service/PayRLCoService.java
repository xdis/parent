package com.zyxy.service.micro.third.service;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.domain.PayRLCo;
import com.zyxy.common.domain.PayRLCoExample;
import com.zyxy.common.mapper.PayRLCoMapper;


/**
 * 支付记录服务模块
 * @author tanquan
 *
 */
public interface PayRLCoService extends PayRLCoMapper{
	
	/**
	 * 分页查询
	 * @param page 当前页
	 * @param pageSize 页面大小
	 * @param example 查询条件
	 * @return
	 */
	PageInfo<PayRLCo> selectPagedByExample(Integer page, Integer pageSize,
			PayRLCoExample example);
}
