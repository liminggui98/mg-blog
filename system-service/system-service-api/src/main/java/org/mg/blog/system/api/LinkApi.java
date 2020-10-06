
package org.mg.blog.system.api;

import org.mg.blog.api.BaseApi;
import org.mg.blog.fallback.BaseApiFallBack;
import org.mg.blog.system.dto.Link;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 日志 api
 *
 * @since 2020-09-28
 */
@FeignClient(name = "system-service", contextId = "linkApi", path = "/link", fallback = BaseApiFallBack.class)
public interface LinkApi extends BaseApi<Link> {
}
