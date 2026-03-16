package com.share.user.service;

/**
 * @author xq-cloud
 * @version 1.0
 * @description: 验证码服务接口
 * @date 2026/3/8 0:21
 */
public interface ICodeService {

    /**
     * 发送验证码
     * @param phone 手机号码
     */
    void sendVerifyCode(String phone);

    /**
     * 校验验证码
     * @param phone 手机号码
     * @param code 验证码
     */
    void verifyCode(String phone, String code);
}
