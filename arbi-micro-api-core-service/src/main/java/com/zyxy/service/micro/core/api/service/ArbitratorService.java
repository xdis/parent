package com.zyxy.service.micro.core.api.service;

import com.zyxy.common.dto.ArbitratorChangeProfileDTO;
import com.zyxy.common.vo.ApiResultVO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 仲裁员信息模块
 *
 * @author tanquan
 */
@FeignClient("coreService")
public interface ArbitratorService {

    /**
     * 仲裁员个人消息
     *
     * @return
     */
    @RequestMapping(value = "/arbitrator/personalInfo", method = RequestMethod.POST)
    ApiResultVO<?> queryArbitratorPersonalInfo(@RequestParam("userId") String userId);

    /**
     * 仲裁员基本信息
     *
     * @return
     */
    @RequestMapping(value = "/arbitrator/baseInfo", method = RequestMethod.POST)
    ApiResultVO<?> queryArbitratorBaseInfo(@RequestParam("userId") String userId);

    /**
     * 仲裁员修改信息申请
     *
     * @return
     */
    @RequestMapping(value = "/arbitrator/change", method = RequestMethod.POST)
    ApiResultVO<?> change(@RequestBody ArbitratorChangeProfileDTO formData);

}
