package org.mg.blog.blogadmin.service;

import org.mg.blog.model.Right;

import java.util.List;

/**
 * 权限服务
 */
public interface RightService {
    /**
     * 根据角色 id 查询权限集
     * @param roleId  角色id
     * @return 权限集
     */
    List<Right> queryByRoleId(Integer roleId);
}
