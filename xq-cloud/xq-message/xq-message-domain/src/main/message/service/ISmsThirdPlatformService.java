package com.share.message.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.share.common.domain.dto.PageDTO;
import com.share.common.domain.so.PageSO;
import com.share.message.domain.dto.SmsThirdPlatformDTO;
import com.share.message.domain.dto.SmsThirdPlatformFormDTO;
import com.share.message.domain.po.SmsThirdPlatform;
import com.share.message.domain.so.SmsThirdPlatformPageSO;

import java.util.List;

/**
 * @author xq-cloud
 * @version 1.0
 * @description:
 * @date 2026/3/7 23:39
 */
public interface ISmsThirdPlatformService extends IService<SmsThirdPlatform> {

    List<SmsThirdPlatform> queryAllPlatform();

    Long saveSmsThirdPlatform(SmsThirdPlatformFormDTO thirdPlatformDTO);

    void updateSmsThirdPlatform(SmsThirdPlatformFormDTO thirdPlatformDTO);

    PageDTO<SmsThirdPlatformDTO> querySmsThirdPlatforms(PageSO<SmsThirdPlatformPageSO> querySO);

    SmsThirdPlatformDTO querySmsThirdPlatform(Long id);
}
