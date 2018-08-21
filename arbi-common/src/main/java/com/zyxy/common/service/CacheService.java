package com.zyxy.common.service;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import com.zyxy.common.enums.CacheTypeEnum;

/**
 * 
 * @author tanquan
 *
 */
@Service
public class CacheService {
	
	private final static Logger logger = LoggerFactory.getLogger(CacheService.class);

	@Autowired
	private CacheManager cacheManager;
	
	/**
	 * 清除缓存
	 * 
	 * @param key
	 *            为null时清除所有
	 */
	public void clearCache(String cacheName, String key) {
		Cache cache = cacheManager.getCache(cacheName);
		if (cache != null) {
			if (key == null) {
				cache.clear();
			} else {
				cache.evict(key);
			}
		} else {
			logger.error("cache:{} is not exist , clear failed", cacheName);
		}
	}
	
	/**
	 * 清除缓存
	 * 
	 * @param key
	 *            为null时清除所有
	 */
	public void clearCache(CacheTypeEnum typeEnum, String key) {
	    this.clearCache(typeEnum.getCode(), key);
	}
	
	/**
	 * 
	 * @param cacheName
	 *            缓存名称
	 * @param key
	 *            缓存key
	 * @param value
	 *            缓存对象
	 */
	public void addCache(String cacheName, String key, Object value) {
		Cache cache = cacheManager.getCache(cacheName);
		if (cache != null) {
			cache.put(key, value);
		} else {
			logger.error("cache:{} is not exist , clear failed", cacheName);
		}
	}
	
	/**
	 * 添加缓存
	 * @param typeEnum
	 * @param key
	 * @param value
	 */
	public void addCache(CacheTypeEnum typeEnum, String key, Object value) {
	    this.addCache(typeEnum.getCode(), key, value);
	}

	/**
	 * 获取缓存
	 * @param cacheName
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
    public <T> T getCache(String cacheName, String key) {
		Cache cache = cacheManager.getCache(cacheName);
		ValueWrapper value = null;
		if (cache != null) {
			value = cache.get(key);
		} else {
			logger.error("cache:{} is not exist , add failed", cacheName);
		}
		return value == null ? null : (T)value.get();
	}

	
	/**
	 * 
	 * @param cacheName
	 *            缓存名
	 * @param key
	 *            缓存key
	 * @return
	 */
	public <T> T getCache(CacheTypeEnum typeEnum, String key) {
	    return this.getCache(typeEnum.getCode(), key);
	}
	
	/**
	 * 清除所有缓存
	 */
	public void clearCache() {
		Collection<String> cacheNames = cacheManager.getCacheNames();
		for (String cacheName : cacheNames) {
			cacheManager.getCache(cacheName).clear();
		}
	}
	
}
