
package org.mg.blog.system.endpoint;

import org.mg.blog.dto.Result;
import org.mg.blog.endpoint.BaseEndpoint;
import org.mg.blog.system.api.ConfigApi;
import org.mg.blog.system.dto.Config;
import org.mg.blog.system.service.ConfigService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 配置端点
 *
 * @since 2020-05-29
 */
@RestController
@RequestMapping(value = "/config")
public class ConfigEndpoint extends BaseEndpoint<ConfigService, Config> implements ConfigApi {

    @Override
    public Result<Map<String, Object>> queryConfigs() {
        Map<String, Object> configs = service.queryConfigs();

        Result<Map<String, Object>> result = new Result<>();
        result.setResult(configs);
        return result;
    }
}
