package com.share.message.domain.so;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author xq-cloud
 * @version 1.0
 * @description:
 * @date 2026/3/7 23:31
 */
@ApiModel(description = "通知模板查询对象")
@Data
public class NoticeTemplatePageSO {
    private Integer status;
    private String keyword;
}
