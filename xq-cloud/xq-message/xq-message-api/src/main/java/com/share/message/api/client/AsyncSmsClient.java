package com.share.message.api.client;

import com.share.common.autoconfigure.mq.RabbitMqHelper;
import com.share.common.constants.MqConstants;
import com.share.message.domain.dto.SmsInfoDTO;

/**
 * @author xq-cloud
 * @version 1.0
 * @description: 异步发送短信
 * @date 2026/3/7 20:47
 */
public class AsyncSmsClient {
    private final RabbitMqHelper mqHelper;

    public AsyncSmsClient(RabbitMqHelper mqHelper) {
        this.mqHelper = mqHelper;
    }

    /**
     * 基于 MQ 异步发送短信
     * @param smsInfoDTO 短信相关信息
     */
    public void sendMessage(SmsInfoDTO smsInfoDTO){
        mqHelper.send(MqConstants.Exchange.SMS_EXCHANGE, MqConstants.Key.SMS_MESSAGE, smsInfoDTO);
    }
}
