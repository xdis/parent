package com.zyxy.service.micro.api.service;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.domain.ApiOrgCert;
import com.zyxy.common.domain.ApiOrgCertExample;
import com.zyxy.common.domain.ApiOrgCertWithBLOBs;
import com.zyxy.common.mapper.ApiOrgCertMapper;
import com.zyxy.common.vo.BuzzResultVO;


/**
 * 仲裁员服务信息模块
 * @author tanquan
 *
 */
public interface ApiOrgCertService extends ApiOrgCertMapper{
	
	/**
	 * 分页查询
	 * @param page 当前页
	 * @param pageSize 页面大小
	 * @param example 查询条件
	 * @return
	 */
	PageInfo<ApiOrgCert> selectPagedByExample(Integer page, Integer pageSize,
	        ApiOrgCertExample example);
	
	/**
	 * 证书生成
	 * @param orgNo
	 * @return
	 */
	BuzzResultVO<ApiOrgCertWithBLOBs> generateCert(String orgNo, String clientStorePass);
}
