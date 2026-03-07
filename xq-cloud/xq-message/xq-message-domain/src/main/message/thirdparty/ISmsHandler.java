package com.share.message.thirdparty;

import com.share.message.domain.dto.SmsInfoDTO;
import com.share.message.domain.po.MessageTemplate;

/**
 * @author xq-cloud
 * @version 1.0
 * @description:
 * @date 2026/3/8 0:05
 */
public interface ISmsHandler {

    /**
     * 发送短信
     */
    void send(SmsInfoDTO platformSmsInfoDTO, MessageTemplate template);
}
