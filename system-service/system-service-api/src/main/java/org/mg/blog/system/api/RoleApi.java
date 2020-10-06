
package org.mg.blog.system.api;

import org.mg.blog.api.BaseApi;
import org.mg.blog.dto.Result;
import org.mg.blog.fallback.BaseApiFallBack;
import org.mg.blog.system.dto.Resource;
import org.mg.blog.system.dto.Role;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 角色
 */
@FeignClient(name = "system-service", contextId = "roleApi", path = "/role", fallback = BaseApiFallBack.class)
public interface RoleApi extends BaseApi<Role> {
    /**
     * 通过用户 id 查询用户资源
     *
     * @param roleId 用户 Id
     * @return 资源
     */
    @GetMapping("/{roleId}/resource")
    Result<List<Resource>> queryUserResource(@PathVariable(value = "roleId") String roleId);
}
