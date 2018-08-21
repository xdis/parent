package com.zyxy.auth.service;

import com.zyxy.common.domain.LitigantInfo;

/**
 * 用户信息
 */
public interface LitigantInfoService {

    LitigantInfo getByUserId(String userId);
}
