package com.share.api.config;

import com.share.api.client.remark.fallback.RemarkClientFallback;
import com.share.api.client.user.fallback.UserClientFallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xq-cloud
 * @version 1.0
 * @description: 服务降级配置
 * @date 2026/3/7 19:23
 */
@Configuration
public class FallbackConfig {

    /**
     * 用户服务降级处理
     * @return 用户服务降级处理
     */
    @Bean
    public UserClientFallback userClientFallback(){
        return new UserClientFallback();
    }

    /**
     * 评论服务降级处理
     * @return 评论服务降级处理
     */
    @Bean
    public RemarkClientFallback remarkClientFallback(){
        return new RemarkClientFallback();
    }
}
