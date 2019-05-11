package com.springboot.demo.config;

import com.springboot.demo.bean.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

@Configuration
public class MyRedisConfig {

    @Bean
    public RedisTemplate<Object,Employee> empRedisTemplate(
            RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object,Employee> template = new RedisTemplate<Object, Employee>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Employee> ser = new Jackson2JsonRedisSerializer<Employee>(Employee.class);
        template.setDefaultSerializer(ser);
        return template;
    }

//    @Bean
//    public RedisCacheManager employeeCacheManager(RedisTemplate<Object,Employee> empRedisTemplate){
//        RedisCacheManager cacheManager = new RedisCacheManager(empRedisTemplate);
//        cacheManager.setTransactionAware(true);
//        return cacheManager;
//    }


}
