package com.share.common.exceptions;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 请求超时异常
 * @date 2026/3/7 16:12
 */
public class RequestTimeoutException  extends CommonException {
    public RequestTimeoutException(String message) {
        super(message);
    }

    public RequestTimeoutException(int code, String message) {
        super(code, message);
    }

    public RequestTimeoutException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
