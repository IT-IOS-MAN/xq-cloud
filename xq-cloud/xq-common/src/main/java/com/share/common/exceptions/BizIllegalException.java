package com.share.common.exceptions;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 业务不合法异常
 * @date 2026/3/7 16:12
 */
public class BizIllegalException extends CommonException {
    public BizIllegalException(String message) {
        super(message);
    }

    public BizIllegalException(int code, String message) {
        super(code, message);
    }

    public BizIllegalException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
