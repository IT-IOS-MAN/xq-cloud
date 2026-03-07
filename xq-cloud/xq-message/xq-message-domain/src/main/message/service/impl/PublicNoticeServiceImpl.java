package com.share.message.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.share.message.config.MessageProperties;
import com.share.message.domain.po.NoticeTemplate;
import com.share.message.domain.po.PublicNotice;
import com.share.message.mapper.PublicNoticeMapper;
import com.share.message.service.IPublicNoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 公告消息模板 服务实现类
 * @date 2026/3/7 23:51
 */
@Service
@RequiredArgsConstructor
public class PublicNoticeServiceImpl extends ServiceImpl<PublicNoticeMapper, PublicNotice> implements IPublicNoticeService {

    private final MessageProperties messageProperties;
    @Override
    public void saveNoticeOfTemplate(NoticeTemplate noticeTemplate) {
        LocalDateTime now = LocalDateTime.now();
        PublicNotice notice = new PublicNotice();
        notice.setTitle(noticeTemplate.getTitle());
        notice.setContent(noticeTemplate.getContent());
        notice.setPushTime(now);
        notice.setType(noticeTemplate.getType());
        notice.setExpireTime(now.plusMonths(messageProperties.getNoticeTtlMonths()));
        save(notice);
    }
}
