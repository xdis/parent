package com.zyxy.service.micro.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyxy.common.domain.ApiOrgnazation;
import com.zyxy.common.domain.ApiOrgnazationExample;
import com.zyxy.common.enums.CacheTypeEnum;
import com.zyxy.common.mapper.ApiOrgnazationMapper;
import com.zyxy.common.service.CacheService;
import com.zyxy.service.micro.api.service.ApiOrgnazationService;
/**
 * 
 * @author tanquan
 *
 */
@Service
public class ApiOrgnazationServiceImpl implements ApiOrgnazationService {

	@Autowired
	private ApiOrgnazationMapper mapper;
	
	@Autowired
	private CacheService cacheService;
	
	@Override
	public int countByExample(ApiOrgnazationExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(ApiOrgnazationExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(ApiOrgnazation record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(ApiOrgnazation record) {
		return mapper.insertSelective(record);
	}

	@Override
	public List<ApiOrgnazation> selectByExample(ApiOrgnazationExample example) {
		return mapper.selectByExample(example);
	}

	@Override
	public ApiOrgnazation selectByPrimaryKey(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(ApiOrgnazation record,
			ApiOrgnazationExample example) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByExample(ApiOrgnazation record,
			ApiOrgnazationExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(ApiOrgnazation record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ApiOrgnazation record) {
		return mapper.updateByPrimaryKey(record);
	}
	
	@Override
	public PageInfo<ApiOrgnazation> selectPagedByExample(Integer page, Integer pageSize,
			ApiOrgnazationExample example) {
		if (page == null || page < 1) {
			page = 1;
		}
		if (pageSize == null || pageSize < 1 || pageSize > 1000) {
			pageSize = 10;
		}
		PageHelper.startPage(page, pageSize);
		return new PageInfo<>(this.selectByExample(example));
	}

    @Override
    public ApiOrgnazation selectCacheByPrimaryKey(String id) {
        Object cache = cacheService.getCache(CacheTypeEnum.ORG_INFO.getCode(), id);
        if (cache == null) {
            cache = this.selectByPrimaryKey(id);
            cacheService.addCache(CacheTypeEnum.ORG_INFO.getCode(), id, cache);
        }
        return (ApiOrgnazation) cache;
    }
	
}
