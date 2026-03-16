package com.share.common.exceptions;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 数据库异常
 * @date 2026/3/7 16:12
 */
public class DbException extends CommonException {

    /**
     * 默认构造函数
     * @param message 错误信息
     */
    public DbException(String message) {
        super(message);
    }

    /**
     * 自定义构造函数
     * @param code 错误码
     * @param message 错误信息
     */
    public DbException(int code, String message) {
        super(code, message);
    }

    /**
     * 自定义构造函数
     * @param code 错误码
     * @param message 错误信息
     * @param cause 异常原因
     */
    public DbException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}

