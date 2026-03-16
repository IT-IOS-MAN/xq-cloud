package com.share.authsdk.resource.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 资源服务器认证配置
 * @date 2026/3/7 16:08
 */
@Data
@ConfigurationProperties(prefix = "xq.auth.resource")
public class ResourceAuthProperties {
    private Boolean enable = false;
    private List<String> includeLoginPaths;
    private List<String> excludeLoginPaths;
}
