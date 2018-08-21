package com.zyxy.common.mapper;

import org.apache.ibatis.annotations.Param;

import com.zyxy.common.dto.ArbitratorAcceptStatusDTO;
import com.zyxy.common.vo.ArbitratorAcceptStatusVO;

public interface ArbitratorAcceptStatusMapper {
	/**
	 * 查询仲裁员接案状态
	 * @param arbitratorId 仲裁员id
	 * @return 仲裁员接案状态对象
	 */
	ArbitratorAcceptStatusVO queryAcceptStatus(String arbitratorId);
	
	/**
	 * 更改接案状态
	 * @param formData 表单对象
	 * @return 更改接案状态结果
	 */
	int updateAcceptStatus(@Param("dto")ArbitratorAcceptStatusDTO formData);
}
