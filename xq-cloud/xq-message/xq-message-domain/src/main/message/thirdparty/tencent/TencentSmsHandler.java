package com.share.message.thirdparty.tencent;

import com.share.message.domain.dto.SmsInfoDTO;
import com.share.message.domain.po.MessageTemplate;
import com.share.message.thirdparty.ISmsHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 腾讯平台短信发送功能
 * @date 2026/3/8 0:03
 */
@Service("tencent")
@Slf4j
public class TencentSmsHandler implements ISmsHandler {
    @Override
    public void send(SmsInfoDTO platformSmsInfoDTO, MessageTemplate template) {
        //第三方发送短信验证码
        log.info("tencent平台，短信发送成功 ...");
        log.info("platformSmsInfoDTO：{}", platformSmsInfoDTO);
    }
}
