package com.zyxy.service.micro.core.controller;


import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.vo.ApiResultVO;
import com.zyxy.common.vo.MenuVO;
import com.zyxy.common.web.BaseController;
import com.zyxy.service.micro.core.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "页面按钮权限")
@RestController
@RequestMapping("/gainMenu")
public class MenuController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(CaseDocController.class);

    @Autowired
    private MenuService menuService;


    @ApiOperation(value = "获取当前菜单可操作按钮")
    @PostMapping(value = "/{caseId}/{userId}/query")
    public ApiResultVO<List<MenuVO>> query(@PathVariable String caseId, @PathVariable String userId) {


        /*
         * 参数验证
         */
        if (StringUtils.isBlank(caseId)) {
            return super.validError();
        }
        if(StringUtils.isBlank(userId)){
            return super.validError();
        }
        BusiExecuteResult<List<MenuVO>> busiExecuteResult=menuService.queryMenu(caseId,userId);

        return super.busiExecuteSuccess(busiExecuteResult.getBody());


    }
}
