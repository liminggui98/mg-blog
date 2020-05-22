package org.mg.blog.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mg.blog.user.dto.User;

/**
 * 用户数据 mapper
 *
 * @since 2020-05-21
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 通过用户名查询用户信息
     *
     * @param userName 用户姓名
     * @return 用户信息
     */
    User queryByUserName(String userName);
}
