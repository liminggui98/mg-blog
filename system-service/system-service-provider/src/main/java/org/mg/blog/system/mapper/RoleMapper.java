package org.mg.blog.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mg.blog.system.dto.Role;

/**
 * 角色 mapper
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
}
