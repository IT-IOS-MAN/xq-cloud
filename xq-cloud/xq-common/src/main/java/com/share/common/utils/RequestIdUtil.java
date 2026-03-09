package com.share.common.utils;

import cn.hutool.core.lang.UUID;
import org.slf4j.MDC;

import static com.share.common.constants.Constant.REQUEST_ID_HEADER;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description:
 * @date 2026/3/7 16:12
 */
public class RequestIdUtil {
    public static void markRequest() {
        // 1.判断是否已经存在
        String requestId = MDC.get(REQUEST_ID_HEADER);
        if(requestId != null){
            return;
        }
        // 2.尝试从请求头获取
        requestId = WebUtils.getRequestId();
        // 3.再次判断
        if (requestId == null) {
            // 不存在则直接生成一个新的requestId
            requestId = UUID.randomUUID().toString(true);
        }
        // 4.保存
        MDC.put(REQUEST_ID_HEADER, requestId);
    }
    public static void clear(){
        MDC.clear();
    }
}
