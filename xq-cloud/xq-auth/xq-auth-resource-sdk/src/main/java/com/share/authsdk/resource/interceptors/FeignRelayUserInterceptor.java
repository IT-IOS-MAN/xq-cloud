package com.share.authsdk.resource.interceptors;

import com.share.auth.common.constants.JwtConstants;
import com.share.common.utils.UserContext;
import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * @author xq-cloud
 * @version 1.0
 * @description:
 * @date 2026/3/7 16:06
 */
public class FeignRelayUserInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        Long userId = UserContext.getUser();
        if (userId == null) {
            return;
        }
        template.header(JwtConstants.USER_HEADER, userId.toString());
    }
}
