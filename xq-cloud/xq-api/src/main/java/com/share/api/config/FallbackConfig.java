package com.share.api.config;

import com.share.api.client.remark.fallback.RemarkClientFallback;
import com.share.api.client.user.fallback.UserClientFallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xq-cloud
 * @version 1.0
 * @description:
 * @date 2026/3/7 19:23
 */
@Configuration
public class FallbackConfig {

    @Bean
    public UserClientFallback userClientFallback(){
        return new UserClientFallback();
    }

    @Bean
    public RemarkClientFallback remarkClientFallback(){
        return new RemarkClientFallback();
    }
}
