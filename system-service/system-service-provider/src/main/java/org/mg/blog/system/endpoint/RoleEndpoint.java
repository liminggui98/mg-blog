
package org.mg.blog.system.endpoint;

import org.mg.blog.dto.Result;
import org.mg.blog.endpoint.BaseEndpoint;
import org.mg.blog.system.api.RoleApi;
import org.mg.blog.system.dto.Resource;
import org.mg.blog.system.dto.Role;
import org.mg.blog.system.service.RoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 角色端点
 *
 * @since 2020-06-20
 */
@RestController
@RequestMapping("/role")
public class RoleEndpoint extends BaseEndpoint<RoleService, Role> implements RoleApi {
    @Override
    public Result<List<Resource>> queryUserResource(String roleId) {
        return null;
    }
}
