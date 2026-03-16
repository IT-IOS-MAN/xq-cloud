package com.share.common.utils;


import com.share.common.constants.ErrorInfo;
import com.share.common.exceptions.BadRequestException;

import java.util.Map;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 断言工具类
 * @date 2026/3/7 16:12
 */
public class AssertUtils {
    public static void equals(Object obj1, Object obj2, String ... message){
        if (obj1 == null || obj2 == null) {
            handleException(message);
            return;
        }
        if (obj1 == obj2) {
            return;
        }
        if(!obj1.equals(obj2)){
            handleException(message);
        }
    }

    /**
     * 判断对象是否为空
     * @param obj 对象
     * @param message 错误信息
     */
    public static void isNotNull(Object obj, String ... message){
        if (obj == null) {
            handleException(message);
        }
    }

    /**
     * 判断字符串是否为空
     * @param str 字符串
     * @param message 错误信息
     */
    public static void isNotBlank(String str, String ... message){
        if (StringUtils.isBlank(str)) {
            handleException(message);
        }
    }

    /**
     * 判断布尔值是否为true
     * @param boo 布尔值
     * @param message 错误信息
     */
    public static void isTrue(Boolean boo, String... message) {
        if (BooleanUtils.isFalse(boo)) {
            handleException(message);
        }
    }

    /**
     * 判断布尔值是否为false
     * @param boo 布尔值
     * @param message 错误信息
     */
    public static void isFalse(Boolean boo, String... message) {
        if (BooleanUtils.isTrue(boo)) {
            handleException(message);
        }
    }

    /**
     * 处理异常
     * @param message 错误信息
     */
    private static void handleException(String ... message){
        String msg = ErrorInfo.Msg.REQUEST_PARAM_ILLEGAL;
        if(message != null && message.length > 0){
            msg = message[0];
        }
        throw new BadRequestException(msg);
    }

    /**
     * 判断集合是否为空
     * @param coll 集合
     * @param message 错误信息
     */
    public static void isNotEmpty(Iterable<?> coll, String ... message) {
        if(CollUtils.isEmpty(coll)){
            handleException(message);
        }
    }

    /**
     * 判断Map是否为空
     * @param map Map
     * @param message 错误信息
     */
    public static void isNotEmpty(Map<?, ?> map, String ... message) {
        if(CollUtils.isEmpty(map)){
            handleException(message);
        }
    }
}
