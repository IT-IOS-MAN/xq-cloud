package com.share.common.autoconfigure.mvc;

import com.share.common.autoconfigure.mvc.advice.CommonExceptionAdvice;
import com.share.common.autoconfigure.mvc.advice.WrapperResponseBodyAdvice;
import com.share.common.autoconfigure.mvc.converter.WrapperResponseMessageConverter;
import com.share.common.filters.RequestIdFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: Mvc配置
 * @date 2026/3/23 23:52
 */
@ConditionalOnClass({CommonExceptionAdvice.class, Filter.class})
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * <h1>通用的ControllerAdvice异常处理器</h1>
     */
    @Bean
    public CommonExceptionAdvice commonExceptionAdvice(){
        return new CommonExceptionAdvice();
    }

    /**
     * <h1>请求ID过滤器</h1>
     */
    @Bean
    public RequestIdFilter requestIdFilter(){
        return new RequestIdFilter();
    }

    /**
     * <h1>包装响应消息转换器</h1>
     */
    @Bean
    @ConditionalOnMissingClass("org.springframework.cloud.gateway.filter.GlobalFilter")
    public WrapperResponseMessageConverter wrapperResponseMessageConverter(
            MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter
    ){
        return new WrapperResponseMessageConverter(mappingJackson2HttpMessageConverter);
    }

    /**
     * <h1>包装响应体</h1>
     */
    @Bean
    public WrapperResponseBodyAdvice wrapperResponseBodyAdvice(){
        return new WrapperResponseBodyAdvice();
    }
}
