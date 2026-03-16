package com.share.gateway.config;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 认证配置
 * @date 2026/3/7 16:12
 */
@Data
@Component
@ConfigurationProperties(prefix = "xq.auth")
public class AuthProperties implements InitializingBean {

    /**
     * 不拦截的路径
     */
    private Set<String> excludePath;

    /**
     * 不拦截的路径
     */
    @Override
    public void afterPropertiesSet() throws Exception {

        // 添加默认不拦截的路径
        excludePath.add("/error/**");
        excludePath.add("/jwks");
        excludePath.add("/accounts/login");
        excludePath.add("/accounts/admin/login");
        excludePath.add("/accounts/refresh");
    }
}
