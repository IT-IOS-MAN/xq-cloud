package com.share.api.config;

import feign.RequestInterceptor;
import org.slf4j.MDC;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.share.common.constants.Constant.*;

/**
 * @author xq-cloud
 * @version 1.0
 * @description: 请求ID传递配置
 * @date 2026/3/7 19:30
 */
@Configuration
@EnableFeignClients(basePackages = "com.share.api.client")
public class RequestIdRelayConfiguration {

    /**
     * 请求ID拦截器
     * @return 请求ID拦截器
     */
    @Bean
    public RequestInterceptor requestIdInterceptor(){
        return template -> template
                .header(REQUEST_ID_HEADER, MDC.get(REQUEST_ID_HEADER))
                .header(REQUEST_FROM_HEADER, FEIGN_ORIGIN_NAME);
    }
}
