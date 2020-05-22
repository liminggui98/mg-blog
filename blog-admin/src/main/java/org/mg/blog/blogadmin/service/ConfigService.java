package org.mg.blog.blogadmin.service;

import org.mg.blog.model.Config;

/**
 * 配置查询
 */
public interface ConfigService {
    /**
     * 通过配置 id 查询配置信息
     *
     * @return 配置信息
     */
    Config query();
}
