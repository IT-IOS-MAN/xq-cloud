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

    /**
     * 查询用户详情
     * @param loginDTO 登录参数
     * @param isStaff 是否为员工
     * @return 用户详情
     */
    LoginUserDTO queryUserDetail(LoginFormDTO loginDTO, boolean isStaff);

    /**
     * 重置密码
     * @param userId 用户ID
     */
    void resetPassword(Long userId);

    /**
     * 我的信息
     * @return 用户详情
     */
    UserDetailVO myInfo();

    /**
     * 根据手机号码添加用户
     * @param user 用户信息
     * @param code 验证码
     */
    void addUserByPhone(User user, String code);

    /**
     * 根据手机号码修改密码
     * @param cellPhone 手机号码
     * @param code 验证码
     * @param password 密码
     */
    void updatePasswordByPhone(String cellPhone, String code, String password);

    /**
     * 保存用户
     * @param userDTO 用户信息
     * @return 用户ID
     */
    Long saveUser(UserDTO userDTO);

    /**
     * 修改用户
     * @param userDTO 用户信息
     */
    void updateUser(UserDTO userDTO);

    /**
     * 修改用户
     * @param userDTO 用户信息
     */
    void updateUserWithPassword(UserFormDTO userDTO);
}
