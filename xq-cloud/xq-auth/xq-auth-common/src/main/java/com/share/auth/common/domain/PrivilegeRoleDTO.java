package com.share.auth.common.domain;

import lombok.Data;

import java.util.Set;

/**
 * @author xq-cloud
 * @version 1.0
 * @description:
 * @date 2026/3/7 15:50
 */
@Data
public class PrivilegeRoleDTO {
    private Long id;
    private String antPath;
    private Boolean internal;
    private Set<Long> roles;
}