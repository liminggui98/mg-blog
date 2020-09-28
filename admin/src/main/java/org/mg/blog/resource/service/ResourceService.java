
package org.mg.blog.resource.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.mg.blog.system.dto.Resource;
import org.mg.blog.system.dto.Role;

import java.util.List;

/**
 * 资源服务
 *
 * @since 2020-09-26
 */
public interface ResourceService {
    /**
     * 查询资源数据
     *
     * @param page 分页数据
     * @return 资源数据
     */
    Page<List<Resource>> queryResource(Page page);

    /**
     * 查询角色拥有的资源
     *
     * @param role 角色
     * @return 资源集
     */
    List<Resource> queryRoleResource(Role role);
}
