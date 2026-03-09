package com.share.auth.common.domain;

import lombok.Data;

import java.util.Set;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 权限角色DTO
 * @date 2026/3/7 15:50
 */
@Data
public class PrivilegeRoleDTO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 权限路径
     */
    private String antPath;

    /**
     * 是否内部权限
     */
    private Boolean hasInternal;

    /**
     * 角色列表
     */
    private Set<Long> roles;
}