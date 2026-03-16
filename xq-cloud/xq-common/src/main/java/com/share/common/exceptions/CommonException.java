package com.share.common.exceptions;

import lombok.Getter;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 通用异常
 * @date 2026/3/7 16:12
 */
@Getter
public class CommonException extends RuntimeException {

    /**
     * 错误码
     */
    private final int code;

    /**
     * 默认构造函数
     * @param message 错误信息
     */
    public CommonException(String message) {
        super(message);
        this.code = 0;
    }

    /**
     * 自定义构造函数
     * @param message 错误信息
     * @param cause 异常原因
     */
    public CommonException(String message, Throwable cause) {
        super(message, cause);
        this.code = 0;
    }

    /**
     * 自定义构造函数
     * @param code 错误码
     * @param message 错误信息
     */
    public CommonException(int code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 自定义构造函数
     * @param code 错误码
     * @param message 错误信息
     * @param cause 异常原因
     */
    public CommonException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    /**
     * 获取状态码
     * @return
     */
    public int getStatus(){
        return 500;
    };
}
