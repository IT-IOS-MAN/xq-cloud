package com.share.auth.sms;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Map;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 短信发送参数
 * @date 2026/3/7 16:24
 */
@Data
@ApiModel(description = "短信发送参数")
public class SmsInfoDTO {
    private String templateCode;
    private Iterable<String> phones;
    private Map<String, String> templateParams;
}