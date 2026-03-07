package com.share.message.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.share.api.dto.user.UserDTO;
import com.share.common.domain.dto.PageDTO;
import com.share.common.domain.so.PageSO;
import com.share.message.domain.dto.UserInboxDTO;
import com.share.message.domain.dto.UserInboxFormDTO;
import com.share.message.domain.po.NoticeTemplate;
import com.share.message.domain.po.UserInbox;
import com.share.message.domain.so.UserInboxSO;

import java.util.List;

/**
 * @author xq-cloud
 * @version 1.0
 * @description:
 * @date 2026/3/7 23:40
 */
public interface IUserInboxService extends IService<UserInbox> {

    void saveNoticeToInbox(NoticeTemplate noticeTemplate, List<UserDTO> users);

    PageDTO<UserInboxDTO> queryUserInBoxesPage(PageSO<UserInboxSO> query);

    Long sentMessageToUser(UserInboxFormDTO userInboxFormDTO);
}
