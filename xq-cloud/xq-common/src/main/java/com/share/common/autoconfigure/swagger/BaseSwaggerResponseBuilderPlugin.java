package com.share.common.autoconfigure.swagger;

import com.fasterxml.classmate.ResolvedType;
import com.fasterxml.classmate.TypeResolver;
import com.share.common.domain.R;
import com.share.common.utils.CollUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ResponseStatus;
import springfox.documentation.schema.property.ModelSpecificationFactory;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.schema.contexts.ModelContext;
import springfox.documentation.spi.service.OperationBuilderPlugin;
import springfox.documentation.spi.service.contexts.OperationContext;
import springfox.documentation.spi.service.contexts.ResponseContext;
import springfox.documentation.spring.web.plugins.DocumentationPluginsManager;

import java.util.Optional;

import static com.github.xiaoymin.knife4j.spring.util.TypeUtils.isVoid;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: swagger响应结果封装
 * @date 2026/3/7 16:12
 */
public class BaseSwaggerResponseBuilderPlugin implements OperationBuilderPlugin, Ordered {

    /**
     * 类型解析器
     */
    @Autowired
    private TypeResolver typeResolver;

    /**
     * 文档插件管理器
     */
    @Autowired
    private DocumentationPluginsManager documentationPlugins;

    /**
     * 模型规范工厂
     */
    @Autowired
    private ModelSpecificationFactory modelSpecifications;

    /**
     * 支持的文档类型
     * @param documentationType 文档类型
     * @return 是否支持
     */
    @Override
    public boolean supports(DocumentationType documentationType) {
        return true;
    }

    /**
     * 获取执行顺序
     * @return 执行顺序
     */
    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE+13;
    }

    /**
     * 处理操作
     * @param context 上下文
     */
    @Override
    public void apply(OperationContext context) {
        // 1.处理返回值类型
        ResolvedType resolvedType = isVoid(context.getReturnType()) ?
                typeResolver.resolve(R.class) : typeResolver.resolve(R.class, context.getReturnType());
        ResolvedType returnType = context.alternateFor(resolvedType);
        // 2.处理状态码为ok
        int httpStatusCode = HttpStatus.OK.value();
        // 3.处理message
        String message = message(context);
        // 4.处理响应类型
        ModelContext modelContext = context.operationModelsBuilder().addReturn(returnType);
        // 5.响应结果
        ResponseContext responseContext = new ResponseContext(context.getDocumentationContext(), context);
        responseContext.responseBuilder()
                .representation(MediaType.APPLICATION_JSON)
                .apply(r -> r.model(m -> {
                    m.copyOf(modelSpecifications.create(modelContext, returnType));
                    m.name("R");
                    m.build();
                }))
                .description(message)
                .code(String.valueOf(httpStatusCode));
        context.operationBuilder()
                .responses(CollUtils.singletonList(documentationPlugins.response(responseContext)));
    }

    /**
     * 获取消息
     * @param context 上下文
     * @return 消息
     */
    public static String message(OperationContext context) {
        Optional<ResponseStatus> responseStatus = context.findAnnotation(ResponseStatus.class);
        String reasonPhrase = HttpStatus.OK.getReasonPhrase();
        if (responseStatus.isPresent()) {
            reasonPhrase = responseStatus.get().reason();
            if (reasonPhrase.isEmpty()) {
                reasonPhrase = responseStatus.get().value().getReasonPhrase();
            }
        }
        return reasonPhrase;
    }
}
