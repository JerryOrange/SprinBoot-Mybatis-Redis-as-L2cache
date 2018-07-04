package com.ncu.jerry.jedis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import redis.clients.jedis.JedisPool;

/**
 * 初始化自定义的Jedis管理池
 *
 * Created by Jiacheng on 2018/7/4.
 */
@Configuration
public class JedisConfiguration {

    @Autowired
    private JedisProperties jedisProperties;

    @Bean
    @Profile("jedisPool")
    public JedisPool getJedisPool() {

        //Java通用对象池
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();

        JedisPool jedisPool = new JedisPool(poolConfig, jedisProperties.getHost(), jedisProperties.getPort(),
                jedisProperties.getTimeout(), jedisProperties.getPassword(), jedisProperties.getSsl());

        return jedisPool;
    }
}
