package com.share.user.domain.dto;

import com.share.api.dto.user.UserDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 修改用户信息的表单，带有密码
 * @date 2026/3/8 0:14
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description = "修改用户信息的表单，带有密码")
public class UserFormDTO extends UserDTO {
    @ApiModelProperty(value = "原始密码", example = "123321")
    @NotNull
    private String oldPassword;
    @ApiModelProperty(value = "新密码", example = "123321")
    @NotNull
    private String password;
}
