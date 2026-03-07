package com.share.message.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.share.common.domain.dto.PageDTO;
import com.share.common.domain.so.PageSO;
import com.share.message.domain.dto.NoticeTaskDTO;
import com.share.message.domain.dto.NoticeTaskFormDTO;
import com.share.message.domain.po.NoticeTask;
import com.share.message.domain.so.NoticeTaskPageSO;

/**
 * @author xq-cloud
 * @version 1.0
 * @description: 系统通告的任务表，可以延期或定期发送通告 服务类
 * @date 2026/3/7 23:36
 */
public interface INoticeTaskService extends IService<NoticeTask> {

    Long saveNoticeTask(NoticeTaskFormDTO noticeTaskFormDTO);

    void handleTask(NoticeTask noticeTask);

    void updateNoticeTask(NoticeTaskFormDTO noticeTaskFormDTO);

    PageDTO<NoticeTaskDTO> queryNoticeTasks(PageSO<NoticeTaskPageSO> pageSO);

    NoticeTaskDTO queryNoticeTask(Long id);

    PageDTO<NoticeTask> queryTodoNoticeTaskByPage(int pageNo, int size);
}
