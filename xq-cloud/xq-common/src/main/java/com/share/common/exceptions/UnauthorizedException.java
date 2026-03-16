package com.share.common.exceptions;

import lombok.Getter;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 401异常 没有授权
 * @date 2026/3/7 16:12
 */
@Getter
public class UnauthorizedException extends CommonException {

    /**
     * 状态码
     */
    private final int status = 401;

    /**
     * 默认构造函数
     * @param message 错误信息
     */

    public UnauthorizedException(String message) {
        super(401, message);
    }

    /**
     * 自定义构造函数
     * @param code 错误码
     * @param message 错误信息
     */

    public UnauthorizedException(int code, String message) {
        super(code, message);
    }

    /**
     * 自定义构造函数
     * @param code 错误码
     * @param message 错误信息
     * @param cause 异常原因
     */

    public UnauthorizedException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}