package com.zyxy.service.micro.file.service;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.domain.SysFile;
import com.zyxy.common.domain.SysFileExample;
import com.zyxy.common.mapper.SysFileMapper;


/**
 * 仲裁员服务信息模块
 * @author tanquan
 *
 */
public interface SysFileService extends SysFileMapper{
	
	/**
	 * 分页查询
	 * @param page 当前页
	 * @param pageSize 页面大小
	 * @param example 查询条件
	 * @return
	 */
	PageInfo<SysFile> selectPagedByExample(Integer page, Integer pageSize,
			SysFileExample example);
}
