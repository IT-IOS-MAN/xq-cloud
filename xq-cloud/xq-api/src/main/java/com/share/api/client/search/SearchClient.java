package com.share.api.client.search;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author xq-cloud
 * @version 1.0
 * @description:
 * @date 2026/3/7 19:25
 */
@FeignClient("search-service")
public interface SearchClient {

    @GetMapping("/courses/name")
    List<Long> queryCoursesIdByName(
            @RequestParam(value = "keyword", required = false) String keyword);
}