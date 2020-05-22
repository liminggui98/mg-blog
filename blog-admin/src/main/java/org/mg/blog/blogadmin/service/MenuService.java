package org.mg.blog.blogadmin.service;


import org.mg.blog.model.Menu;

import java.util.List;

public interface MenuService {
    /**
     * 通过角色 id 查询菜单集
     *
     * @param roleId 角色 id
     * @return 菜单集
     */
    List<Menu> queryByRoleId(Integer roleId);
}
