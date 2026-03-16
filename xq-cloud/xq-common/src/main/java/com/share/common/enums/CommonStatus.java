package com.share.common.enums;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 通用状态枚举
 * @date 2026/3/7 16:12
 */
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommonStatus implements BaseEnum{
    DISABLE(0, "禁用"),
    ENABLE(1, "启用"),
    ;
    private final int value;
    private final String desc;

    /**
     * 根据value获取枚举
     * @param value
     * @return
     */
    public static CommonStatus of(Integer value) {
        if (value == null) {
            return null;
        }
        for (CommonStatus commonStatus : values()) {
            if (commonStatus.getValue() == value) {
                return commonStatus;
            }
        }
        return null;
    }

    /**
     * 根据value获取描述
     * @param value
     * @return
     */
    public static String desc(Integer value) {
        CommonStatus status = of(value);
        return status.getDesc();
    }
}
