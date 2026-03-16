package com.share.common.autoconfigure.swagger;

import com.fasterxml.classmate.ResolvedType;
import com.fasterxml.classmate.TypeResolver;
import com.share.common.domain.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.OperationModelsProviderPlugin;
import springfox.documentation.spi.service.contexts.RequestMappingContext;

import static com.github.xiaoymin.knife4j.spring.util.TypeUtils.isVoid;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: swagger响应结果封装
 * @date 2026/3/7 16:12
 */
public class BaseSwaggerResponseModelPlugin implements OperationModelsProviderPlugin, Ordered {

    /**
     * 类型解析器
     */
    @Autowired
    private TypeResolver typeResolver;

    /**
     * 是否支持
     * @param documentationType 文档类型
     * @return 是否支持
     */
    @Override
    public boolean supports(DocumentationType documentationType) {
        return true;
    }

    /**
     * 获取优先级
     * @return 优先级
     */
    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE+12;
    }

    /**
     * 应用
     * @param context 上下文
     */
    @Override
    public void apply(RequestMappingContext context) {
        // 获取返回类型
        ResolvedType resolvedType = isVoid(context.getReturnType()) ?
                typeResolver.resolve(R.class) : typeResolver.resolve(R.class, context.getReturnType());
        // 替换返回类型
        ResolvedType returnType = context.alternateFor(resolvedType);
        // 添加返回类型
        context.operationModelsBuilder().addReturn(returnType);
    }
}
