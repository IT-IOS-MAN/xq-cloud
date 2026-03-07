package com.share.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.share.api.dto.user.LoginFormDTO;
import com.share.api.dto.user.UserDTO;
import com.share.common.domain.dto.LoginUserDTO;
import com.share.user.domain.dto.UserFormDTO;
import com.share.user.domain.po.User;
import com.share.user.domain.vo.UserDetailVO;

/**
 * @author xq-cloud
 * @version 1.0
 * @description: 用户表 服务类
 * @date 2026/3/8 0:22
 */
public interface IUserService extends IService<User> {
    LoginUserDTO queryUserDetail(LoginFormDTO loginDTO, boolean isStaff);

    void resetPassword(Long userId);

    UserDetailVO myInfo();

    void addUserByPhone(User user, String code);

    void updatePasswordByPhone(String cellPhone, String code, String password);

    Long saveUser(UserDTO userDTO);

    void updateUser(UserDTO userDTO);

    void updateUserWithPassword(UserFormDTO userDTO);
}
