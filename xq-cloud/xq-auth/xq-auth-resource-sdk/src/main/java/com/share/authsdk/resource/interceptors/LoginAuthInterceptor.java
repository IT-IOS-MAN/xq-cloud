package com.share.authsdk.resource.interceptors;

import com.share.common.utils.UserContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 登录认证拦截器
 * @date 2026/3/7 16:06
 */
@Slf4j
public class LoginAuthInterceptor implements HandlerInterceptor {

    /**
     * 登录认证拦截器
     * @param request 请求
     * @param response 响应
     * @param handler 处理器
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1.尝试获取用户信息
        Long userId = UserContext.getUser();
        // 2.判断是否登录
        if (userId == null) {
            response.setStatus(401);
            response.sendError(401, "未登录用户无法访问！");
            // 2.3.未登录，直接拦截
            return false;
        }
        // 3.登录则放行
        return true;
    }
}
