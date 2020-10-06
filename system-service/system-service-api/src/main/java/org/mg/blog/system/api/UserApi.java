package org.mg.blog.system.api;

import org.mg.blog.api.BaseApi;
import org.mg.blog.dto.Result;
import org.mg.blog.fallback.BaseApiFallBack;
import org.mg.blog.system.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 用户
 */
@FeignClient(name = "system-service", contextId = "userApi", path = "/user", fallback = BaseApiFallBack.class)
public interface UserApi extends BaseApi<User> {
    @GetMapping("/name/{userName}")
    Result<User> queryByUserName(@PathVariable("userName") String userName);
}
