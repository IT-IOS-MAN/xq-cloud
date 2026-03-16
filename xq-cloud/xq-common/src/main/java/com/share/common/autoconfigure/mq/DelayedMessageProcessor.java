package com.share.common.autoconfigure.mq;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;

import java.time.Duration;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 延迟消息处理器
 * @date 2026/3/8 1:08
 */
public class DelayedMessageProcessor extends BasicIdMessageProcessor {

    /**
     * 延迟时间，单位是毫秒
     */
    private final long delay;

    /**
     * 延迟消息处理器
     * @param delay 延迟时间
     */
    public DelayedMessageProcessor(Duration delay) {
        this.delay = delay.toMillis();
    }

    /**
     * 消息处理器
     * @param message 消息
     * @return 消息
     * @throws AmqpException 异常
     */
    @Override
    public Message postProcessMessage(Message message) throws AmqpException {
        // 1.添加消息id
        super.postProcessMessage(message);
        // 2.添加延迟时间
        message.getMessageProperties().setHeader("x-delay", delay);
        return message;
    }
}
