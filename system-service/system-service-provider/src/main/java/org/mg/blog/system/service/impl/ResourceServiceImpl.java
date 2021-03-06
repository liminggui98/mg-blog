
package org.mg.blog.system.service.impl;

import org.mg.blog.service.impl.BaseServiceImpl;
import org.mg.blog.system.dto.Resource;
import org.mg.blog.system.mapper.ResourceMapper;
import org.mg.blog.system.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述
 *
 * @since 2020-05-29
 */
@Service
public class ResourceServiceImpl extends BaseServiceImpl<Resource> implements ResourceService {
    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public List<Resource> queryRoleResource(String roleId) {
        List<Resource> resources = resourceMapper.queryTopResourcesByRoleId(roleId);
        resources.forEach(res -> {
            querySubNode(roleId, res);
        });
        return resources;
    }

    @Override
    public List<Resource> queryList() {
        return queryRoleResource("");
    }

    /**
     * 查询子集资源
     *
     * @param roleId 角色id
     * @param resource 父级资源
     * @return 子集资源
     */
    private List<Resource> querySubNode(String roleId, Resource resource) {
        String resourceId = resource.getId();

        List<Resource> resources = resourceMapper.queryResourcesByParentIdAndRoleId(roleId, resourceId);
        resources.forEach(res -> querySubNode(roleId, res));
        resource.setNodes(resources);
        return resources;
    }
}
