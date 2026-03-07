package com.share.message.thirdparty.ali;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description:
 * @date 2026/3/8 0:02
 */
@Data
@ConfigurationProperties(prefix = "xq.sms.ali")
public class AliProperties {
    private String accessId;
    private String accessSecret;
}
