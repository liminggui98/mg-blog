package org.mg.blog.user.endpoint;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mg.blog.common.dto.Result;
import org.mg.blog.user.api.RoleApi;
import org.mg.blog.user.dto.Role;
import org.mg.blog.user.dto.User;
import org.mg.blog.user.vo.resp.AddRoleResp;
import org.mg.blog.user.vo.resp.DeleteRoleResp;
import org.mg.blog.user.vo.resp.UpdateRoleResp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @since 2020-05-21
 */
@RestController
@RequestMapping(value = "/role")
public class RoleEndPoint implements RoleApi {
    @Override
    public Result<AddRoleResp> add(Role role) {
        return null;
    }

    @Override
    public Result<DeleteRoleResp> deleteById(String id) {
        return null;
    }

    @Override
    public Result<UpdateRoleResp> update(String id, Role role) {
        return null;
    }

    @Override
    public Result<Role> queryById(String id) {
        return null;
    }

    @Override
    public Result<Role> queryByRoleName(String roleName) {
        return null;
    }

    @Override
    public Result<Page<Role>> query(Page<User> page) {
        return null;
    }
}
