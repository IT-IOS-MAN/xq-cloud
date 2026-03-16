package com.share.common.enums;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 枚举基础接口
 * @date 2026/3/7 16:12
 */
public interface BaseEnum {

    /**
     * 获取枚举值
     * @return
     */
    int getValue();

    /**
     * 获取枚举描述
     * @return
     */
    String getDesc();

    /**
     * 判断枚举值是否相等
     * @param value
     * @return
     */
    default boolean equalsValue(Integer value){
        if (value == null) {
            return false;
        }
        return getValue() == value;
    }
}