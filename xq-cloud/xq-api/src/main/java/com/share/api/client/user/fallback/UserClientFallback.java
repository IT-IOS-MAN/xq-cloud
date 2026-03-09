package com.share.api.client.user.fallback;

import com.share.api.client.user.UserClient;
import com.share.api.dto.user.LoginFormDTO;
import com.share.api.dto.user.UserDTO;
import com.share.common.domain.dto.LoginUserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;

import java.util.Collections;
import java.util.List;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description:
 * @date 2026/3/7 16:35
 */
@Slf4j
public class UserClientFallback implements FallbackFactory<UserClient> {

    /**
     * 创建用户客户端
     * @param cause 异常信息
     * @return 用户客户端
     */
    @Override
    public UserClient create(Throwable cause) {
        log.error("查询用户服务出现异常", cause);
        return new UserClient() {
            /**
             * 根据手机号查询用户id
             * @param phone 手机号
             * @return 用户id
             */
            @Override
            public Long exchangeUserIdWithPhone(String phone) {
                return null;
            }
            /**
             * 查询用户详情
             * @param loginDTO 登录信息
             * @param isStaff 是否是员工
             * @return 用户详情
             */
            @Override
            public LoginUserDTO queryUserDetail(LoginFormDTO loginDTO, boolean isStaff) {
                return null;
            }
            /**
             * 查询用户类型
             * @param id 用户id
             * @return 用户类型，0-普通学员，1-老师，2-其他员工
             */
            @Override
            public Integer queryUserType(Long id) {
                return null;
            }

            /**
             * 根据id批量查询用户信息
             * @param ids 用户id集合
             * @return 用户集合
             */
            @Override
            public List<UserDTO> queryUserByIds(Iterable<Long> ids) {
                return Collections.emptyList();
            }

            /**
             * 根据id查询单个用户信息
             * @param id 用户id
             * @return 用户信息
             */
            @Override
            public UserDTO queryUserById(Long id) {
                return null;
            }
        };
    }
}
