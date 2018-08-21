package com.zyxy.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyxy.common.domain.SysDataDic;
import com.zyxy.common.domain.SysDataDicExample;
import com.zyxy.common.domain.SysDataDicKey;
import com.zyxy.common.enums.CacheTypeEnum;
import com.zyxy.common.mapper.SysDataDicMapper;

@Service
public class SysDataDicService {
    
    @Autowired
    SysDataDicMapper mapper;
    
    @Autowired
    private CacheService cacheService;
    
    public int countByExample(SysDataDicExample example) {
        
        return mapper.countByExample(example);
    }

    public int deleteByExample(SysDataDicExample example) {
        int r = mapper.deleteByExample(example);
        return r;
    }

    public int insert(SysDataDic record) {
        
        return mapper.insert(record);
    }

    public int insertSelective(SysDataDic record) {
        
        return mapper.insertSelective(record);
    }

    public List<SysDataDic> selectByExample(SysDataDicExample example) {
        
        return mapper.selectByExample(example);
    }


    public int updateByExampleSelective(SysDataDic record, SysDataDicExample example) {
        return mapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(SysDataDic record, SysDataDicExample example) {
        return mapper.updateByExample(record, example);
    }

    public int updateByPrimaryKeySelective(SysDataDic record) {
        return mapper.updateByPrimaryKeySelective(record);
    }
    
    public int updateByPrimaryKey(SysDataDic record) {
        return mapper.updateByPrimaryKey(record);
    }
    
    public int deleteByPrimaryKey(SysDataDicKey key) {
        return mapper.deleteByPrimaryKey(key);
    }
    

    
    public SysDataDic selectByPrimaryKey(SysDataDicKey key) {
        return mapper.selectByPrimaryKey(key);
    }
    
    /**
     * 根据key直接获取 dicValue
     * @param key
     * @return
     */
    public String selectValueByPrimaryKey(SysDataDicKey key) {
        SysDataDic dic = mapper.selectByPrimaryKey(key);
        if (dic == null) {
            return null;
        }
        return dic.getDicValue();
    }
    
    /**
     * 根据key从缓存获取 dicValue
     * @param key
     * @return
     */
    public String selectCacheValueByPrimaryKey(SysDataDicKey key) {
        Object cache = cacheService.getCache(CacheTypeEnum.DATADIC.getCode(), key.getDicGroup() + key.getDicKey() + "_VALUE");
        if (cache != null) {
            return (String)cache;
        }
        SysDataDic dic = mapper.selectByPrimaryKey(key);
        if (dic == null) {
            return null;
        }
        cacheService.addCache(CacheTypeEnum.DATADIC.getCode(), key.getDicGroup() + key.getDicKey() + "_VALUE", dic.getDicValue());
        return dic.getDicValue();
    }
    
    
    public SysDataDic selectCacheByPrimaryKey(SysDataDicKey key) {
        Object cache = cacheService.getCache(CacheTypeEnum.DATADIC.getCode(), key.getDicGroup() + key.getDicKey());
        if (cache != null) {
            return (SysDataDic)cache;
        }
        cache = mapper.selectByPrimaryKey(key);
        cacheService.addCache(CacheTypeEnum.DATADIC.getCode(), key.getDicGroup() + key.getDicKey(), cache);
        return (SysDataDic)cache;
    }

    public PageInfo<?> pageByExample(int rows, int page, SysDataDicExample example) {
        PageHelper.startPage(page, rows);
        List<SysDataDic> list = this.selectByExample(example);
        PageInfo<?> pageinfo = new PageInfo<>(list);
        return pageinfo;
    }
}
