package com.share.authsdk.gateway.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthAutoConfiguration {

    @Bean
    @ConditionalOnClass(DiscoveryClient.class)
    public JwtSignerHolder jwtSignerHolder(DiscoveryClient discoveryClient){
        return new JwtSignerHolder(discoveryClient);
    }

    @Bean
    public AuthUtil authUtil(JwtSignerHolder jwtSignerHolder, StringRedisTemplate stringRedisTemplate){
        return new AuthUtil(jwtSignerHolder, stringRedisTemplate);
    }
}

