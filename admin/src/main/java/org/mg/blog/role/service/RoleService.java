
package org.mg.blog.role.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.mg.blog.system.dto.Role;

import java.util.List;

/**
 * 角色服务
 *
 * @since 2020-09-25
 */
public interface RoleService {
    /**
     * 查询角色列表集
     *
     * @param page 分页数据
     * @return 角色数据集
     */
    Page<List<Role>> queryRoles(Page<List<Role>> page);
}
