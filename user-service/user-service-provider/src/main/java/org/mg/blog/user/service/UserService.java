package org.mg.blog.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mg.blog.user.dto.User;

public interface UserService {
    int add(User user);

    int deleteById(String id);

    int update(String id, User user);

    User queryById(String id);

    User queryByUserName(String userName);

    Page<User> query(Page<User> page);
}
