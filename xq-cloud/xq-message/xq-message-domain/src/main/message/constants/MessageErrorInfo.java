package com.share.message.constants;

/**
 * @author xq-cloud
 * @version 1.0
 * @description:
 * @date 2026/3/7 20:53
 */
public interface MessageErrorInfo {
    String NOTICE_TEMPLATE_CANNOT_USE = "通知模板已停用";
    String NOTICE_TEMPLATE_NOT_EXISTS = "通知模板不存在";
    String NOTICE_NOT_MESSAGE_TEMPLATE = "通知模板不是短信模板";
    String PLATFORM_IS_EMPTY = "短信平台信息为空";
    String NO_SUITABLE_TEMPLATE = "找不到可用的消息模板";
}
