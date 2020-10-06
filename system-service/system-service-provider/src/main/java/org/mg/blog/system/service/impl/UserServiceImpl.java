package org.mg.blog.system.service.impl;

import org.mg.blog.service.impl.BaseServiceImpl;
import org.mg.blog.system.dto.User;
import org.mg.blog.system.mapper.UserMapper;
import org.mg.blog.system.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户服务
 *
 * @since 2020-05-29
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User queryByUserName(String userName) {
        return userMapper.queryByUserName(userName);
    }
}
