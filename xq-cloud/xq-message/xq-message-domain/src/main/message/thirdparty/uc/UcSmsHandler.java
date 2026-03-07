package com.share.message.thirdparty.uc;

import com.share.message.domain.dto.SmsInfoDTO;
import com.share.message.domain.po.MessageTemplate;
import com.share.message.thirdparty.ISmsHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: uCloud平台短信发送功能
 * @date 2026/3/8 0:04
 */
@Service("uCloud")
@Slf4j
public class UcSmsHandler implements ISmsHandler {
    @Override
    public void send(SmsInfoDTO platformSmsInfoDTO, MessageTemplate template) {
        //第三方发送短信验证码
        log.info("短信发送成功 ...");
        log.info("platformSmsInfoDTO：{}", platformSmsInfoDTO);
    }
}

