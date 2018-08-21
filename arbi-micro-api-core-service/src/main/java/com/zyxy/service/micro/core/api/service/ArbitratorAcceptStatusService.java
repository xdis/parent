package com.zyxy.service.micro.core.api.service;

import com.zyxy.common.dto.ArbitratorAcceptStatusDTO;
import com.zyxy.common.vo.ApiResultVO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 仲裁员接案状态控制层
 */
@FeignClient("coreService")
public interface ArbitratorAcceptStatusService {

	/**
	 * 更新仲裁员接案状态
	 * @param formData
	 * @return
	 */
	@RequestMapping(value = "/arbitrator/acceptstatus/updateStatus", method = RequestMethod.POST)
	ApiResultVO<String> updateStatus(@RequestBody ArbitratorAcceptStatusDTO formData);
}
