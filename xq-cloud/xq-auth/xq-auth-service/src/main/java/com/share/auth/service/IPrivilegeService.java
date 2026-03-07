package com.share.auth.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.share.auth.common.domain.PrivilegeRoleDTO;
import com.share.auth.domain.po.Privilege;
import com.share.common.domain.so.PageSO;

import java.util.List;
import java.util.Set;

/**
 * @author xq-cloud
 * @version 1.0
 * @description: 权限表，包括菜单权限和访问路径权限 服务类
 * @date 2026/3/7 16:40
 */
public interface IPrivilegeService extends IService<Privilege> {

    Page<Privilege> listPrivilegesByPage(PageSO pageQuery);

    void savePrivilege(Privilege privilege);

    void removePrivilegeById(Long id);

    List<PrivilegeRoleDTO> listPrivilegeRoles();

    Set<Long> listPrivilegeByRoleId(Long roleId);

    void bindRolePrivileges(Long roleId, List<Long> privilegeIds);

    void deleteRolePrivileges(Long roleId, List<Long> privilegeIds);
}
