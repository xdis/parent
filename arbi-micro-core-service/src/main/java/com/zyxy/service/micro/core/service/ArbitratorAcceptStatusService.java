package com.zyxy.service.micro.core.service;

import com.zyxy.common.dto.ArbitratorAcceptStatusDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.vo.ArbitratorAcceptStatusVO;

/**
 * 仲裁员接案状态服务
 */
public interface ArbitratorAcceptStatusService {
	/**
	 * 查询仲裁员接案状态业务执行
	 * @param arbitratorId 仲裁员id
	 * @return 接案状态结果
	 */
	BusiExecuteResult queryAcceptStatusBusiExecute(String arbitratorId);
	
	/**
	 * 更新仲裁员接案状态业务执行
	 * @param formData 表单信息
	 * @return
	 */
	BusiExecuteResult updateAcceptStatusBusiExecute(ArbitratorAcceptStatusDTO formData);
}
