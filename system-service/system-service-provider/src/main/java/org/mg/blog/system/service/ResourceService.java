
package org.mg.blog.system.service;

import org.mg.blog.service.BaseService;
import org.mg.blog.system.dto.Resource;

import java.util.List;

/**
 * 功能描述
 *
 * @since 2020-05-29
 */
public interface ResourceService extends BaseService<Resource> {
    /**
     * 通过用户 id 查询用户资源
     *
     * @param roleId 角色 Id
     * @return 资源集
     */
    List<Resource> queryRoleResource(String roleId);

    /**
     * 查询所有资源
     *
     * @return 资源集
     */
    List<Resource> queryList();
}
