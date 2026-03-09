package com.share.api.client.auth;

import com.share.api.dto.auth.RoleDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 角色信息查询客户端
 * @date 2026/3/7 16:31
 */
@FeignClient("auth-service")
public interface AuthClient {

    /**
     * 根据角色ID查询角色信息
     * @param id 角色ID
     * @return 角色信息
     */
    @GetMapping("/roles/{id}")
    RoleDTO queryRoleById(@PathVariable("id") Long id);

    /**
     * 查询所有角色信息
     * @return 角色信息列表
     */
    @GetMapping("/roles/list")
    List<RoleDTO> listAllRoles();
}
