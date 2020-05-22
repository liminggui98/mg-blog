package org.mg.blog.blogadmin.service.impl;

import org.mg.blog.blogadmin.service.LoginService;
import org.mg.blog.blogadmin.service.UserService;
import org.mg.blog.entity.UserVo;
import org.mg.blog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 登录服务
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserService userService;

    @Override
    public User doLoin(UserVo userVo) {
        return userService.query(userVo);
    }
}
