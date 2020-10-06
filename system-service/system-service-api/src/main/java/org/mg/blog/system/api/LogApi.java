package org.mg.blog.system.api;

import org.mg.blog.api.BaseApi;
import org.mg.blog.fallback.BaseApiFallBack;
import org.mg.blog.system.dto.Log;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 日志 api
 */
@FeignClient(name = "system-service", contextId = "logApi", path = "/log", fallback = BaseApiFallBack.class)
public interface LogApi extends BaseApi<Log> {
}
