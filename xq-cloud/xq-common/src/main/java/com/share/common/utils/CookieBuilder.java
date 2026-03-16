package com.share.common.utils;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: cookie 构建器
 * @date 2026/3/7 16:12
 */
@Slf4j
@Data
@Accessors(chain = true, fluent = true)
public class CookieBuilder {

    /**
     * 默认的cookie编码
     */
    private Charset charset = StandardCharsets.UTF_8;

    /**
     * 默认的cookie过期时间
     */
    private int maxAge = -1;

    /**
     * 默认的cookie路径
     */
    private String path = "/";

    /**
     * 是否只允许http访问
     */
    private boolean httpOnly;

    /**
     * 是否只允许https访问
     */
    private boolean secure;

    /**
     * 是否允许跨域访问
     */
    private boolean sameSite;

    /**
     * 是否允许跨域访问
     */
    private String name;

    /**
     * 值
     */
    private String value;

    /**
     * 域名
     */
    private String domain;

    /**
     * 请求
     */
    private final HttpServletRequest request;

    /**
     * 响应
     */
    private final HttpServletResponse response;

    /**
     * 构造函数
     * @param request 请求
     * @param response 响应
     */
    public CookieBuilder(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    /**
     * 构建cookie，会对cookie值用UTF-8做URL编码，避免中文乱码
     */
    public void build(){
        if (response == null) {
            log.error("response为null，无法写入cookie");
            return;
        }
        Cookie cookie = new Cookie(name, URLEncoder.encode(value, charset));
        if(StringUtils.isNotBlank(domain)) {
            cookie.setDomain(domain);
        }else if (request != null) {
            String serverName = request.getServerName();
            serverName = StringUtils.subAfter(serverName, ".", false);
            cookie.setDomain("." + serverName);
        }
        cookie.setHttpOnly(httpOnly);
        cookie.setMaxAge(maxAge);
        cookie.setPath(path);
        log.debug("生成cookie，编码方式:{}，【{}={}，domain:{};maxAge={};path={};httpOnly={}】",
                charset.name(), name, value, domain, maxAge, path, httpOnly);
        response.addCookie(cookie);
    }

    /**
     * 利用UTF-8对cookie值解码，避免中文乱码问题
     * @param cookieValue cookie原始值
     * @return 解码后的值
     */
    public String decode(String cookieValue){
        return URLDecoder.decode(cookieValue, charset);
    }
}
