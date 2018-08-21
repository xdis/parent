package com.zyxy.common.service;

import com.zyxy.common.domain.ApproveType;
import com.zyxy.common.enums.CacheTypeEnum;
import com.zyxy.common.enums.CommonStatus;
import com.zyxy.common.mapper.ApproveTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApproveTypeService {

    @Autowired
    ApproveTypeMapper approveTypeMapper;
    @Autowired
    CacheService cacheService;


    /**
     * 根据key直接获取 value
     * @param key
     * @return
     */
    public String selectValueByPrimaryKey(ApproveType key) {
        key.setStatus(CommonStatus.STATUS_TRUE.getValue());
        ApproveType approveType = approveTypeMapper.selectByPrimaryKey(key);
        if (approveType == null) {
            return null;
        }
        return approveType.getTypeValue();
    }


    public ApproveType selectCacheByPrimaryKey(ApproveType key) {
        key.setStatus(CommonStatus.STATUS_TRUE.getValue());
        Object cache = cacheService.getCache(CacheTypeEnum.APPROVE_TYPE.getCode(), key.getTypeName());
        if (cache != null) {
            return (ApproveType)cache;
        }
        cache = approveTypeMapper.selectByPrimaryKey(key);
        cacheService.addCache(CacheTypeEnum.APPROVE_TYPE.getCode(), key.getTypeName(), cache);
        return (ApproveType)cache;
    }
}
