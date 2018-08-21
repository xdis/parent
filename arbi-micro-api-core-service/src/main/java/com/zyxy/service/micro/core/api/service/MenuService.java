package com.zyxy.service.micro.core.api.service;

import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.MenuVO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 页面按钮权限控制
 */
@FeignClient("coreService")
public interface MenuService {


    @RequestMapping(value = "/gainMenu/{caseId}/{userId}/query", method = RequestMethod.POST)
    ApiResultVO<List<MenuVO>> get(@PathVariable("caseId") String caseId, @PathVariable("userId") String userId);



}
