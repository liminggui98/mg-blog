
package org.mg.blog.system.api;

import org.mg.blog.api.BaseApi;
import org.mg.blog.dto.Result;
import org.mg.blog.fallback.BaseApiFallBack;
import org.mg.blog.system.dto.Resource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 系统资源
 */
@FeignClient(name = "system-service", contextId = "resourceApi", path = "/resource", fallback = BaseApiFallBack.class)
public interface ResourcesApi extends BaseApi<Resource> {
    /**
     * 通过用户 id 查询用户资源
     *
     * @param roleId 用户 Id
     * @return 资源
     */
    @GetMapping("/role/{roleId}")
    Result<List<Resource>> queryRoleResource(@PathVariable(value = "roleId") String roleId);

    /**
     * 查询列表
     *
     * @return
     */
    @GetMapping("/list")
    Result<List<Resource>> queryResource();
}
