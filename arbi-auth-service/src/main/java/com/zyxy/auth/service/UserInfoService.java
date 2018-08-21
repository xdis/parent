package com.zyxy.auth.service;

import com.zyxy.common.domain.UserInfo;

/**
 * 用户信息
 */
public interface UserInfoService {

    UserInfo getById(String id);
}
