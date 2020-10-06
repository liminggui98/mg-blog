package org.mg.blog.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mg.blog.system.dto.User;
import org.springframework.stereotype.Repository;

/**
 * 用户 mapper
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 通过用户名查询用户信息
     * @param userName 用户名称
     * @return 用户信息
     */
    User queryByUserName(@Param("userName") String userName);
}
