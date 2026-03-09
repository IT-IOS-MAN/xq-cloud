package com.share.common.exceptions;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 数据库异常
 * @date 2026/3/7 16:12
 */
public class DbException extends CommonException {
    public DbException(String message) {
        super(message);
    }

    public DbException(int code, String message) {
        super(code, message);
    }

    public DbException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}

