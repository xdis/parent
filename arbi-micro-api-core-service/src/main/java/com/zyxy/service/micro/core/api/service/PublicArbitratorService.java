package com.zyxy.service.micro.core.api.service;

import com.github.pagehelper.PageInfo;
import com.zyxy.common.dto.BasePageDTO;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.ArbitratorListVO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 公共仲裁员模块
 */
@FeignClient("coreService")
public interface PublicArbitratorService {

    @RequestMapping(value = "/public/arbitrator", method = RequestMethod.POST)
    ApiResultVO<PageInfo<ArbitratorListVO>> list(@RequestBody BasePageDTO formData);

}
