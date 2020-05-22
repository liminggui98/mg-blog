package org.mg.blog.blogadmin.service.impl;

import org.mg.blog.blogadmin.service.RoleService;
import org.mg.blog.blogadmin.service.UserService;
import org.mg.blog.entity.UserVo;
import org.mg.blog.model.Role;
import org.mg.blog.model.User;
import org.mg.blog.utils.FieldUtils;
import org.mg.blog.utils.ResultSetUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RoleService roleService;

    @Override
    public User query(String userName) {
        String querySql = "select " +
                "id,user_name,pass,first_name,last_name,profile_photo," +
                "last_login_time,last_login_ip,create_time,update_time " +
                "from tbl_user where user_name = ?";
        User user = jdbcTemplate.queryForObject(querySql, new UserRowMapper(), userName);
        if (ObjectUtils.isEmpty(user)) {
            return null;
        }
        Set<Role> roles = roleService.queryByUserId(user.getId());
        user.setRoles(roles);
        return user;
    }

    @Override
    public User query(String userName, char[] chars) {
        String querySql = "select " +
                "id,user_name,pass,first_name,last_name,profile_photo," +
                "last_login_time,last_login_ip,create_time,update_time " +
                "from tbl_user where user_name = ? and pass = ?";
        return jdbcTemplate.queryForObject(querySql, new UserRowMapper(), userName, new String(chars));
    }

    @Override
    public User query(UserVo userVo) {
        String querySql = "select id,user_name,pass,first_name,last_name,profile_photo," +
                "last_login_time,last_login_ip,create_time,update_time" +
                " from tbl_user where user_name = ? and pass = ?";
        User user = jdbcTemplate.queryForObject(querySql, new UserRowMapper(), userVo.getUserName(), userVo.getPass());
        if (ObjectUtils.isEmpty(user)) {
            return null;
        }
        Set<Role> roles = roleService.queryByUserId(user.getId());
        user.setRoles(roles);
        return user;
    }

    private class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            ResultSetUtils.handle(user, resultSet);
            user.setUserName(FieldUtils.getString(resultSet, "user_name"));
            user.setPass(FieldUtils.getString(resultSet, "pass"));
            user.setFirstName(FieldUtils.getString(resultSet, "first_name"));
            user.setLastName(FieldUtils.getString(resultSet, "last_name"));
            user.setProfilePhoto(FieldUtils.getString(resultSet, "profile_photo"));
            user.setLastLoginTime(FieldUtils.getDate(resultSet, "last_login_time"));
            user.setLastLoginIp(FieldUtils.getString(resultSet, "last_login_ip"));

            Set<Role> roles = roleService.queryByUserId(user.getId());
            user.setRoles(roles);
            return user;
        }
    }
}
