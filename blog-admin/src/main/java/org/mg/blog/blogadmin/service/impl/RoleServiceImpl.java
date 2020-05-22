package org.mg.blog.blogadmin.service.impl;

import org.mg.blog.blogadmin.service.MenuService;
import org.mg.blog.blogadmin.service.RightService;
import org.mg.blog.blogadmin.service.RoleService;
import org.mg.blog.model.Menu;
import org.mg.blog.model.Right;
import org.mg.blog.model.Role;
import org.mg.blog.utils.FieldUtils;
import org.mg.blog.utils.ResultSetUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 角色服务
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private MenuService menuService;

    @Autowired
    private RightService rightService;

    @Override
    public Role queryById(Integer id) {
        String querySql = "select id,name,create_time,update_time from tbl_role where id = ? limit 1";
        return jdbcTemplate.queryForObject(querySql, new RoleMapper(), id);
    }

    @Override
    public Set<Role> queryByUserId(Integer userId) {
        String querySql = "select role.id,role.name,role.create_time,role.update_time from " +
                "tbl_user_role user_role," +
                "tbl_role role " +
                "where user_role.role_id = role_id " +
                "and user_role.user_id = ?";
        List<Role> roles = jdbcTemplate.query(querySql, new RoleMapper(), userId);
        return new HashSet<>(roles);
    }

    private class RoleMapper implements RowMapper<Role> {
        @Override
        public Role mapRow(ResultSet resultSet, int i) throws SQLException {
            Role role = new Role();
            ResultSetUtils.handle(role, resultSet);
            role.setName(FieldUtils.getString(resultSet, "name"));

            List<Menu> menus = menuService.queryByRoleId(role.getId());
            role.setMenus(new ArrayList<>(menus));

            List<Right> rights = rightService.queryByRoleId(role.getId());
            role.setRights(new ArrayList<>(rights));
            return role;
        }
    }
}
