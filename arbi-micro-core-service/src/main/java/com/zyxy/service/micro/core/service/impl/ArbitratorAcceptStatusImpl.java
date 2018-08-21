package com.zyxy.service.micro.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyxy.common.dto.ArbitratorAcceptStatusDTO;
import com.zyxy.common.mapper.ArbitratorAcceptStatusMapper;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.service.BusiValidResult;
import com.zyxy.common.util.StringUtil;
import com.zyxy.common.vo.ArbitratorAcceptStatusVO;
import com.zyxy.service.micro.core.service.ArbitratorAcceptStatusService;

/**
 * 仲裁员接案状态相关服务
 */
@Service
public class ArbitratorAcceptStatusImpl implements ArbitratorAcceptStatusService{
	@Autowired
	private ArbitratorAcceptStatusMapper mapper;

	@Override
	public BusiExecuteResult queryAcceptStatusBusiExecute(String arbitratorId) {
		return BusiExecuteResult.builderSuccessResult(mapper.queryAcceptStatus(arbitratorId));
	}

	@Override
	public BusiExecuteResult updateAcceptStatusBusiExecute(
			ArbitratorAcceptStatusDTO formData) {
		mapper.updateAcceptStatus(formData);
		return BusiExecuteResult.builderSuccessResult();
	}
	
}
