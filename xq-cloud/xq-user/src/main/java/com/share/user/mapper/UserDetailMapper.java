package com.share.user.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.share.user.domain.po.UserDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xq-cloud
 * @version 1.0
 * @description: 详情表 Mapper 接口
 * @date 2026/3/8 0:19
 */
public interface UserDetailMapper extends BaseMapper<UserDetail> {

    UserDetail queryById(Long userId);

    List<UserDetail> queryByIds(List<Long> ids);

    Page<UserDetail> queryByPage(Page<UserDetail> p, @Param("ew") QueryWrapper<UserDetail> wrapper);
}
