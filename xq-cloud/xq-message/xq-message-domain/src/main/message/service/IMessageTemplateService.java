package com.share.message.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.share.common.domain.dto.PageDTO;
import com.share.common.domain.so.PageSO;
import com.share.message.domain.dto.MessageTemplateDTO;
import com.share.message.domain.dto.MessageTemplateFormDTO;
import com.share.message.domain.po.MessageTemplate;
import com.share.message.domain.so.MessageTemplatePageSO;

import java.util.List;

/**
 * @author xq-cloud
 * @version 1.0
 * @description: 第三方短信平台签名和模板信息 服务类
 * @date 2026/3/7 22:32
 */
public interface IMessageTemplateService extends IService<MessageTemplate> {

    List<MessageTemplate> queryByNoticeTemplateId(Long id);

    Long saveMessageTemplate(MessageTemplateFormDTO messageTemplateDTO);

    void updateMessageTemplate(MessageTemplateFormDTO messageTemplateDTO);

    PageDTO<MessageTemplateDTO> queryMessageTemplates(PageSO<MessageTemplatePageSO> pageSO);

    MessageTemplateDTO queryMessageTemplate(Long id);
}
