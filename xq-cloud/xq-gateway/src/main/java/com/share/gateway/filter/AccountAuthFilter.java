package com.share.gateway.filter;

import com.share.authsdk.gateway.util.AuthUtil;
import com.share.common.domain.R;
import com.share.common.domain.dto.LoginUserDTO;
import com.share.gateway.config.AuthProperties;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

import static com.share.auth.common.constants.JwtConstants.AUTHORIZATION_HEADER;
import static com.share.auth.common.constants.JwtConstants.USER_HEADER;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 账户认证过滤器
 * @date 2026/3/7 15:57
 */
@Component
public class AccountAuthFilter implements GlobalFilter, Ordered {

    /**
     * 认证工具类
     */
    private final AuthUtil authUtil;

    /**
     * 认证配置
     */
    private final AuthProperties authProperties;

    /**
     * 路径匹配器
     */
    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**
     * 构造器
     * @param authUtil 认证工具类
     * @param authProperties 认证配置
     */
    public AccountAuthFilter(AuthUtil authUtil, AuthProperties authProperties) {
        this.authUtil = authUtil;
        this.authProperties = authProperties;
    }

    /**
     * 过滤器
     * @param exchange 交换器
     * @param chain 过滤器链
     * @return 处理结果
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 1.获取请求request信息
        ServerHttpRequest request = exchange.getRequest();
        String method = request.getMethodValue();
        String path = request.getPath().toString();
        String antPath = method + ":" + path;

        // 2.判断是否是无需登录的路径
        if(isExcludePath(antPath)){
            // 直接放行
            return chain.filter(exchange);
        }

        // 3.尝试获取用户信息
        List<String> authHeaders = exchange.getRequest().getHeaders().get(AUTHORIZATION_HEADER);
        String token = authHeaders == null ? "" : authHeaders.get(0);
        R<LoginUserDTO> r = authUtil.parseToken(token);

        // 4.如果用户是登录状态，尝试更新请求头，传递用户信息
        if(r.success()){
            exchange.mutate()
                    .request(builder -> builder.header(USER_HEADER, r.getData().getUserId().toString()))
                    .build();
        }

        // 5.校验权限
        authUtil.checkAuth(antPath, r);

        // 6.放行
        return chain.filter(exchange);
    }

    /**
     * 是否是无需登录的路径
     * @param antPath 路径
     * @return 是否是无需登录的路径
     */
    private boolean isExcludePath(String antPath) {
        for (String pathPattern : authProperties.getExcludePath()) {
            if(antPathMatcher.match(pathPattern, antPath)){
                return true;
            }
        }
        return false;
    }

    /**
     * 获取过滤器执行顺序
     * @return 过滤器执行顺序
     */
    @Override
    public int getOrder() {
        return 1000;
    }
}

