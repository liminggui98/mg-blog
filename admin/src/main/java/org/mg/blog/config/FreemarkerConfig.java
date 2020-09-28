
package org.mg.blog.config;

import freemarker.template.TemplateModelException;

import org.mg.blog.system.api.ConfigApi;
import org.mg.blog.system.api.ResourcesApi;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * FreeMarker 配置类
 */
@Configuration
public class FreemarkerConfig {
    @Resource
    private ConfigApi configApi;

    @Resource
    private ResourcesApi resourcesApi;

    @Resource
    private freemarker.template.Configuration configuration;

    /**
     * 塞入数据
     *
     * @throws TemplateModelException 设值错误
     */
    @PostConstruct
    public void init() throws TemplateModelException {
        configuration.setSharedVariable("config", configApi.queryConfigs().getResult());
        configuration.setSharedVariable("menus", resourcesApi.queryUserResource("1").getResult());
    }
}
