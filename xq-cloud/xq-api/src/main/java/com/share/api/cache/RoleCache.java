package com.share.api.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.share.api.client.auth.AuthClient;
import com.share.api.dto.auth.RoleDTO;
import com.share.api.dto.user.UserDTO;
import com.share.common.enums.UserType;
import lombok.RequiredArgsConstructor;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 角色信息缓存 使用 Caffeine 缓存角色数据，避免频繁查询数据库
 * @date 2026/3/7 16:18
 */
@RequiredArgsConstructor
public class RoleCache {

    private final Cache<Long, RoleDTO> roleCaches;
    private final AuthClient authClient;

    /**
     * 获取角色名称
     * @param roleId 角色ID
     * @return 角色名称
     */
    public String getRoleName(Long roleId) {
        RoleDTO roleDTO = roleCaches.get(roleId, authClient::queryRoleById);
        if (roleDTO == null) {
            return null;
        }
        return roleDTO.getName();
    }

    /**
     * 获取用户名称
     * @param u 用户信息
     * @return 用户名称
     */
    public String exchangeRoleName(UserDTO u) {
        if (u == null) {
            return "--";
        }
        if (UserType.STUDENT.equalsValue(u.getType())) {
            // 学生，直接返回角色名称
            return u.getName();
        } else {
            // 管理员需要拼接角色名称
            return getRoleName(u.getRoleId()) + "-" + u.getName();
        }
    }
}
