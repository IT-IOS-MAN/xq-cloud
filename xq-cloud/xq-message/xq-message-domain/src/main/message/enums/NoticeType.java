package com.share.message.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xq-cloud
 * @version 1.0
 * @description:
 * @date 2026/3/7 22:22
 */
@AllArgsConstructor
@Getter
public enum NoticeType {
    SYSTEM(0, "系统通知"),
    NOTE(1, "笔记通知"),
    QA(2, "问答通知"),
    OTHER(3, "其它通知"),
    PRIVATE_MESSAGE(4, "私信"),
    ;

    private final int value;
    private final String desc;
}
