package com.zyxy.admin.service;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.dto.ArbitratorEnquiriesDTO;
import com.zyxy.common.dto.ArbitratorInfoUpdateDTO;
import com.zyxy.common.dto.UserAuditDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.vo.ArbitratorInfoAduitVO;
import com.zyxy.common.vo.ArbitratorInformationVO;

/**
 * 仲裁员列表Service
 *
 */
public interface ArbitratorAdministerService {
	/**
	 * 仲裁员列表业务处理
	 * @param formData 仲裁员信息DTO
	 * @return
	 */
	 BusiExecuteResult<PageInfo<ArbitratorInformationVO>> arbitratorTableBusiExecute(ArbitratorEnquiriesDTO formData);
	 
	 
	 /**
	  * 获取仲裁员信息业务处理
	  * @param id 仲裁员Id
	  * @return
	  */
	 ArbitratorInformationVO arbitratorInfoBusiExecute(String id);
	 
	 /**
	  * 禁用仲裁员
	  * @param id 仲裁员Id
	  * @return 成功失败
	  */
	 BusiExecuteResult arbitratorDisableBusiExecute(String id);
	 
	 
	 /**
	  * 获取仲裁员信息审核对象
	  * @param id 仲裁员Id
	  * @return
	  */
	 ArbitratorInfoAduitVO arbitratorInfoAduitBusiExecute(String id);
	 
	 /**
	  * 仲裁员信息更新或驳回
	  * @param formData
	  * @return
	  */
	 BusiExecuteResult updateArbitratorInfoBusiExecute(ArbitratorInfoUpdateDTO formData );
	 
	 /**
	  * 删除或移出黑名单
	  * @param formData
	  * @return
	  */
	 BusiExecuteResult deleteOrReinstateNormalBusiExecute(ArbitratorInfoUpdateDTO formData );



}
