package com.zyxy.service.micro.message.service;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.domain.SmsRecord;
import com.zyxy.common.domain.SmsRecordExample;
import com.zyxy.common.mapper.SmsRecordMapper;


/**
 * 仲裁员服务信息模块
 * @author tanquan
 *
 */
public interface SmsRecordService extends SmsRecordMapper{
	
	/**
	 * 分页查询
	 * @param page 当前页
	 * @param pageSize 页面大小
	 * @param example 查询条件
	 * @return
	 */
	PageInfo<SmsRecord> selectPagedByExample(Integer page, Integer pageSize,
			SmsRecordExample example);
}
