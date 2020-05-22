package org.mg.blog.blogadmin.service.impl;

import org.mg.blog.blogadmin.service.MenuService;
import org.mg.blog.model.Menu;
import org.mg.blog.utils.FieldUtils;
import org.mg.blog.utils.ResultSetUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Menu> queryByRoleId(Integer roleId) {
        String querySql = "select menu.id,menu.name,menu.url from tbl_menu menu,tbl_role_menu role_menu where " +
                "menu.id = role_menu.menu_id and role_menu.role_id = ?";
        return jdbcTemplate.query(querySql, new MenuMapper(), roleId);
    }

    private class MenuMapper implements RowMapper<Menu> {
        @Override
        public Menu mapRow(ResultSet resultSet, int i) throws SQLException {
            Menu menu = new Menu();
            ResultSetUtils.handle(menu, resultSet);
            menu.setName(FieldUtils.getString(resultSet, "name"));
            menu.setUrl(FieldUtils.getString(resultSet, "url"));
            return menu;
        }
    }
}
