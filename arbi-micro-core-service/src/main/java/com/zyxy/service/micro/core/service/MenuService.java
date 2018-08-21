package com.zyxy.service.micro.core.service;

import com.zyxy.common.enums.LitigantTypeEnum;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.vo.MenuVO;

import java.util.List;

public interface MenuService {

    /**
     * 查询对应案件对应人员的按钮权限
     * @param caseId
     * @param userId
     * @return
     */
    BusiExecuteResult<List<MenuVO>> queryMenu(String caseId, String userId);


    LitigantTypeEnum queryCaseRoleByUserId(String caseId, String userId);
 }
