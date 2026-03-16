package com.share.common.autoconfigure.xxljob;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: xxl-job配置
 * @date 2026/3/8 1:17
 */
@Data
@ConfigurationProperties(prefix = "xq.xxl-job")
public class XxlJobProperties {

    /**
     * 访问令牌
     */
    private String accessToken;

    /**
     * 管理员
     */
    private Admin admin;

    /**
     * 执行器
     */
    private Executor executor;

    /**
     * 管理员
     */
    @Data
    public static class Admin {
        private String address;
    }

    /**
     * 执行器
     */
    @Data
    public static class Executor {

        /**
         * 应用名称
         */
        private String appName;

        /**
         * 执行器IP
         */
        private String address;

        /**
         * 执行器IP
         */
        private String ip;

        /**
         * 执行器端口
         */
        private Integer port;

        /**
         * 日志路径
         */
        private String logPath;

        /**
         * 日志保留天数
         */
        private Integer logRetentionDays;

    }
}
