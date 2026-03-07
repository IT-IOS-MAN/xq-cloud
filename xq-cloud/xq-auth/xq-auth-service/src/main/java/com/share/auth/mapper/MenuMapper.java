package com.share.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.share.auth.domain.po.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xq-cloud
 * @version 1.0
 * @description: 权限表，包括菜单权限和访问路径权限 Mapper 接口
 * @date 2026/3/7 16:59
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> listByRoles(@Param("roleIds") List<Long> roleIds);
}
