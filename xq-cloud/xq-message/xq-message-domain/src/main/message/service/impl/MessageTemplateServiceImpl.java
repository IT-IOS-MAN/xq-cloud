package com.share.message.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.share.common.domain.dto.PageDTO;
import com.share.common.domain.so.PageSO;
import com.share.common.utils.BeanUtils;
import com.share.common.utils.StringUtils;
import com.share.message.domain.dto.MessageTemplateDTO;
import com.share.message.domain.dto.MessageTemplateFormDTO;
import com.share.message.domain.po.MessageTemplate;
import com.share.message.domain.so.MessageTemplatePageSO;
import com.share.message.mapper.MessageTemplateMapper;
import com.share.message.service.IMessageTemplateService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 第三方短信平台签名和模板信息 服务实现类
 * @date 2026/3/7 23:42
 */
@Service
public class MessageTemplateServiceImpl extends ServiceImpl<MessageTemplateMapper, MessageTemplate> implements IMessageTemplateService {

    @Override
    public List<MessageTemplate> queryByNoticeTemplateId(Long templateId) {
        return lambdaQuery()
                .eq(MessageTemplate::getTemplateId, templateId)
                .list();
    }

    @Override
    public Long saveMessageTemplate(MessageTemplateFormDTO messageTemplateDTO) {
        // 1.数据转换
        MessageTemplate messageTemplate = BeanUtils.copyBean(messageTemplateDTO, MessageTemplate.class);
        // 2.新增
        save(messageTemplate);
        return messageTemplate.getId();
    }

    @Override
    public void updateMessageTemplate(MessageTemplateFormDTO messageTemplateDTO) {
        // 1.数据转换
        MessageTemplate messageTemplate = BeanUtils.copyBean(messageTemplateDTO, MessageTemplate.class);
        // 2.新增
        updateById(messageTemplate);
    }

    @Override
    public PageDTO<MessageTemplateDTO> queryMessageTemplates(PageSO<MessageTemplatePageSO> pageSO) {
        // 1.分页条件
        Page<MessageTemplate> page = pageSO.toMpPage();

        MessageTemplatePageSO so = pageSO.getCondition();

        // 2.过滤条件
        page = lambdaQuery()
                .eq(so.getStatus() != null, MessageTemplate::getStatus, so.getStatus())
                .eq(so.getThirdPlatformId() != null, MessageTemplate::getPlatformCode, so.getThirdPlatformId())
                .like(StringUtils.isNotBlank(so.getKeyword()), MessageTemplate::getName, so.getKeyword())
                .page(page);
        // 3.数据转换
        return PageDTO.of(page, MessageTemplateDTO.class);
    }

    @Override
    public MessageTemplateDTO queryMessageTemplate(Long id) {
        return BeanUtils.copyBean( getById(id), MessageTemplateDTO.class);
    }
}
