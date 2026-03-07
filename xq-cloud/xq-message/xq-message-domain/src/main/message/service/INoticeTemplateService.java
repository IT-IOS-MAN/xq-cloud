package com.share.message.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.share.common.domain.dto.PageDTO;
import com.share.common.domain.so.PageSO;
import com.share.message.domain.dto.NoticeTemplateDTO;
import com.share.message.domain.dto.NoticeTemplateFormDTO;
import com.share.message.domain.po.NoticeTemplate;
import com.share.message.domain.so.NoticeTemplatePageSO;

/**
 * @author xq-cloud
 * @version 1.0
 * @description:
 * @date 2026/3/7 23:37
 */
public interface INoticeTemplateService extends IService<NoticeTemplate> {

    Long saveNoticeTemplate(NoticeTemplateFormDTO noticeTemplateFormDTO);

    void updateNoticeTemplate(NoticeTemplateFormDTO noticeTemplateFormDTO);

    PageDTO<NoticeTemplateDTO> queryNoticeTemplates(PageSO<NoticeTemplatePageSO> pageSO);

    NoticeTemplateDTO queryNoticeTemplate(Long id);

    NoticeTemplate queryByCode(String code);
}
