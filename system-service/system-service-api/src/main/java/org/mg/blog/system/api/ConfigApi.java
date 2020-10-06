package org.mg.blog.system.api;

import io.swagger.annotations.Api;
import org.mg.blog.api.BaseApi;
import org.mg.blog.dto.Result;
import org.mg.blog.fallback.BaseApiFallBack;
import org.mg.blog.system.dto.Config;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * 系统配置 api
 */
@Api
@FeignClient(name = "system-service", contextId = "configApi", path = "/config", fallback = BaseApiFallBack.class)
public interface ConfigApi extends BaseApi<Config> {
    /**
     * 查询所有配置信息
     *
     * @return 查询配置数据响应
     */
    @GetMapping("/all")
    Result<Map<String, Object>> queryConfigs();
}
