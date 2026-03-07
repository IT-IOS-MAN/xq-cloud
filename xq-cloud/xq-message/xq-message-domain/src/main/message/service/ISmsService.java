package com.share.message.service;

import com.share.api.dto.user.UserDTO;
import com.share.message.domain.dto.SmsInfoDTO;
import com.share.message.domain.po.NoticeTemplate;

import java.util.List;

/**
 * @author xq-cloud
 * @version 1.0
 * @description:
 * @date 2026/3/7 23:39
 */
public interface ISmsService {

    void sendMessageByTemplate(NoticeTemplate noticeTemplate, List<UserDTO> users);

    void sendMessage(SmsInfoDTO smsInfoDTO);

    void sendMessageAsync(SmsInfoDTO smsInfoDTO);
}
