package org.mg.blog.system.service;

import org.mg.blog.service.BaseService;
import org.mg.blog.system.dto.User;

/**
 * 用户
 */
public interface UserService extends BaseService<User> {
    User queryByUserName(String userName);
}
