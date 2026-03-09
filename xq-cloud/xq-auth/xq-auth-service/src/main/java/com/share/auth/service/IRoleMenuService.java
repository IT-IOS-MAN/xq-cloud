package com.share.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.share.auth.domain.po.RoleMenu;

import java.util.List;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 账户、角色关联表 服务类
 * @date 2026/3/7 16:40
 */
public interface IRoleMenuService extends IService<RoleMenu> {

    void removeByRoleId(Long id);

    void deleteRoleMenus(Long roleId, List<Long> menuIds);
}
