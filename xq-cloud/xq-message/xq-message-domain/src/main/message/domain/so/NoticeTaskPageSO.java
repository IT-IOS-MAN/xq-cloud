package com.share.message.domain.so;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @author xq-cloud
 * @version 1.0
 * @description: 通知模板查询对象
 * @date 2026/3/7 23:24
 */
@ApiModel(description = "通知模板查询对象")
@Data
public class NoticeTaskPageSO {
    private Boolean finished;
    private String keyword;
    private LocalDateTime minPushTime;
    private LocalDateTime maxPushTime;
}
