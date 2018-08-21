package com.zyxy.auth.service;

import java.util.List;

/**
 * 资源菜单
 */
public interface SysResourceService {
    /**
     * 获取所有权限资源菜单code
     */
    List<String> listAllCodeByUserId(String userId);
}
