package org.mg.blog.system.endpoint;

import org.mg.blog.dto.Result;
import org.mg.blog.endpoint.BaseEndpoint;
import org.mg.blog.resp.AddResp;
import org.mg.blog.system.api.UserApi;
import org.mg.blog.system.dto.User;
import org.mg.blog.system.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户端点
 *
 * @since 2020-06-20
 */
@RestController
@RequestMapping(value = "/user")
public class UserEndpoint extends BaseEndpoint<UserService, User> implements UserApi {

    @Resource
    private UserService userService;

    @Override
    public Result<User> queryByUserName(String userName) {
        User user = userService.queryByUserName(userName);

        Result<User> result = new Result<>();
        result.setResult(user);
        return result;
    }
}
