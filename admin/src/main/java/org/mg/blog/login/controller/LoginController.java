
package org.mg.blog.login.controller;

import org.mg.blog.dto.Result;
import org.mg.blog.system.api.UserApi;
import org.mg.blog.system.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("casLogin")
public class LoginController {
    @Resource
    private UserApi userApi;

    /**
     * to login
     *
     * @return login 视图名
     */
    @GetMapping
    public String toLogin() {
        return "login/login";
    }

    /**
     * do login
     *
     * @param user 用户信息
     * @return 登录结果
     */
    @PostMapping
    @ResponseBody
    public Result<Object> doLogin(User user) {
        Result<Object> result = new Result<>();
        return result;
    }
}
