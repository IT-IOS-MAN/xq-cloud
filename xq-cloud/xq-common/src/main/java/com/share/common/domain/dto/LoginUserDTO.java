package com.share.common.domain.dto;

import lombok.Data;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description:
 * @date 2026/3/7 16:12
 */
@Data
public class LoginUserDTO {
    private Long userId;
    private Long roleId;
    private Boolean rememberMe;
}
