package org.mg.blog.user.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mg.blog.common.dto.Result;
import org.mg.blog.user.dto.User;
import org.mg.blog.user.vo.resp.AddUserResp;
import org.mg.blog.user.vo.resp.DeleteUserResp;
import org.mg.blog.user.vo.resp.UpdateUserResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户服务接口
 */
@FeignClient(value = "user-service-provider", path = "/user")
public interface UserApi {
    /**
     * 添加用户
     *
     * @param user 用户信息
     * @return 添加用户结果
     */
    @PostMapping
    Result<AddUserResp> add(@RequestBody User user);

    /**
     * 通过用户 id 删除用户信息
     *
     * @param id 用户 id
     * @return 删除用户结果
     */
    @DeleteMapping(value = "/{id}")
    Result<DeleteUserResp> deleteById(@PathVariable("id") String id);

    /**
     * 根据用户 id 修改用户信息
     *
     * @param id   用户id
     * @param user 用户信息
     * @return 修改用户结果
     */
    @PutMapping(value = "/{id}")
    Result<UpdateUserResp> update(@PathVariable("id") String id, @RequestBody User user);

    /**
     * 通过用户id查询用户信息
     *
     * @param id 用户id
     * @return 用户查询结果
     */
    @GetMapping(value = "/{id}")
    Result<User> queryById(@PathVariable("id") String id);

    /**
     * 通过用户名查询用户信息
     *
     * @param userName 用户名
     * @return 用户查询结果
     */
    @GetMapping
    Result<User> queryByUserName(@RequestParam(value = "user_name") String userName);

    /**
     * 查询用户列表
     *
     * @param userPage 用户查询条件
     * @return 查询用户列表响应
     */
    @PostMapping(value = "/list")
    Result<Page<User>> query(@RequestBody Page<User> userPage);
}
