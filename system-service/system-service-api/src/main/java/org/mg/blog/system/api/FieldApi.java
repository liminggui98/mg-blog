
package org.mg.blog.system.api;

import org.mg.blog.api.BaseApi;
import org.mg.blog.dto.Result;
import org.mg.blog.fallback.BaseApiFallBack;
import org.mg.blog.system.dto.Field;
import org.mg.blog.system.dto.Resource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 系统配置
 *
 * @since 2020-10-06
 */
@FeignClient(name = "system-service", contextId = "fieldApi", path = "/field", fallback = BaseApiFallBack.class)
public interface FieldApi extends BaseApi<Field> {
    /**
     * 通过用户 id 查询用户资源
     *
     * @param roleId 用户 Id
     * @return 资源
     */
    @GetMapping("/resource/{resourceId}")
    Result<List<Field>> queryByResourceId(@PathVariable(value = "resourceId") String resourceId);
}
