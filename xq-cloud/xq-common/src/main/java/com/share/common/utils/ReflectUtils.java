package com.share.common.utils;

import cn.hutool.core.util.ReflectUtil;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description:
 * @date 2026/3/7 16:12
 */
public class ReflectUtils extends ReflectUtil {

    /**
     * 判断一个类中是否含有指定字段
     *
     * @param fieldName 指定字段名称
     * @param clazz     类class
     * @return 是否包含 true/false
     */
    public static boolean containField(String fieldName, Class<?> clazz) {
        return getField(clazz, fieldName) != null;
    }
}
