
package org.mg.blog.system.api;

import org.mg.blog.api.BaseApi;
import org.mg.blog.fallback.BaseApiFallBack;
import org.mg.blog.system.dto.Field;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 系统配置
 *
 * @since 2020-10-06
 */
@FeignClient(name = "system-service", contextId = "fieldApi", path = "/field", fallback = BaseApiFallBack.class)
public interface FieldApi extends BaseApi<Field> {
}
