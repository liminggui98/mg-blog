
package org.mg.blog.resource.service;

import org.mg.blog.base.service.BaseService;
import org.mg.blog.system.dto.Resource;

import java.util.List;

/**
 * 资源服务
 *
 * @since 2020-09-26
 */
public interface ResourceService extends BaseService<Resource> {
    /**
     * 查询角色资源集
     *
     * @param roleId 角色 id
     * @return 资源集
     */
    List<Resource> queryRoleResource(String roleId);

    /**
     * 查询资源集
     *
     * @return 资源集
     */
    List<Resource> queryResource();
}
