package com.zyxy.service.micro.third.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.domain.PayRLItems;
import com.zyxy.common.domain.PayRLItemsExample;
import com.zyxy.common.mapper.PayRLItemsMapper;
import com.zyxy.common.vo.PayItemVO;


/**
 * 支付记录服务模块
 * @author tanquan
 *
 */
public interface PayRLItemsService extends PayRLItemsMapper{
	
	/**
	 * 分页查询
	 * @param page 当前页
	 * @param pageSize 页面大小
	 * @param example 查询条件
	 * @return
	 */
	PageInfo<PayRLItems> selectPagedByExample(Integer page, Integer pageSize,
			PayRLItemsExample example);
	
	/**
	 * 根据用户获取缴费项目
	 * @param usages 0-案件处理费，1-案件受理费
	 * @return
	 */
	List<PayItemVO> selectPayItemByUsages(Integer usages);
}
