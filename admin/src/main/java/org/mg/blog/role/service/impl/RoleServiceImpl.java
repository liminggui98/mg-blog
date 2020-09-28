
package org.mg.blog.role.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.mg.blog.dto.Result;
import org.mg.blog.role.service.RoleService;
import org.mg.blog.system.api.RoleApi;
import org.mg.blog.system.dto.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

/**
 * 角色服务
 *
 * @since 2020-09-25
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleApi roleApi;

    @Override
    public Page<List<Role>> queryRoles(Page page) {
        Result<Page<List<Role>>> result = roleApi.query(page);
        return Optional.ofNullable(result.getResult()).orElse(new Page<>());
    }
}
