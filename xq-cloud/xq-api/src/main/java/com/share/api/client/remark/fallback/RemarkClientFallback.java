package com.share.api.client.remark.fallback;

import com.share.api.client.remark.RemarkClient;
import com.share.common.utils.CollUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;

import java.util.Set;

/**
 * @author xq-cloud
 * @version 1.0
 * @description: 评论服务降级处理
 * @date 2026/3/7 19:27
 */
@Slf4j
public class RemarkClientFallback implements FallbackFactory<RemarkClient> {

    /**
     * 创建评论客户端
     * @param cause 异常信息
     * @return 备注客户端
     */
    @Override
    public RemarkClient create(Throwable cause) {
        log.error("查询remark-service服务异常", cause);
        return new RemarkClient() {
            /**
             * 查询业务点赞状态
             * @param bizIds 业务ID列表
             * @return 点赞状态
             */
            @Override
            public Set<Long> isBizLiked(Iterable<Long> bizIds) {
                return CollUtils.emptySet();
            }
        };
    }
}
