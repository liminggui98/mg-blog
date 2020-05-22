package org.mg.blog.user.endpoint;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mg.blog.common.dto.Result;
import org.mg.blog.user.api.UserApi;
import org.mg.blog.user.dto.User;
import org.mg.blog.user.service.UserService;
import org.mg.blog.user.vo.resp.AddUserResp;
import org.mg.blog.user.vo.resp.DeleteUserResp;
import org.mg.blog.user.vo.resp.UpdateUserResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserEndpoint implements UserApi {

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private UserService userService;

    @Override
    public Result<AddUserResp> add(User user) {
        int count = userService.add(user);

        AddUserResp addUserResp = new AddUserResp();
        addUserResp.setUpdateCount(count);
        addUserResp.setDesc("success");

        Result<AddUserResp> result = new Result<>();
        result.setResult(addUserResp);
        return result;
    }

    @Override
    public Result<DeleteUserResp> deleteById(String id) {
        int i = userService.deleteById(id);

        DeleteUserResp deleteUserResp = new DeleteUserResp();

        Result<DeleteUserResp> result = new Result<>();
        result.setResult(deleteUserResp);
        return result;
    }

    @Override
    public Result<UpdateUserResp> update(String id, User user) {
        int count = userService.update(id, user);

        UpdateUserResp updateUserResp = new UpdateUserResp();

        Result<UpdateUserResp> result = new Result<>();
        result.setResult(updateUserResp);
        return result;
    }

    @Override
    public Result<User> queryById(String id) {
        User user = userService.queryById(id);

        Result<User> result = new Result<>();
        result.setResult(user);
        return result;
    }

    @Override
    public Result<User> queryByUserName(String userName) {
        User user = userService.queryByUserName(userName);

        Result<User> result = new Result<>();
        result.setResult(user);
        return result;
    }

    @Override
    @Cacheable
    public Result<Page<User>> query(Page<User> userPage) {
        Page<User> user = userService.query(userPage);

        Result<Page<User>> result = new Result<>();
        result.setResult(user);
        return result;
    }
}
