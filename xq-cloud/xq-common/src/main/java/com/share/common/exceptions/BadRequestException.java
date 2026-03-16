package com.share.common.exceptions;

import lombok.Getter;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 400异常
 * @date 2026/3/7 16:12
 */
@Getter
public class BadRequestException extends CommonException {
    private final int status = 400;

    /**
     * 默认构造函数
     */
    public BadRequestException(String message) {
        super(400, message);
    }

    /**
     * 自定义构造函数
     * @param code 错误码
     * @param message 错误信息
     */
    public BadRequestException(int code, String message) {
        super(code, message);
    }

    /**
     * 自定义构造函数
     * @param code 错误码
     * @param message 错误信息
     * @param cause 异常原因
     */
    public BadRequestException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
