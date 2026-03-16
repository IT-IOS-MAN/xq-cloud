package com.share.common.autoconfigure.swagger;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description:
 * @date 2026/3/7 16:12
 */
@Data
@ConfigurationProperties(prefix = "xq.swagger")
public class SwaggerConfigProperties implements Serializable {

    /**
     * 是否开启swagger
     */
    private Boolean enable = false;

    /**
     * 是否开启响应结果封装
     */
    private Boolean enableResponseWrap = false;

    /**
     * 扫描包路径
     */
    public String packagePath;

    /**
     * 标题
     */
    public String title;

    /**
     * 描述
     */
    public String description;

    /**
     * 联系人
     */
    public String contactName;

    /**
     * 联系人地址
     */
    public String contactUrl;

    /**
     * 联系人邮箱
     */
    public String contactEmail;

    /**
     * 版本
     */
    public String version;
}
