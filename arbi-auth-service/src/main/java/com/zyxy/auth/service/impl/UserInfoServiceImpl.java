package com.zyxy.auth.service.impl;

import com.zyxy.auth.service.UserInfoService;
import com.zyxy.common.domain.UserInfo;
import com.zyxy.common.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户信息
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getById(String id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }
}
