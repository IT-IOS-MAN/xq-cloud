package com.share.user.domain.so;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 分页查询条件
 * @date 2026/3/8 0:16
 */
@Data
@ApiModel(description = "分页查询条件")
public class UserPageSO {
    @ApiModelProperty(value = "账户状态")
    private Integer status;
    @ApiModelProperty(value = "教师名称")
    private String name;
    @ApiModelProperty(value = "手机号码")
    private String phone;
}
