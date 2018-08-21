package com.zyxy.service.micro.api.service;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.domain.ApiOrgnazation;
import com.zyxy.common.domain.ApiOrgnazationExample;
import com.zyxy.common.mapper.ApiOrgnazationMapper;


/**
 * 仲裁员服务信息模块
 * @author tanquan
 *
 */
public interface ApiOrgnazationService extends ApiOrgnazationMapper{
	
	/**
	 * 分页查询
	 * @param page 当前页
	 * @param pageSize 页面大小
	 * @param example 查询条件
	 * @return
	 */
	PageInfo<ApiOrgnazation> selectPagedByExample(Integer page, Integer pageSize,
	        ApiOrgnazationExample example);
	
	/**
     * 从缓存中获取机构信息
     * @param id
     * @return
     */
    ApiOrgnazation selectCacheByPrimaryKey(String id);
}
