package com.share.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.share.auth.domain.po.Menu;

import java.util.List;

/**
 * @author xq-cloud
 * @version 1.0
 * @description: 权限表，包括菜单权限和访问路径权限 服务类
 * @date 2026/3/7 16:39
 */
public interface IMenuService extends IService<Menu> {

    List<Menu> listMenuByUser();

    void saveMenu(Menu menu);

    void deleteMenu(Long id);

    void bindRoleMenus(Long roleId, List<Long> menuIds);

    void deleteRoleMenus(Long roleId, List<Long> menuIds);
}
