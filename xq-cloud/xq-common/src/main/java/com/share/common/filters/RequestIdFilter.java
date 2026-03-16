package com.share.common.filters;

import com.share.common.constants.Constant;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 请求ID过滤器
 * @date 2026/3/7 16:12
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@WebFilter(filterName = "requestIdFilter", urlPatterns = "/**")
public class RequestIdFilter implements Filter {

    /**
     * 过滤器
     * @param servletRequest 请求
     * @param servletResponse 响应
     * @param filterChain 过滤器链
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 1.获取request
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // 2.获取请求头中的requestId
        String requestId = request.getHeader(Constant.REQUEST_ID_HEADER);
        try {
            // 3.存入MDC
            MDC.put(Constant.REQUEST_ID_HEADER, requestId);
            filterChain.doFilter(request, servletResponse);
        }finally {
            // 4.移除
            MDC.clear();
        }
    }
}
