package com.share.user.service;

/**
 * @author xq-cloud
 * @version 1.0
 * @description:
 * @date 2026/3/8 0:21
 */
public interface ICodeService {
    void sendVerifyCode(String phone);
    void verifyCode(String phone, String code);
}
