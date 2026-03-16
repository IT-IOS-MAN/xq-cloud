package com.share.authsdk.gateway.config;

import com.share.authsdk.gateway.util.AuthUtil;
import com.share.authsdk.gateway.util.JwtSignerHolder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description:
 * @date 2026/3/8 1:08
 */
@Configuration
public class AuthAutoConfiguration {


    /**
     * jwt签名器
     * @param discoveryClient
     * @return
     */
    @Bean
    @ConditionalOnClass(DiscoveryClient.class)
    public JwtSignerHolder jwtSignerHolder(DiscoveryClient discoveryClient){
        return new JwtSignerHolder(discoveryClient);
    }

    /**
     * 认证工具类
     * @param jwtSignerHolder
     * @param stringRedisTemplate
     * @return
     */
    @Bean
    public AuthUtil authUtil(JwtSignerHolder jwtSignerHolder, StringRedisTemplate stringRedisTemplate){
        return new AuthUtil(jwtSignerHolder, stringRedisTemplate);
    }
}

