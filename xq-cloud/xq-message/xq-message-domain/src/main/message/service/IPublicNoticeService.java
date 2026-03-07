package com.share.message.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.share.message.domain.po.NoticeTemplate;
import com.share.message.domain.po.PublicNotice;

/**
 * @author xq-cloud
 * @version 1.0
 * @description: 公告消息模板 服务类
 * @date 2026/3/7 23:38
 */
public interface IPublicNoticeService extends IService<PublicNotice> {

    void saveNoticeOfTemplate(NoticeTemplate noticeTemplate);
}
