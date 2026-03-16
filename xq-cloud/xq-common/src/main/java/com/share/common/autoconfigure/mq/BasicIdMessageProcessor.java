package com.share.common.autoconfigure.mq;

import cn.hutool.core.lang.UUID;
import org.slf4j.MDC;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;

import static com.share.common.constants.Constant.REQUEST_ID_HEADER;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 消息处理器
 * @date 2026/3/8 1:07
 */
public class BasicIdMessageProcessor implements MessagePostProcessor {

    /**
     * 消息处理器
     * @param message 消息
     * @return 消息
     * @throws AmqpException 异常
     */
    @Override
    public Message postProcessMessage(Message message) throws AmqpException {
        String requestId = MDC.get(REQUEST_ID_HEADER);
        if (requestId == null) {
            requestId = UUID.randomUUID().toString(true);
        }
        // 写入RequestID标示
        message.getMessageProperties().setHeader(REQUEST_ID_HEADER, requestId);
        return message;
    }
}
