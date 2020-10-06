
package org.mg.blog.system.endpoint;

import org.mg.blog.dto.Result;
import org.mg.blog.endpoint.BaseEndpoint;
import org.mg.blog.system.api.ResourcesApi;
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
public class ResourceEndpoint extends BaseEndpoint<ResourceService, Resource> implements ResourcesApi {
    @Override
    public Result<List<Resource>> queryUserResource(String roleId) {
        List<Resource> resources = service.queryUserResource(roleId);

        Result<List<Resource>> result = new Result<>();
        result.setResult(resources);
        return result;
    }
}
