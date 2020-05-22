package org.mg.blog.user.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mg.blog.common.dto.Result;
import org.mg.blog.user.dto.Role;
import org.mg.blog.user.dto.User;
import org.mg.blog.user.vo.resp.AddRoleResp;
import org.mg.blog.user.vo.resp.DeleteRoleResp;
import org.mg.blog.user.vo.resp.UpdateRoleResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 角色api
 *
 * @since 2020-05-21
 */
@FeignClient(value = "role-api", path = "/role")
public interface RoleApi {
    /**
     * 增加角色
     *
     * @param role 角色数据
     * @return 增加角色结果
     */
    @PostMapping
    Result<AddRoleResp> add(Role role);

    /**
     * 通过角色 id 删除角色
     *
     * @param id 角色id
     * @return 删除角色结果
     */
    @DeleteMapping(value = "/{id}")
    Result<DeleteRoleResp> deleteById(@PathVariable(value = "id") String id);

    /**
     * 通过角色 id 更新角色数据
     *
     * @param id   角色 id
     * @param role 角色数据
     * @return 更新角色结果
     */
    @PutMapping(value = "/{id}")
    Result<UpdateRoleResp> update(@PathVariable(value = "id") String id, @RequestBody Role role);

    /**
     * 通过角色 id 查询角色数据
     *
     * @param id 角色id
     * @return 查询角色结果
     */
    @GetMapping("/{id}")
    Result<Role> queryById(@PathVariable(value = "id") String id);

    /**
     * 通过角色名查询角色数据
     *
     * @param roleName 角色名
     * @return 查询角色结果
     */
    @GetMapping
    Result<Role> queryByRoleName(@RequestParam(value = "role_name") String roleName);

    /**
     * 查询角色列表
     *
     * @param page 分页条件
     * @return 查询角色结果
     */
    @GetMapping(value = "/list")
    Result<Page<Role>> query(@RequestBody Page<User> page);
}
