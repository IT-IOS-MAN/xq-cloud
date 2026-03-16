package com.share.user.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.share.common.exceptions.BadRequestException;
import com.share.user.constants.UserErrorInfo;
import lombok.Getter;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 用户状态
 * @date 2026/3/8 0:19
 */
@Getter
public enum UserStatus {
    FROZEN(0, "禁止使用"),
    NORMAL(1, "已激活"),
    ;
    @EnumValue
    int value;
    String desc;

    UserStatus(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static UserStatus of(int value) {
        if (value == 0) {
            return FROZEN;
        }
        if (value == 1) {
            return NORMAL;
        }
        throw new BadRequestException(UserErrorInfo.Msg.INVALID_USER_STATUS);
    }
}
