package com.zyxy.common.config;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.zyxy.common.enums.CacheTypeEnum;

@EnableCaching
@Configuration
public class CacheConfig extends CachingConfigurerSupport {

    /**
     * 自定义key. 这个可以不用
     * 此方法将会根据类名+方法名+所有参数的值生成唯一的一个key,即使@Cacheable中的value属性一样，key也会不一样。
     */
    @Bean
    public KeyGenerator wiselyKeyGenerator() {
       return new KeyGenerator() {
           @Override
           public Object generate(Object target, Method method, Object... objects) {
              // This will generate a unique key of the class name, the method name
              //and all method parameters appended.
              StringBuilder sb = new StringBuilder();
              sb.append(target.getClass().getName());
              sb.append(method.getName());
              for (Object obj : objects) {
                  sb.append(obj.toString());
              }
              System.out.println("keyGenerator=" + sb.toString());
              return sb.toString();
           }
       };
    }

    @Bean
    public CacheManager cacheManager(@SuppressWarnings("rawtypes") RedisTemplate redisTemplate) {
        RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
        rcm.setUsePrefix(true);
        // 设置缓存过期时间
        rcm.setDefaultExpiration(60);
        // 设置value的过期时间
        Map<String,Long> map=new HashMap<>();
        for (CacheTypeEnum c : CacheTypeEnum.values()) {
            map.put(c.getCode(),c.getExpire());
        }
        rcm.setExpires(map);
        return rcm;
    }

    /**
     * RedisTemplate配置
     *
     * @param factory
     * @return
     */
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate template = new StringRedisTemplate(factory);
        //定义key序列化方式
        RedisSerializer<String> stringSerializer = new StringRedisSerializer();//Long类型会出现异常信息;需要我们上面的自定义key生成策略，一般没必要
        RedisSerializer<Object> jdkSerializer = new JdkSerializationRedisSerializer();
        template.setKeySerializer(stringSerializer);
        template.setStringSerializer(stringSerializer);
        template.setDefaultSerializer(jdkSerializer);
        template.setValueSerializer(jdkSerializer);
        template.setHashKeySerializer(jdkSerializer);
        template.setHashValueSerializer(jdkSerializer);
        template.afterPropertiesSet();
        return template;
    }

}
