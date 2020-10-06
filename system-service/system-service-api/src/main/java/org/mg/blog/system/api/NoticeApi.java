package org.mg.blog.system.api;


import org.mg.blog.api.BaseApi;
import org.mg.blog.fallback.BaseApiFallBack;
import org.mg.blog.system.dto.Notice;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 系统通知
 */
@FeignClient(name = "system-service", contextId = "noticeApi", path = "/notice", fallback = BaseApiFallBack.class)
public interface NoticeApi extends BaseApi<Notice> {
}
