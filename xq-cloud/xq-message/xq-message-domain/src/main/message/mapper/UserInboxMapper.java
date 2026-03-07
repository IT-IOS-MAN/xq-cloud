package com.share.message.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.share.message.domain.po.UserInbox;

/**
 * @author xq-cloud
 * @version 1.0
 * @description:
 * @date 2026/3/7 22:27
 */
public interface UserInboxMapper extends BaseMapper<UserInbox> {

    UserInbox queryLatestPublicNotice(Long userId);
}
