package com.zyxy.service.micro.message.service;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.domain.MailRecord;
import com.zyxy.common.domain.MailRecordExample;
import com.zyxy.common.mapper.MailRecordMapper;


/**
 * 仲裁员服务信息模块
 * @author tanquan
 *
 */
public interface MailRecordService extends MailRecordMapper{
	
	/**
	 * 分页查询
	 * @param page 当前页
	 * @param pageSize 页面大小
	 * @param example 查询条件
	 * @return
	 */
	PageInfo<MailRecord> selectPagedByExample(Integer page, Integer pageSize,
			MailRecordExample example);
}
