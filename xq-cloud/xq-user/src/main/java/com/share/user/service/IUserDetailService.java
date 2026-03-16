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

    /**
     * 根据用户ID查询用户详情
     * @param userId 用户ID
     * @return 用户详情
     */
    UserDetail queryById(Long userId);

    /**
     * 根据用户ids批量查询用户详情
     * @param ids 用户ID列表
     * @return 用户详情列表
     */
    List<UserDetail> queryByIds(List<Long> ids);

    /**
     * 分页查询用户详情
     * @param querySO 分页查询参数
     * @param type 用户类型
     * @return 分页查询结果
     */
    Page<UserDetail> queryUserDetailByPage(PageSO<UserPageSO> querySO, UserType type);
}
