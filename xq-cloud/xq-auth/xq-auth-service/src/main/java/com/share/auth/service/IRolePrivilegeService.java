package com.share.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.share.auth.domain.po.RolePrivilege;

import java.util.List;

/**
 * @author xq-cloud
 * @version 1.0
 * @description: 账户、角色关联表 服务类
 * @date 2026/3/7 16:41
 */
public interface IRolePrivilegeService extends IService<RolePrivilege> {

    void removeByPrivilegeId(Long id);

    void removeByRoleId(Long id);

    void deleteRolePrivileges(Long roleId, List<Long> privilegeIds);
}
