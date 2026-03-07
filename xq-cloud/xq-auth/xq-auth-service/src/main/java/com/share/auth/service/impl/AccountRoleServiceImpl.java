package com.share.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.share.auth.domain.po.AccountRole;
import com.share.auth.mapper.AccountRoleMapper;
import com.share.auth.service.IAccountRoleService;
import org.springframework.stereotype.Service;

/**
 * @author xq-cloud
 * @version 1.0
 * @description: 账户、角色关联表 服务实现类
 * @date 2026/3/7 16:57
 */
@Service
public class AccountRoleServiceImpl extends ServiceImpl<AccountRoleMapper, AccountRole> implements IAccountRoleService {

}
