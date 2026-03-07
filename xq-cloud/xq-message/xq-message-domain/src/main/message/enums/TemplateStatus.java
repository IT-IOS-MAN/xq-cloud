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
public enum TemplateStatus {
    DRAFT(0, "草稿"),
    IN_SERVICE(1, "使用中"),
    OUT_OF_SERVICE(2, "停用"),
    ;

    private final int value;
    private final String desc;
}