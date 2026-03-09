package com.share.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.share.auth.domain.po.LoginRecord;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description:
 * @date 2026/3/7 16:39
 */
public interface ILoginRecordService extends IService<LoginRecord> {

    void saveAsync(LoginRecord record);

    void loginSuccess(String cellphone, Long userId);
}
