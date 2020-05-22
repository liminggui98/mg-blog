package org.mg.blog.blogadmin.service;

import org.mg.blog.entity.UserVo;
import org.mg.blog.model.User;

/**
 * 系统用户服务
 */
public interface UserService {
    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 查询到的用户
     */
    User query(String userName);

    /**
     * 通过用户名及密码查询用户
     *
     * @param userName 用户名
     * @param chars 密码数组
     * @return 查询到的用户
     */
    User query(String userName, char[] chars);

    /**
     * 通过用户名与密码查询用户
     *
     * @param user 用户信息（用户名与密码）
     * @return 查询到的用户
     */
    User query(UserVo user);
}
