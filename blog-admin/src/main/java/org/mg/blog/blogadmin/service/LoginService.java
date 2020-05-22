package org.mg.blog.blogadmin.service;


import org.mg.blog.entity.UserVo;
import org.mg.blog.model.User;

/**
 * 登录服务
 */
public interface LoginService {
    /**
     * 登录
     */
    User doLoin(UserVo userVo);
}
