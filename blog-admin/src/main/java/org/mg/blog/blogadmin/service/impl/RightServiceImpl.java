package org.mg.blog.blogadmin.service.impl;

import org.mg.blog.blogadmin.service.RightService;
import org.mg.blog.model.Right;
import org.mg.blog.utils.FieldUtils;
import org.mg.blog.utils.ResultSetUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 权限服务
 */
@Service
public class RightServiceImpl implements RightService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Right> queryByRoleId(Integer roleId) {
        String querySql = "select " +
                "rights.id,rights.name,rights.right_content,rights.create_time,rights.update_time " +
                "from tbl_role_right role_right,tbl_right rights " +
                " where role_right.right_id = rights.id and role_right.role_id = ?";
        return jdbcTemplate.query(querySql, new RightRowMapper(), roleId);
    }

    private class RightRowMapper implements RowMapper<Right> {
        @Override
        public Right mapRow(ResultSet resultSet, int i) throws SQLException {
            Right right = new Right();
            ResultSetUtils.handle(right, resultSet);
            right.setName(FieldUtils.getString(resultSet, "name"));
            right.setRightContent(FieldUtils.getString(resultSet, "right_content"));
            return right;
        }
    }
}
