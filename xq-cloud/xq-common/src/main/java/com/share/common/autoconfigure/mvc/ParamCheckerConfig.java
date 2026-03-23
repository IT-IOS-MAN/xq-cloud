package com.share.common.autoconfigure.mvc;

import com.share.common.autoconfigure.mvc.aspects.CheckerAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 参数校验配置
 * @date 2026/3/23 23:52
 */
@Configuration
public class ParamCheckerConfig {

    @Bean
    public CheckerAspect checkerAspect(){
        return new CheckerAspect();
    }
}
