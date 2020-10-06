package org.mg.blog.system.service;


import org.mg.blog.service.BaseService;
import org.mg.blog.system.dto.Config;

import java.util.Map;

/**
 * 功能描述
 *
 * @since 2020-05-29
 */
public interface ConfigService extends BaseService<Config> {
    Map<String, Object> queryConfigs();
}
