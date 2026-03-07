package com.share.message.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author xq-cloud
 * @version 1.0
 * @description:
 * @date 2026/3/7 20:52
 */
@Data
@ConfigurationProperties(prefix = "xq.message")
public class MessageProperties {
    /**
     * 通知的最大有效期，默认1个月
     */
    private Integer noticeTtlMonths = 1;
    /**
     * 私信的最大有效期，默认6个月
     */
    private Integer messageTtlMonths = 6;
}
