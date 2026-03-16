package com.share.common.autoconfigure.swagger;

import cn.hutool.core.convert.ConverterRegistry;
import com.fasterxml.classmate.TypeResolver;
import com.share.common.domain.R;
import com.share.common.utils.XqTemporalConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: knife4j配置
 * @date 2026/3/7 16:12
 */
@Configuration
@ConditionalOnProperty(prefix = "tj.swagger", name = "enable",havingValue = "true")
@EnableConfigurationProperties(SwaggerConfigProperties.class)
public class Knife4jConfiguration {

    /**
     * Swagger 配置属性
     */
    @Resource
    private SwaggerConfigProperties swaggerConfigProperties;

    /**
     * 默认API
     * @param typeResolver 类型解析器
     * @return Docket
     */
    @Bean(value = "defaultApi2")
    public Docket defaultApi2(TypeResolver typeResolver) {
        // 1.初始化Docket
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        // 2.是否需要包装R
        if(swaggerConfigProperties.getEnableResponseWrap()){
            docket.additionalModels(typeResolver.resolve(R.class));
        }
        return docket.apiInfo(new ApiInfoBuilder()
                        .title(this.swaggerConfigProperties.getTitle())
                        .description(this.swaggerConfigProperties.getDescription())
                        .contact(new Contact(
                                this.swaggerConfigProperties.getContactName(),
                                this.swaggerConfigProperties.getContactUrl(),
                                this.swaggerConfigProperties.getContactEmail()))
                        .version(this.swaggerConfigProperties.getVersion())
                        .build())
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage(swaggerConfigProperties.getPackagePath()))
                .paths(PathSelectors.any())
                .build();

    }

    /**
     * 响应结果封装
     * @return BaseSwaggerResponseModelPlugin
     */
    @Bean
    @Primary
    @ConditionalOnProperty(prefix = "xq.swagger", name = "enableResponseWrap",havingValue = "true")
    public BaseSwaggerResponseModelPlugin baseSwaggerResponseModelPlugin(){
        return new BaseSwaggerResponseModelPlugin();
    }

    /**
     * 响应结果封装
     * @return BaseSwaggerResponseBuilderPlugin
     */
    @Bean
    @Primary
    @ConditionalOnProperty(prefix = "xq.swagger", name = "enableResponseWrap",havingValue = "true")
    public BaseSwaggerResponseBuilderPlugin baseSwaggerResponseBuilderPlugin(){
        return new BaseSwaggerResponseBuilderPlugin();
    }
    {
        // hutool的日期转换器加载
        ConverterRegistry converterRegistry = ConverterRegistry.getInstance();
        converterRegistry.putCustom(LocalDateTime.class, new XqTemporalConverter(LocalDateTime.class));
    }
}
