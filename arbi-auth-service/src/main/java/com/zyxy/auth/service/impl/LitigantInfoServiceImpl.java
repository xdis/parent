package com.zyxy.auth.service.impl;

import com.zyxy.auth.service.LitigantInfoService;
import com.zyxy.common.domain.LitigantInfo;
import com.zyxy.common.mapper.LitigantInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户信息
 */
@Service
public class LitigantInfoServiceImpl implements LitigantInfoService {
    @Autowired
    private LitigantInfoMapper litigantInfoMapper;

    @Override
    public LitigantInfo getByUserId(String userId) {
        return litigantInfoMapper.selectByUserId(userId);
    }
}
