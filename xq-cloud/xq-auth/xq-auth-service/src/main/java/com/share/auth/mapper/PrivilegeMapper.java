package com.share.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.share.auth.domain.po.Privilege;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xq-cloud
 * @version 1.0
 * @description: 权限表，包括菜单权限和访问路径权限 Mapper 接口
 * @date 2026/3/7 17:00
 */
public interface PrivilegeMapper extends BaseMapper<Privilege> {

    List<Privilege> listRolePrivileges(@Param("roleId") Long roleId);
}
