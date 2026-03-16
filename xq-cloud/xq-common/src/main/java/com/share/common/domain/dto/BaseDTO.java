package com.share.common.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: DTO基础属性
 * @date 2026/3/7 16:12
 */
@ApiModel(description = "DTO基础属性")
public class BaseDTO {
    @ApiModelProperty("创建人id")
    private Long creater;
    @ApiModelProperty("更新人id")
    private Long updater;
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;
    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;
}
