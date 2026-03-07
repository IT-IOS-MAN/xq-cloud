package com.share.user.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 用户详情
 * @date 2026/3/8 0:18
 */
@Data
@ApiModel(description = "用户详情")
public class UserDetailVO {
    @ApiModelProperty(value = "用户id", example = "1")
    private Long id;
    @ApiModelProperty(value = "名字", example = "张三")
    private String name;
    @ApiModelProperty(value = "头像", example = "default-icon.jpg")
    private String icon;
    @ApiModelProperty(value = "手机号", example = "13800010004")
    private String cellPhone;
    @ApiModelProperty(value = "用户名", example = "13800010004")
    private String username;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "QQ号码")
    private String qq;
    @ApiModelProperty(value = "个人介绍")
    private String intro;
    @ApiModelProperty(value = "省")
    private String province;
    @ApiModelProperty(value = "市")
    private String city;
    @ApiModelProperty(value = "区")
    private String district;
    @ApiModelProperty(value = "性别：0-男性，1-女性", example = "0")
    private Integer gender;
    @ApiModelProperty(value = "注册时间", example = "2022-07-12")
    private LocalDateTime createTime;
    @ApiModelProperty(value = "角色名称", example = "教师")
    private String roleName;
}
