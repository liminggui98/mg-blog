
package org.mg.blog.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.mg.blog.service.BaseService;
import org.mg.blog.system.dto.Resource;

import java.util.List;

/**
 * 功能描述
 *
 * @since 2020-05-29
 */
public interface ResourceService extends BaseService<Resource> {
    /**
     * 通过用户 id 查询用户资源
     *
     * @param roleId 角色 Id
     * @return 资源
     */
    List<Resource> queryUserResource(String roleId);
}
