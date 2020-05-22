package org.mg.blog.user.service.impl;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mg.blog.user.dto.User;
import org.mg.blog.user.mapper.UserMapper;
import org.mg.blog.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "user")
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public int add(User user) {
        try {
            return userMapper.insert(user);
        } catch (MybatisPlusException e) {
            LOGGER.error("add user failed!", e);
            return 0;
        }
    }

    @Override
    public int deleteById(String id) {
        try {
            return userMapper.deleteById(id);
        } catch (MybatisPlusException e) {
            LOGGER.error("delete user failed by id!", e);
            return 0;
        }
    }

    @Override
    public int update(String id, User user) {
        try {
            return userMapper.updateById(user);
        } catch (MybatisPlusException e) {
            LOGGER.error("update user failed by id!", e);
            return 0;
        }
    }

    @Override
    @Cacheable
    public User queryById(String id) {
        try {
            return userMapper.selectById(id);
        } catch (MybatisPlusException e) {
            LOGGER.error("query user failed by id!", e);
            return null;
        }
    }

    @Override
    @Cacheable
    public User queryByUserName(String userName) {
        try {
            return userMapper.queryByUserName(userName);
        } catch (MybatisPlusException e) {
            LOGGER.error("query user failed by id!", e);
            return null;
        }
    }

    @Override
    public Page<User> query(Page<User> page) {
        Page<User> pageUser = userMapper.selectPage(page, Wrappers.emptyWrapper());
        return pageUser;
    }
}
