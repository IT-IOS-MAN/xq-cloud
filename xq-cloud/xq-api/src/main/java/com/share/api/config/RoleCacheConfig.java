package com.share.api.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.share.api.cache.RoleCache;
import com.share.api.client.auth.AuthClient;
import com.share.api.dto.auth.RoleDTO;
import org.springframework.context.annotation.Bean;

import java.time.Duration;

/**
 * @author xq-cloud
 * @version 1.0
 * @description: 角色缓存配置
 * @date 2026/3/7 19:29
 */
public class RoleCacheConfig {
    /**
     * 角色的caffeine缓存
     */
    @Bean
    public Cache<Long, RoleDTO> roleCaches(){
        return Caffeine.newBuilder()
                .initialCapacity(1)
                .maximumSize(10_000)
                .expireAfterWrite(Duration.ofMinutes(30))
                .build();
    }
    /**
     * 角色的缓存工具
     */
    @Bean
    public RoleCache roleCache(Cache<Long, RoleDTO> roleCaches, AuthClient authClient){
        return new RoleCache(roleCaches, authClient);
    }
}
