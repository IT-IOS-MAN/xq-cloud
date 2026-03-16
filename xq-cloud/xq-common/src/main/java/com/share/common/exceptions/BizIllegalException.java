package com.share.common.exceptions;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 业务不合法异常
 * @date 2026/3/7 16:12
 */
public class BizIllegalException extends CommonException {
    /**
     * 默认构造函数
     * @param message 错误信息
     */
    public BizIllegalException(String message) {
        super(message);
    }

    /**
     * 自定义构造函数
     * @param code 错误码
     * @param message 错误信息
     */
    public BizIllegalException(int code, String message) {
        super(code, message);
    }

    /**
     * 自定义构造函数
     * @param code 错误码
     * @param message 错误信息
     * @param cause 异常原因
     */
    public BizIllegalException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
