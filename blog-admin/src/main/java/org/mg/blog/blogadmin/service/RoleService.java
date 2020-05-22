package org.mg.blog.blogadmin.service;

import org.mg.blog.model.Role;

import java.util.List;
import java.util.Set;

/**
 * 角色服务
 */
public interface RoleService {
    /**
     * 通过角色 id 查询角色
     *
     * @param id 角色id
     * @return 角色
     */
    Role queryById(Integer id);

    /**
     * 通过用户 id 查询角色集
     *
     * @param userId 用户 id
     * @return 角色集
     */
    Set<Role> queryByUserId(Integer userId);
}
