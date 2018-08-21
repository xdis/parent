package com.zyxy.service.micro.third.service;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.domain.RealNameAuthRecord;
import com.zyxy.common.domain.RealNameAuthRecordExample;
import com.zyxy.common.mapper.RealNameAuthRecordMapper;


/**
 * 认证记录
 * @author tanquan
 *
 */
public interface RealNameAuthRecordService extends RealNameAuthRecordMapper{
	
	/**
	 * 分页查询
	 * @param page 当前页
	 * @param pageSize 页面大小
	 * @param example 查询条件
	 * @return
	 */
	PageInfo<RealNameAuthRecord> selectPagedByExample(Integer page, Integer pageSize,
			RealNameAuthRecordExample example);
}
