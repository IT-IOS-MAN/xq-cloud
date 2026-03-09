package com.share.common.enums;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description:
 * @date 2026/3/7 16:12
 */
public interface BaseEnum {
    int getValue();
    String getDesc();

    default boolean equalsValue(Integer value){
        if (value == null) {
            return false;
        }
        return getValue() == value;
    }
}