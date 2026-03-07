package com.share.message.api.client;

import com.share.message.domain.dto.SmsInfoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author xq-cloud
 * @version 1.0
 * @description:
 * @date 2026/3/7 20:47
 */
@FeignClient("message-service")
public interface MessageClient {

    /**
     * 同步发送短信
     * @param smsInfoDTO 短信相关信息
     */
    @PostMapping("message")
    void sendMessage(@RequestBody SmsInfoDTO smsInfoDTO);

}
