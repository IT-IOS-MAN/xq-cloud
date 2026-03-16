package com.share.auth.util;

import cn.hutool.json.JSONUtil;
import com.share.auth.common.domain.PrivilegeRoleDTO;
import com.share.auth.domain.po.Privilege;
import com.share.common.utils.CollUtils;
import com.share.common.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.share.auth.common.constants.JwtConstants.AUTH_PRIVILEGE_KEY;
import static com.share.auth.common.constants.JwtConstants.AUTH_PRIVILEGE_VERSION_KEY;

/**
 * @author xq-cloud
 * @version 1.0
 * @description: 鉴权缓存类
 * @date 2026/3/7 16:42
 */
@Slf4j
@Component
public class PrivilegeCache {

    /**
     * 权限缓存
     */
    private final BoundHashOperations<String, String, String> hashOps;

    /**
     * 字符串redis模板
     */
    private final StringRedisTemplate stringRedisTemplate;

    /**
     * 构造函数
     * @param stringRedisTemplate 字符串redis模板
     */
    public PrivilegeCache(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.hashOps = stringRedisTemplate.boundHashOps(AUTH_PRIVILEGE_KEY);
    }

    /**
     * 初始化权限缓存
     * @param list 权限角色DTO列表
     */
    public void initPrivilegesCache(List<PrivilegeRoleDTO> list) {
        // 1.组装权限对应角色
        Map<String, String> map = new HashMap<>();
        for (PrivilegeRoleDTO prDTO : list) {
            map.put(prDTO.getId().toString(), JSONUtil.toJsonStr(prDTO));
        }
        // 2.写入 redis
        hashOps.putAll(map);
        // 3.版本递增
        incrementVersion();
    }

    /**
     * 缓存单个权限
     * @param p 权限
     * @param roleIds 角色id列表
     */
    public void cacheSinglePrivilege(Privilege p, Set<Long> roleIds) {
        try {
            PrivilegeRoleDTO privilegeRoleDTO = new PrivilegeRoleDTO();
            privilegeRoleDTO.setId(p.getId());
            privilegeRoleDTO.setAntPath(p.getMethod() + ":" + p.getUri());
            privilegeRoleDTO.setRoles(roleIds);
            privilegeRoleDTO.setHasInternal(p.getInternal());
            hashOps.put(p.getId().toString(), JSONUtil.toJsonStr(privilegeRoleDTO));
            incrementVersion();
        } catch (Exception e) {
            log.error("缓存权限信息失败。 ->", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 移除权限缓存
     * @param id 权限id
     */
    public void removePrivilegeCacheById(Long id) {
        hashOps.delete(id);
        incrementVersion();
    }

    /**
     * 批量移除权限缓存
     * @param ids 权限id列表
     */
    public void removePrivilegeCacheByIds(List<Long> ids) {
        hashOps.delete(ids.toArray());
        incrementVersion();
    }

    /**
     * 递增权限版本
     */
    private void incrementVersion() {
        stringRedisTemplate.opsForValue().increment(AUTH_PRIVILEGE_VERSION_KEY, 1);
    }

    /**
     * 移除角色id对应的权限缓存
     * @param id 角色id
     */
    public void removeCacheByRoleId(Long id) {
        // 查询出所有权限信息
        Map<String, String> cacheMap = hashOps.entries();
        if(CollUtils.isEmpty(cacheMap)){
            return;
        }
        // 记录修改的数据
        Map<String, String> modified = new HashMap<>();
        for (Map.Entry<String, String> en : cacheMap.entrySet()) {
            // 获取权限数据
            String value = en.getValue();
            PrivilegeRoleDTO prDTO = JsonUtils.toBean(value, PrivilegeRoleDTO.class);
            // 尝试移除角色id
            boolean remove = prDTO.getRoles().remove(id);
            if(remove){
                modified.put(en.getKey(), JsonUtils.toJsonStr(prDTO));
            }
        }
        // 写回缓存
        hashOps.putAll(modified);
        incrementVersion();
    }
}
