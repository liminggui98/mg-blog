
package org.mg.blog.system.endpoint;

import org.mg.blog.dto.Result;
import org.mg.blog.endpoint.BaseEndpoint;
import org.mg.blog.system.api.ResourceApi;
import org.mg.blog.system.dto.Resource;
import org.mg.blog.system.service.ResourceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 资源断点
 *
 * @since 2020-06-20
 */
@RestController
@RequestMapping(value = "/resource")
public class ResourceEndpoint extends BaseEndpoint<ResourceService, Resource> implements ResourceApi {
    @Override
    public Result<List<Resource>> queryRoleResource(String roleId) {
        List<Resource> resources = service.queryRoleResource(roleId);

        Result<List<Resource>> result = new Result<>();
        result.setResult(resources);
        return result;
    }

    @Override
    public Result<List<Resource>> queryResource() {
        return queryRoleResource("");
    }
}
