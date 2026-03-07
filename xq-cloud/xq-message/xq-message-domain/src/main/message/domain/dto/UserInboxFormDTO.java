package com.share.message.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author xq-cloud
 * @version 1.0
 * @description: 用户通知记录
 * @date 2026/3/7 21:11
 */
@Data
@ApiModel(description = "用户私信表单实体")
public class UserInboxFormDTO {

    @ApiModelProperty("目标用户id")
    private Long userId;

    @ApiModelProperty("私信内容")
    private String content;
}
