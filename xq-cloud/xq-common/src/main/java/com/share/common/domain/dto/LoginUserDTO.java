package com.share.common.domain.dto;

import lombok.Data;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description:  登录用户信息
 * @date 2026/3/7 16:12
 */
@Data
public class LoginUserDTO {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 是否记住我
     */
    private Boolean rememberMe;
}
