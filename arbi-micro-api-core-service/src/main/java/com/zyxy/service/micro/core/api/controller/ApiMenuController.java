package com.zyxy.service.micro.core.api.controller;

import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.MenuVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.api.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "页面菜单按钮权限")
@RestController
@RequestMapping("/api/menu")
public class ApiMenuController extends BaseController{

    @Autowired
    private MenuService menuService;

    @GetMapping(value = "/{caseId}/list")
    public ApiResultVO<List<MenuVO>> get(@PathVariable("caseId") String caserId){


        return menuService.get(caserId, getSessionUserId());
    }


}
