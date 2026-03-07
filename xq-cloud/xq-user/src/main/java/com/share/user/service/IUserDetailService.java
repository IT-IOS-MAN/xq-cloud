package com.share.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.share.common.domain.so.PageSO;
import com.share.common.enums.UserType;
import com.share.user.domain.po.UserDetail;
import com.share.user.domain.so.UserPageSO;

import java.util.List;

/**
 * @author xq-cloud
 * @version 1.0
 * @description: 用户详情表 服务类
 * @date 2026/3/8 0:21
 */
public interface IUserDetailService extends IService<UserDetail> {

    UserDetail queryById(Long userId);

    List<UserDetail> queryByIds(List<Long> ids);

    Page<UserDetail> queryUserDetailByPage(PageSO<UserPageSO> querySO, UserType type);
}
