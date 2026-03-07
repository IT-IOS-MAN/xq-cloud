package com.share.message.domain.enums;

import lombok.Getter;

/**
 * @author xq-cloud
 * @version 1.0
 * @description:
 * @date 2026/3/7 20:50
 */
@Getter
public enum SmsTemplate {
    VERIFY_CODE("短信验证码"),
    ;
    private String desc;

    SmsTemplate( String desc) {
        this.desc = desc;
    }
}
