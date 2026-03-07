package com.share.common.autoconfigure.xxljob;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description:
 * @date 2026/3/8 1:17
 */
@Data
@ConfigurationProperties(prefix = "xq.xxl-job")
public class XxlJobProperties {

    private String accessToken;
    private Admin admin;
    private Executor executor;

    @Data
    public static class Admin {
        private String address;
    }

    @Data
    public static class Executor {
        private String appName;
        private String address;
        private String ip;
        private Integer port;
        private String logPath;
        private Integer logRetentionDays;

    }
}
