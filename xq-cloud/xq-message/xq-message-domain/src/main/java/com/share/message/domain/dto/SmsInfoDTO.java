package com.share.message.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Map;

/**
 * @author xq-cloud
 * @version 1.0
 * @description:
 * @date 2026/3/7 20:50
 */
@Data
@ApiModel(description = "短信发送参数")
public class SmsInfoDTO {
    @ApiModelProperty("模板代号")
    private String templateCode;
    @ApiModelProperty("手机号码")
    private Iterable<String> phones;
    @ApiModelProperty("模板参数")
    private Map<String, String> templateParams;
}
