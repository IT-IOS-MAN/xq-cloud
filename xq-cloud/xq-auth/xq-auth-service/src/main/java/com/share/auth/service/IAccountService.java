package com.share.auth.service;

import com.share.api.dto.user.LoginFormDTO;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 账号表，平台内所有用户的账号、密码信息 服务类
 * @date 2026/3/7 16:38
 */
public interface IAccountService{

    String login(LoginFormDTO loginFormDTO, boolean isStaff);

    void logout();

    String refreshToken(String refreshToken);
}
