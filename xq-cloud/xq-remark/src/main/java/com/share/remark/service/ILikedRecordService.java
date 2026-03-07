package com.share.remark.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.share.remark.domain.dto.LikeRecordFormDTO;
import com.share.remark.domain.po.LikedRecord;

import java.util.List;
import java.util.Set;

/**
 * @author xq-cloud
 * @version 1.0
 * @description: 点赞记录表 服务类
 * @date 2026/3/8 0:56
 */
public interface ILikedRecordService extends IService<LikedRecord> {

    void addLikeRecord(LikeRecordFormDTO recordDTO);

    Set<Long> isBizLiked(List<Long> bizIds);

    void readLikedTimesAndSendMessage(String bizType, int maxBizSize);
}
