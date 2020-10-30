
package org.mg.blog.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mg.blog.system.dto.Resource;

import java.util.List;

/**
 * 资源 mapper
 */
@Mapper
public interface ResourceMapper extends BaseMapper<Resource> {
    /**
     * 查询用户的顶级资源菜单
     *
     * @param roleId 角色 id
     * @return 用户资源集
     */
    List<Resource> queryTopResourcesByRoleId(@Param("roleId") String roleId);

    /**
     * 通过角色 id 及父级角色 id 查询资源
     *
     * @param roleId 角色 id
     * @param parentId 父级资源 id
     * @return 资源列表
     */
    List<Resource> queryResourcesByParentIdAndRoleId(@Param("roleId") String roleId,
        @Param("parentId") String parentId);
}
