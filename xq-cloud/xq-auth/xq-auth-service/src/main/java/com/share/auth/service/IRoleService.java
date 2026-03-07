package com.share.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.share.auth.domain.po.Role;

import java.util.List;

/**
 * @author xq-cloud
 * @version 1.0
 * @description: 角色表 服务类
 * @date 2026/3/7 16:41
 */
public interface IRoleService extends IService<Role> {

    boolean exists(Long roleId);
    boolean exists(List<Long> roleIds);

    void deleteRole(Long id);
}
