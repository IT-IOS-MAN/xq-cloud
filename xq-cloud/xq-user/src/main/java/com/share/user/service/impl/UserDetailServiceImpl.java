package com.share.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.share.common.domain.so.PageSO;
import com.share.common.enums.UserType;
import com.share.common.utils.StringUtils;
import com.share.user.domain.po.UserDetail;
import com.share.user.domain.so.UserPageSO;
import com.share.user.mapper.UserDetailMapper;
import com.share.user.service.IUserDetailService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 用户详情表 服务实现类
 * @date 2026/3/8 0:25
 */
@Service
public class UserDetailServiceImpl extends ServiceImpl<UserDetailMapper, UserDetail> implements IUserDetailService {

    @Override
    public UserDetail queryById(Long userId) {
        return getBaseMapper().queryById(userId);
    }

    @Override
    public List<UserDetail> queryByIds(List<Long> ids) {
        return getBaseMapper().queryByIds(ids);
    }

    @Override
    public Page<UserDetail> queryUserDetailByPage(PageSO<UserPageSO> querySO, UserType type) {
        // 1.分页条件
        Page<UserDetail> p = querySO.toMpPageDefaultSortByCreateTimeDesc();

        UserPageSO so = querySO.getCondition();

        // 2.搜索条件
        Integer status = so.getStatus();
        String name = so.getName();
        String phone = so.getPhone();
        QueryWrapper<UserDetail> wrapper = new QueryWrapper<>();
        wrapper
                .eq(type != null , "u.type", type)
                .eq(status != null, "u.status", status)
                .eq(StringUtils.isNotBlank(phone),"u.cell_phone", phone)
                .like(StringUtils.isNotBlank(name), "ud.name", name);
        // 3.查询
        p = getBaseMapper().queryByPage(p, wrapper);
        // 4.返回
        return p;
    }
}
