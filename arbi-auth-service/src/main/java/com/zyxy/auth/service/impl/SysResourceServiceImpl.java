package com.zyxy.auth.service.impl;

import com.zyxy.auth.service.SysResourceService;
import com.zyxy.common.mapper.SysResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户密码相关服务
 */
@Service
public class SysResourceServiceImpl implements SysResourceService {
    @Autowired
    SysResourceMapper sysResourceMapper;

    @Override
    public List<String> listAllCodeByUserId(String userId) {
        return sysResourceMapper.listAllCodeByUserId(userId);
    }
}
